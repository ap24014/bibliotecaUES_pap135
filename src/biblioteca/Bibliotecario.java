package biblioteca;

import java.util.ArrayList;

public class Bibliotecario extends Persona {
    protected ArrayList<Libro> libros;

    public Bibliotecario(String nombre, String apellido) {
        super(nombre, apellido);
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro);
    }

    public void mostrarLibros() {
        System.out.println("Libros en la biblioteca:");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro libro : libros) {
                System.out.println(" - " + libro + (libro.estaDisponible() ? " [Disponible]" : " [Prestado]"));
            }
        }
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libros.contains(libro) && libro.estaDisponible()) {
            libro.prestar();
            usuario.prestarLibro(libro);
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    public void devolverLibro(Libro libro, Usuario usuario) {
        if (usuario.tieneLibro(libro)) {
            usuario.devolverLibro(libro);
            libro.devolver();
        } else {
            System.out.println("El usuario no tiene ese libro prestado.");
        }
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}