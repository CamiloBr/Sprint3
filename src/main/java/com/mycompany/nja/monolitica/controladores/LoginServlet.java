package com.mycompany.nja.monolitica.controladores;

import com.mycompany.nja.monolitica.bd.Conexion;
import com.mycompany.nja.monolitica.entidades.Usuario;
import com.mycompany.nja.monolitica.modelos.dao.LoginDAO;
import com.mycompany.nja.monolitica.modelos.dao.UsuarioDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camilo
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        LoginDAO loginDAO = new LoginDAO(conexion);
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
        Usuario usuarioE = new Usuario();

        String opcion = request.getParameter("accion");

        opcion = (opcion == null) ? "login" : opcion;

        if (opcion.equals("login")) {

            boolean sesion = (request.getParameter("sesion") != null) ? true : false;

            if (sesion) {

                String usuario = request.getParameter("nombre");
                String pass = request.getParameter("password");
                usuarioE.setNombre(usuario);
                usuarioE.setPassword(pass);
                int res = loginDAO.login(usuarioE);

                int idUs = usuarioE.getId();

                if (res == 1) {

                    ArrayList<Usuario> usuarios = loginDAO.list(idUs);

                    request.setAttribute("usuarios", usuarios);

                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);

                } else {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else if (opcion.equals("ingresar")) {

            boolean ingresar = (request.getParameter("guardar") != null) ? true : false;

            if (ingresar) {
                Usuario usuario = new Usuario();
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setPassword(request.getParameter("password"));
                usuario.setCorreo(request.getParameter("correo"));
                usuario.setTelefono(request.getParameter("telefono"));
                usuario.setRol(Integer.parseInt(request.getParameter("rol")));
                Usuario e = usuarioDAO.add(usuario);

                response.sendRedirect("login");

            } else {
                request.getRequestDispatcher("ingresar.jsp").forward(request, response);
            }

        } else if (opcion.equals("editar")) {

            int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
            boolean actualizar = (request.getParameter("actualizar") != null) ? true : false;

            ArrayList<Usuario> usuarios = loginDAO.list(id);

            request.setAttribute("usuarioA", usuarios);

            if (actualizar) {

                Usuario usuario = new Usuario();
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setPassword(request.getParameter("password"));
                usuario.setCorreo(request.getParameter("correo"));
                usuario.setTelefono(request.getParameter("telefono"));
                usuario.setId(id);
                usuarioDAO.update(usuario);

                response.sendRedirect("login?accion=listar&idI=" + id);

            } else {
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
            }

        } else if (opcion.equals("listar")) {

            int id = (request.getParameter("idI") != null) ? Integer.parseInt(request.getParameter("idI")) : 0;

            ArrayList<Usuario> usuarios = loginDAO.list(id);

            request.setAttribute("usuarios", usuarios);

            request.getRequestDispatcher("usuarios.jsp").forward(request, response);

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
