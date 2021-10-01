/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.DAO;

import com.project.Model.StudentModel;
import com.project.Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TCLD
 */
public class StudentDAO {

    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public int addService(StudentModel m) {
        try {
            String query = "insert into student(name, father, mother, gender, year, NID, religion, role, Fnumber, Mnumber, Classess, present, permanent)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            con = DBConnection.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, m.getName());
            ps.setString(2, m.getFather());
            ps.setString(3, m.getMother());
            ps.setString(4, m.getGender());
            ps.setString(5, m.getYear());
            ps.setString(6, m.getNID());
            ps.setString(7, m.getReligion());
            ps.setString(8, m.getRole());
            ps.setString(9, m.getFnumber());
            ps.setString(10, m.getMnumber());
            ps.setString(11, m.getClassess());
            ps.setString(12, m.getPresent());
            ps.setString(13, m.getPermanent());
            int status = ps.executeUpdate();
            con.close();
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public StudentModel getAllValue(int id) {
        try {
            String query = "Select * from student where id='" + id + "'";
            con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            StudentModel s = new StudentModel();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setFather(rs.getString("father"));
                s.setMother(rs.getString("mother"));
                s.setGender(rs.getString("gender"));
                s.setYear(rs.getString("year"));
                s.setNID(rs.getString("NID"));
                s.setReligion(rs.getString("religion"));
                s.setRole(rs.getString("role"));
                s.setFnumber(rs.getString("Fnumber"));
                s.setMnumber(rs.getString("Mnumber"));
                s.setClassess(rs.getString("Classess"));
                s.setPresent(rs.getString("present"));
                s.setPermanent(rs.getString("permanent"));
            }
            con.close();
            return s;
        } catch (Exception e) {
        }
        return null;
    }

    public int UpdateService(StudentModel m) {
        try {
            String query = "update student set name='" + m.getName() + "', father='" + m.getFather() + "', mother='" + m.getMother() + "', gender='" + m.getGender() + "', year='" + m.getYear() + "', NID='" + m.getNID() + "', religion='" + m.getReligion() + "', role='" + m.getRole() + "', Fnumber='" + m.getFnumber() + "', Mnumber='" + m.getMnumber() + "', Classess='" + m.getClassess() + "', present='" + m.getPresent() + "', permanent='" + m.getPermanent() + "' where id = '" + m.getId() + "'";
            con = DBConnection.getConnection();
            st = con.createStatement();
            int status = st.executeUpdate(query);
            con.close();
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int DeleteService(int id) {
        try {
            String query = "Delete from student where id='" + id + "'";
            con = DBConnection.getConnection();
            st = con.createStatement();
            int status = st.executeUpdate(query);
            con.close();
            return status;
        } catch (Exception e) {

        }
        return 0;
    }

    public List<StudentModel> showTable(StudentModel sd) {
        try {
            String query = "select * from student";
            con = DBConnection.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            List<StudentModel> list = new ArrayList<>();
            StudentModel sm = new StudentModel();
            while (rs.next()) {
                sm.setId(rs.getInt("id"));
                sm.setName(rs.getString("name"));
                sm.setFather(rs.getString("father"));
                sm.setMother(rs.getString("mother"));
                sm.setGender(rs.getString("gender"));
                sm.setYear(rs.getString("year"));
                sm.setNID(rs.getString("NID"));
                sm.setReligion(rs.getString("religion"));
                sm.setRole(rs.getString("role"));
                sm.setFnumber(rs.getString("Fnumber"));
                sm.setMnumber(rs.getString("Mnumber"));
                sm.setClassess(rs.getString("Classess"));
                sm.setPresent(rs.getString("present"));
                sm.setPermanent(rs.getString("permanent"));
            }
            list.add(sm);
            con.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
