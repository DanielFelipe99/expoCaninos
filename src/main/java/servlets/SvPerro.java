/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mycompany.expocaninos.Perro;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danie
 */
@WebServlet(name = "SvPerro", urlPatterns = {"/SvPerro"})
public class SvPerro extends HttpServlet {
    ArrayList<Perro> miPerro = new ArrayList<>();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //taremos los parametros
         String nombre = request.getParameter("nombre");
         String raza = request.getParameter("raza");
         String imagen= request.getParameter("fileFoto");
         String puntos = request.getParameter("puntos");
         String edad = request.getParameter("edad");
         //creacion del objeto 
         Perro perro = new Perro (nombre, raza, imagen, puntos, edad);   
         //se añade el objeto a la lista
         miPerro.add(perro);
         //serializacion
        FileOutputStream datosPerros= new FileOutputStream(getServletContext().getRealPath("datosPerro.txt" ));
        ObjectOutputStream escribirPerro = new ObjectOutputStream(datosPerros);
        escribirPerro.writeObject(miPerro);
        request.setAttribute("listarPerros", miPerro);

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
           
           
           }

    

            


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
