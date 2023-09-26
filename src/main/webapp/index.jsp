<%-- 
    Document   : index
    Created on : 23 sept 2023, 13:15:49
    Author     : daniel
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.expocaninos.Perro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Principal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        
        <%@include file = "templates/header.jsp" %>
          
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        
        
        <h1>¡Bienvenidos!</h1>
        
        
        <div class="container">
            
            
            <section class="mt-5 mb-5 " id="formulario">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-3" style="max-width: 540px;">
                            <div class="row g-0">
                                <div class="col-md-12">
                                    <div class="card-body">
                                       <h5 class="card-tittle">Insertar Perro</h5>
                                        <div class="card-text">
                                            <form action="SvPerro" method="POST">
                                                <div class="mb-3">
                                                    <label for="nombre" class="form-label">Nombre</label>
                                                    <input class="form-control" type="text" name="nombre">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="raza" class="form-label">Raza</label> <br>
                                                    <input class="form-control" type="text" name="raza">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="fileFoto" class="form-label">Foto</label>
                                                    <input class="form-control" type="file" name="fileFoto">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="puntos" class="form-label">Puntos</label>
                                                    <input class="form-control form-control-sm" name="puntos" type="text">
                                                </div>
                                                <div class="mb-3">
                                                    <label for="edad" class="form-label">Edad</label> <br>
                                                    <input class="form-control" type="text" name="edad" >
                                                </div>
                                                <input type= "submit" class= "btn btn-warning" value= "Ingresar perrito" >

                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>



                    </div>

                
                
                    <div class="col-md-8">
                        
                        <% 
                            List<Perro> miPerro= (List<Perro>) request.getAttribute("listaEntregada");
                            if (miPerro == null) {
                                    // Mostrar un mensaje de error al usuario
                                    request.setAttribute("error", "La lista de perros está vacía.");

                            }
                        %>

                        <table class="table table-dark" >
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Raza</th>
                                    <th scope="col">Foto</th>
                                    <th scope="col">Puntos</th>
                                    <th scope="col">Edad</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            </thead>
                            
                            <tbody>
                                
                                    <% 
                                          if(miPerro!=null){
                                                for (Perro perro : miPerro) { 
                                                 
                                    %>
                                           
                                <tr>
                                    <th scope="row"><%= perro.getNombre() %></th>
                                    <td><%= perro.getRaza() %></td>
                                    <td><%= perro.getImagen() %></td>
                                    <td><%= perro.getPuntos() %></td>
                                    <td><%= perro.getEdad() %></td>
                                    <td>accion</td>
                                </tr>

                                <%}}%>
                            </tbody>
                        </table>

                    </div>
                </div> 
            </section>
        </div>
                
        <%@include file = "templates/footer.jsp" %>
    </body>
</html>
