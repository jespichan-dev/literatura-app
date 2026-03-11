package com.example.literatura.service;

import com.example.literatura.model.Author;
import com.example.literatura.model.Book;
import com.example.literatura.repository.AuthorRepository;
import com.example.literatura.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // Guardar libro con autor
    public void guardarLibroConAutor(Book libro) {
        Author autor = authorRepository.findByName(libro.getAuthor().getName())
                .orElseGet(() -> authorRepository.save(libro.getAuthor()));

        libro.setAuthor(autor);
        bookRepository.save(libro);
    }

    // Buscar libro por título
    public Optional<Book> buscarLibroPorTitulo(String titulo) {
        return bookRepository.findByTitle(titulo);
    }
}