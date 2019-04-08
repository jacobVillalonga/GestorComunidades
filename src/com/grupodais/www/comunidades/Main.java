/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodais.www.comunidades;

import com.grupodais.www.comunidades.controller.Persistencia;
import com.grupodais.www.comunidades.model.*;
import java.util.Collection;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author administracion
 */
public class Main {
    
    public static void main(String[] args){
        
//        System.out.println(Persistencia.getPropietario(1));
//        
//        Collection <Comunidad> comus = Persistencia.getComunidades();
//        for (Comunidad com : Persistencia.getComunidades()){
//            System.out.println(com);
//        }
//        Comunidad com = Persistencia.getComunidad(1);
//        for (Vivienda viv : Persistencia.getViviendasComunidad(com)){
//            System.out.println(viv);
//        }
//        System.out.println("FACTURITAS:");
//        for (Factura fac : Persistencia.getFacturasComunidad(com)){
//            System.out.println(fac);
//        }
//        
//        Vivienda mec = Persistencia.getVivienda(1);
//        System.out.println("Pagos Cuotas Vivienda 1:");
//        for (PagoCuota cuota : Persistencia.getCuotasVivienda(mec)){
//            System.out.println(cuota);
//        }
//        for (Propietario prop : Persistencia.getPropietariosVivienda(mec)){
//            System.out.println(prop);
//        }
//        System.out.println("Propietarios Vivienda 1:");
//        Collection <Propietario> props = Persistencia.getPropietariosVivienda(mec);
//        for (Propietario prop : props){
//            System.out.println(prop);
//        }
        for (Propietario p : Persistencia.getPropietariosComunidadDistinct(Persistencia.getComunidad(1))){
            System.out.println(p);
        }
    }
    
}
