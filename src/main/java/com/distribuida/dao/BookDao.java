package com.distribuida.dao;

import com.distribuida.db.Books;
import com.distribuida.db.mapping.BookMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(BookMapper.class)
public interface BookDao {

    @SqlUpdate("insert into books (isbn, title, author, price) values (:isbn, :title, :author, :price);")
    void crearBook(@BindBean Books book);
    @SqlUpdate("update books set isbn = :isbn, title = :title, author = :author, price = :price where id = :id;")
    void updateBook(@BindBean Books book);
    @SqlUpdate("delete from books where id = :id;")
    void deleteBook(@Bind("id") Integer id);
    @SqlQuery("select * from books where id = :id;")
    Books findById(@Bind("id") Integer id);
    @SqlQuery("select * from books;")
    List<Books> findAll();

}