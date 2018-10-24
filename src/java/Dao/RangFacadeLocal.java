/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Rang;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomas
 */
@Local
public interface RangFacadeLocal {

    void create(Rang rang);

    void edit(Rang rang);

    void remove(Rang rang);

    Rang find(Object id);

    List<Rang> findAll();

    List<Rang> findRange(int[] range);

    int count();
    
}
