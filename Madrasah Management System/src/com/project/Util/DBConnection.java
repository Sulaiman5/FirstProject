/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TCLD
 */
public class DBConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/madrasah";
    private static final String DB_NAME = "root";
    private static final String PASSWORD ="58438";
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, DB_NAME, PASSWORD);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
