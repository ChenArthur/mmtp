package com.plus.mmtp.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ch
 * @since 2018-07-16
 */
@Repository
public interface BaseMybatisMapper {

    List<Map<String, Object>> showTables(@Param("schema") String dataBaseName);

    List<Map<String, Object>> showTableInfo(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> showTableStructure(@Param("tableName") String tableName);

    Map<String, Object> showCreateTableSql(@Param("tableName") String tableName);

}
