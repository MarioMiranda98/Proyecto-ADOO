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
public class Existencias {
    public Existencias() {}
    
    public static boolean siExiste(String idSql, String tabla, String id) {
        String consulta = "SELECT " + idSql + " FROM " + tabla + " WHERE " + idSql + " = '" + id + "'";
        boolean bandera = false;
        try {
            Connection miConexion = Conexion.dameConexion();
            ResultSet rs = null;
            Statement sentencia = miConexion.createStatement();
            
            rs = sentencia.executeQuery(consulta);
            
            while(rs.next())
                bandera = true;
            
        }catch(Exception e) { e.printStackTrace(); }
        
        return bandera;
    }
}
