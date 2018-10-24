/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "PARI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pari.findAll", query = "SELECT p FROM Pari p")
    , @NamedQuery(name = "Pari.findByIdPari", query = "SELECT p FROM Pari p WHERE p.idPari = :idPari")
    , @NamedQuery(name = "Pari.findByMontantPari", query = "SELECT p FROM Pari p WHERE p.montantPari = :montantPari")
    , @NamedQuery(name = "Pari.findByTypePari", query = "SELECT p FROM Pari p WHERE p.typePari = :typePari")})
public class Pari implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PARI")
    private Integer idPari;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTANT_PARI")
    private int montantPari;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TYPE_PARI")
    private Character typePari;
    @JoinColumn(name = "ID_PARIEUR", referencedColumnName = "ID_MEMBRE")
    @ManyToOne(optional = false)
    private Membre idParieur;
    @JoinColumn(name = "ID_TUEUR", referencedColumnName = "ID_MEMBRE")
    @ManyToOne
    private Membre idTueur;
    @JoinColumn(name = "ID_DEAD", referencedColumnName = "ID_MEMBRE")
    @ManyToOne
    private Membre idDead;
    @JoinColumn(name = "ID_JEU", referencedColumnName = "ID_JEU")
    @ManyToOne(optional = false)
    private Jeux idJeu;

    public Pari() {
    }

    public Pari(Integer idPari) {
        this.idPari = idPari;
    }

    public Pari(Integer idPari, int montantPari, Character typePari) {
        this.idPari = idPari;
        this.montantPari = montantPari;
        this.typePari = typePari;
    }

    public Integer getIdPari() {
        return idPari;
    }

    public void setIdPari(Integer idPari) {
        this.idPari = idPari;
    }

    public int getMontantPari() {
        return montantPari;
    }

    public void setMontantPari(int montantPari) {
        this.montantPari = montantPari;
    }

    public Character getTypePari() {
        return typePari;
    }

    public void setTypePari(Character typePari) {
        this.typePari = typePari;
    }

    public Membre getIdParieur() {
        return idParieur;
    }

    public void setIdParieur(Membre idParieur) {
        this.idParieur = idParieur;
    }

    public Membre getIdTueur() {
        return idTueur;
    }

    public void setIdTueur(Membre idTueur) {
        this.idTueur = idTueur;
    }

    public Membre getIdDead() {
        return idDead;
    }

    public void setIdDead(Membre idDead) {
        this.idDead = idDead;
    }

    public Jeux getIdJeu() {
        return idJeu;
    }

    public void setIdJeu(Jeux idJeu) {
        this.idJeu = idJeu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPari != null ? idPari.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pari)) {
            return false;
        }
        Pari other = (Pari) object;
        if ((this.idPari == null && other.idPari != null) || (this.idPari != null && !this.idPari.equals(other.idPari))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pari[ idPari=" + idPari + " ]";
    }
    
}
