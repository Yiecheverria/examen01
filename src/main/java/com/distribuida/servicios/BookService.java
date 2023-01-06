package com.distribuida.servicios;

import com.distribuida.db.Books;

import java.util.List;

public interface BookService {
    void crearBook(Books book);
    List<Books> findAll();
    void updateBook(Books book);
    void deleteBook(Integer id);
    Books findById(Integer id);

}
