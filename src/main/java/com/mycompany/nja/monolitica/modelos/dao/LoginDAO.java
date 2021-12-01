package com.mycompany.nja.monolitica.modelos.dao;

import com.mycompany.nja.monolitica.bd.Conexion;
import com.mycompany.nja.monolitica.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Camilo
 */
public class LoginDAO {

    private Conexion conexion;

    public LoginDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public ArrayList<Usuario> list(int id) {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            String sql = "SELECT us_id, us_usuario, us_password, us_correo, "
                    + "us_telefono FROM usuarios WHERE us_id =  ?";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario e = new Usuario();
                e.setId(rs.getInt("us_id"));
                e.setNombre(rs.getString("us_usuario"));
                e.setPassword(rs.getString("us_password"));
                e.setCorreo(rs.getString("us_correo"));
                e.setTelefono(rs.getString("us_telefono"));

                usuarios.add(e);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return usuarios;
    }

    public int login(Usuario usuario) {

        int r = 0;

        try {
            String sql = "SELECT * FROM usuarios WHERE us_usuario = ? AND us_password = ?;";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getPassword());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                r = r+1;
                usuario.setNombre(rs.getString("us_usuario"));
                usuario.setPassword(rs.getString("us_password"));
                usuario.setId(rs.getInt("us_id"));
                
            }
            
            if(r != 1){
                
                r = 0;
            
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return r;
        
    }

}
