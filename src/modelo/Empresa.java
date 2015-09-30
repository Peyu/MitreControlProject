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
public class Empresa {
    String razonSocial;
    float tarifa;

    public Empresa(String razonSocial, float tarifa) {
        this.razonSocial = razonSocial;
        this.tarifa = tarifa;
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
