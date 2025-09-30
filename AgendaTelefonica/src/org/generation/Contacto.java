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
		
		// validación del teléfono agregado
		if (telefono == null || telefono.trim().isEmpty()) {
			throw new IllegalArgumentException("El campo no puede permanecer vacío.");
		}
		
		// Si todo esta bien, se guardan los valores en los atributos
		this.nombre = nombre.trim();
		this.apellido = apellido.trim();
		this.telefono = telefono.trim();

	} // fin constructor

	//gets para devolver nombre, apellido y teléfono
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}
	
	
	// setTelefono sirve para modificar un telefono guardado
	public void setTelefono(String telefono) {
		if (telefono == null || telefono.trim().isEmpty()) {
			// Si esta vacío, se da un mensaje al usuario que no puede ingresar un campo
			// vacío
			throw new IllegalArgumentException("El campo no puede permanecer vacío.");
		}
		this.telefono = telefono.trim();
	}
	
	
	
	// Método equals, compara dos objetos Contacto
	@Override
	public boolean equals(Object obj) {
		// Si son el mismo objeto en memoria
		if (this == obj) return true;
		
		// Si el otro objeto es nulo -> no son iguales
		if (obj == null) return false;
		
		// Si el otro objeto no es de tipo Contactos -> no son iguales
		if (!(obj instanceof Contacto)) return false;
		
		//Convertir el objeto genérico recibido como Object en un objeto de tipo Contacto
		// para poder acceder a sus atributos y métodos (nombre, apellido, etc.)
		Contacto otro = (Contacto) obj;
		
		
		if (this.nombre.equalsIgnoreCase(otro.nombre) && this.apellido.equalsIgnoreCase(otro.apellido)) {
			return true;
		}
		return false;
	}
	
	// Método hashCode: devuelve un número entero único para este contacto
	// Se usa en colecciones como HashSet o HashMap para encontrar objetos rápidamente
	// Dos contactos con el mismo nombre y apellido generan el mismo hash, 
	// para que se reconozcan como iguales aunque el teléfono sea distinto
	@Override
	public int hashCode() {
		
		int hash = 7;
		
		hash = 31 * hash + nombre.toLowerCase().hashCode();
	
		hash = 31 * hash + apellido.toLowerCase().hashCode();
		
		return hash;
	}
	
	
	//Devuelve una representación en texto del contacto, 
	@Override
	public String toString() {
		return nombre + " " + apellido + " - " + telefono;
	}
	
	
	

} // fin main