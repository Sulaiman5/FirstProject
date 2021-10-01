/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.DAO;

import com.project.Model.ResultModel;
import com.project.Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TCLD
 */
public class ResultDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int save(ResultModel rm) {
        try {
            if (rm.getMarks() >= 80 && rm.getMarks() <= 100) {
                rm.setGrade("A+");
                rm.setGpa("5");
            } else if (rm.getMarks() >= 70 && rm.getMarks() <= 79) {
                rm.setGrade("A");
                rm.setGpa("4");
            } else if (rm.getMarks() >= 60 && rm.getMarks() <= 69) {
                rm.setGrade("A-");
                rm.setGpa("3.50");
            } else if (rm.getMarks() >= 50 && rm.getMarks() <= 59) {
                rm.setGrade("B");
                rm.setGpa("3");
            } else if (rm.getMarks() >= 40 && rm.getMarks() <= 49) {
                rm.setGrade("C");
                rm.setGpa("2");
            } else if (rm.getMarks() >= 33 && rm.getMarks() <= 39) {
                rm.setGrade("D");
                rm.setGpa("1");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter your value between 0 to 100");
            }
            String sql = "insert into result (name, classs, roll, year, term, subject, marks, grade, gpa) values (?,?,?,?,?,?,?,?,?)";
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rm.getName());
            ps.setString(2, rm.getClasss());
            ps.setInt(3, rm.getRoll());
            ps.setString(4, rm.getYear());
            ps.setString(5, rm.getTerm());
            ps.setString(6, rm.getSubject());
            ps.setInt(7, rm.getMarks());
            ps.setString(9, rm.getGrade());
            ps.setString(8, rm.getGpa());
            int status = ps.executeUpdate();
            con.close();
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ResultModel> getAll(ResultModel rm) {
        try {
            System.out.println(rm.toString());
            String sql = "select * from result where classs = ? and roll = ? and year = ? and term = ?";
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rm.getClasss());
            ps.setInt(2, rm.getRoll());
            ps.setString(3, rm.getYear());
            ps.setString(4, rm.getTerm());
            rs = ps.executeQuery();

            List<ResultModel> l = new ArrayList<ResultModel>();
            while (rs.next()) {
                ResultModel r = new ResultModel();
                r.setName(rs.getString("name"));
                r.setClasss(rs.getString("classs"));
                r.setRoll(rs.getInt("roll"));
                r.setYear(rs.getString("year"));
                r.setTerm(rs.getString("term"));
                r.setSubject(rs.getString("subject"));
                r.setGpa(rs.getString("gpa"));
                r.setGrade(rs.getString("grade"));
                r.setMarks(rs.getInt("marks"));
                l.add(r);
            }
            return l;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
