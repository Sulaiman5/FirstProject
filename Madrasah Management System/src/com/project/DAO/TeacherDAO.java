/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.DAO;

import com.project.Controlar.AllTeachers;
import com.project.Model.Teacher;
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
public class TeacherDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    public int Save(Teacher tm) {
        try {
            String Query = "insert into teacher(name, father, religion, education, gender, post, present, mobile, mother, marid, subject, NID, salary, permanent)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            con = DBConnection.getConnection();
            ps = con.prepareStatement(Query);
            ps.setString(1, tm.getName());
            ps.setString(2, tm.getFather());
            ps.setString(3, tm.getReligion());
            ps.setString(4, tm.getEducation());
            ps.setString(5, tm.getGender());
            ps.setString(6, tm.getPost());
            ps.setString(7, tm.getPresent());
            ps.setString(8, tm.getMobile());
            ps.setString(9, tm.getMother());
            ps.setString(10, tm.getMarid());
            ps.setString(11, tm.getSubject());
            ps.setInt(12, tm.getNID());
            ps.setDouble(13, tm.getSalary());
            ps.setString(14, tm.getPermanent());
            int status = ps.executeUpdate();
            con.close();
            return status;
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Teacher> getAllService(Teacher m) {
        String query = "select * from Teacher";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            List<Teacher> l = new ArrayList<>();
            Teacher t = new Teacher();
            while(rs.next()){
            t.setName(rs.getString("name"));
            t.setFather(rs.getString("father"));
            t.setReligion(rs.getString("religion"));
            t.setEducation(rs.getString("education"));
            t.setGender(rs.getString("gender"));
            t.setPost(rs.getString("post"));
            t.setPresent(rs.getString("present"));
            t.setMobile(rs.getString("mobile"));
            t.setMother(rs.getString("mother"));
            t.setMarid(rs.getString("marid"));
            t.setSubject(rs.getString("subject"));
            t.setNID(rs.getInt("NID"));
            t.setSalary(rs.getDouble("salary"));
            t.setPermanent(rs.getString("permanent"));
            }
            l.add(t);
            con.close();
            return l;
        } catch (Exception e) {
        }
        return null;
    }

    public Teacher getAllSearch(int id) {
        String query = "Select * from Teacher where id='"+id+"'";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            Teacher t = new Teacher();
            while(rs.next()){
            t.setId(rs.getInt("id"));
            t.setName(rs.getString("name"));
            t.setFather(rs.getString("father"));
            t.setReligion(rs.getString("religion"));
            t.setEducation(rs.getString("Education"));
            t.setGender(rs.getString("gender"));
            t.setPost(rs.getString("post"));
            t.setPresent(rs.getString("present"));
            t.setMobile(rs.getString("mobile"));
            t.setMother(rs.getString("mother"));
            t.setMarid(rs.getString("marid"));
            t.setSubject(rs.getString("subject"));
            t.setNID(rs.getInt("NID"));
            t.setSalary(rs.getDouble("salary"));
            t.setPermanent(rs.getString("permanent"));
            }
            con.close();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int UpdateSevice(Teacher t) {
    try {
        String query = "update Teacher set name='"+t.getName()+"',father='"+t.getFather()+"',religion='"+t.getReligion()+"',Education='"+t.getEducation()+"',gender='"+t.getGender()+"',post='"+t.getPost()+"',present='"+t.getPresent()+"',mobile='"+t.getMobile()+"',mother='"+t.getMother()+"',marid='"+t.getMarid()+"',subject='"+t.getSubject()+"',NID='"+t.getNID()+"',salary='"+t.getSalary()+"',permanent='"+t.getPermanent()+"' where id='"+t.getId()+"'";
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

    public int deleteSevice(int id) {
        try {
             String query = "delete from teacher where id ='"+id+"'";
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

}
