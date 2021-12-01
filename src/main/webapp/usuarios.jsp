<%-- 
    Document   : usuarios
    Created on : 24/11/2021, 11:54:59 AM
    Author     : Camilo
--%>

<%@page import="com.mycompany.nja.monolitica.entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@include file="WEB-INF/header.jsp" %>

<div class="p-3">

    <div class="container jumbotron">
        
        <div class="text-center pb-4">
        <h1 class="display-4">Bienvenido</h1>
        </div>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Password</th>
                    <th>Correo</th>
                    <th>Telefono</th>
                    <th>Actualizar</th>
                    <th>Productos</th>
                </tr>
            </thead>
            <tbody>

                <%
                    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
                    int i = 0;
                    for (Usuario usuario : usuarios) {
                        i++;
                %>
                <tr>
                    <td><%=usuario.getNombre()%></td>
                    <td><%=usuario.getPassword()%></td>
                    <td><%=usuario.getCorreo()%></td>
                    <td><%=usuario.getTelefono()%></td>
                    <td>
                        <a href="?accion=editar&id=<%=usuario.getId()%>" 
                           class="btn btn-warning">Editar</a>
                    </td>
                    <td>
                        <a href="productos?accionP=productosL&idU=<%=usuario.getId()%>" 
                           class="btn btn-primary">Ver productos</a>
                    </td>
                </tr>
                <%
                    }
                %>

            </tbody>
            
        </table>

    </div>

</div>

<%@include file="WEB-INF/footer.jsp" %>
