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



public class Empresa {
    String razonSocial;
    float tarifa;
    ArrayList<TelEmp> tels;
    ArrayList<Huesped> huespedes;
    
    

    public Empresa(String razonSocial, float tarifa, ArrayList t, ArrayList h) {
        this.razonSocial = razonSocial;
        this.tarifa = tarifa;
        this.tels= t;
        this.huespedes=h;
        
        System.out.println(razonSocial + tarifa);
        
        for (TelEmp telefono : tels)
            System.out.println("telefono: " + telefono.numero);
        
        for (Huesped huesped : huespedes)
            System.out.println("Huesped: " + huesped.getNombre());
        
    }

    
    
    
    
    //G&S
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    
    
    
}
