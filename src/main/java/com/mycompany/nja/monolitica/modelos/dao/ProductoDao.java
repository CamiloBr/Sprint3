package com.mycompany.nja.monolitica.modelos.dao;

import com.mycompany.nja.monolitica.bd.Conexion;
import com.mycompany.nja.monolitica.entidades.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDao {

    private Conexion conexion;

    public ProductoDao(Conexion conexion) {
        this.conexion = conexion;
    }

    //metodos CRUD
    
    public Producto getProductoA(int id) {
        Producto producto = new Producto();

        try {
            String sql = "SELECT po_id, po_nombre, po_marca, po_precio, po_categoria, po_cantidad, po_imagen, po_activo FROM productos WHERE po_id = ?";

            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();

                p.setId(rs.getInt("po_id"));
                p.setNombre(rs.getString("po_nombre"));
                p.setMarca(rs.getString("po_marca"));
                p.setPrecio(rs.getFloat("po_precio"));
                p.setCategoria(rs.getString("po_categoria"));
                p.setCantidad(rs.getInt("po_cantidad"));
                p.setImagen(rs.getString("po_imagen"));
                p.setActivo(rs.getString("po_activo"));

                return p;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return producto;
    }

    public ArrayList<Producto> getProducto(int id) {
        
        ArrayList<Producto> producto = new ArrayList<>();

        try {
            String sql = "SELECT po_id, po_id_usuario, po_nombre, po_marca, po_precio, po_categoria, po_cantidad, "
                    + "po_imagen, po_activo FROM productos WHERE po_id_usuario = ?";

            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                Producto p = new Producto();
                p.setId(rs.getInt("po_id"));
                p.setIdUsuario(rs.getInt("po_id_usuario"));
                p.setNombre(rs.getString("po_nombre"));
                p.setMarca(rs.getString("po_marca"));
                p.setPrecio(rs.getFloat("po_precio"));
                p.setCategoria(rs.getString("po_categoria"));
                p.setCantidad(rs.getInt("po_cantidad"));
                p.setImagen(rs.getString("po_imagen"));
                p.setActivo(rs.getString("po_activo"));

                producto.add(p);
                
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return producto;
    }

    public Producto add(Producto producto) {
        try {
            String sql = "INSERT INTO productos (`po_id_usuario`, `po_nombre` ,`po_marca`, `po_precio`, "
                    + "`po_categoria`, `po_cantidad`, `po_imagen`, `po_activo`) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setInt(1, producto.getIdUsuario());
            pst.setString(2, producto.getNombre());
            pst.setString(3, producto.getMarca());
            pst.setFloat(4, producto.getPrecio());
            pst.setString(5, producto.getCategoria());
            pst.setInt(6, producto.getCantidad());
            pst.setString(7, producto.getImagen());
            pst.setString(8, producto.getActivo());

            int filas = pst.executeUpdate();

            if (filas > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    producto.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return producto;
    }

    public Producto edit(Producto producto) {
        boolean resultado = false;

        try {
            String sql = "UPDATE productos SET po_nombre = ?, po_marca = ?, po_precio = ?,"
                    + " po_categoria = ?, po_cantidad = ?, po_imagen = ?, po_activo = ? WHERE po_id = ? and po_id_usuario = ?";

            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getMarca());
            pst.setFloat(3, producto.getPrecio());
            pst.setString(4, producto.getCategoria());
            pst.setInt(5, producto.getCantidad());
            pst.setString(6, producto.getImagen());
            pst.setString(7, producto.getActivo());
            pst.setInt(8, producto.getId());
            pst.setInt(9, producto.getIdUsuario());
            
            int filas = pst.executeUpdate();

            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return producto;
    }

    public boolean delete(int id, int idU) {
        boolean resultado = false;

        try {
            String sql = "DELETE FROM productos WHERE po_id = ? and po_id_usuario = ?";

            PreparedStatement pst = this.conexion.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, id);
            pst.setInt(2, idU);
            int filas = pst.executeUpdate();

            if (filas > 0) {
                resultado = true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return resultado;
    }

}
