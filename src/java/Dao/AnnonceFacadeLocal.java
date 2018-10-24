/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entity.Annonce;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thomas
 */
@Local
public interface AnnonceFacadeLocal {

    void create(Annonce annonce);

    void edit(Annonce annonce);

    void remove(Annonce annonce);

    Annonce find(Object id);

    List<Annonce> findAll();

    List<Annonce> findRange(int[] range);

    int count();
    
}
