package com.distribuida.servicios;

import com.distribuida.config.DbConfig;
import com.distribuida.dao.BookDao;
import com.distribuida.db.Books;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.SneakyThrows;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    private Jdbi getJdbi () {
        Jdbi jdbi = Jdbi.create(DbConfig.getConnection());
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

    @SneakyThrows
    @Override
    public void crearBook(Books book) {
        getJdbi().useExtension(BookDao.class, dao -> {
            dao.crearBook(book);
        });
    }

    @Override
    public void updateBook(Books book) {
        getJdbi().useExtension(BookDao.class, dao -> {
            dao.updateBook(book);
        });
    }

    @Override
    public void deleteBook(Integer id) {
        getJdbi().useExtension(BookDao.class, dao -> {
            dao.deleteBook(id);
        });
    }

    @Override
    public Books findById(Integer id) {
        Books book = getJdbi().withExtension(BookDao.class, dao -> {
            return dao.findById(id);
        });
        return book;
    }

    @Override
    public List<Books> findAll() {
        List<Books> books = getJdbi().withExtension(BookDao.class, dao -> {
            return dao.findAll();
        });
        return books;
    }

}