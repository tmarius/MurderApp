/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Thomas
 */
@Embeddable
public class KillfeedPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_KILLER")
    private int idKiller;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DEAD")
    private int idDead;

    public KillfeedPK() {
    }

    public KillfeedPK(int idKiller, int idDead) {
        this.idKiller = idKiller;
        this.idDead = idDead;
    }

    public int getIdKiller() {
        return idKiller;
    }

    public void setIdKiller(int idKiller) {
        this.idKiller = idKiller;
    }

    public int getIdDead() {
        return idDead;
    }

    public void setIdDead(int idDead) {
        this.idDead = idDead;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idKiller;
        hash += (int) idDead;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KillfeedPK)) {
            return false;
        }
        KillfeedPK other = (KillfeedPK) object;
        if (this.idKiller != other.idKiller) {
            return false;
        }
        if (this.idDead != other.idDead) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KillfeedPK[ idKiller=" + idKiller + ", idDead=" + idDead + " ]";
    }
    
}
