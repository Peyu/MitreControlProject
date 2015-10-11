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
    private String tipoDocumento;    //varchar(3)
    private String DNI;              //Varchar(12) porque los pasaportes tienen letras
    private String nombre;          //varchar(45)
    private String mail;            //varchar(35)
    private String observaciones;   //varchar(100)
    private String vehiculo;        //varchar(8)
    private int idEmp;

    
    //Constructores:
    
    //todos los parametros sin idEmp
    public Huesped(String tipoDocumento, String DNI, String nombre, String mail, String observaciones, String vehiculo) {
        this.tipoDocumento = tipoDocumento;
        this.DNI = DNI;
        this.nombre = nombre;
        this.mail = mail;
        this.observaciones = observaciones;
        this.vehiculo = vehiculo;
    
            
    }

    public Huesped(String tipoDocumento, String DNI, String nombre, String mail, String observaciones, String vehiculo, int idEmp) {
        this.tipoDocumento = tipoDocumento;
        this.DNI = DNI;
        this.nombre = nombre;
        this.mail = mail;
        this.observaciones = observaciones;
        this.vehiculo = vehiculo;
        this.idEmp = idEmp;
    }

    
    
    public int getIdEmp() {
        return idEmp;
    }

//G&S
    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
  



}

