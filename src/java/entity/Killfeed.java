/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "KILLFEED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Killfeed.findAll", query = "SELECT k FROM Killfeed k")
    , @NamedQuery(name = "Killfeed.findByIdKiller", query = "SELECT k FROM Killfeed k WHERE k.killfeedPK.idKiller = :idKiller")
    , @NamedQuery(name = "Killfeed.findByIdDead", query = "SELECT k FROM Killfeed k WHERE k.killfeedPK.idDead = :idDead")
    , @NamedQuery(name = "Killfeed.findByDateKillfeed", query = "SELECT k FROM Killfeed k WHERE k.dateKillfeed = :dateKillfeed")})
public class Killfeed implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KillfeedPK killfeedPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_KILLFEED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateKillfeed;
    @JoinColumn(name = "ID_DEAD", referencedColumnName = "ID_MEMBRE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Membre membre;
    @JoinColumn(name = "ID_KILLER", referencedColumnName = "ID_MEMBRE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Membre membre1;
    @JoinColumn(name = "ID_ARME", referencedColumnName = "ID_ARME")
    @ManyToOne(optional = false)
    private Arme idArme;

    public Killfeed() {
    }

    public Killfeed(KillfeedPK killfeedPK) {
        this.killfeedPK = killfeedPK;
    }

    public Killfeed(KillfeedPK killfeedPK, Date dateKillfeed) {
        this.killfeedPK = killfeedPK;
        this.dateKillfeed = dateKillfeed;
    }

    public Killfeed(int idKiller, int idDead) {
        this.killfeedPK = new KillfeedPK(idKiller, idDead);
    }

    public KillfeedPK getKillfeedPK() {
        return killfeedPK;
    }

    public void setKillfeedPK(KillfeedPK killfeedPK) {
        this.killfeedPK = killfeedPK;
    }

    public Date getDateKillfeed() {
        return dateKillfeed;
    }

    public void setDateKillfeed(Date dateKillfeed) {
        this.dateKillfeed = dateKillfeed;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Membre getMembre1() {
        return membre1;
    }

    public void setMembre1(Membre membre1) {
        this.membre1 = membre1;
    }

    public Arme getIdArme() {
        return idArme;
    }

    public void setIdArme(Arme idArme) {
        this.idArme = idArme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (killfeedPK != null ? killfeedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Killfeed)) {
            return false;
        }
        Killfeed other = (Killfeed) object;
        if ((this.killfeedPK == null && other.killfeedPK != null) || (this.killfeedPK != null && !this.killfeedPK.equals(other.killfeedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Killfeed[ killfeedPK=" + killfeedPK + " ]";
    }
    
}
