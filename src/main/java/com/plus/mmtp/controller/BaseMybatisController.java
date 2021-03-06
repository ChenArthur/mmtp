package com.plus.mmtp.controller;

import com.plus.mmtp.service.BaseMybatisService;
import com.plus.mmtp.util.ActionResultUtil;
import com.plus.mmtp.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseMybatisController
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/9/15 15:52
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/database")
public class BaseMybatisController {

    @Autowired
    BaseMybatisService baseMybatisService;

    @GetMapping("/databasetables")
    public String dataBaseTables(){
        return "tablepage/tables";
    }

    @ResponseBody
    @GetMapping("/getdatabasetables")
    public ActionResultUtil<Object> getDataBaseTables(String dataBaseName, String tableName, String search, Integer page, Integer limit){
        Map<String, Object> params = new HashMap<>();
        params.put("schema", dataBaseName);
        params.put("tableName", search);
        ActionResultUtil action = new ActionResultUtil();
        List<Map<String, Object>> mapList = this.baseMybatisService.showTables(params);
        action.setPage(page);
        action.setRows(mapList);
        action.setTotal(mapList.size());
        return action;
    }

    @GetMapping("/tablesinfo")
    public String tablesInfo(){
        return "tablepage/tablesinfo";
    }

    @ResponseBody
    @GetMapping("/gettableinfos")
    public ActionResultUtil getTableInfos(String tableName, Integer page, Integer limit){
        Map<String, Object> map = new HashMap<>();
        map.put("schema","sys");
        map.put("tableName",tableName);
        List<Map<String, Object>> mapList = this.baseMybatisService.showTableInfo(map);
        return new ActionResultUtil<Object>(page, mapList.size(), mapList);
    }

    @ResponseBody
    @GetMapping("/getcreatetablesql")
    public Map<String, Object> getCreateTableSql(String tableName){
        return this.baseMybatisService.showCreateTableSql(tableName);
    }

    @ResponseBody
    @GetMapping("/gettablestructure")
    public ActionResultUtil getTableStructure(String tableName, Integer page, Integer limit){
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (StringUtils.isEmptyAndNull(tableName)) {
            System.out.println(tableName);
        } else {
            mapList = this.baseMybatisService.showTableStructure(tableName);
        }
        return new ActionResultUtil(page, mapList.size(), mapList);
    }
}
