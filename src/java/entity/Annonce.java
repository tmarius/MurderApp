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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "ANNONCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annonce.findAll", query = "SELECT a FROM Annonce a")
    , @NamedQuery(name = "Annonce.findByIdAnnonce", query = "SELECT a FROM Annonce a WHERE a.idAnnonce = :idAnnonce")})
public class Annonce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANNONCE")
    private Integer idAnnonce;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "DESCRIPTION_ANNONCE")
    private String descriptionAnnonce;
    @JoinColumn(name = "ID_JEU", referencedColumnName = "ID_JEU")
    @ManyToOne(optional = false)
    private Jeux idJeu;

    public Annonce() {
    }

    public Annonce(Integer idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Annonce(Integer idAnnonce, String descriptionAnnonce) {
        this.idAnnonce = idAnnonce;
        this.descriptionAnnonce = descriptionAnnonce;
    }

    public Integer getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Integer idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getDescriptionAnnonce() {
        return descriptionAnnonce;
    }

    public void setDescriptionAnnonce(String descriptionAnnonce) {
        this.descriptionAnnonce = descriptionAnnonce;
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
        hash += (idAnnonce != null ? idAnnonce.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if ((this.idAnnonce == null && other.idAnnonce != null) || (this.idAnnonce != null && !this.idAnnonce.equals(other.idAnnonce))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Annonce[ idAnnonce=" + idAnnonce + " ]";
    }
    
}
