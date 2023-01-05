package com.distribuida.servicios;

import com.distribuida.db.Books;

import java.util.List;

public interface BookService {
    void crearBook(Books book);
    void updateBook(Books book);
    void deleteBook(Integer id);
    Books findById(Integer id);
    List<Books> findAll();
}
