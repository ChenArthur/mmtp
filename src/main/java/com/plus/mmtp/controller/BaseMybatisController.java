package com.plus.mmtp.controller;

import com.plus.mmtp.service.BaseMybatisService;
import com.plus.mmtp.util.ActionResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ActionResultUtil<Object> getDataBaseTables(String dataBaseName, Integer page, Integer limit){
        ActionResultUtil action = new ActionResultUtil();
        action.setPage(page);
        action.setRows(this.baseMybatisService.showTables(dataBaseName));
        action.setTotal(this.baseMybatisService.showTables(dataBaseName).size());
        return action;
    }

    @GetMapping("/tablesinfo")
    public String tablesInfo(){
        return "tablepage/tablesinfo";
    }

    @ResponseBody
    @GetMapping("/gettableinfos")
    public ActionResultUtil getTableInfos(Integer page, Integer limit){
        Map<String, Object> map = new HashMap<>();
        map.put("schema","sys");
        map.put("tableName","t_pro_loginuser");
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
    public List<Map<String, Object>> getTableStructure(String tableName){
        return this.baseMybatisService.showTableStructure(tableName);
    }
}
