/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Killfeed;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomas
 */
@Local
public interface KillfeedFacadeLocal {

    void create(Killfeed killfeed);

    void edit(Killfeed killfeed);

    void remove(Killfeed killfeed);

    Killfeed find(Object id);

    List<Killfeed> findAll();

    List<Killfeed> findRange(int[] range);

    int count();
    
}
