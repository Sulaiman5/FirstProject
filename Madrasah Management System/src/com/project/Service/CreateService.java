/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.Service;

import com.project.DAO.CreateDAO;
import com.project.Model.Create1;

/**
 *
 * @author TCLD
 */
public class CreateService {

    public int addService(Create1 n) {
        return new CreateDAO().addService(n);
    }

    public int gttService(Create1 m) {
        return new CreateDAO().gttService(m);
    }

    public Create1 scearService(String id) {
        return new CreateDAO().scearService(id);
    }
    public int DeleteServic(String id) {
        return new CreateDAO().DeleteServic(id);
    }

}
