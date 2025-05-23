package biblioteca;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bibliotecario bibliotecario = new Bibliotecario("Ana", "Pérez");
        Usuario usuario = new Usuario("Carlos", "Gómez");
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestión de Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros prestados por usuario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = sc.nextInt();
                    sc.nextLine();
                    Libro nuevoLibro = new Libro(titulo, autor, anio);
                    bibliotecario.agregarLibro(nuevoLibro);
                    break;
                case 2:
                    bibliotecario.mostrarLibros();
                    break;
                case 3:
                    bibliotecario.mostrarLibros();
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestar = sc.nextLine();
                    Libro libroAPrestar = buscarLibroPorTitulo(bibliotecario, tituloPrestar);
                    if (libroAPrestar != null) {
                        bibliotecario.prestarLibro(libroAPrestar, usuario);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolver = sc.nextLine();
                    Libro libroADevolver = buscarLibroPorTitulo(bibliotecario, tituloDevolver);
                    if (libroADevolver != null) {
                        bibliotecario.devolverLibro(libroADevolver, usuario);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 5:
                    usuario.mostrarLibrosPrestados();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    public static Libro buscarLibroPorTitulo(Bibliotecario bibliotecario, String titulo) {
        for (Libro libro : bibliotecario.getLibros()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}