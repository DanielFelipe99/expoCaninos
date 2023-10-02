<%-- 
    Document   : header
    Created on : 23 sept 2023, 13:17:47
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <body>
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <header>
            <ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="#">Exposicion Canina</a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Buscar por</a>
    <ul class="dropdown-menu">
      <li><input class="dropdown" type="search" placeholder = "Nombre"></li>
      <li><button class="btn btn-warning" type = "submit">Buscar</button></li>
      <li><a class="dropdown-item" href="#">Puntos</a></li>
    </ul>
  </li>
  <li class="nav-item">
    <a class="nav-link">Mostrar perros registrados</a>
  </li>
</ul>
            <img src="imagenes/expoImagen.jpeg" alt="Perros" style="width: 100%;" />
            <script src =" scripts/script.js" type =" text/javascript"></script>
        </header>
    </body>
</html>
