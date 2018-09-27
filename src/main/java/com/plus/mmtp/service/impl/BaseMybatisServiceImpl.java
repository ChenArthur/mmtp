package com.plus.mmtp.service.impl;

import com.plus.mmtp.mapper.BaseMybatisMapper;
import com.plus.mmtp.service.BaseMybatisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseMybatisServiceImpl
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/9/15 15:43
 * @Version: 1.0
 **/
@Service
public class BaseMybatisServiceImpl implements BaseMybatisService {

    @Autowired
    BaseMybatisMapper baseMybatisMapper;

    @Override
    public List<Map<String, Object>> showTables(Map<String, Object> params){
        return this.baseMybatisMapper.showTables(params);
    }

    @Override
    public List<Map<String, Object>> showTableInfo(Map<String, Object> params){
        return this.baseMybatisMapper.showTableInfo(params);
    }

    @Override
    public List<Map<String, Object>> showTableStructure(String tableName){
        return this.baseMybatisMapper.showTableStructure(tableName);
    }

    @Override
    public Map<String, Object> showCreateTableSql(String tableName){
        return this.baseMybatisMapper.showCreateTableSql(tableName);
    }
}
