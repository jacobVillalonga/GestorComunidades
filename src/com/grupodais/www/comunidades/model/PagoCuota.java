/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodais.www.comunidades.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administracion
 */
@Entity
@Table(name = "pago_cuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoCuota.findAll", query = "SELECT p FROM PagoCuota p"),
    @NamedQuery(name = "PagoCuota.findByIdCuota", query = "SELECT p FROM PagoCuota p WHERE p.idCuota = :idCuota"),
    @NamedQuery(name = "PagoCuota.findByImporte", query = "SELECT p FROM PagoCuota p WHERE p.importe = :importe"),
    @NamedQuery(name = "PagoCuota.findByFecha", query = "SELECT p FROM PagoCuota p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PagoCuota.findByPagado", query = "SELECT p FROM PagoCuota p WHERE p.pagado = :pagado"),
    @NamedQuery(name = "PagoCuota.findByVivienda", query = "SELECT p FROM PagoCuota p WHERE p.viviendaFk = :viviendaFk")})

public class PagoCuota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuota")
    private Integer idCuota;
    @Basic(optional = false)
    @Column(name = "importe")
    private float importe;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @Column(name = "pagado")
    private boolean pagado;
    @JoinColumn(name = "vivienda_fk", referencedColumnName = "id_vivienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vivienda viviendaFk;

    public PagoCuota() {
    }

    public PagoCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public PagoCuota(Integer idCuota, float importe, String fecha, boolean pagado) {
        this.idCuota = idCuota;
        this.importe = importe;
        this.fecha = fecha;
        this.pagado = pagado;
    }

    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean getPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Vivienda getViviendaFk() {
        return viviendaFk;
    }

    public void setViviendaFk(Vivienda viviendaFk) {
        this.viviendaFk = viviendaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuota != null ? idCuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoCuota)) {
            return false;
        }
        PagoCuota other = (PagoCuota) object;
        if ((this.idCuota == null && other.idCuota != null) || (this.idCuota != null && !this.idCuota.equals(other.idCuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PagoCuota{" + "idCuota=" + idCuota + ", importe=" + importe + ", fecha=" + fecha + ", pagado=" + pagado + ", viviendaFk=" + viviendaFk + '}';
    }

}
