package com.igeek.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @ClassName: MyTypeHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月16日 下午6:28:19
 * 
 */
public class HobbiesTypeHandler implements TypeHandler<String[]> {

    /**
     * @Title: setParameter
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement,
     *      int, java.lang.Object, org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        // 这里的I是index的意思，后面提供一个String，它会转义
        String param = Arrays.asList(parameter).stream().collect(Collectors.joining(","));
        ps.setString(i, param);
    }

    /**
     * @Title: getResult
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet,
     *      java.lang.String)
     */
    @Override
    public String[] getResult(ResultSet rs, String columnName) throws SQLException {
        String hoobies = rs.getString(columnName);
        return hoobies.split(",");
    }

    /**
     * @Title: getResult
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet,
     *      int)
     */
    @Override
    public String[] getResult(ResultSet rs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @Title: getResult
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement,
     *      int)
     */
    @Override
    public String[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
