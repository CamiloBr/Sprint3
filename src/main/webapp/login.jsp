<%-- 
    Document   : login
    Created on : 26/11/2021, 08:06:51 PM
    Author     : Camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/header.jsp" %>

<div class="p-3">

    <form method="post" action="">

        <div class="row">

            <div class="col-md-4 offset-md-4">

                <div class="card">

                    <div class="card-header bg-dark">
                        <h4 class="text-white text-center">Login</h4>
                    </div>

                    <div class="card-body">

                        <div class="form-group">
                            <label for="nombre">Usuario:</label>
                            <input required type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del usuario" class="form-control">
                        </div>

                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input required type="password" id="password" name="password" placeholder="Ingrese la contraseña" class="form-control">
                        </div>

                    </div>

                    <div class="card-footer">

                        <div class="row justify-content-center pt-3">

                            <div class="col-md-4">                    
                                <input type="submit" name="sesion" value="Iniciar sesion" class="btn btn-primary btn-block">
                            </div>

                            <div class="col-md-4">
                                <a href=" " class="btn btn-danger btn-block">Cancelar</a>
                            </div>
                        </div>

                        <div>

                            <div class="row justify-content-center pt-3">
                                <small>
                                    <p>Si no tienes una cuenta puedes crear una  <a href="?accion=ingresar" class="">Aqui</a></p>
                                </small>
                            </div>

                        </div>

                    </div>
                </div>

            </div>
        </div>

    </form>

</div>

<%@include file="WEB-INF/footer.jsp" %>

