/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodais.www.comunidades.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administracion
 */
@Entity
@Table(name = "propietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p"),
    @NamedQuery(name = "Propietario.findByIdPropietario", query = "SELECT p FROM Propietario p WHERE p.idPropietario = :idPropietario"),
    @NamedQuery(name = "Propietario.findByNombre", query = "SELECT p FROM Propietario p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Propietario.findByApellidos", query = "SELECT p FROM Propietario p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Propietario.findByNif", query = "SELECT p FROM Propietario p WHERE p.nif = :nif"),
    @NamedQuery(name = "Propietario.findByFechaNacimiento", query = "SELECT p FROM Propietario p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Propietario.findBySexo", query = "SELECT p FROM Propietario p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Propietario.findByTelefono", query = "SELECT p FROM Propietario p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Propietario.findByTelefono2", query = "SELECT p FROM Propietario p WHERE p.telefono2 = :telefono2"),
    @NamedQuery(name = "Propietario.findByEmail", query = "SELECT p FROM Propietario p WHERE p.email = :email"),
    @NamedQuery(name = "Propietario.findByDireccion", query = "SELECT p FROM Propietario p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Propietario.findByCp", query = "SELECT p FROM Propietario p WHERE p.cp = :cp"),
    @NamedQuery(name = "Propietario.findByPoblacion", query = "SELECT p FROM Propietario p WHERE p.poblacion = :poblacion"),
    @NamedQuery(name = "Propietario.findByProvincia", query = "SELECT p FROM Propietario p WHERE p.provincia = :provincia"),
    @NamedQuery(name = "Propietario.findByPais", query = "SELECT p FROM Propietario p WHERE p.pais = :pais")
//        ,@NamedQuery(name = "Propietario.findByVivienda", query = "SELECT p FROM Propietario p WHERE p.idPropietario = "+
// "(SELECT pv FROM Prop)")  
//:comunidadFk")})
})

public class Propietario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_propietario")
    private Integer idPropietario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "nif")
    private String nif;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "telefono2")
    private String telefono2;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "cp")
    private String cp;
    @Basic(optional = false)
    @Column(name = "poblacion")
    private String poblacion;
    @Basic(optional = false)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @JoinTable(name = "prop_vivienda", joinColumns = {
        @JoinColumn(name = "id_propietario", referencedColumnName = "id_propietario")}, 
    inverseJoinColumns = {
        @JoinColumn(name = "id_vivienda", referencedColumnName = "id_vivienda")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Vivienda> viviendaCollection;

    public Propietario() {
    }

    public Propietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Propietario(Integer idPropietario, String nombre, String apellidos, String nif, Date fechaNacimiento, String sexo, String direccion, String cp, String poblacion, String provincia, String pais) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.cp = cp;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlTransient
    public Collection<Vivienda> getViviendaCollection() {
        return viviendaCollection;
    }

    public void setViviendaCollection(Collection<Vivienda> viviendaCollection) {
        this.viviendaCollection = viviendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPropietario != null ? idPropietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietario)) {
            return false;
        }
        Propietario other = (Propietario) object;
        if ((this.idPropietario == null && other.idPropietario != null) || (this.idPropietario != null && !this.idPropietario.equals(other.idPropietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Propietario{" + "idPropietario=" + idPropietario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", telefono=" + telefono + ", telefono2=" + telefono2 + ", email=" + email + ", direccion=" + direccion + ", cp=" + cp + ", poblacion=" + poblacion + ", provincia=" + provincia + ", pais=" + pais + '}';
    }
    
        //devuelve los datos del propietario en forma de vector de Strings para mostrarlos en una tabla
    public Vector<String> getDataVector(){
        Vector vector = new Vector();
        vector.addElement(this.idPropietario.toString());
        vector.addElement(this.nombre);
        vector.addElement(this.apellidos);
        vector.addElement(this.nif);
        vector.addElement(this.telefono);
        vector.addElement(this.email);
        return vector;
    }
}
