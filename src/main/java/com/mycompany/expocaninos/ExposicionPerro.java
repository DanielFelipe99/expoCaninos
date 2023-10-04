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
    public void ordenarPorRaza(){
        
    }
    public void ordenarPorNombre(){
        
    }
    public void ordenarPorPuntos(){
        
    }
    public void ordenarPorEdad(){
        
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
    
    public static void eliminarPerro(ArrayList<Perro> misPerros, ServletContext context) throws IOException {
        String relativePath = "datosPerros.txt";
        String absPath = context.getRealPath(relativePath);
        File archivo = new File(absPath);

    try {
        FileInputStream datosPerrosStream = new FileInputStream(archivo);
        ObjectInputStream leerPerro = new ObjectInputStream(datosPerrosStream);

        @SuppressWarnings("unchecked")
        ArrayList<Perro> perrosGuardados = (ArrayList<Perro>) leerPerro.readObject();
        leerPerro.close();

        // Eliminar el perro de la lista
        perrosGuardados.removeAll(misPerros);

        FileOutputStream datosPerros = new FileOutputStream(archivo);
        ObjectOutputStream escribirPerro = new ObjectOutputStream(datosPerros);
        escribirPerro.writeObject(perrosGuardados);
        escribirPerro.close();

        System.out.println("Datos eliminados y guardados: " + relativePath);
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("Los datos no han sido eliminados: " + e.getMessage());
    }
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
