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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "CONTRAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrat.findAll", query = "SELECT c FROM Contrat c")
    , @NamedQuery(name = "Contrat.findByIdContrat", query = "SELECT c FROM Contrat c WHERE c.idContrat = :idContrat")
    , @NamedQuery(name = "Contrat.findByDatedebutContrat", query = "SELECT c FROM Contrat c WHERE c.datedebutContrat = :datedebutContrat")
    , @NamedQuery(name = "Contrat.findByDatefinContrat", query = "SELECT c FROM Contrat c WHERE c.datefinContrat = :datefinContrat")
    , @NamedQuery(name = "Contrat.findByReussiteContrat", query = "SELECT c FROM Contrat c WHERE c.reussiteContrat = :reussiteContrat")})
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTRAT")
    private Integer idContrat;
    @Lob
    @Size(max = 65535)
    @Column(name = "CONDITION_CONTRAT")
    private String conditionContrat;
    @Column(name = "DATEDEBUT_CONTRAT")
    @Temporal(TemporalType.DATE)
    private Date datedebutContrat;
    @Column(name = "DATEFIN_CONTRAT")
    @Temporal(TemporalType.DATE)
    private Date datefinContrat;
    @Column(name = "REUSSITE_CONTRAT")
    private Integer reussiteContrat;
    @JoinColumn(name = "CIBLE_CONTRAT", referencedColumnName = "ID_MEMBRE")
    @ManyToOne(optional = false)
    private Membre cibleContrat;
    @JoinColumn(name = "TUEUR_CONTRAT", referencedColumnName = "ID_MEMBRE")
    @ManyToOne(optional = false)
    private Membre tueurContrat;

    public Contrat() {
    }

    public Contrat(Integer idContrat) {
        this.idContrat = idContrat;
    }

    public Integer getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(Integer idContrat) {
        this.idContrat = idContrat;
    }

    public String getConditionContrat() {
        return conditionContrat;
    }

    public void setConditionContrat(String conditionContrat) {
        this.conditionContrat = conditionContrat;
    }

    public Date getDatedebutContrat() {
        return datedebutContrat;
    }

    public void setDatedebutContrat(Date datedebutContrat) {
        this.datedebutContrat = datedebutContrat;
    }

    public Date getDatefinContrat() {
        return datefinContrat;
    }

    public void setDatefinContrat(Date datefinContrat) {
        this.datefinContrat = datefinContrat;
    }

    public Integer getReussiteContrat() {
        return reussiteContrat;
    }

    public void setReussiteContrat(Integer reussiteContrat) {
        this.reussiteContrat = reussiteContrat;
    }

    public Membre getCibleContrat() {
        return cibleContrat;
    }

    public void setCibleContrat(Membre cibleContrat) {
        this.cibleContrat = cibleContrat;
    }

    public Membre getTueurContrat() {
        return tueurContrat;
    }

    public void setTueurContrat(Membre tueurContrat) {
        this.tueurContrat = tueurContrat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContrat != null ? idContrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.idContrat == null && other.idContrat != null) || (this.idContrat != null && !this.idContrat.equals(other.idContrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Contrat[ idContrat=" + idContrat + " ]";
    }
    
}
