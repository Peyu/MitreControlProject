/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author peyu
 */
public class Huesped {
    String tipoDocumento;    //varchar(3)
    int DNI;                //Int(9)
    String nombre;          //varchar(45)
    String mail;            //varchar(35)
    String observaciones;   //varchar(100)
    String vehiculo;        //varchar(8)

    
    //Sera necesario hacer varios constructores para campos no nulos???? 
    
    public Huesped(String tipoDocumento, int DNI, String nombre, String mail, String observaciones, String vehiculo) {
        this.tipoDocumento = tipoDocumento;
        this.DNI = DNI;
        this.nombre = nombre;
        this.mail = mail;
        this.observaciones = observaciones;
        this.vehiculo = vehiculo;
    }
    




}

