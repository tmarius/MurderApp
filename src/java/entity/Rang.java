/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "RANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rang.findAll", query = "SELECT r FROM Rang r")
    , @NamedQuery(name = "Rang.findByIdRang", query = "SELECT r FROM Rang r WHERE r.idRang = :idRang")
    , @NamedQuery(name = "Rang.findByNomRang", query = "SELECT r FROM Rang r WHERE r.nomRang = :nomRang")
    , @NamedQuery(name = "Rang.findByImgRang", query = "SELECT r FROM Rang r WHERE r.imgRang = :imgRang")})
public class Rang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RANG")
    private Integer idRang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_RANG")
    private String nomRang;
    @Size(max = 100)
    @Column(name = "IMG_RANG")
    private String imgRang;
    @OneToMany(mappedBy = "idRang")
    private Collection<Membre> membreCollection;
    @JoinColumn(name = "ID_JEU", referencedColumnName = "ID_JEU")
    @ManyToOne(optional = false)
    private Jeux idJeu;

    public Rang() {
    }

    public Rang(Integer idRang) {
        this.idRang = idRang;
    }

    public Rang(Integer idRang, String nomRang) {
        this.idRang = idRang;
        this.nomRang = nomRang;
    }

    public Integer getIdRang() {
        return idRang;
    }

    public void setIdRang(Integer idRang) {
        this.idRang = idRang;
    }

    public String getNomRang() {
        return nomRang;
    }

    public void setNomRang(String nomRang) {
        this.nomRang = nomRang;
    }

    public String getImgRang() {
        return imgRang;
    }

    public void setImgRang(String imgRang) {
        this.imgRang = imgRang;
    }

    @XmlTransient
    public Collection<Membre> getMembreCollection() {
        return membreCollection;
    }

    public void setMembreCollection(Collection<Membre> membreCollection) {
        this.membreCollection = membreCollection;
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
        hash += (idRang != null ? idRang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rang)) {
            return false;
        }
        Rang other = (Rang) object;
        if ((this.idRang == null && other.idRang != null) || (this.idRang != null && !this.idRang.equals(other.idRang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rang[ idRang=" + idRang + " ]";
    }
    
}
