/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.XHuesped;
import controlador.XReserva;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Huesped;
import modelo.Reserva;
import java.sql.Timestamp;



/**
 *
 * @author peyu
 * Falta poblar el cmb de habitaciones con el resutado de una busqueda en BD de hab disponibles
 * Falta Accion en Boton Cancelar
 * Falta accion en boton Menos
 * Falta agregar idres/idhues a la tabla intermedia en la creacion de reserva/Huesped
*/



public class CrearReserva extends javax.swing.JDialog {
    public static Reserva res;
    //public static ArrayList<Huesped> huesTemp;
    private DefaultListModel listModel;   //listModel para poblar JList lstHuespedes 
    /**
     * Creates new form CrearReserva
     */
    public CrearReserva(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        //Titulo del Panel
        pnlGroup.setBorder(BorderFactory.createTitledBorder("Huespedes"));
        res = new Reserva();  //inicializo static res
        listModel = new DefaultListModel();   
        
        
       
        
        

//        
//         Huesped hues1 = new Huesped("DNI ", "27982218","Andres Coppola ","cop@gmail ","huesped frecuente ","JON 264 ");
//       
//        res.huespedes = new ArrayList();
//        res.huespedes.add(hues1);
//        
//        //res.getHuespedes().add(hues1);
//        XHuesped xh = new XHuesped(res.getHuespedes().get(1));
//        xh.Mostrar();
//              
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGroup = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstHuespedes = new javax.swing.JList();
        btnMas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMenos = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaObs = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox();
        txtAnticipo = new javax.swing.JTextField();
        dpkIngreso = new org.jdesktop.swingx.JXDatePicker();
        dpkSalida = new org.jdesktop.swingx.JXDatePicker();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbHab = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstHuespedes.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        lstHuespedes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstHuespedes.setFixedCellHeight(10);
        jScrollPane1.setViewportView(lstHuespedes);

        btnMas.setText("+");
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });

        jLabel2.setText("Agregar Huespedes:");

        btnMenos.setText("-");

        javax.swing.GroupLayout pnlGroupLayout = new javax.swing.GroupLayout(pnlGroup);
        pnlGroup.setLayout(pnlGroupLayout);
        pnlGroupLayout.setHorizontalGroup(
            pnlGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGroupLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGroupLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlGroupLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMenos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        pnlGroupLayout.setVerticalGroup(
            pnlGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(pnlGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGroupLayout.createSequentialGroup()
                        .addComponent(btnMas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenos))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha Ingreso:");

        jLabel3.setText("Fecha Salida:");

        jLabel4.setText("Estado:");

        jLabel5.setText("Anticipo:");

        jLabel6.setText("Observaciones de la Reserva:");

        txtaObs.setColumns(20);
        txtaObs.setRows(5);
        jScrollPane2.setViewportView(txtaObs);

        jButton1.setText("Cancelar");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tentativa", "Confirmada", "Cancelada" }));

        txtAnticipo.setText("0.00");

        jButton2.setText("salida a consola");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Hab:");

        cmbHab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "202", "1510" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dpkIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dpkSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnticipo)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(78, 78, 78)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(btnAceptar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dpkIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dpkSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtAnticipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        // TODO add your handling code here:
        new vista.AgregarHuesped(this,true).setVisible(true);
        
        int vueltas=0;
        
        
        //Vacio el DefaulListModel para evitar repeticiones
        listModel.clear();
        
        //Recorro ArrayList y agrego elementos al DefaultListModel
        for(Huesped huesped : res.getHuespedes()){
                        
            listModel.addElement(huesped.getNombre());
        }
        
        
        
        //Agrego el DefaultListModel al Jlist
        lstHuespedes.setModel(listModel);
        
        
        
        
        
        
    }//GEN-LAST:event_btnMasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
     
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        
        //bandera para saber si estan listos todos los campos
        boolean datosOk= false;
        java.sql.Date fecha_ingreso=null;
        java.sql.Date fecha_reserva=null;
        java.sql.Date fecha_salida=null;
        String estado=null;
        String observaciones=null;
        float anticipo2 = 0;
        int hab = 0;
        int idRes=0;
        
        //Valido los campos y prepara datos para la reserva.
       
        if (listModel.isEmpty()){
             JOptionPane.showMessageDialog(null, "Debe agregar al menos un Huesped a la reserva");
             
        }else{
            
            String obs= txtaObs.getText();
            if (obs.length()>255){
                  //agregar msg
                JOptionPane.showMessageDialog(null, "Las observaciones no pueden sobrepasar los 255 caracteres");
            }else{
            
                fecha_reserva = new java.sql.Date(new java.util.Date().getTime());
                observaciones = txtaObs.getText();
                
                
                if(dpkIngreso.getDate()==null || dpkSalida.getDate()==null){
                    JOptionPane.showMessageDialog(null, "Las fechas de Ingreso y Egreso no pueden estar vacias");
                }else{
                    
                    if(!(dpkIngreso.getDate().getTime() <= dpkSalida.getDate().getTime())){
                        JOptionPane.showMessageDialog(null, "La fecha de Ingreso debe ser anterior a la de salida");
                                       
                    }else{
                        datosOk = true;

                        java.util.Date ingresoUtil = dpkIngreso.getDate();
                        fecha_ingreso = new java.sql.Date(ingresoUtil.getTime());

                        java.util.Date salidaUtil = dpkSalida.getDate();
                        fecha_salida = new java.sql.Date(salidaUtil.getTime());

                        estado= (String)cmbEstado.getSelectedItem();
                        System.out.println(estado);

                        String anticipo= txtAnticipo.getText();


                        try {
                            anticipo2 = Float.parseFloat(anticipo);
                        }   
                        catch(NumberFormatException e) {
                             JOptionPane.showMessageDialog(null,"El anticipo debe ser numerico"); 
                             datosOk = false;
                        }

                        hab = Integer.parseInt((String)cmbHab.getSelectedItem());
                        System.out.println(hab);
                    }        
                    
            }            
            }
                        
        
        }
        
        if (datosOk){
            //si estan los datos listos guardo la reserva en BD
            XReserva xr = new XReserva();
            XHuesped xh = new XHuesped();
            
            xr.CrearReserva(fecha_reserva, fecha_ingreso, fecha_salida, estado, observaciones, anticipo2, hab);
            idRes = xr.getIdUltimaRes();
            System.out.println("id de la reserva: " + idRes);
            
            
            ArrayList<Integer> idsDeHuesped = new ArrayList();
            //Grabo cada Huesped Creado en BD y guardo Ids en Array (De los creados y existentes)
            int i=0;
            
            
            for(Huesped huesped : res.getHuespedes()){
                //Falta poner huesped.getIdEmp() al final en lugar de 1 en xh.CrearHuesped
                i++;
                System.out.println("Vuelta " +i);
                if(huesped.getIdHues()>0){
                    idsDeHuesped.add(huesped.getIdHues());
                    System.out.println("Id del Huesped creado anteriormente agregado al array: " + huesped.getIdHues());
                }else{
                
                    xh.CrearHuesped(huesped.getTipoDocumento(), huesped.getDNI(), huesped.getNombre(), huesped.getMail(), huesped.getObservaciones(), huesped.getVehiculo(), 1);
                    idsDeHuesped.add(xh.getUltimoId());
                    System.out.println("id de HUesped creado actualmente e ingresado al array: " + xh.getUltimoId());
                    
                }            
            }
                
            //Grabo en la tabla intermedia los idhuesped con la idres correspondiente
            
            for(int id : idsDeHuesped){
                
                xr.GrabarTableIntermedia(id, idRes);
                //System.out.println("id huesped a grabar: " + id);
                
            }
            
            dispose();
            
        }
            
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearReserva dialog = new CrearReserva(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnMenos;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbHab;
    private org.jdesktop.swingx.JXDatePicker dpkIngreso;
    private org.jdesktop.swingx.JXDatePicker dpkSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstHuespedes;
    private javax.swing.JPanel pnlGroup;
    private javax.swing.JTextField txtAnticipo;
    private javax.swing.JTextArea txtaObs;
    // End of variables declaration//GEN-END:variables


//G&S

    public Reserva getRes() {
        return res;
    }

    public void setRes(Reserva res) {
        this.res = res;
    }



}
