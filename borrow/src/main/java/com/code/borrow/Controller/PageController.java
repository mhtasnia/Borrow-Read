package com.code.borrow.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/home")
    public String homepage(){
        System.out.println("Home");
        return "home";
    }

    @GetMapping(value = "/userlogin")
    public String UserLogin(){
        System.out.println("User Login");
        return  "userloginpage";
    }

    @GetMapping( value = "/librarylogin")
    public String LibraryLogin(){
        System.out.println("L");
        return "library_login";
    }
}
