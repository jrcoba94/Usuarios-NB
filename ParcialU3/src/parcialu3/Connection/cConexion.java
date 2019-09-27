/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialu3.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SAMSUNG
 */
public class cConexion {
    Connection con = null;
    String cadena = "jdbc:sqlite:src//DataBase//Usuarios.s3db";
    
    public Connection cOpen() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.con= DriverManager.getConnection(cadena);
        } catch (Exception e) {
            System.out.println("Problemas al conectarse"+e);
        }
        return this.con;
    }
    
    public int eQuery(String sql){
        try {
         PreparedStatement pstm=cOpen().prepareStatement(sql);
         pstm.execute();
         
         return 1;
        }catch (SQLException e) {
            return 0;
        }
    }
    
    public void cClose(){
        this.con=null;
    }
    
    public ResultSet DataSet(String Sentencia){
     try {
         PreparedStatement pstm=cOpen().prepareStatement(Sentencia);
         pstm.execute();
          ResultSet Resultado=pstm.executeQuery();
           return Resultado;
        }catch (SQLException e) {
            System.out.println(e);
         return null;   
        }
    }
}
