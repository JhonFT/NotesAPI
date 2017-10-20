/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.notas.dao;

import com.incca.notas.entitys.Users;
import com.incca.notas.helper.ConnecionDB;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Home
 */
public class UsersDAO {

    EntityManager em;

    public UsersDAO() {
        em = new ConnecionDB().getConenection();
    }

    public List<Users> getAllUsers() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

}
