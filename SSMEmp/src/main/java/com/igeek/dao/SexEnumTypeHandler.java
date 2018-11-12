package com.igeek.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.igeek.domain.SexEnum;

/**
 * @ClassName: SexEnumTypeHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月16日 下午5:02:51
 * 
 */
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

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
    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getSex());
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
    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        String sexName = rs.getString(columnName);
        return SexEnum.getSexFromString(sexName);
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
    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
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
    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
