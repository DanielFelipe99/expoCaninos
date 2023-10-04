<%-- 
    Document   : index
    Created on : 23 sept 2023, 13:15:49
    Author     : daniel
--%>

<%@page import="com.mycompany.expocaninos.ExposicionPerro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.expocaninos.Perro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Principal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/e153d37948.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <%@include file = "templates/header.jsp" %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


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
                                            <form action="SvPerro" method="POST" enctype="multipart/form-data">
                                                <div class="mb-3">
                                                    <label for="nombre" class="form-label">Nombre</label>
                                                    <input class="form-control" type="text" name="nombre"required>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="raza" class="form-label">Raza</label> <br>
                                                    <input class="form-control" type="text" name="raza"required>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="fileFoto" class="form-label">Foto</label>
                                                    <input class="form-control" type="file" name="fileFoto"required>
                                                </div>
                                                <div class="mb-3">
                                                    <label for="puntos" class="form-label">Puntos</label>
                                                    <select class="form-select" name="puntos" type="text"required>
                                                     <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                    <option value="6">6</option>
                                                    <option value="7">7</option>
                                                    <option value="8">8</option>
                                                    <option value="9">9</option>
                                                    <option value="10">10</option>    
                                                    </select>   
                                                </div>
                                                <div class="mb-3">
                                                    <label for="edad" class="form-label">Edad</label> <br>
                                                    <input class="form-control" type="text" name="edad" required>
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
                            ServletContext context = request.getServletContext();
                            ArrayList<Perro> miPerro = ExposicionPerro.mostrarPerros(context);
                           
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
                                    if (miPerro != null) {
                                        for (Perro perro : miPerro) {

                                %>

                                <tr>
                                    <th scope="row"><%= perro.getNombre()%></th>
                                    <td><%= perro.getRaza()%></td>
                                    <td><%= perro.getImagen()%></td>
                                    <td><%= perro.getPuntos()%></td>
                                    <td><%= perro.getEdad()%></td>
                                    <td><a href="#" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal" data-nombre="<%= perro.getNombre()%>"><i class="fa-solid fa-eye"></i></a>
                                        <a href="#" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="" data-nombre="<%= perro.getNombre()%>"><i class="fa-solid fa-pencil"></i></a>
                                        <a href="#" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#eliminarModal" data-nombre="<%= perro.getNombre()%>"><i class="fa-solid fa-trash"></i></a>
                                    </td>
                                </tr>
                              
                                            <%}
                                    }%>
                                            </tbody>
                                            </table>
                                            
                                            
                                            
                                            
                                         
                            
                                     
                                            
                                            <!-- Modal de eliminación -->
                                            <div class="modal fade" id="eliminarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog"  >
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Eliminar Perro</h5>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <p>¿Estás seguro de que deseas eliminar el perro con el nombre <span id="nombrePerro"></span>?</p>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <!-- Botón de confirmación de eliminación -->
                                                            <button type="submit" class="btn btn-danger" id="confirmarEliminar">Eliminar</button>
                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                            
                                                            
                                                               <!-- Modal Ver -->
                                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Detalles del Perro</h5>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div id="perro-details">
                                                                <!-- Contenido del modal de detalles -->
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                  
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                          

                                            
                                        </div>
                                    </div> 
                                    </section>
                                </div>
                                            
                                            
                                            
                                            
                                  <script>
                                    // funcion para mostrar los datos en la ventana modal
                                    $('#exampleModal').on('show.bs.modal', function (event) {
                                        var button = $(event.relatedTarget); // Botón que desencadenó el evento
                                        var nombre = button.data('nombre'); // Obtén el nombre del perro

                                        // Realiza una solicitud AJAX al servlet para obtener los detalles del perro por su nombre
                                        $.ajax({
                                            url: 'SvPerro?nombre=' + nombre, // Cambia 'id' por el nombre del parámetro que esperas en tu servlet
                                            method: 'GET',
                                            success: function (data) {
                                                // Actualiza el contenido del modal con los detalles del perro
                                                $('#perro-details').html(data);
                                            },
                                            error: function () {
                                                // Maneja errores aquí si es necesario
                                                console.log('Error al cargar los detalles del perro.');
                                            }
                                        });
                                    });

                                </script>
                                            
                                    <script>
// Función para mostrar el modal de eliminación cuando se hace clic en el botón de eliminar
$('.btn.btn-warning').on('click', function() {
    const nombre = $(this).data('nombre');
    $('#nombrePerro').text(nombre); // Actualiza el nombre del perro en el modal
    $('#eliminarModal').modal('show');
    // Puedes pasar el nombre o cualquier otro identificador necesario al modal de eliminación.
});

// Cuando se confirma la eliminación, ejecuta el método POST utilizando AJAX
$('#confirmarEliminar').on('click', function() {
    const nombre = $('#nombrePerro').text(); // Obtiene el nombre del perro del modal
    // Realiza una solicitud AJAX para eliminar el perro por su nombre
    $.ajax({
        url: 'SvEliminar?nombre=' + nombre, // Cambia por la URL correcta de tu servlet
        method: 'POST', // Utiliza POST para operaciones de eliminación
        success: function (data) {
            // Maneja la respuesta después de la eliminación (por ejemplo, recargar la página o actualizar la tabla)
            console.log('Perro eliminado con éxito.');
            $('#eliminarModal').modal('hide'); // Cierra el modal de eliminación
        },
        error: function () {
            // Maneja errores aquí si es necesario
            console.log('Error al eliminar el perro.');
        }
    });
});
                                    </script>
                                
                          
                                
                            

                                
                                
                                
                                <%@include file = "templates/footer.jsp" %>
                                </body>
                                </html>
