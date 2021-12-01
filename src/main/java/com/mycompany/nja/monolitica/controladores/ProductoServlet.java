package com.mycompany.nja.monolitica.controladores;

import com.mycompany.nja.monolitica.bd.Conexion;
import com.mycompany.nja.monolitica.entidades.Producto;
import com.mycompany.nja.monolitica.modelos.dao.ProductoDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Productos", urlPatterns = {"/productos"})
public class ProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Conexion conexion = new Conexion();
        ProductoDao ProductoDao = new ProductoDao(conexion);

        String opcion = request.getParameter("accionP");

        opcion = (opcion == null) ? "productosL" : opcion;

        if (opcion.equals("productos")) {

            boolean ingresar = (request.getParameter("guardar") != null) ? true : false;
            int idU = (request.getParameter("idU") != null) ? Integer.parseInt(request.getParameter("idU")) : 0;

            if (ingresar) {
                Producto Producto = new Producto();
                Producto.setIdUsuario(idU);
                Producto.setNombre(request.getParameter("nombre"));
                Producto.setMarca(request.getParameter("marca"));
                Producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
                Producto.setCategoria(request.getParameter("categoria"));
                Producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                Producto.setImagen(request.getParameter("imagen"));
                Producto.setActivo(request.getParameter("activo"));

                Producto p = ProductoDao.add(Producto);

                response.sendRedirect("productos?accionP=productosL&idU="+idU);

            } else {
                request.getRequestDispatcher("ingresarProducto.jsp").forward(request, response);
            }

        } else if (opcion.equals("actualizar")) {
            
            boolean editar = (request.getParameter("editar") != null) ? true : false;
            int idU = (request.getParameter("idU") != null) ? Integer.parseInt(request.getParameter("idU")) : 0;
            
            if (editar) {
                
                Producto producto = new Producto(); 
                producto.setNombre(request.getParameter("nombre"));
                producto.setMarca(request.getParameter("marca"));
                producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
                producto.setCategoria(request.getParameter("categoria"));
                producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                producto.setImagen(request.getParameter("imagen"));
                producto.setActivo(request.getParameter("activo"));
                producto.setId(Integer.parseInt(request.getParameter("id"))); 
                producto.setIdUsuario(idU);

                ProductoDao.edit(producto);

                response.sendRedirect("productos?accionP=productosL&idU="+idU);

            } else {
                request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
            }

        } else if (opcion.equals("eliminar")) {

            int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
            int idU = (request.getParameter("idU") != null) ? Integer.parseInt(request.getParameter("idU")) : 0;
            if (id != 0) {
                ProductoDao.delete(id, idU);
                response.sendRedirect("productos?accionP=productosL&idU="+idU);
            }
        } else if (opcion.equals("productosL")) {

            int idU = (request.getParameter("idU") != null) ? Integer.parseInt(request.getParameter("idU")) : 0;

            List<Producto> Productos = ProductoDao.getProducto(idU);

            request.setAttribute("productos", Productos);

            request.getRequestDispatcher("productos.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
