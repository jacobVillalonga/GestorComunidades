/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;

import com.grupodais.www.comunidades.controller.Persistencia;
import com.grupodais.www.comunidades.model.Comunidad;
import com.grupodais.www.comunidades.model.Vivienda;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author administracion
 */
public class DBProves {

    public Boolean insert(Comunidad com){
        Persistencia.insertObject(com);
        return true;
    }
    public Boolean update(Comunidad com){
        Persistencia.updateObject(com);
        return true;
    }
    public Boolean delete(Comunidad com){
        Persistencia.deleteObject(com);
        return true;
    }
    
    public DefaultTableModel getData(){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Id");
        dt.addColumn("Nombre");
        dt.addColumn("Dirección");
        dt.addColumn("Código postal");
        dt.addColumn("Población");
        dt.addColumn("Provincia");
        
        List<Comunidad> comus = Persistencia.getComunidades();
        for (Comunidad comu : comus) {
            dt.addRow(comu.getDataVector());
        }
        return dt;
    }
    public DefaultTableModel getViviendas(int id){
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Id");
        dt.addColumn("Número");
        Comunidad com = new Comunidad();
        com.setIdComunidad(id);
        List<Vivienda> vivs = Persistencia.getViviendasComunidad(com);
        for (Vivienda viv : vivs) {
            dt.addRow(viv.getDataVector());
        }
        return dt;
    }
}
