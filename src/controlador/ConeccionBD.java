/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author peyu
 */
public class ConeccionBD {
    public Connection conectar;
        
    public ConeccionBD(){
    
        try
        {
            conectar = null;
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/basereserva", "controlMitre", "mitre753");      
        }
        
        catch(Exception e)
        {e.printStackTrace(); }
        
    }
    
    
    static public DefaultTableModel ResSet2DTM(ResultSet rs){ //ResultSet to DefaultTableModel
   
       ResultSetMetaData metaDatos=null;
       int cantiCol=0;
       DefaultTableModel modelo= new DefaultTableModel();
       
       try
       {
           metaDatos = rs.getMetaData();  // Consigo los metadatos
           cantiCol= metaDatos.getColumnCount();    // Consigo la cantidad de columnas           
       }
       catch (Exception e){e.printStackTrace();}
       
       //System.out.println(cantiCol);              
       //String[] nombresCols = new String[CantiCol];  //Creo array para guardar los nombres de las columnas
       
       for (int i = 0; i < cantiCol; i++) 
       { //Obtengo los nombres
         
           try{
           
          // nombresCols[i]= metaDatos.getColumnLabel(i+1); //En el ResultSetMetaData la primera columna es la 1
           modelo.addColumn(metaDatos.getColumnLabel(i+1));
           
           }
           catch(Exception e){e.printStackTrace();}
                   
       }
       
       
       
       
       return modelo;
       
   }
    
    
    
}
