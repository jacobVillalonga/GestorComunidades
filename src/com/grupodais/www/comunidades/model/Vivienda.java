/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodais.www.comunidades.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administracion
 */
@Entity
@Table(name = "vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v"),
    @NamedQuery(name = "Vivienda.findByIdVivienda", query = "SELECT v FROM Vivienda v WHERE v.idVivienda = :idVivienda"),
    @NamedQuery(name = "Vivienda.findByNumero", query = "SELECT v FROM Vivienda v WHERE v.numero = :numero"),
    @NamedQuery(name = "Vivienda.findByComunidad", query = "SELECT v FROM Vivienda v WHERE v.comunidadFk = :comunidadFk")})
public class Vivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vivienda")
    private Integer idVivienda;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @ManyToMany(mappedBy = "viviendaCollection", fetch = FetchType.LAZY)
    private Collection<Propietario> propietarioCollection;
    @JoinColumn(name = "comunidad_fk", referencedColumnName = "id_comunidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Comunidad comunidadFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viviendaFk", fetch = FetchType.LAZY)
    private Collection<PagoCuota> pagoCuotaCollection;

    public Vivienda() {
    }

    public Vivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public Vivienda(Integer idVivienda, String numero) {
        this.idVivienda = idVivienda;
        this.numero = numero;
    }

    public Integer getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @XmlTransient
    public Collection<Propietario> getPropietarioCollection() {
        return propietarioCollection;
    }

    public void setPropietarioCollection(Collection<Propietario> propietarioCollection) {
        this.propietarioCollection = propietarioCollection;
    }

    public Comunidad getComunidadFk() {
        return comunidadFk;
    }

    public void setComunidadFk(Comunidad comunidadFk) {
        this.comunidadFk = comunidadFk;
    }

    @XmlTransient
    public Collection<PagoCuota> getPagoCuotaCollection() {
        return pagoCuotaCollection;
    }

    public void setPagoCuotaCollection(Collection<PagoCuota> pagoCuotaCollection) {
        this.pagoCuotaCollection = pagoCuotaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVivienda != null ? idVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vivienda)) {
            return false;
        }
        Vivienda other = (Vivienda) object;
        if ((this.idVivienda == null && other.idVivienda != null) || (this.idVivienda != null && !this.idVivienda.equals(other.idVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vivienda{" + "idVivienda=" + idVivienda + ", numero=" + numero + ", comunidadFk=" + comunidadFk + '}';
    }
    
    //devuelve los datos de la vivienda en forma de vector de Strings para mostrarlos en una tabla
    public Vector<String> getDataVector(){
        Vector vector = new Vector();
        vector.addElement(this.idVivienda.toString());
        vector.addElement(this.numero);
//        vector.addElement(this.comunidadFk);
        return vector;
    }
}
