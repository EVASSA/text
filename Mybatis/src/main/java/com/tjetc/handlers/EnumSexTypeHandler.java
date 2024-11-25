package com.tjetc.handlers;

import com.tjetc.enums.EnumSex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义类型处理器（处理EnumSex这个枚举类型）
 */
public class EnumSexTypeHandler implements TypeHandler<EnumSex> {
    /**
     * 设置参数时调用此方法（例如：大部分 insert update delete）
     *
     * @param ps        jdbc中的PreparedStatement
     * @param i         参数索引（位置）
     * @param parameter 参数值
     * @param jdbcType  jdbc类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i,
                             EnumSex parameter, JdbcType jdbcType) throws SQLException {
        //参数设置值，注意 把枚举转换成int，因为数据库表中类型是 int类型
        ps.setObject(i, parameter.getCode());
    }

    /**
     * 用户查询结果集处理
     *
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public EnumSex getResult(ResultSet rs, String columnName) throws SQLException {
        //获取结果对应列名称的值，就是EnumSex的code值
        Integer sexCode = (Integer) rs.getObject(columnName);
        //把code转换成枚举对象
        return EnumSex.getByCode(sexCode);
    }

    /**
     * 用户查询结果集处理
     *
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public EnumSex getResult(ResultSet rs, int columnIndex) throws SQLException {
        //获取结果对应列索引的值，就是EnumSex的code值
        Integer sexCode = (Integer) rs.getObject(columnIndex);
        //把code转换成枚举对象
        return EnumSex.getByCode(sexCode);
    }

    /**
     * 用户存储过程（处理结果集）
     *
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public EnumSex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer sexCode = (Integer) cs.getObject(columnIndex);
        return EnumSex.getByCode(sexCode);
    }
}
