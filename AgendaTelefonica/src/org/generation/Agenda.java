package org.generation;

import java.util.ArrayList;

public class Agenda {

    // Lista que almacena todos los contactos de la agenda
    private ArrayList<Contacto> contactos = new ArrayList<>();

    // Capacidad fija: 10
    private final int capacidadMaxima = 10;

    // ===================== NUEVO: helper para validar nombre único =====================
    // Método privado que revisa si ya existe alguien con el MISMO NOMBRE (ignorando mayúsculas)
    private boolean existeNombre(String nombre) {
        for (Contacto c : contactos) {                                 // Recorremos todos los contactos
            if (c.getNombre().equalsIgnoreCase(nombre)) {              // Si el nombre coincide (case-insensitive)
                return true;                                           // Ya existe un contacto con ese nombre
            }
        }
        return false;                                                  // No existe ese nombre
    }
    // ===================================================================================

    // Método para añadir contacto
    public void anadirContacto(Contacto c) {
        // Verifica si la agenda ya está llena
        if (contactos.size() >= capacidadMaxima) {
            System.out.println("La agenda está llena.");
            return;
        }

        // 1) Bloquea duplicado por nombre (aunque cambien apellido o teléfono)
        if (existeNombre(c.getNombre())) {                             // Usamos el helper recién creado
            System.out.println("No se permite repetir nombres. Ya existe un contacto con ese nombre.");
            return;
        }

        // 2) (Opcional, pero lo mantenemos) evita duplicado exacto nombre+apellido
        //    Esto cubre el caso de que además no quieras duplicar la persona exacta
        if (contactos.contains(c)) {                                   // contains usa equals (nombre+apellido en tu Contacto)
            System.out.println("Ese contacto (nombre y apellido) ya existe.");
            return;
        }

        // Si pasa ambas validaciones, se agrega
        contactos.add(c);
        System.out.println("Contacto agregado.");
    }

    // Método para listar todos los contactos guardados
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

    // Método para buscar contactos por nombre
    public void buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado: " + c);
                return;
            }
        }
        System.out.println("No se encontró ese contacto.");
    }

    // Método para eliminar un contacto por su nombre
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

    // Método para modificar el teléfono de un contacto que ya existe
    public void modificarTelefono(String nombre, String apellido, String nuevoTel) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTel);                                // Actualiza el teléfono usando el setter
                System.out.println("Teléfono actualizado.");
                return;
            }
        }
        System.out.println("No se encontró ese contacto.");
    }

    // Método para mostrar cuántos espacios libres quedan en la agenda
    public void mostrarEspaciosLibres() {
        System.out.println("Espacios libres: " + (capacidadMaxima - contactos.size()));
    }
}
