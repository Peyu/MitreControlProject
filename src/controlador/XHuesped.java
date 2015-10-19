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
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author peyu
 */
public class XHuesped {
    private Huesped hues;

    public XHuesped(Huesped hues01) {
        this.hues = hues01;
    }

    public XHuesped() {
    }
    
    
    public void Mostrar(){
        System.out.println("Tipo: " + hues.getTipoDocumento());
        System.out.println("Numero: " + hues.getDNI());
        System.out.println("Nombre: " + hues.getNombre());
        System.out.println("Mail: " + hues.getMail());
        System.out.println("Obs: " + hues.getObservaciones());
        System.out.println("Vehiculo: " + hues.getVehiculo());
        
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
    
    public void CrearHuesped(String tipo, String documento, String nombre, String mail, String obs, String vehiculo, int idempresa){
    
        try{
            String sql = DBSentencias.crearHuesped;
            ConeccionBD cone= new ConeccionBD();
            PreparedStatement sentencia =cone.conectar.prepareStatement(sql);
            sentencia.setString(1, tipo);
            sentencia.setString(2, documento);
            sentencia.setString(3, nombre);
            sentencia.setString(4, mail);
            sentencia.setString(5, obs);
            sentencia.setString(6, vehiculo);
            sentencia.setInt(7, idempresa);
            int rowsInserted = sentencia.executeUpdate();
            System.out.println("se ingresaron " + rowsInserted + "fila/s nueva/s");  
            
        }
        catch(Exception e){e.printStackTrace();}
        
    }
    
    public int getIdHues(String tipoDoc, String nroDoc){
        int idHues=0;
        String sql = DBSentencias.idHues;
        
        try{
            ConeccionBD cone= new ConeccionBD();
            PreparedStatement sentencia = cone.conectar.prepareStatement(sql);
            sentencia.setString(1, tipoDoc);
            sentencia.setString(2, nroDoc);
            ResultSet rs = sentencia.executeQuery();
            if(rs.next()){
            
              idHues=rs.getInt(1);
            }
            
        }catch(Exception e){e.printStackTrace();}
        
        
    
        return idHues;
    }
    
    public ResultSet getDatosHuesped(int idHues){
         
        String sql = DBSentencias.datosHuesped;
        ResultSet rs=null;
        
        try{
            ConeccionBD cone= new ConeccionBD();
            PreparedStatement sentencia = cone.conectar.prepareStatement(sql);
            sentencia.setInt(1, idHues);
            
            rs = sentencia.executeQuery();
                        
        }catch(Exception e){e.printStackTrace();}
        
    
        return rs;   
        
    }
    
    public int getUltimoId(){
            int idHues=0;
       
        try
        {
            String query = controlador.DBSentencias.idUltimoHues;
            ConeccionBD cone= new ConeccionBD();
            Statement sentencia = cone.conectar.createStatement();
            ResultSet rs = sentencia.executeQuery(query);
            rs.first();
            idHues=rs.getInt(1);
            
        }
            
        catch(Exception e){ e.printStackTrace();}
       
    return idHues;
        
    }
    
//G&S 
    public Huesped getHues01() {
        return hues;
    }

    public void setHues01(Huesped hues01) {
        this.hues = hues01;
    }
    
    
    
    
    
}
