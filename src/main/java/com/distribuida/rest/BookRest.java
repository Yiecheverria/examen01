package com.distribuida.rest;

import com.distribuida.db.Books;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/books")
public class BookRest {
    @Inject
    private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Books findById(@PathParam("id") Integer id) {
        return bookService.findById(id);
    }

    @POST
    @Path("/{isbn},{title},{author},{price}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void crearBook(@PathParam("isbn") String isbn, @PathParam("title") String title,
                         @PathParam("author") String author, @PathParam("price") Double price) {
        bookService.crearBook(new Books(0, isbn, title, author, price));
    }

    @PUT
    @Path("/{id},{isbn},{title},{author},{price}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateBook(@PathParam("id") Integer id,@PathParam("isbn") String isbn, @PathParam("title") String title,
                           @PathParam("author") String author, @PathParam("price") Double price) {
        bookService.updateBook(new Books(id, isbn, title, author, price));
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteBook(@PathParam("id") Integer id) {
        bookService.deleteBook(id);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> findAll() {
        return bookService.findAll();
    }

}