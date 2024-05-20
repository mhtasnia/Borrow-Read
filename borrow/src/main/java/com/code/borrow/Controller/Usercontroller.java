package com.code.borrow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.borrow.repository.BookRepo;

@Controller
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    BookRepo bookRepo;

    @RequestMapping("/index")
    public String dashboard(Model m){
        m.addAttribute("title", "User-dashboard");
        return "/user_dashboard";
    }
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "user_booklist";
    }

    
    
}
