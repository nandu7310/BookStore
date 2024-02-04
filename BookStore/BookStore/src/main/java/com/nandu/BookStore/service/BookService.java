package com.nandu.BookStore.service;

import com.nandu.BookStore.entity.Book;
import com.nandu.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository brepo;
    public void save(Book book) {
        brepo.save(book);


    }
    public List<Book> getAllBooks()
    {
        return brepo.findAll();
    }
    public Book getBookById(int id)
    {
        return brepo.findById(id).get();
    }
    public void deleteById(int id)
    {
        brepo.deleteById(id);
    }

}
