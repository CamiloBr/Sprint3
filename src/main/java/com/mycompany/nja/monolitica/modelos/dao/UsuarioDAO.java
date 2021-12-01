package com.mycompany.nja.monolitica.modelos.dao;

import com.mycompany.nja.monolitica.bd.Conexion;
import com.mycompany.nja.monolitica.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Camilo
 */
public class UsuarioDAO {

    private Conexion conexion;

    public UsuarioDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public Usuario add(Usuario usuario) {

        try {
            String sql = "INSERT INTO usuarios (us_usuario, us_password, us_correo, us_telefono, us_rol) VALUES (?,?,?,?,?)";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getPassword());
            pst.setString(3, usuario.getCorreo());
            pst.setString(4, usuario.getTelefono());
            pst.setInt(5, usuario.getRol());
            int filas = pst.executeUpdate();

            if (filas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
    public Usuario update(Usuario usuario) {

        try {
            String sql = "UPDATE usuarios SET us_usuario = ?, us_password = ?, us_correo = ?, us_telefono = ? WHERE us_id = ?;";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getPassword());
            pst.setString(3, usuario.getCorreo());
            pst.setString(4, usuario.getTelefono());
            pst.setInt(5, usuario.getId());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean delete(int id) {
        boolean resultado = false;
        try {
            String sql = "DELETE FROM usuarios WHERE us_id = ? and us_rol = ?";
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, id);
            pst.setInt(2, 3);
            int filas = pst.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

}
