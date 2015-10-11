/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;


/**
 *
 * @author peyu
 */

//Esto puede ser util:
//java.util.Date date = new Date();
//Object param = new java.sql.Timestamp(date.getTime());
//// The JDBC driver knows what to do with a java.sql type:
//preparedStatement.setObject(param); 


//java.util.Date dt = new java.util.Date();
//
//java.text.SimpleDateFormat sdf = 
//     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//String currentTime = sdf.format(dt);




public class Reserva {
    
    private String fecha_reserva;                 //si se prepara el String parece guardarse bien en db
    private String estado;          //Varchar(20)
    private String observaciones;   //Varchar(255)
    private float importe_pagado;
    private int numero_hab;
    public ArrayList<Huesped> huespedes;
    // private ArrayList<String> estadia;   //no creo que sea asi
    private String fecha_ingreso;
    private String fecha_salida;
    
    
    
    //ejemplo de como preparar el string
//   Date miFecha = new Date(Date.UTC(2015, 10, 15, 14, 00, 00));
//     
//   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    
//   String fecha = sdf.format(miFecha); 

    //Constructor con todos los parametros
    public Reserva(String fecha_reserva, String estado, String observaciones, float importe_pagado, int numero_hab, ArrayList<Huesped> huespedes, String fecha_ingreso, String fecha_salida) {
        this.fecha_reserva = fecha_reserva;
        this.estado = estado;
        this.observaciones = observaciones;
        this.importe_pagado = importe_pagado;
        this.numero_hab = numero_hab;
        this.huespedes = huespedes;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
    }

    //Constructor vacio
    public Reserva() {
        huespedes = new ArrayList();
        
    }

   

    
//G&S

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public float getImporte_pagado() {
        return importe_pagado;
    }

    public void setImporte_pagado(float importe_pagado) {
        this.importe_pagado = importe_pagado;
    }

    public int getNumero_hab() {
        return numero_hab;
    }

    public void setNumero_hab(int numero_hab) {
        this.numero_hab = numero_hab;
    }

    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(ArrayList<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
    
    
    
}
