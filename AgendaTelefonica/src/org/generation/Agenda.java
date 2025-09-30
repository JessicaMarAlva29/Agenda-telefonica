package org.generation;

import java.util.ArrayList;

public class Agenda {

	// Listra que almacena todos los contactos de la agenda
	private ArrayList<Contacto> contactos = new ArrayList<>();
	
	private final int capacidadMaxima = 10;
	
	
	// Método para añadir contacto
	public void anadirContacto(Contacto c) {
		// Verifica si la agenda ya está llena
		if (contactos.size() >= capacidadMaxima) {
			System.out.println("La agenda está llena.");
			return;
		}
		
		// Verifica si el contacto ya existe
		if (contactos.contains(c)) {
			System.out.println("Ese contacto ya existe.");
			return;
		}
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
			if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
				// Actualiza el teléfono usando el setter de Contacto
				c.setTelefono(nuevoTel);
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
