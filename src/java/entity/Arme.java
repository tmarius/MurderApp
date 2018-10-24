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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "ARME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arme.findAll", query = "SELECT a FROM Arme a")
    , @NamedQuery(name = "Arme.findByIdArme", query = "SELECT a FROM Arme a WHERE a.idArme = :idArme")
    , @NamedQuery(name = "Arme.findByNomArme", query = "SELECT a FROM Arme a WHERE a.nomArme = :nomArme")
    , @NamedQuery(name = "Arme.findByImgArme", query = "SELECT a FROM Arme a WHERE a.imgArme = :imgArme")})
public class Arme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ARME")
    private Integer idArme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_ARME")
    private String nomArme;
    @Size(max = 100)
    @Column(name = "IMG_ARME")
    private String imgArme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArme")
    private Collection<Killfeed> killfeedCollection;

    public Arme() {
    }

    public Arme(Integer idArme) {
        this.idArme = idArme;
    }

    public Arme(Integer idArme, String nomArme) {
        this.idArme = idArme;
        this.nomArme = nomArme;
    }

    public Integer getIdArme() {
        return idArme;
    }

    public void setIdArme(Integer idArme) {
        this.idArme = idArme;
    }

    public String getNomArme() {
        return nomArme;
    }

    public void setNomArme(String nomArme) {
        this.nomArme = nomArme;
    }

    public String getImgArme() {
        return imgArme;
    }

    public void setImgArme(String imgArme) {
        this.imgArme = imgArme;
    }

    @XmlTransient
    public Collection<Killfeed> getKillfeedCollection() {
        return killfeedCollection;
    }

    public void setKillfeedCollection(Collection<Killfeed> killfeedCollection) {
        this.killfeedCollection = killfeedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArme != null ? idArme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arme)) {
            return false;
        }
        Arme other = (Arme) object;
        if ((this.idArme == null && other.idArme != null) || (this.idArme != null && !this.idArme.equals(other.idArme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Arme[ idArme=" + idArme + " ]";
    }
    
}
