/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Reserva;
import controlador.ConeccionBD;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Huesped;
import vista.CrearReserva;
import java.sql.Timestamp;
import java.time.LocalDate;


/**
 *
 * @author peyu
 */
public class XReserva {
    private Reserva res;
    private static ArrayList<Huesped> huesTemp;

    public XReserva(Reserva res) {
        this.res = res;
    }

    public XReserva() {
    }

    //devuelve int id_reserva de una reserva en fecha current a partir de un nombre
public int idResCurrentDate(String nombre){

    String query = controlador.DBSentencias.idResCurrentDate;
    int idreserva=0;
        
        try
        {
           
            ConeccionBD cone= new ConeccionBD();
            PreparedStatement statement = cone.conectar.prepareStatement(query);
            statement.setString(1, nombre);
            ResultSet rs= statement.executeQuery();
            rs.first();//muevo el cursor al primer y unico resultado
            idreserva=rs.getInt(1);
            
        }
            
        catch(Exception e){ e.printStackTrace();}
       
        return idreserva;
}    
    
public int CheckIn(int id_reserva){
  int filasModificadas =0;
  try{
    ConeccionBD cone= new ConeccionBD();
    String query= "UPDATE basereserva.reserva SET estado='Check-In' WHERE idreserva=?";
    PreparedStatement statement= cone.conectar.prepareStatement(query);
    statement.setInt(1, id_reserva);
    filasModificadas= statement.executeUpdate();
    
  }
  catch(Exception e){ e.printStackTrace();}
    
return filasModificadas;
  
}

public int CheckOut(int id_reserva){
  int filasModificadas =0;
  try{
    ConeccionBD cone= new ConeccionBD();
    String query= "UPDATE basereserva.reserva SET estado='Check-Out' WHERE idreserva=?";
    PreparedStatement statement= cone.conectar.prepareStatement(query);
    statement.setInt(1, id_reserva);
    filasModificadas= statement.executeUpdate();
    
  }
  catch(Exception e){ e.printStackTrace();}
    
return filasModificadas;
  
}

//agrega un Huesped al ArrayList de huespedes static de CrearReserva 
public void AgregaHuespedes(Huesped hues){
    CrearReserva.res.getHuespedes().add(hues);  //Funciona?
}

public void CrearReserva(java.sql.Date fecha_reserva, java.sql.Date fecha_ing, java.sql.Date fecha_sal, String estado, String obs, float anticipo, int hab){
    
    try{
        //Grabo en DB los datos de la reserva excepto la estadia
        String sql = DBSentencias.crearReserva;
        ConeccionBD cone= new ConeccionBD();
        PreparedStatement sentencia =cone.conectar.prepareStatement(sql);
        sentencia.setDate(1, fecha_reserva);
        sentencia.setString(2, estado);
        sentencia.setString(3, obs);
        sentencia.setFloat(4, anticipo);
        sentencia.setInt(5, hab);
        int rowsInserted = sentencia.executeUpdate();
        //System.out.println("se ingresaron " + rowsInserted + "fila/s nueva/s en Reserva");
        
        //Consigo la id de la reserva creada anteriormente
        XReserva xr = new XReserva();
        int idRes=xr.getIdUltimaRes();
        
        //Guardo cada uno de los dias en la tabla estadia con el idRes correspondiente                
        LocalDate start = fecha_ing.toLocalDate();
        LocalDate end = fecha_sal.toLocalDate();
        sql = DBSentencias.GuardarFecha;
        
        while (!start.isAfter(end)) {
            sentencia=cone.conectar.prepareStatement(sql);
            sentencia.setInt(1, idRes);
            sentencia.setDate(2, java.sql.Date.valueOf(start.toString()));
            rowsInserted = sentencia.executeUpdate();
            System.out.println("se ingreso " + rowsInserted + "fila nueva en Estadia");
            
            start = start.plusDays(1);
        }
        
        
    
    } catch(Exception e){ e.printStackTrace();}

}

public int getIdUltimaRes(){

    int idRes=0;
       
        try
        {
            String query = controlador.DBSentencias.idUltimaRes;
            ConeccionBD cone= new ConeccionBD();
            Statement sentencia = cone.conectar.createStatement();
            ResultSet rs = sentencia.executeQuery(query);
            rs.first();
            idRes=rs.getInt(1);
            
        }
            
        catch(Exception e){ e.printStackTrace();}
       
    return idRes;
    
}

public void GrabarTableIntermedia(int idHues, int idRes){

    try{
                
        String sql = DBSentencias.guardaHuespedEnReserva;
        ConeccionBD cone= new ConeccionBD();
        PreparedStatement sentencia =cone.conectar.prepareStatement(sql);
        sentencia.setInt(1, idHues);
        sentencia.setInt(2, idRes);
        int rowsInserted = sentencia.executeUpdate();
        //System.out.println("se ingresaron " + rowsInserted + "fila/s nueva/s en Reserva");
        
                
    } catch(Exception e){ e.printStackTrace();}

}


    //G&S

    public Reserva getRes() {
        return res;
    }

    public void setRes(Reserva res) {
        this.res = res;
    }

    public static ArrayList<Huesped> getHuesTemp() {
        return huesTemp;
    }

    public static void setHuesTemp(ArrayList<Huesped> huesTemp) {
        XReserva.huesTemp = huesTemp;
    }
    
    
    
    
}
