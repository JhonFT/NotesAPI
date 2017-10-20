/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.notas.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Home
 */
public class ConnecionDB {

    private final static String PERSISTENCE_UNIT_NAME = "notesUnity";
    EntityManager em = null;
    EntityManagerFactory emf;

    public ConnecionDB() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public EntityManager getConenection() {
        if (em != null) {
            em = emf.createEntityManager();
        }
        return em;
    }
}
