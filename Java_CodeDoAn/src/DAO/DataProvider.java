/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WIN 10
 */
public class DataProvider {

    private final static String serverName = "LENOVO-NXT";
    private final static String dbName = "JAVA_DOAN_QUANLYCUAHANGXE";
    private final static String portNumber = "1433";
    private final static String userID = "XuanThe";
    private final static String password = "1234";

    private final static String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName="
            + dbName + ";user=" + userID + ";password=" + password + ";encrypt=false;";

    private static DataProvider instance;

    public static DataProvider Instance() {
        if (instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }

//    public ResultSet executeQuery(String query, Object... parameters) {
//        ResultSet data = null;
//        try (Connection conn = DriverManager.getConnection(url)) {
//            try (PreparedStatement ps = conn.prepareStatement(query)) {
//                setParameters(ps, parameters);
//                data = ps.executeQuery();
//            }
//        } catch (SQLException e) {
//        }
//        
//        return data;
//    }
    
    private void setParameters(PreparedStatement ps, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            ps.setObject(i + 1, parameters[i]);
        }
    }
    
    public ResultSet executeQuery(String query, Object... parameters) {
        ResultSet data = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url);
            ps = conn.prepareStatement(query);
            setParameters(ps, parameters);
            data = ps.executeQuery();
        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu cần
            e.printStackTrace();
        } finally {
            // Đóng PreparedStatement và Connection ở đây
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Xử lý ngoại lệ nếu cần
                e.printStackTrace();
            }
        }
        
        return data;
    }

    public int executeUpdate(String query, Object... parameters) {
        int data = 0;
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                setParameters(ps, parameters);
                data = ps.executeUpdate();
            }
        } catch (SQLException e) {
        }
        return data;
    }

    public Object executeScalar(String query, Object... parameters) {
        Object data = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                setParameters(ps, parameters);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        data = rs.getObject(1);
                    }
                }
            }
        } catch (SQLException e) {
        }
        return data;
    }

    
}

//muyxue de thuong xinh dep cute pho mai que hot me dang yeu nhat he mat troi