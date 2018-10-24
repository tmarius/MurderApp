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
@Table(name = "MEMBRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membre.findAll", query = "SELECT m FROM Membre m")
    , @NamedQuery(name = "Membre.findByIdMembre", query = "SELECT m FROM Membre m WHERE m.idMembre = :idMembre")
    , @NamedQuery(name = "Membre.findByNomMembre", query = "SELECT m FROM Membre m WHERE m.nomMembre = :nomMembre")
    , @NamedQuery(name = "Membre.findByPrenomMembre", query = "SELECT m FROM Membre m WHERE m.prenomMembre = :prenomMembre")
    , @NamedQuery(name = "Membre.findByCodeMembre", query = "SELECT m FROM Membre m WHERE m.codeMembre = :codeMembre")
    , @NamedQuery(name = "Membre.findByMdpMembre", query = "SELECT m FROM Membre m WHERE m.mdpMembre = :mdpMembre")
    , @NamedQuery(name = "Membre.findByStatutMembre", query = "SELECT m FROM Membre m WHERE m.statutMembre = :statutMembre")
    , @NamedQuery(name = "Membre.findByPieceMembre", query = "SELECT m FROM Membre m WHERE m.pieceMembre = :pieceMembre")})
public class Membre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MEMBRE")
    private Integer idMembre;
    @Size(max = 50)
    @Column(name = "NOM_MEMBRE")
    private String nomMembre;
    @Size(max = 50)
    @Column(name = "PRENOM_MEMBRE")
    private String prenomMembre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CODE_MEMBRE")
    private String codeMembre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MDP_MEMBRE")
    private String mdpMembre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUT_MEMBRE")
    private Character statutMembre;
    @Column(name = "PIECE_MEMBRE")
    private Integer pieceMembre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cibleContrat")
    private Collection<Contrat> contratCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tueurContrat")
    private Collection<Contrat> contratCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membre")
    private Collection<Killfeed> killfeedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membre1")
    private Collection<Killfeed> killfeedCollection1;
    @JoinColumn(name = "ID_RANG", referencedColumnName = "ID_RANG")
    @ManyToOne
    private Rang idRang;
    @JoinColumn(name = "ID_JEU", referencedColumnName = "ID_JEU")
    @ManyToOne(optional = false)
    private Jeux idJeu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idParieur")
    private Collection<Pari> pariCollection;
    @OneToMany(mappedBy = "idTueur")
    private Collection<Pari> pariCollection1;
    @OneToMany(mappedBy = "idDead")
    private Collection<Pari> pariCollection2;

    public Membre() {
    }

    public Membre(Integer idMembre) {
        this.idMembre = idMembre;
    }

    public Membre(Integer idMembre, String codeMembre, String mdpMembre, Character statutMembre) {
        this.idMembre = idMembre;
        this.codeMembre = codeMembre;
        this.mdpMembre = mdpMembre;
        this.statutMembre = statutMembre;
    }

    public Integer getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(Integer idMembre) {
        this.idMembre = idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getCodeMembre() {
        return codeMembre;
    }

    public void setCodeMembre(String codeMembre) {
        this.codeMembre = codeMembre;
    }

    public String getMdpMembre() {
        return mdpMembre;
    }

    public void setMdpMembre(String mdpMembre) {
        this.mdpMembre = mdpMembre;
    }

    public Character getStatutMembre() {
        return statutMembre;
    }

    public void setStatutMembre(Character statutMembre) {
        this.statutMembre = statutMembre;
    }

    public Integer getPieceMembre() {
        return pieceMembre;
    }

    public void setPieceMembre(Integer pieceMembre) {
        this.pieceMembre = pieceMembre;
    }

    @XmlTransient
    public Collection<Contrat> getContratCollection() {
        return contratCollection;
    }

    public void setContratCollection(Collection<Contrat> contratCollection) {
        this.contratCollection = contratCollection;
    }

    @XmlTransient
    public Collection<Contrat> getContratCollection1() {
        return contratCollection1;
    }

    public void setContratCollection1(Collection<Contrat> contratCollection1) {
        this.contratCollection1 = contratCollection1;
    }

    @XmlTransient
    public Collection<Killfeed> getKillfeedCollection() {
        return killfeedCollection;
    }

    public void setKillfeedCollection(Collection<Killfeed> killfeedCollection) {
        this.killfeedCollection = killfeedCollection;
    }

    @XmlTransient
    public Collection<Killfeed> getKillfeedCollection1() {
        return killfeedCollection1;
    }

    public void setKillfeedCollection1(Collection<Killfeed> killfeedCollection1) {
        this.killfeedCollection1 = killfeedCollection1;
    }

    public Rang getIdRang() {
        return idRang;
    }

    public void setIdRang(Rang idRang) {
        this.idRang = idRang;
    }

    public Jeux getIdJeu() {
        return idJeu;
    }

    public void setIdJeu(Jeux idJeu) {
        this.idJeu = idJeu;
    }

    @XmlTransient
    public Collection<Pari> getPariCollection() {
        return pariCollection;
    }

    public void setPariCollection(Collection<Pari> pariCollection) {
        this.pariCollection = pariCollection;
    }

    @XmlTransient
    public Collection<Pari> getPariCollection1() {
        return pariCollection1;
    }

    public void setPariCollection1(Collection<Pari> pariCollection1) {
        this.pariCollection1 = pariCollection1;
    }

    @XmlTransient
    public Collection<Pari> getPariCollection2() {
        return pariCollection2;
    }

    public void setPariCollection2(Collection<Pari> pariCollection2) {
        this.pariCollection2 = pariCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembre != null ? idMembre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membre)) {
            return false;
        }
        Membre other = (Membre) object;
        if ((this.idMembre == null && other.idMembre != null) || (this.idMembre != null && !this.idMembre.equals(other.idMembre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Membre[ idMembre=" + idMembre + " ]";
    }
    
}
