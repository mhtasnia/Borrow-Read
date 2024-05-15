package com.code.borrow.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class Usercontroller {

    @RequestMapping("/index")
    public String dashboard(Model m){
        m.addAttribute("title", "User-dashboard");
        return "normal/user_dashboard";
    }
}
