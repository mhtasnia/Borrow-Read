package com.code.borrow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.borrow.entities.Library;
import com.code.borrow.entities.User;
import com.code.borrow.helper.Message;
import com.code.borrow.repository.LibraryRepo;
import com.code.borrow.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private LibraryRepo libraryRepo;

    @RequestMapping("/")
    public String homepage(Model model) {
        model.addAttribute("title", "Home");
        System.out.println("Home");
        return "home";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title","Sign Up");
        System.out.println("Signup");
        return "signup";
    }
    @RequestMapping("/user_signup")
    public String user_signup(Model model) {
        model.addAttribute("title","Sign Up");
        System.out.println("Signup");
        return "user_signup";
    }

    @RequestMapping("/library_signup")
    public String library_signup(Model model) {
        model.addAttribute("title","Sign Up");
        System.out.println("Signup");
        return "library_signup";
    }

    @PostMapping("/do_register")
    public String registerUser(@ModelAttribute User user, Model m, HttpSession session) {
        try{
            userRepo.save(user); // Save the user to the database
            System.out.println("Signup");
            m.addAttribute("user", new User());
            session.setAttribute("message", new Message("Successfully Registered!", "alert-success"));
            return "user_signup";
        }catch(Exception e){
            e.printStackTrace();
            m.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(), "alert-error"));
            return "user_signup";
        }
    }
    

    @PostMapping("/do_lregister")
    public String registerLibrary(@ModelAttribute Library library, Model m, HttpSession session) {
        try{
            libraryRepo.save(library); // Save the user to the database
            System.out.println("Signup");
            m.addAttribute("library", new Library());
            session.setAttribute("message", new Message("Successfully Registered!", "alert-primary"));
            return "library_signup";
        }catch(Exception e){
            e.printStackTrace();
            m.addAttribute("library", library);
            session.setAttribute("message", new Message("Something went wrong!"+e.getMessage(), "alert-error"));
            return "library_signup";
        }
    }


}
