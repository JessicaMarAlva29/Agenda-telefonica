
package org.generation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Instancia donde se guardaran los contactos
		Agenda agenda = new Agenda();

		while (true) {
			System.out.println("\nMENÚ");
			System.out.println("1. Añadir contacto");
			System.out.println("2. Listar contactos");
			System.out.println("3. Buscar contacto por nombre");
			System.out.println("4. Eliminar contacto por nombre");
			System.out.println("5. Modificar teléfono");
			System.out.println("6. Espacios libres");
			System.out.println("0. Salir");
			System.out.print("Elige opción: ");

			String opcion = sc.nextLine();

			switch (opcion) {
			case "1":
				while (true) {
					// Se intenta ejecutar el código que puede causar un error
					try {
						System.out.print("Nombre: ");
						String nombre = sc.nextLine();
						System.out.print("Apellido: ");
						String apellido = sc.nextLine();
						System.out.print("Teléfono: ");
						String telefono = sc.nextLine();
						agenda.anadirContacto(new Contacto(nombre, apellido, telefono));
						break;
						// Si ocurre un error al crear el contacto
						// Se captura la excepción de tipo IllegalArgumentException
					} catch (IllegalArgumentException e) {
						// Y si muestra el mensaje de error que se definió en la clase Contacto
						 // Y vuelve a pedir que ingrese los datos correctamente
						System.out.println("Error: " + e.getMessage());
						System.out.println("Intente de nuevo.\n");
					}
				}

			case "2":
				agenda.listarContactos();
				break;

			case "3":
				System.out.print("Nombre a buscar: ");
				agenda.buscarContacto(sc.nextLine());
				break;

			case "4":
				System.out.print("Nombre a eliminar: ");
				agenda.eliminarContacto(sc.nextLine());
				break;

			case "5":
				System.out.print("Nombre: ");
				String n = sc.nextLine();
				System.out.print("Apellido: ");
				String a = sc.nextLine();
				System.out.print("Nuevo teléfono: ");
				String t = sc.nextLine();
				agenda.modificarTelefono(n, a, t);
				break;

			case "6":
				agenda.mostrarEspaciosLibres();
				break;

			case "0":
				System.out.println("¡Hasta luego!");
				sc.close();
				return;

			default:
				System.out.println("Opción no válida.");
			}
		}
	}

}
