<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.nja.monolitica.entidades.Producto"%>
<%@include file="WEB-INF/header.jsp" %>


<div class="container">

    <%
        int idU = (request.getParameter("idU") != null) ? Integer.parseInt(request.getParameter("idU")) : 0;

    %>

    <div class="row alert alert-primary">
        
        <div class="col-md-11">
        <a href="?accionP=productos&idU=<%=idU%>" class="btn btn-primary">Ingresar</a>
        </div>
        <div class="col-md-1">
            <a href="login?accion=listar&idI=<%=idU%>" class="btn btn-success">Atras</a>
        </div>
    </div>

    <div class="container jumbotron">

        <div class="text-center pb-4">
            <h1 class="display-4">Productos</h1>
        </div>
        
        <table class="table table-striped table-hover" style="text-align: center;">
            <thead>

            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Marca</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th>Cantidad</th>
                <th>Imagen</th>
                <th>Activo</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>

                <%
                    List<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");
                    int i = 0;
                    for (Producto producto : productos) {
                        i++;
                %>
                <tr>
                    <td><%=producto.getId()%></td>
                    <td><%=producto.getNombre()%></td>
                    <td><%=producto.getMarca()%></td>
                    <td><%=producto.getPrecio()%></td>
                    <td><%=producto.getCategoria()%></td>
                    <td><%=producto.getCantidad()%></td>
                    <td><%=producto.getImagen()%></td>
                    <td><%=producto.getActivo()%></td>
                    <td>
                        <a href="?accionP=actualizar&id=<%=producto.getId()%>&idU=<%=producto.getIdUsuario()%>" class="btn btn-warning">Editar</a>
                        <a href="?accionP=eliminar&id=<%=producto.getId()%>&idU=<%=producto.getIdUsuario()%>" 
                           class="btn btn-danger"
                           onclick="return confirm('Desea eliminar el producto seleccionado')">Eliminar</a>
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