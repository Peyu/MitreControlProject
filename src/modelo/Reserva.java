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
    private ArrayList<Huesped> huespedes;
    // private ArrayList<String> estadia;   //no creo que sea asi
    private String fecha_ingreso;
    private String fecha_salida;
    
    
    
    //ejemplo de como preparar el string
//   Date miFecha = new Date(Date.UTC(2015, 10, 15, 14, 00, 00));
//     
//   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    
//   String fecha = sdf.format(miFecha); 

        
    
    
    
    
    
    
}
