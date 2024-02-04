package com.nandu.BookStore.controller;

import com.nandu.BookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {
    @Autowired
    private MyBookService bookService;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id)
    {

        bookService.deleteById(id);
        return "redirect:/my_books";
    }
}
