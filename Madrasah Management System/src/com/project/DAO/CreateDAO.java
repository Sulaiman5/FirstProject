/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.DAO;

import com.project.Model.Create1;
import com.project.Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TCLD
 */
public class CreateDAO {

    Connection con;
    PreparedStatement ps;
    Statement ss;
    ResultSet rs;

    public int addService(Create1 n) {
        try {
            String query = "insert into createUser(username, email, password)values(?,?,?)";
            con = DBConnection.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, n.getUsername());
            ps.setString(2, n.getEmail());
            ps.setString(3, n.getPassword());
            int status = ps.executeUpdate();
            con.close();
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int gttService(Create1 m) {
        try {
            String query = "select * from createUser";
            con = DBConnection.getConnection();
            ss = con.createStatement();
            ResultSet rs = ss.executeQuery(query);
            rs.absolute(1);
            while (rs.next()) {
                if (m.getUsername().matches(rs.getString("username")) && m.getPassword().matches(rs.getString("Password"))) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Create1 scearService(String id) {
        String query = "select * from createUser where id='" + id + "'";
        con = DBConnection.getConnection();
        try {
            ss = con.createStatement();
            rs = ss.executeQuery(query);
            Create1 m = new Create1();
            while (rs.next()) {
                m.setUsername(rs.getString("username"));
                m.setEmail(rs.getString("email"));
                m.setPassword(rs.getString("Password"));
            }
            con.close();
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(CreateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int DeleteServic(String id) {

        try {
            String query = "delete from createUser where id ='" + id + "'";
            con = DBConnection.getConnection();
            ss = con.createStatement();
            int status = ss.executeUpdate(query);
            con.close();
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(CreateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
