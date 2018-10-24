/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Jeux;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thomas
 */
@Stateless
public class JeuxFacade extends AbstractFacade<Jeux> implements JeuxFacadeLocal {

    @PersistenceContext(unitName = "MurderPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JeuxFacade() {
        super(Jeux.class);
    }
    
}
