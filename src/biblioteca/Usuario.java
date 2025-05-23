package biblioteca;

import java.util.ArrayList;

public class Usuario extends Persona {
    private ArrayList<Libro> librosPrestados;

    public Usuario(String nombre, String apellido) {
        super(nombre, apellido);
        librosPrestados = new ArrayList<>();
    }

    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
        System.out.println(getNombreCompleto() + " ha prestado el libro: " + libro.getTitulo());
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            librosPrestados.remove(libro);
            System.out.println(getNombreCompleto() + " ha devuelto el libro: " + libro.getTitulo());
        } else {
            System.out.println("El usuario no tiene prestado el libro: " + libro.getTitulo());
        }
    }

    public void mostrarLibrosPrestados() {
        System.out.println("Libros prestados por " + getNombreCompleto() + ":");
        if (librosPrestados.isEmpty()) {
            System.out.println("No tiene libros prestados.");
        } else {
            for (Libro libro : librosPrestados) {
                System.out.println(" - " + libro);
            }
        }
    }

    public boolean tieneLibro(Libro libro) {
        return librosPrestados.contains(libro);
    }
}