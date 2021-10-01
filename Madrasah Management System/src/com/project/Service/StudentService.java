/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.Service;

import com.project.DAO.StudentDAO;
import com.project.Model.StudentModel;
import java.util.List;

/**
 *
 * @author TCLD
 */
public class StudentService {

    public int addService(StudentModel m) {
        return new StudentDAO().addService(m);
    }

    public StudentModel getAllValue(int id) {
        return new StudentDAO().getAllValue(id);
    }

    public int UpdateService(StudentModel m) {
        return new StudentDAO().UpdateService(m);
    }

    public int DeleteService(int id) {
        return new StudentDAO().DeleteService(id);
    }

    public List<StudentModel> showTable(StudentModel sd) {
        return new StudentDAO().showTable(sd);
    }

}
