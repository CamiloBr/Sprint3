<%--
    Document   : ingresar
    Created on : 24/11/2021, 11:55:15 AM
    Author     : Camilo
--%>

<%@include file="WEB-INF/header.jsp" %>
<h3 class="text-center pb-3">Crear Usuario</h3>

<form method="post" action="">

    <div class="pb-4">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <div class="card-header bg-dark">
                    <h4 class="text-white text-center">Ingresar Datos</h4>
                </div>
                <div class="card-body">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input required type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del usuario" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input required type="password" id="password" name="password" placeholder="Ingrese la contraseña" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="correo">Correo:</label>
                        <input required type="email" id="correo" name="correo" placeholder="Ingrese el correo" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input required type="tel" id="telefono" name="telefono" placeholder="Ingrese el telefono" class="form-control">
                    </div>

                    <div class="form-group" hidden>
                        <input required type="text" id="rol" name="rol" value="2" class="form-control">
                    </div>
                </div>
                <div class="card-footer">
                    <div class="row">

                        <div class="col-md-6">                    
                            <input type="submit" name="guardar" value="Guardar" class="btn btn-primary btn-block">
                        </div>

                        <div class="col-md-6">
                            <a href="login" class="btn btn-danger btn-block">Cancelar</a>
                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>

</form>

<%@include file="WEB-INF/footer.jsp" %>        