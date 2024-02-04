package com.nandu.BookStore.controller;


import com.nandu.BookStore.entity.Book;
import com.nandu.BookStore.entity.MyBookList;
import com.nandu.BookStore.service.BookService;
import com.nandu.BookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;
    @Autowired
    private MyBookService bookService;
    @GetMapping ("/")
    public String home()
    {
       return "home";


    }

    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "bookRegister";

    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks()
    {
        List<Book> list=service.getAllBooks();

        return new ModelAndView("availableBooks","book",list);


    }
    @GetMapping("/my_books")
    public String myBooks(Model model)
    {
       List<MyBookList> list=bookService.getAllMyBooks();
       model.addAttribute("book",list);
       return "myBooks";

    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book)
    {
        service.save(book);
        return "redirect:/available_books";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id)
    {
        Book b=service.getBookById(id);
        MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        bookService.saveMyBook(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model)
    {
       Book b= service.getBookById(id);
       model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id)
    {

        service.deleteById(id);
        return "redirect:/available_books";
    }


}
