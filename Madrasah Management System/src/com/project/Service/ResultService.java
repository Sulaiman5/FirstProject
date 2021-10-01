/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.Service;

import com.project.DAO.ResultDAO;
import com.project.Model.ResultModel;
import java.util.List;

/**
 *
 * @author TCLD
 */
public class ResultService {

    public List<ResultModel> getAll(ResultModel rm) {
        return new ResultDAO().getAll(rm);
    }

    public int save(ResultModel rm) {
        return new ResultDAO().save(rm);
    }

}
