/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodais.www.comunidades.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administracion
 */
@Entity
@Table(name = "comunidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunidad.findAll", query = "SELECT c FROM Comunidad c"),
    @NamedQuery(name = "Comunidad.findByIdComunidad", query = "SELECT c FROM Comunidad c WHERE c.idComunidad = :idComunidad"),
    @NamedQuery(name = "Comunidad.findByNombreComunidad", query = "SELECT c FROM Comunidad c WHERE c.nombreComunidad = :nombreComunidad"),
    @NamedQuery(name = "Comunidad.findByProvincia", query = "SELECT c FROM Comunidad c WHERE c.provincia = :provincia"),
    @NamedQuery(name = "Comunidad.findByDireccion", query = "SELECT c FROM Comunidad c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Comunidad.findByPoblacion", query = "SELECT c FROM Comunidad c WHERE c.poblacion = :poblacion"),
    @NamedQuery(name = "Comunidad.findByCp", query = "SELECT c FROM Comunidad c WHERE c.cp = :cp")})
public class Comunidad implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comunidad")
    private Integer idComunidad;
    @Basic(optional = false)
    @Column(name = "nombre_comunidad")
    private String nombreComunidad;
    @Basic(optional = false)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "poblacion")
    private String poblacion;
    @Basic(optional = false)
    @Column(name = "cp")
    private String cp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunidadFk", fetch = FetchType.LAZY)
    private Collection<Vivienda> viviendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comunidadFk", fetch = FetchType.LAZY)
    private Collection<Factura> facturaCollection;

    public Comunidad() {
    }

    public Comunidad(Integer idComunidad) {
        this.idComunidad = idComunidad;
    }

    public Comunidad(Integer idComunidad, String nombreComunidad, String provincia, String direccion, String poblacion, String cp) {
        this.idComunidad = idComunidad;
        this.nombreComunidad = nombreComunidad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.cp = cp;
    }

    public Integer getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(Integer idComunidad) {
        Integer oldIdComunidad = this.idComunidad;
        this.idComunidad = idComunidad;
        changeSupport.firePropertyChange("idComunidad", oldIdComunidad, idComunidad);
    }

    public String getNombreComunidad() {
        return nombreComunidad;
    }

    public void setNombreComunidad(String nombreComunidad) {
        String oldNombreComunidad = this.nombreComunidad;
        this.nombreComunidad = nombreComunidad;
        changeSupport.firePropertyChange("nombreComunidad", oldNombreComunidad, nombreComunidad);
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        String oldProvincia = this.provincia;
        this.provincia = provincia;
        changeSupport.firePropertyChange("provincia", oldProvincia, provincia);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        String oldPoblacion = this.poblacion;
        this.poblacion = poblacion;
        changeSupport.firePropertyChange("poblacion", oldPoblacion, poblacion);
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        String oldCp = this.cp;
        this.cp = cp;
        changeSupport.firePropertyChange("cp", oldCp, cp);
    }

    @XmlTransient
    public Collection<Vivienda> getViviendaCollection() {
        return viviendaCollection;
    }

    public void setViviendaCollection(Collection<Vivienda> viviendaCollection) {
        this.viviendaCollection = viviendaCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComunidad != null ? idComunidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunidad)) {
            return false;
        }
        Comunidad other = (Comunidad) object;
        if ((this.idComunidad == null && other.idComunidad != null) || (this.idComunidad != null && !this.idComunidad.equals(other.idComunidad))) {
            return false;
        }
        return true;
    }
    
    public Vector<String> getDataVector(){
        Vector vector = new Vector();
        vector.addElement(this.idComunidad.toString());
        vector.addElement(this.nombreComunidad);
        vector.addElement(this.direccion);
        vector.addElement(this.cp);
        vector.addElement(this.poblacion);
        vector.addElement(this.provincia);
        return vector;
    }

    @Override
    public String toString() {
        return "Comunidad{" + "idComunidad=" + idComunidad + ", nombreComunidad=" + nombreComunidad + ", provincia=" + provincia + ", direccion=" + direccion + ", poblacion=" + poblacion + ", cp=" + cp + '}';
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
