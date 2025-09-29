package org.generation;

public class Contacto {

 private String nombre;     
 private String apellido;   
 private String telefono;   

 public Contacto(String nombre, String apellido, String telefono) {
     this.nombre = nombre;       
     this.apellido = apellido;   
     this.telefono = telefono;   
 }


 public String getNombre() { return nombre; }
 public String getApellido() { return apellido; }
 public String getTelefono() { return telefono; }
 
 public void setTelefono(String telefono) {
     this.telefono = telefono;   
 }

 public boolean equals(Object obj) {
     if (this == obj) return true;                       
     if (!(obj instanceof Contacto)) return false;      
     Contacto otro = (Contacto) obj;                     
     return nombre.equalsIgnoreCase(otro.nombre)        
         && apellido.equalsIgnoreCase(otro.apellido);    
 }

 public int hashCode() {
     return (nombre.toLowerCase() + apellido.toLowerCase()).hashCode();
 }

 @Override
 public String toString() {
     return nombre + " " + apellido + " - Tel: " + telefono;
 }
}
