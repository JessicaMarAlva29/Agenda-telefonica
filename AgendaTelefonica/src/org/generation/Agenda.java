package org.generation;

import java.util.ArrayList;   

public class Agenda {

 
 private ArrayList<Contacto> contactos = new ArrayList<>();
 
 private final int capacidadMaxima = 10;

 
 public void anadirContacto(Contacto c) {
     if (contactos.size() >= capacidadMaxima) {           
         System.out.println("La agenda está llena.");    
         return;                                          
     }
     if (contactos.contains(c)) {                          
         System.out.println("Ese contacto ya existe.");   
         return;                                          
     }
     contactos.add(c);                                     
     System.out.println("Contacto agregado.");            
 }

 public void listarContactos() {
     if (contactos.isEmpty()) {                            
         System.out.println("No hay contactos.");        
         return;                                         
     }
     System.out.println("== Contactos ==");               
     for (Contacto c : contactos) {                       
         System.out.println(c); 
     }
 }

 
 public void buscarContacto(String nombre) {
     for (Contacto c : contactos) {                        
         if (c.getNombre().equalsIgnoreCase(nombre)) {     
             System.out.println("Encontrado: " + c);       
             return;                                       
         }
     }
     System.out.println("No se encontró ese contacto.");  
 }


 public void eliminarContacto(String nombre) {
     for (Contacto c : contactos) {                        
         if (c.getNombre().equalsIgnoreCase(nombre)) {    
             contactos.remove(c);                          
             System.out.println("Contacto eliminado.");    
             return;                                       
         }
     }
     System.out.println("No se encontró ese contacto.");  
 }


 public void modificarTelefono(String nombre, String apellido, String nuevoTel) {
     for (Contacto c : contactos) {                                       
         if (c.getNombre().equalsIgnoreCase(nombre)                        
          && c.getApellido().equalsIgnoreCase(apellido)) {                   
             c.setTelefono(nuevoTel);                                     
             System.out.println("Teléfono actualizado.");                   
             return;                                                       
         }
     }
     System.out.println("No se encontró ese contacto.");                    
 }
 
 public void mostrarEspaciosLibres() {
     System.out.println("Espacios libres: " + (capacidadMaxima - contactos.size()));
 }
}
