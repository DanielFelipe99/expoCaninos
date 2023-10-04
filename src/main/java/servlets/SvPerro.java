/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.expocaninos.ExposicionPerro;
import com.mycompany.expocaninos.Perro;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author danie
 */
@WebServlet(name = "SvPerro", urlPatterns = {"/SvPerro"})
 @MultipartConfig
public class SvPerro extends HttpServlet {
    ArrayList<Perro> miPerro = new ArrayList<>();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public void init() throws ServletException{
    
    
    }
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        //System.out.println(nombre);
        Perro perro = ExposicionPerro.buscarPerroPorNombre(nombre); // Implementa la lógica para buscar el perro en tu lista de perros
        if (perro != null) {
            // Genera la respuesta HTML con los detalles del perro
            String perroHtml = "<h2>Nombre: " + perro.getNombre() + "</h2>"
                    + "<p>Raza: " + perro.getRaza() + "</p>"
                    + "<p>Puntos: " + perro.getPuntos() + "</p>"
                    + "<p>Edad (meses): " + perro.getEdad() + "</p>"
                    + "<img src='imagenes/" + perro.getImagen() + "' alt='" + perro.getNombre() + "' width='100%'/>";
            response.setContentType("text/html");
            response.getWriter().write(perroHtml);
        } else {
            // Maneja el caso en el que no se encuentra el perro
            response.setContentType("text/plain");
            response.getWriter().write("Perro no encontrado");
        }
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //taremos los parametros
        
        //obtener la parte de archivo (foto)
          Part fotoPart = request.getPart ("fileFoto");
          
        //Nombre original del archivo 
        String fileName = fotoPart.getSubmittedFileName();
        //Directorio donde se almacenará el archivo
        String uploadDirectory = getServletContext().getRealPath("imagenes");
        //Ruta completa del archivo a guardar
        String filePath = uploadDirectory + File.separator + fileName;
     
          //Guardar el archivo en el sistema de archivos
        
        try (InputStream input = fotoPart.getInputStream();
            OutputStream output = new FileOutputStream(filePath))
            
                 {
        byte[] buffer = new byte[1024];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
            }
   
         String nombre = request.getParameter("nombre");
         String raza = request.getParameter("raza");
         
   
       //  String imagen= request.getParameter("fileFoto");
         String puntos = request.getParameter("puntos");
         String edad = request.getParameter("edad");
         
         
         try {
            Perro perro = new Perro (nombre, raza, fileName, puntos, edad);   
            ServletContext servletContext = getServletContext();
            miPerro = ExposicionPerro.mostrarPerros(servletContext);
            miPerro.add(perro);
            ExposicionPerro.agregarPerro(miPerro, servletContext);
            request.setAttribute("miPerro", miPerro);
            
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
           } catch (IOException | ClassNotFoundException ex) {
               
           }
         
         
         
         
         /**
         //creacion del objeto 
         Perro perro = new Perro (nombre, raza, fileName, puntos, edad);   
         //se añade el objeto a la lista
         miPerro.add(perro);
         //serializacion
        FileOutputStream datosPerros= new FileOutputStream(getServletContext().getRealPath("datosPerro.txt" ));
        ObjectOutputStream escribirPerro = new ObjectOutputStream(datosPerros);
        escribirPerro.writeObject(miPerro);
        //request.setAttribute("listarPerros", miPerro);

           //deserializar
           FileInputStream leerA = new FileInputStream(getServletContext().getRealPath("datosPerro.txt"));
           ObjectInputStream archivo = new ObjectInputStream(leerA);
           
            try {
            ArrayList<Perro> listaCargada = (ArrayList<Perro>) archivo.readObject();
            listaCargada.clear();
            miPerro.addAll(listaCargada); 
            
            } catch (IOException | ClassNotFoundException e) {
                
            }
           
           leerA.close();
           archivo.close();
           
           //se envia la informacion a la lista miPerro
           request.setAttribute("listaEntregada", miPerro);
           //sirve para que la pagina no se rediriga a otra parte 
           request.getRequestDispatcher("index.jsp").forward(request, response);
           
           **/
           }

    

            


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
