/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author WIN 10
 */
public class DBConnection {

    private final static String serverName = "LENOVO-NXT";
    private final static String dbName = "JAVA_DOAN_QUANLYCUAHANGXE";
    private final static String portNumber = "1433";
    private final static String instance = "";// MSSQLSERVER LEAVE THIS ONE
    private final static String userID = "XuanThe";
    private final static String password = "1234";

    public static Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" 
            + dbName + ";user=" + userID + ";password=" + password + ";encrypt=false;";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
    
    public static java.sql.Date convertStringToDate(String date){
        java.sql.Date sqlDate = null;
        try {
            Date d = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
            sqlDate = new java.sql.Date(d.getTime());
        } catch (Exception e) {
            
        }
        return sqlDate;
    }

}
