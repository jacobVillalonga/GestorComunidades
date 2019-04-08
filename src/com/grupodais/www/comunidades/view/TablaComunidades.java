/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupodais.www.comunidades.view;

import com.grupodais.www.comunidades.controller.Persistencia;
import com.grupodais.www.comunidades.model.Comunidad;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author administracion
 */
public class TablaComunidades {

    public static void main(String[] argv) {

        List<Comunidad> comus = Persistencia.getComunidades();

        Vector rowData = new Vector();

        for (Comunidad comu : comus) {
            rowData.addElement(comu.getDataVector());
        }

        String[] columnNames = {"ID", "Nombre", "Direccion", "CP", "Poblacion", "Provincia"};

        Vector columnNamesV = new Vector(Arrays.asList(columnNames));

        JTable table = new JTable(rowData, columnNamesV);
        
        table.setCellSelectionEnabled(true);
    ListSelectionModel cellSelectionModel = table.getSelectionModel();
    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        String selectedData = null;

        int[] selectedRow = table.getSelectedRows();
        int[] selectedColumns = table.getSelectedColumns();

        for (int i = 0; i < selectedRow.length; i++) {
          for (int j = 0; j < selectedColumns.length; j++) {
            selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
          }
        }
        System.out.println("Selected: " + selectedData);
      }

    });
    
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        f.setSize(300, 300);
        f.add(new JScrollPane(table));
        f.setVisible(true);

    }
}
