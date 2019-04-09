/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodais.www.comunidades.controller;

import com.grupodais.www.comunidades.auxiliares.ComunidadesException;
import com.grupodais.www.comunidades.model.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author administracion
 */
public class Persistencia {
    
    public String unidadPersistencia;

    public Persistencia(String unidadPersistencia) throws ComunidadesException {
        if (unidadPersistencia == null || unidadPersistencia.trim().isEmpty()){
            throw new ComunidadesException("String unidadPersistencia cant be null or empty");
        }else {
            this.unidadPersistencia = unidadPersistencia;
        }
    }
    
    public String getUnidadPersistencia() {
        return unidadPersistencia;
    }

//COMUNIDADES
    //Devuelve todas las comunidades
    public static List<Comunidad> getComunidades(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery tq=em.createQuery("SELECT c FROM Comunidad c", Comunidad.class);
        List comunidades = tq.getResultList();
        em.close();
        emf.close();
        return comunidades;
        
    }
    //Devuelve la comunidad con la id del parametro
    public static Comunidad getComunidad(int idCom){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        Comunidad comunidad = em.find(Comunidad.class, idCom);
        em.close();
        emf.close();
        return comunidad;
    }
    //Actualiza la Comunidad del parametro en la BDD
    public static void updateComunidad(Comunidad comunidad){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.merge(comunidad);
        ts.commit();
        em.close();
        emf.close();
    }
    //Actualiza la Comunidad del parametro en la BDD
    public static void deleteComunidad(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.merge(id);
        ts.commit();
        em.close();
        emf.close();
    }
    
//VIVIENDAS
    //Devuelve todas las viviendas de la comunidad del parametro
    public static List<Vivienda> getViviendasComunidad(Comunidad comunidad){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery tq = em.createNamedQuery("Vivienda.findByComunidad", Vivienda.class);
        tq.setParameter("comunidadFk", comunidad);
        List viviendas = tq.getResultList();
        //si no sout, error: org.hibernate.LazyInitializationException - could not initialize proxy - no Session
        if (viviendas.size()>0){
            System.out.println(viviendas.get(0));
        }
        em.close();
        emf.close();
        return viviendas;
        
    }
    public static List<Vivienda> getViviendasComunidad(String comunidad){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery tq = em.createNamedQuery("Vivienda.findByComunidad", Vivienda.class);
        tq.setParameter("comunidadFk", comunidad);
        List viviendas = tq.getResultList();
        //si no sout, error: org.hibernate.LazyInitializationException - could not initialize proxy - no Session
        if (viviendas.size()>0){
            System.out.println(viviendas.get(0));
        }
        em.close();
        emf.close();
        return viviendas;
        
    }
    //Devuelve la vivienda con la id del parametro
    public static Vivienda getVivienda (int idViv){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        Vivienda vivienda = em.find(Vivienda.class, idViv);
        System.out.println("MEEC:" +vivienda);
        em.close();
        emf.close();
        return vivienda;
    }
    //Actualiza la Vivienda del parametro en la BDD
    public static void updateVivienda(Vivienda vivienda){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.merge(vivienda);
        ts.commit();
        em.close();
        emf.close();
    }
    
//PROPIETARIOS
    //Devuelve al propietario con la id del parametro
    public static Propietario getPropietario(int idPropietario){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        Propietario propietario = em.find(Propietario.class, idPropietario);
        em.close();
        emf.close();
        return propietario;
    }
    //Devuelve todos los propietarios de la vivienda del parametro
    public static List<Propietario> getPropietariosVivienda(Vivienda vivienda){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        String qery = "SELECT p FROM Propietario p JOIN p.viviendaCollection v  WHERE v.idVivienda = :idVivienda";
        TypedQuery tq=em.createQuery(qery, Propietario.class);
        tq.setParameter("idVivienda",vivienda.getIdVivienda());
        List propietarios = tq.getResultList();
        em.close();
        emf.close();
        return propietarios;
    }
    //Devuelve todos los propietarios de la comunidad del parametro
    public static List<Propietario> getPropietariosComunidad(Comunidad comunidad){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        String qery = "SELECT p FROM Propietario p "
                + "JOIN p.viviendaCollection v "
                + "JOIN v.comunidadFk c "
                + "WHERE c.idComunidad = :idComunidad";
        TypedQuery tq=em.createQuery(qery, Propietario.class);
        tq.setParameter("idComunidad",comunidad.getIdComunidad());
        List propietarios = tq.getResultList();
        em.close();
        emf.close();
        return propietarios;
    }
    //Devuelve todos los propietarios de la comunidad del parametro sin repeticiones
    public static List<Propietario> getPropietariosComunidadDistinct(Comunidad comunidad){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        String qery = "SELECT DISTINCT p FROM Propietario p "
                + "JOIN p.viviendaCollection v "
                + "JOIN v.comunidadFk c "
                + "WHERE c.idComunidad = :idComunidad";
        TypedQuery tq=em.createQuery(qery, Propietario.class);
        tq.setParameter("idComunidad",comunidad.getIdComunidad());
        List propietarios = tq.getResultList();
        em.close();
        emf.close();
        return propietarios;
    }
    //Actualiza el propietario del parametro en la BDD
    public static void updatePropietario(Propietario propietario){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.merge(propietario);
        ts.commit();
        em.close();
        emf.close();
    }
    
//FACTURAS
    //Devuelve la factura con la id del parametro
    public static Factura getFactura (int idFac){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        Factura factura = em.find(Factura.class, idFac);
        em.close();
        emf.close();
        return factura;
    }
    //Devuelve todas las facturas de la comunidad del parametro
    public static List<Factura> getFacturasComunidad(Comunidad comunidad){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery tq = em.createNamedQuery("Factura.findByComunidad", Factura.class);
        tq.setParameter("comunidadFk", comunidad);
        List facturas = tq.getResultList();
        //if !sout, error: org.hibernate.LazyInitializationException - could not initialize proxy - no Session
        if (facturas.size()>0){
            System.out.println(facturas.get(0));
        }
        em.close();
        emf.close();
        return facturas;
        
    }
    //Actualiza la Factura del parametro en la BDD
    public static void updateFactura(Factura factura){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.merge(factura);
        ts.commit();
        em.close();
        emf.close();
    }
    
//PAGO_CUOTAS
    //Devuelve la cuota con la id del parametro
    public static PagoCuota getCuota (int idCuota){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        PagoCuota cuota = em.find(PagoCuota.class, idCuota);
        em.close();
        emf.close();
        return cuota;
    }
    //Devuelve todas las facturas de la comunidad del parametro
    public static List<PagoCuota> getCuotasVivienda(Vivienda vivienda){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery tq = em.createNamedQuery("PagoCuota.findByVivienda", PagoCuota.class);
        tq.setParameter("viviendaFk", vivienda);
        List cuotas = tq.getResultList();
        //if !sout, error: org.hibernate.LazyInitializationException - could not initialize proxy - no Session
        if (cuotas.size()>0){
            System.out.println(cuotas.get(0));
        }
        em.close();
        emf.close();
        return cuotas;
        
    }    
    //Actualiza el PagoCuota del parametro en la BDD
    public static void updatePagoCuota(PagoCuota cuota){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.merge(cuota);
        ts.commit();
        em.close();
        emf.close();
    }
    
//GENERICS
    //Inserta objeto
    public static void insertObject(Object objeto){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.persist(objeto);
        ts.commit();
        em.close();
        emf.close();
    }
    //Actualiza objeto
    public static void updateObject(Object objeto){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.merge(objeto);
        ts.commit();
        em.close();
        emf.close();
    }
    //Elimina objeto
    public static void deleteObject(Object objeto){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorComunidadesPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();
        ts.begin();
        em.remove(em.contains(objeto) ? objeto : em.merge(objeto));
        ts.commit();
        em.close();
        emf.close();
    }
    
}