package com.nandu.BookStore.service;

import com.nandu.BookStore.entity.MyBookList;
import com.nandu.BookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    MyBookRepository myrepo;
    public void saveMyBook(MyBookList myBook)
    {
        myrepo.save(myBook);

    }
    public List<MyBookList> getAllMyBooks()
    {
        return myrepo.findAll();

    }
    public void deleteById(int id)
    {
        myrepo.deleteById(id);
    }
}
