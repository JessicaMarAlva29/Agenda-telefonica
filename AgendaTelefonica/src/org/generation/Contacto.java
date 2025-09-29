package org.generation;

public class Contacto {
	
	private String nombre;
	private String apellido;
	private String telefono;

	// Constructor
	public Contacto(String nombre, String apellido, String telefono) {
		// Se tiene que validar el nombre ingresado y comprobar si la entrada no esta
		// vacía
		if (nombre == null || nombre.trim().isEmpty()) {
			// Si esta vacío, se da un mensaje al usuario que no puede ingresar un campo
			// vacío
			throw new IllegalArgumentException("El campo no puede permanecer vacío.");
		}

		// bloque para validar el apellido
		if (apellido == null || apellido.trim().isEmpty()) {
			throw new IllegalArgumentException("El campo no puede permanecer vacío.");
		}
		
		if (telefono == null || telefono.trim().isEmpty()) {
			throw new IllegalArgumentException("El campo no puede permanecer vacío.");
		}

		this.nombre = nombre.trim();
		this.apellido = apellido.trim();
		this.telefono = telefono.trim();

	} // fin constructor

	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}

	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null || telefono.trim().isEmpty()) {
			// Si esta vacío, se da un mensaje al usuario que no puede ingresar un campo
			// vacío
			throw new IllegalArgumentException("El campo no puede permanecer vacío.");
		}
		this.telefono = telefono.trim();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null) return false;
		
		if (!(obj instanceof Contacto)) return false;
		
		Contacto otro = (Contacto) obj;
		
		
		if (this.nombre.equalsIgnoreCase(otro.nombre) && this.apellido.equalsIgnoreCase(otro.apellido)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		
		int hash = 7;
		
		hash = 31 * hash + nombre.toLowerCase().hashCode();
	
		hash = 31 * hash + apellido.toLowerCase().hashCode();
		
		return hash;
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + " - " + telefono;
	}
	
	
	

} // fin main