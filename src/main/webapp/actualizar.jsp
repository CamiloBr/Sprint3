<%-- 
    Document   : actualizar
    Created on : 26/11/2021, 06:22:33 PM
    Author     : Camilo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.nja.monolitica.entidades.Usuario"%>
<%@include file="WEB-INF/header.jsp" %>
<h3 class="text-center pb-3">Actualizar Usuario</h3>
<form method="post" action="">
    <div class="pb-3">
        <div class="col-md-4 offset-md-4">
            <div class="card">

                <%
                    ArrayList<Usuario> usuarioA = (ArrayList<Usuario>) request.getAttribute("usuarioA");
                    int i = 0;
                    for (Usuario usuario : usuarioA) {
                        i++;
                %>

                <div class="card-header bg-dark">
                    <h4 class="text-white text-center">Ingresar Datos</h4>
                </div>
                <div class="card-body">

                    <div class="form-group">
                        <input hidden type="text" id="idI" name="idI" class="form-control" value="<%=usuario.getId()%>">
                    </div>
                    
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input required type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del usuario" class="form-control" value="<%=usuario.getNombre()%>">
                    </div>

                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input required type="password" id="password" name="password" placeholder="Ingrese la contraseña" class="form-control" value="<%=usuario.getPassword()%>">
                    </div>

                    <div class="form-group">
                        <label for="correo">Correo:</label>
                        <input required type="email" id="correo" name="correo" placeholder="Ingrese el correo" class="form-control" value="<%=usuario.getCorreo()%>">
                    </div>

                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input required type="tel" id="telefono" name="telefono" placeholder="Ingrese el telefono" class="form-control" value="<%=usuario.getTelefono()%>">
                    </div>

                </div>
                <div class="card-footer">
                    <div class="row">

                        <div class="col-md-6">                    
                            <input type="submit" name="actualizar" value="Actualizar" class="btn btn-primary btn-block">
                        </div>

                        <div class="col-md-6">
                            <a href="login?accion=listar&idI=<%=usuario.getId()%>" class="btn btn-danger btn-block">Cancelar</a>
                        </div>
                    </div>
                </div>

                <%
                    }
                %>
            </div>
        </div>
    </div>
</form>

<%@include file="WEB-INF/footer.jsp" %> 