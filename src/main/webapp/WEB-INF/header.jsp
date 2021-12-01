<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina principal</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"">
    </head>
    <body>

        <header class="header">
            <div class="container-fluid d-flex justify-content-center">
                <div class="row">
                    <div class="col">
                        <h1 class="titulo text-center">
                            <img
                                src="<%=request.getContextPath()%>/resources/img/pod.png"
                                alt=""
                                width="60"
                                height="44"
                                class="d-inline-block align-text-top"
                                />
                            N'T Just Aesthetics
                        </h1>
                    </div>
                </div>
            </div>

            <div
                class="container-fluid d-flex justify-content-center"
                style="padding-bottom: 15px"
                >
                <nav
                    class="navbar navbar-expand-lg navbar-light bg-transparent"
                    >
                    <div class="container-fluid">
                        <button
                            class="navbar-toggler"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent"
                            aria-expanded="false"
                            aria-label="Toggle navigation"
                            >
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div
                            class="collapse navbar-collapse"
                            id="navbarSupportedContent"
                            >
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item" routerLinkActive="active">
                                    <a
                                        class="nav-link"
                                        href="index.jsp"
                                        >Inicio</a
                                    >
                                </li>
                                <!--<li class="nav-item dropdown">
                                    <a
                                        class="nav-link dropdown-toggle"
                                        href="#"
                                        id="navbarDropdown"
                                        role="button"
                                        data-bs-toggle="dropdown"
                                        aria-expanded="false"
                                        >
                                        Hombre
                                    </a>
                                    <ul
                                        class="dropdown-menu"
                                        aria-labelledby="navbarDropdown"
                                        >
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Camisetas</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Pantalones</a
                                            >
                                        </li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown">
                                    <a
                                        class="nav-link dropdown-toggle"
                                        href="#"
                                        id="navbarDropdown"
                                        role="button"
                                        data-bs-toggle="dropdown"
                                        aria-expanded="false"
                                        >
                                        Mujer
                                    </a>
                                    <ul
                                        class="dropdown-menu"
                                        aria-labelledby="navbarDropdown"
                                        >
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Blusas</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Camisetas</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Faldas</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Pantalones</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Vestidos</a
                                            >
                                        </li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown">
                                    <a
                                        class="nav-link dropdown-toggle"
                                        href="#"
                                        id="navbarDropdown"
                                        role="button"
                                        data-bs-toggle="dropdown"
                                        aria-expanded="false"
                                        >
                                        Niña/o
                                    </a>
                                    <ul
                                        class="dropdown-menu"
                                        aria-labelledby="navbarDropdown"
                                        >
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Blusas</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Camisetas</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Faldas</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Pantalones</a
                                            >
                                        </li>
                                        <li routerLinkActive="active">
                                            <a class="dropdown-item" href=""
                                               >Vestidos</a
                                            >
                                        </li>
                                    </ul>
                                </li>
                                <li class="nav-item" routerLinkActive="active">
                                    <a
                                        class="nav-link"
                                        [routerLink]="['/ofertas']"
                                        >Ofertas</a
                                    >
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="">Vender</a>
                                </li>
                                -->
                                <li class="nav-item">
                                    <a href="login" class="nav-link">Ingresar</a>
                                </li>

                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </header>