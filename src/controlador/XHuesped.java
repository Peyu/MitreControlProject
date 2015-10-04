/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Huesped;
import controlador.DBSentencias;
import java.util.ArrayList;

/**
 *
 * @author peyu
 */
public class XHuesped {
    private Huesped hues01;

    public XHuesped(Huesped hues01) {
        this.hues01 = hues01;
    }

    public XHuesped() {
    }
    
    
    
    public ResultSet HuespedesCheckIn(){
        String query=controlador.DBSentencias.HuespedesCheckIn;
        ResultSet rs=null;
        
        try
        {    
            ConeccionBD cone= new ConeccionBD();
            Statement sentencia = cone.conectar.createStatement();
            rs= sentencia.executeQuery(query);
            
                              
        }
        
        catch(Exception e){ e.printStackTrace();}
       
        return rs;
    
    }
    
    public ResultSet HuespedesCheckOut(){
        String query=controlador.DBSentencias.HuespedesCheckOut;
        ResultSet rs=null;
        
        try
        {    
            ConeccionBD cone= new ConeccionBD();
            Statement sentencia = cone.conectar.createStatement();
            rs= sentencia.executeQuery(query);
            
                              
        }
        
        catch(Exception e){ e.printStackTrace();}
       
        return rs;
    
    }
    
    
//G&S 
    public Huesped getHues01() {
        return hues01;
    }

    public void setHues01(Huesped hues01) {
        this.hues01 = hues01;
    }
    
    
    
    
    
}
