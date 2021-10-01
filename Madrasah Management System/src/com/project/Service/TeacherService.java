/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.Service;

import com.project.Controlar.AllTeachers;
import com.project.DAO.TeacherDAO;
import com.project.Model.Teacher;
import java.util.List;

/**
 *
 * @author TCLD
 */
public class TeacherService {

    public int save(Teacher tm) {
        return new TeacherDAO().Save(tm);
    }

    public List<Teacher> getAllService(Teacher m) {
        return new TeacherDAO().getAllService(m);

    }

    public Teacher addsearch(int id) {
        return new TeacherDAO().getAllSearch(id);
    }

    public int UpdateService(Teacher t) {
    return new TeacherDAO().UpdateSevice(t);
    }

    public int delete(int id) {
    return new TeacherDAO().deleteSevice(id); 
    }

}
