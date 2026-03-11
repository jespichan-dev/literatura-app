package com.example.literatura;

import com.example.literatura.model.Author;
import com.example.literatura.model.Book;
import com.example.literatura.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

    private final BookService bookService;

    public LiteraturaApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraturaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== LiterAlura ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> {
                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Nombre del autor: ");
                    String nombreAutor = scanner.nextLine();

                    Book libro = new Book(titulo, new Author(nombreAutor));
                    bookService.guardarLibroConAutor(libro);

                    System.out.println("Libro guardado exitosamente!");
                }
                case 2 -> {
                    System.out.print("Título del libro a buscar: ");
                    String titulo = scanner.nextLine();

                    Optional<Book> libroBuscado = bookService.buscarLibroPorTitulo(titulo);
                    if (libroBuscado.isPresent()) {
                        System.out.println("Libro encontrado: " +
                                libroBuscado.get().getTitle() +
                                ", Autor: " + libroBuscado.get().getAuthor().getName());
                    } else {
                        System.out.println("No se encontró el libro con ese título.");
                    }
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}