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
         <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
         <header>
     <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                
              
              <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                  
                  
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" >
                      Ordenamientos
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" id="ordenamiento-nombre" data-value="nombre"   href="#">Por nombre</a></li>
                      <li><a class="dropdown-item" id="ordenamiento-puntos" data-value="puntos"  href="#">Por puntos</a></li>
                      <li><a class="dropdown-item" id="ordenamiento-raza" data-value="raza"  href="#">Por raza </a></li>
                      
                    </ul>
                  </li>
                </ul>
                  <form class="d-flex"  role="search" action="SvOrdenar" method="GET" >
                  <input class="form-control me-6" type="search" placeholder="Buscar por nombre" name="buscar" aria-label="Search" required>
                  <button class="btn btn-outline-success" type="submit"  >Buscar</button>
                </form>
              </div>
            </div>
        </nav>
            
            
            <img src="imagenes/expoImagen.jpeg" alt="Perros" style="width: 100%;" />
  <script>
        
        $('#ordenamiento-nombre').click(function() {
            var campo = $(this).data('value');
            console.log("holi, gracias por su seleccion: "+campo);
            $.ajax({
                url: 'SvOrdenamiento?value=' + campo,
                method: 'POST',
                success: function () {

                window.location.href = 'index.jsp';
                },
                error: function () {

                     }
                });
          });
         
        $('#ordenamiento-puntos').click(function() {
            var campo = $(this).data('value');
            console.log("holi, gracias por su seleccion: "+campo);
             $.ajax({
                url: 'SvOrdenamiento?value=' + campo,
                method: 'POST',
                success: function () {

                window.location.href = 'index.jsp';
                },
                error: function () {

                     }
                });
          });
          
        $('#ordenamiento-raza').click(function() {
            var campo = $(this).data('value');
            console.log("holi, gracias por su seleccion: "+campo);
             $.ajax({
                url: 'SvOrdenamiento?value=' + campo,
                method: 'POST',
                success: function () {

                window.location.href = 'index.jsp';
                },
                error: function () {

                     }
                });
          });
          
        

    </script>
    <!-- comment  <script src =" scripts/script.js" type =" text/javascript"></script>-->
        </header>
    </body>
</html>
