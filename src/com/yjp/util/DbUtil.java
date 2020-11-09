package com.yjp.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    public static DataSource dataSource = null;
    public static Properties prop = new Properties();

    static {
        try {
            prop.load(DbUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = threadLocal.get();
        if (con == null){
            con = dataSource.getConnection();
            threadLocal.set(con);
        }
        return con;
    }

    public static void closeConnection(){
        Connection con = threadLocal.get();
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        threadLocal.set(null);
    }

    public static void closeResource(PreparedStatement pstmt, ResultSet rs){
        if (pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
