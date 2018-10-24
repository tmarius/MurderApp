/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Pari;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomas
 */
@Local
public interface PariFacadeLocal {

    void create(Pari pari);

    void edit(Pari pari);

    void remove(Pari pari);

    Pari find(Object id);

    List<Pari> findAll();

    List<Pari> findRange(int[] range);

    int count();
    
}
