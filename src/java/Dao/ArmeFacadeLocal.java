/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Arme;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomas
 */
@Local
public interface ArmeFacadeLocal {

    void create(Arme arme);

    void edit(Arme arme);

    void remove(Arme arme);

    Arme find(Object id);

    List<Arme> findAll();

    List<Arme> findRange(int[] range);

    int count();
    
}
