/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.time.LocalDate;

import controlador.Renderizado;
import controlador.XPlanning;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author peyu
 */
public class Planning extends javax.swing.JDialog {
    

    /**
     * Creates new form Planning
     */
    public Planning(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tblPlanning.setVisible(true);
        
        XPlanning xp = new XPlanning();
        int habs = xp.getHabs();
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Hab");
        
        //agrego las columnas al modelo
        for (int i = 1; i < 32; i++) {
           modelo.addColumn(i);
        }
        
        //Declaro Vector para las filas
        Vector<Object> row = new Vector<Object>();
        
        //Declaro ArrayList para pintar celdas
        ArrayList<Integer> pintar = new ArrayList<Integer>();
        //Vector<Object> pintar = new Vector<Object>();
        //Renderizado rend = new Renderizado();
        
//        ArrayList<Integer> celdas = new ArrayList<Integer>();
//        
//        celdas.add(1);
        
//        Renderizado.pintar.add(0);
//                        Renderizado.pintar.add(2);
//                        
////                        Triplet de color rgb (Verde)
//                        Renderizado.pintar.add(0); 
//                        Renderizado.pintar.add(255);
//                        Renderizado.pintar.add(0);
        
        
        //Inicializo Vector para evitar OutOfBound
        for (int i = 0; i < 31; i++) {
            row.add("");
            
        }
        
        //Obtengo datos de octubre en la hab 202
        ResultSet rs = xp.getDatos(202);
       
        try{
            int i=0;
            
            
            //Agrego nombre de la fila en indice 0
            row.add(0,202);
            
            while(rs.next()){
                
                i++;
                    
                    int hab= rs.getInt("numero_hab");
                    String nombre=rs.getString("nombre");
                    java.sql.Date fecha_aux= rs.getDate("dia_reservado");
                    LocalDate fecha = fecha_aux.toLocalDate();
                    int idRes= rs.getInt("idreserva");
                    String estado= rs.getString("estado");
                    if(estado.equals("Confirmada")){
                        //cordenada a pintar
                        pintar.add(0);
                        pintar.add(fecha.getDayOfMonth());
                        
                        //Triplet de color rgb (Verde)
                        pintar.add(0); 
                        pintar.add(255);
                        pintar.add(0);
                        
                    }
                    
                    
                    //para no comparar con un rs.before que no existe
                    if (i>1){
                        rs.absolute(i-1);
                        int hab01= rs.getInt("numero_hab");
                        String nombre01=rs.getString("nombre");
                        java.sql.Date fecha_aux01= rs.getDate("dia_reservado");
                        LocalDate fecha01 = fecha_aux.toLocalDate();
                        int idRes01=rs.getInt("idreserva");
                        String estado01= rs.getString("estado");
                        rs.absolute(i+1);
                        if(idRes==idRes01){
                        //no hago nada
                        }else{
                        row.add(fecha.getDayOfMonth(), nombre);
                        
                        } 
                        
                        
                        
                    }else {
                    row.add(fecha.getDayOfMonth(),nombre);
                        
                    }

             
                     
                    
            }
            
                        
        }catch(Exception e){e.printStackTrace();}    
            
        
        
        modelo.addRow(row);
        
        
        
        
        
         
//
//            row.add(5,"celda 1");
            
//            row.add("celda 2"); 
//            row.add("celda 3"); 
//            row.add("otra");
//            modelo.addRow(row);
//            modelo.addRow(row);

        
           
        
        
        
        
        
        
        //pintado de celdas
        //Renderizado rend = new Renderizado(0,3);
        //tblPlanning.setDefaultRenderer(Object.class, rend);
        
        tblPlanning.setDefaultRenderer(Object.class, new Renderizado(pintar));
        
        
        
        tblPlanning.setModel(modelo);
  
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlanning = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbMes = new javax.swing.JComboBox();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPlanning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPlanning);

        jLabel1.setText("Mes:");

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "setiembe", "Octube", "Noviembre", "Diciembre" }));

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConsultar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        
        tblPlanning.setVisible(true);
        
    }//GEN-LAST:event_btnConsultarActionPerformed


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Planning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Planning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Planning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Planning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Planning dialog = new Planning(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPlanning;
    // End of variables declaration//GEN-END:variables
}
