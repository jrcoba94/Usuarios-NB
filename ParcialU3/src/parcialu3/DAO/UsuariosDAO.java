/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialu3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import parcialu3.BO.usuariosBO;
import parcialu3.Connection.cConexion;

/**
 *
 * @author SAMSUNG
 */
public class UsuariosDAO {
    cConexion conn = new cConexion();
    String sql;
    //'"+obj.getClave()+"',
    
    //no modificar
    public int addU(usuariosBO obj){
        try{
        sql="insert into Alumnos \n" +
       "values(null,'"+obj.getNombres()+"','"+obj.getApellidos()+
       "','"+obj.getDireccion()+"','"+obj.getTelefono()+"','"+obj.getCorreo()+
       "','"+obj.getSexo()+"','"+obj.getEstado()+"','"+obj.getCiudad()+"','"+obj.getFoto()+"');";
        
        int i = conn.eQuery(sql);
        conn.cClose();
        if(i<=0){
            return 0;
        }
        return 1;
        }
        catch(Exception e){return 0;}
    }
    
    //no modificar
    public int deleteU(usuariosBO obj){
        try{
        sql="DELETE FROM Alumnos WHERE Clave='"+obj.getClave()+"'";
        
        int i = conn.eQuery(sql);
        conn.cClose();
        if(i<=0){
            return 0;
        }
        return 1;
        }
        catch(Exception e){return 0;}
    }
    
    
    public int updateU(usuariosBO obj){
        try{
        sql = "UPDATE Alumnos "+
                  "SET Nombres='"+obj.getNombres()+"'," +
                  "Apellidos='"+obj.getApellidos()+"'," +
                  "Direccion='"+obj.getDireccion()+"'," +
                  "Telefono='"+obj.getTelefono()+"'," +
                  "Correo='"+obj.getCorreo()+"'," +
                  "Sexo='"+obj.getSexo()+"'," +
                  "Estado='"+obj.getEstado()+"'," +
                  "Ciudad='"+obj.getCiudad()+"'," +
                  "Foto='"+obj.getFoto()+"'" +
                  "WHERE Clave='"+obj.getClave()+"'";

            int i = conn.eQuery(sql);
            if (i <= 0)
            {
                return 0;
            }
            return 1;
        }
        catch(Exception e){return 0;}
    }
    
    public DefaultTableModel Buscar(){
        DefaultTableModel dtm;
        try{
        dtm = new DefaultTableModel(
            new Object[][]{
                
            },
            new String[]{
                "Código", "Nombres", "Apellidos", "Dirección", "Teléfono", "Correo", "Sexo", "Estado", "Ciudad","Foto"
            }
        ){
        @Override
        public boolean isCellEditable(int row,int col){
            return false;
        }};
        }
        catch(Exception e){return null;}
         
        try{
         cConexion objConexion= new cConexion();
         ResultSet  rs =objConexion.DataSet("SELECT * FROM Alumnos");
         while(rs.next()){
        // Recuperar Datos de la GUI
        Object[] row = new Object[10];
        row[0]=rs.getString("Clave");
        row[1]=rs.getString("Nombres");
        row[2]=rs.getString("Apellidos");
        row[3]=rs.getString("Direccion");
        row[4]=rs.getString("Telefono");
        row[5]=rs.getString("Correo");
        row[6]=rs.getString("Sexo");
        row[7]=rs.getString("Estado");
        row[8]=rs.getString("Ciudad");
        row[9]=rs.getString("Foto");
         
        // Agregar Datos al JTable
        dtm.addRow(row);
        
        }
         return dtm;       
         }catch(SQLException e){
         return null;
         }
    }   
}