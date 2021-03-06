/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author peyu
 */
public interface DBSentencias {
    
    public static String listaRes=" select * from basereserva.reserva";
   
    public static String listaHues=" select * from basereserva.huesped";
    
    //devuelve todas las columnas de huespedes con estadia en currentDate
    public static String HuespedesHospedados =
        "SELECT tipo_documento, documento, nombre, mail, huesped.observaciones, vehiculo " +
        "FROM  basereserva.huesped, basereserva.huesped_has_reserva, basereserva.reserva, basereserva.estadia " +
        "WHERE huesped.idhuesped = huesped_has_reserva.huesped_idhuesped " +
        "AND huesped_has_reserva.reserva_idreserva = reserva.idreserva " +
        "AND reserva.idreserva = estadia.idreserva " +
        "AND estadia.dia_reservado = curdate();";
    
    //le falta el ultimo ; para concatenar en busquedas parametrizadas
    public static String HuesParam =
        "SELECT tipo_documento, documento, nombre, mail, huesped.observaciones, vehiculo " +
        "FROM  basereserva.huesped, basereserva.huesped_has_reserva, basereserva.reserva, basereserva.estadia " +
        "WHERE huesped.idhuesped = huesped_has_reserva.huesped_idhuesped " +
        "AND huesped_has_reserva.reserva_idreserva = reserva.idreserva " +
        "AND reserva.idreserva = estadia.idreserva " +
        "AND estadia.dia_reservado = curdate()";
    
    //devuelve nombre de huespedes con estadia en current day que no sea Check-In
    public static String HuespedesCheckIn =
        "SELECT nombre " +
        "FROM  basereserva.huesped, basereserva.huesped_has_reserva, basereserva.reserva, basereserva.estadia " +
        "WHERE huesped.idhuesped = huesped_has_reserva.huesped_idhuesped " +
        "AND huesped_has_reserva.reserva_idreserva = reserva.idreserva " +
        "AND reserva.idreserva = estadia.idreserva " +
        "AND reserva.estado != 'Check-In' " +    
        "AND estadia.dia_reservado = curdate();";

    //devuelve nombre de huespedes cn estadia en current day que no sea Check-Out
    public static String HuespedesCheckOut =
        "SELECT nombre " +
        "FROM  basereserva.huesped, basereserva.huesped_has_reserva, basereserva.reserva, basereserva.estadia " +
        "WHERE huesped.idhuesped = huesped_has_reserva.huesped_idhuesped " +
        "AND huesped_has_reserva.reserva_idreserva = reserva.idreserva " +
        "AND reserva.idreserva = estadia.idreserva " +
        "AND reserva.estado != 'Check-Out' " +    
        "AND estadia.dia_reservado = curdate();";
    
    
    
    
       //devuelve id de una reserva en currentdate a partir del nombre recibido por parametro 
    public static String idResCurrentDate = "SELECT reserva.idreserva " +
    "FROM  basereserva.huesped, basereserva.huesped_has_reserva, basereserva.reserva, basereserva.estadia " +
    "WHERE huesped.idhuesped = huesped_has_reserva.huesped_idhuesped " +
    "AND huesped_has_reserva.reserva_idreserva = reserva.idreserva " +
    "AND reserva.idreserva = estadia.idreserva " +
    "AND estadia.dia_reservado = curdate() " +
    "AND huesped.nombre =? LIMIT 1;";
    
    //Crea reserva segun parametros
    public static String crearReserva="INSERT INTO basereserva.reserva "
            + "(fecha_reserva, estado, observaciones, importe_pagado, numero_hab) "
            + "VALUES (?, ?, ?, ?, ?);";
    
    //devuelve el id de la ultima reserva creada
    public static String idUltimaRes="SELECT idreserva FROM basereserva.reserva "
            + " ORDER BY idreserva DESC LIMIT 1;";
    
    //devuelve el id del último Huesped grabado
    public static String idUltimoHues="SELECT idhuesped FROM basereserva.huesped "
            + " ORDER BY idhuesped DESC LIMIT 1;";
    
    
    
    //Crea Huesped segun parametros
    public static String crearHuesped= "INSERT INTO basereserva.huesped "
            + " (tipo_documento, documento, nombre, mail, observaciones, vehiculo, idempresa) "
            + "VALUES (?,?,?,?,?,?,?);";
    
    //guarda una fecha en tabla estadia
    public static String GuardarFecha = "INSERT INTO basereserva.estadia (idreserva, dia_reservado)"
            + " VALUES (?, ?);";
    
    //Devuelve un idhuesped buscando por tipo y numero de documento
    public static String idHues="SELECT idhuesped FROM basereserva.huesped "
            + "WHERE  tipo_documento = ? " 
            + "AND documento = ?;";
    
    //Devuelve datos de Huesped a partir de un idhuesped
    public static String datosHuesped= "SELECT * FROM basereserva.huesped "
            + "WHERE  idhuesped=? ;";
    
    //Guarda en tabla intemedia Huesped_has_Reserva
    public static String guardaHuespedEnReserva ="INSERT INTO basereserva.huesped_has_reserva "
            + "(huesped_idhuesped, reserva_idreserva) VALUES (?, ?);";
    
    
}


