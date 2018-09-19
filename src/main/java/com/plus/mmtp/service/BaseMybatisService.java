package com.plus.mmtp.service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: BaseMybatisService
 * @Description: TODO
 * @Auther: ch
 * @Date: 2018/9/15 15:43
 * @Version: 1.0
 **/
public interface BaseMybatisService {
    List<Map<String, Object>> showTables(String dataBaseName);

    List<Map<String, Object>> showTableInfo(Map<String, Object> params);

    List<Map<String, Object>> showTableStructure(String tableName);

    Map<String, Object> showCreateTableSql(String tableName);
}
