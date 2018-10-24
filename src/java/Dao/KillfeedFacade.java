/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Killfeed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thomas
 */
@Stateless
public class KillfeedFacade extends AbstractFacade<Killfeed> implements KillfeedFacadeLocal {

    @PersistenceContext(unitName = "MurderPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KillfeedFacade() {
        super(Killfeed.class);
    }
    
}
