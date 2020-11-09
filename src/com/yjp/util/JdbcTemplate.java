package com.yjp.util;

import com.yjp.dao.IObjectMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    //增 删 改
    public static int executeUpdate(String sql, Object... args) throws SQLException {
        int result = -1;
        Connection con = DbUtil.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        setParams(pstmt,args);
        result = pstmt.executeUpdate();
        DbUtil.closeResource(pstmt,null);
        return result;
    }
    //查找
    public static  <T> List<T> executeQuery(String sql, IObjectMapper<T> mapper,Object...args) throws SQLException {
        List<T> list = new ArrayList<>();
        Connection con = DbUtil.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        setParams(pstmt,args);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            list.add(mapper.getObjectFromResultSet(rs));
        }
        DbUtil.closeResource(pstmt,rs);
        return list;
    }

    private static void setParams(PreparedStatement pstmt, Object[] args) throws SQLException {
        if (args != null && args.length > 0){
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i+1,args[i]);
            }
        }
    }
}
