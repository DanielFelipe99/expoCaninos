/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expocaninos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletContext;
import static jdk.jpackage.internal.Arguments.CLIOptions.context;

/**
 *
 * @author danie
 */
public class ExposicionPerro {
    
    public static ArrayList<Perro> miPerro = new ArrayList<>();
    
    public ExposicionPerro(){
        
    }

    public static void ordenar(String ordenar, ServletContext context ) throws IOException{
        System.out.println("aqui estoy");
     switch(ordenar){
            case "puntos":
               // Define un comparador para ordenar por puntos
                Comparator<Perro> comparador = Comparator.comparing(Perro::getPuntos);
              

                // Ordena la lista de perros usando el comparador
                Collections.sort(miPerro, comparador);
                eliminarPerro( context );
                agregarPerro(miPerro, context);
                // Opcional: Puedes imprimir la lista ordenada si lo deseas
                /*for (Perro perro : listarPerros) {
                    System.out.println("Nombre: " + perro.getNombre() + ", Puntos: " + perro.getPuntos());
                }*/
            break;
            
            case "nombre":
                // Define un comparador para ordenar alfabéticamente por nombre
                Comparator<Perro> comparadorNombre = Comparator.comparing(Perro::getNombre);

                // Ordena la lista de perros usando el comparador
                Collections.sort(miPerro, comparadorNombre);
                eliminarPerro(context );
                agregarPerro(miPerro, context);
                // Opcional: Puedes imprimir la lista ordenada si lo deseas
               /* for (Perro perro : listarPerros) {
                    System.out.println("Nombre: " + perro.getNombre());
                }*/
               
            break;
            
            case "raza":
                // Define un comparador para ordenar alfabéticamente por raza
                Comparator<Perro> comparadorraza = Comparator.comparing(Perro::getRaza);

                // Ordena la lista de perros usando el comparador
              Collections.sort(miPerro, comparadorraza);
                eliminarPerro( context );
                agregarPerro(miPerro, context);
                
                // Opcional: Puedes imprimir la lista ordenada si lo deseas
                /*for (Perro perro : listarPerros) {
                    System.out.println("Raza: " + perro.getRaza());
                }*/
               
            break;
    }
    }
    public int buscarPerro(){
        
        return 0;
    }
    public int buscarBinarioPorNombre(String Nombre){
        
        return 0;
    }
    
        public static Perro buscarPerroPorNombre(String nombre){
        for(Perro perro: miPerro){
            if(perro.getNombre().equals(nombre)){
                return perro;
            
            }

        }
        return null;
    }
        
    public static void agregarPerro(ArrayList<Perro> misPerros, ServletContext context) throws IOException{
            String relativePath = "datosPerros.txt";
            String absPath = context.getRealPath(relativePath);
            File archivo = new File(absPath);
           
            try {
              FileOutputStream datosPerros = new FileOutputStream(archivo);
              ObjectOutputStream escribirPerro = new ObjectOutputStream(datosPerros);
              escribirPerro.writeObject(misPerros);
              escribirPerro.close();
                System.out.println("Datos cargados: " + relativePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Los datos no han sido guardados" + e.getMessage());
        }
            
    }
   
    public static ArrayList<Perro> mostrarPerros(ServletContext context) throws IOException, ClassNotFoundException{
        String date = "datosPerros.txt";
        String dateAbstract = context.getRealPath(date);
        File rutaDate = new File (dateAbstract);
        
        try {
            FileInputStream leerA = new FileInputStream(rutaDate);
            ObjectInputStream archivo = new ObjectInputStream(leerA);
            miPerro = (ArrayList<Perro>) archivo.readObject();
            archivo.close();
            System.out.println("Datos guardados: " + archivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error en el archivo" + e.getMessage());
        }
       return miPerro;
    }
    
  
       public static void eliminarPerro(ServletContext context) throws IOException {

        //Definimos una ruta para buscar nuestro archivo perro.ser
        String relativePath = "datosPerros.txt";
        String absPath = context.getRealPath(relativePath);
        File archivo = new File(absPath);
        
        try {
            // Crear un archivo para guardar la lista de perros serializada
            FileOutputStream datosPerro = new FileOutputStream(archivo);
            ObjectOutputStream escribirPerro = new ObjectOutputStream(datosPerro);
            escribirPerro.writeObject("");
            escribirPerro.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos de perro: " + e.getMessage());
        }

    }
       
       public static void eliminarUnPerro(ServletContext context , String nombre) throws IOException{
          Perro perroUnico = buscarPerroPorNombre(nombre);
          miPerro.remove(perroUnico);
          eliminarPerro(context);
          agregarPerro(miPerro, context);
          
       
       }

    public int buscarPerroMayorPuntaje(){
        
        return 0;
    }
    public int buscarPerroMenorPuntaje(){
        
        return 0;
    }
    public int buscarPerrorMayorEdad(){
        
        return 1;
    }
    
}
