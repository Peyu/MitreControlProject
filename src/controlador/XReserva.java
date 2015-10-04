/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.Reserva;
import controlador.ConeccionBD;


/**
 *
 * @author peyu
 */
public class XReserva {
    private Reserva res;

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


    //G&S

    public Reserva getRes() {
        return res;
    }

    public void setRes(Reserva res) {
        this.res = res;
    }
    
    
    
    
}
