<%-- 
    Document   : main
    Created on : 26/11/2021, 07:49:41 PM
    Author     : Camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="principal-img">

    <img class="imgprincipal" src="<%=request.getContextPath()%>/resources/img/ropafondo.jpg" alt="tienda">

</section>


<div class="container container-productos">

    <div class="txt d-flex justify-content-center">

        <h2 class="productos text-center">PRODUCTOS</h2>

    </div>

    <div class="row">
        <div class="col-sm-3 col-card">
            <div class="card">
                <img src="<%=request.getContextPath()%>/resources/img/Producto.PNG" class="card-img-top" alt="...">
                <h5 class="card-title text-center">Camisetas</h5>
                <div class="card-body">
                    <p class="card-text">Diferentes diseños a su gusto <br>
                        Tallas: S, M, L.</p>
                    <!--<div class="d-flex justify-content-center">
                        <a href="./pages/productos.html" class="btn btn-card">Ver más</a>
                    </div>-->
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-card">
            <div class="card">
                <img src="<%=request.getContextPath()%>/resources/img/Producto2.PNG" class="card-img-top" alt="...">
                <h5 class="card-title text-center">Blusas</h5>
                <div class="card-body">
                    <p class="card-text">Diferentes diseños a su gusto <br>
                        Tallas: S, M, L.</p>
                    <!--<div class="d-flex justify-content-center">
                        <a href="./pages/productos.html" class="btn btn-card">Ver más</a>
                    </div>-->
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-card">
            <div class="card">
                <img src="<%=request.getContextPath()%>/resources/img/Producto3.PNG" class="card-img-top" alt="...">
                <h5 class="card-title text-center">Vestidos</h5>
                <div class="card-body">
                    <p class="card-text">Diferentes diseños a su gusto <br>
                        Tallas: S, M, L.</p>
                    <!--<div class="d-flex justify-content-center">
                        <a href="./pages/productos.html" class="btn btn-card">Ver más</a>
                    </div>-->
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-card">
            <div class="card">
                <img src="<%=request.getContextPath()%>/resources/img/Producto4.PNG" class="card-img-top" alt="...">
                <h5 class="card-title text-center">Faldas</h5>
                <div class="card-body">
                    <p class="card-text">Diferentes diseños a su gusto <br>
                        Tallas: S, M, L.</p>
                    <!--<div class="d-flex justify-content-center">
                        <a href="./pages/productos.html" class="btn btn-card">Ver más</a>
                    </div>-->
                </div>
            </div>
        </div>
        <div class="col-sm-3 col-card">
            <div class="card">
                <img src="<%=request.getContextPath()%>/resources/img/Producto5.jpg" class="card-img-top" alt="...">
                <h5 class="card-title text-center">Pantalones</h5>
                <div class="card-body">
                    <p class="card-text">Diferentes diseños a su gusto <br>
                        Tallas: S, M, L.</p>
                    <!--<div class="d-flex justify-content-center">
                        <a href="./pages/productos.html" class="btn btn-card">Ver más</a>
                    </div>-->
                </div>
            </div>
        </div>
    </div>

</div>