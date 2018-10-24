/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "JEUX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jeux.findAll", query = "SELECT j FROM Jeux j")
    , @NamedQuery(name = "Jeux.findByIdJeu", query = "SELECT j FROM Jeux j WHERE j.idJeu = :idJeu")
    , @NamedQuery(name = "Jeux.findByJeux", query = "SELECT j FROM Jeux j WHERE j.jeux = :jeux")})
public class Jeux implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_JEU")
    private Integer idJeu;
    @Size(max = 50)
    @Column(name = "_JEUX")
    private String jeux;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJeu")
    private Collection<Membre> membreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJeu")
    private Collection<Annonce> annonceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJeu")
    private Collection<Pari> pariCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJeu")
    private Collection<Rang> rangCollection;

    public Jeux() {
    }

    public Jeux(Integer idJeu) {
        this.idJeu = idJeu;
    }

    public Integer getIdJeu() {
        return idJeu;
    }

    public void setIdJeu(Integer idJeu) {
        this.idJeu = idJeu;
    }

    public String getJeux() {
        return jeux;
    }

    public void setJeux(String jeux) {
        this.jeux = jeux;
    }

    @XmlTransient
    public Collection<Membre> getMembreCollection() {
        return membreCollection;
    }

    public void setMembreCollection(Collection<Membre> membreCollection) {
        this.membreCollection = membreCollection;
    }

    @XmlTransient
    public Collection<Annonce> getAnnonceCollection() {
        return annonceCollection;
    }

    public void setAnnonceCollection(Collection<Annonce> annonceCollection) {
        this.annonceCollection = annonceCollection;
    }

    @XmlTransient
    public Collection<Pari> getPariCollection() {
        return pariCollection;
    }

    public void setPariCollection(Collection<Pari> pariCollection) {
        this.pariCollection = pariCollection;
    }

    @XmlTransient
    public Collection<Rang> getRangCollection() {
        return rangCollection;
    }

    public void setRangCollection(Collection<Rang> rangCollection) {
        this.rangCollection = rangCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJeu != null ? idJeu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jeux)) {
            return false;
        }
        Jeux other = (Jeux) object;
        if ((this.idJeu == null && other.idJeu != null) || (this.idJeu != null && !this.idJeu.equals(other.idJeu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Jeux[ idJeu=" + idJeu + " ]";
    }
    
}
