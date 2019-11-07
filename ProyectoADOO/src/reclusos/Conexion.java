/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclusos;

import java.sql.*;

/**
 *
 * @author FAROL
 */
public class Conexion {
    public Conexion() {
        conexion = null;
    }
    
    public static Connection dameConexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/adooreclusos?serverTimezone=UTC&SSL=false", "root", "root");
            //System.out.println("Exito!!");
        }catch(Exception e) { e.getMessage(); }
        
        return conexion;
    }
    
    public static Connection conexion;
}
