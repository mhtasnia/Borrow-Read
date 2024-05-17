package com.code.borrow.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.code.borrow.entities.User;
import com.code.borrow.repository.UserRepo;

@Controller
public class LoginController {
    
 private final UserRepo userRepo;

    public LoginController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/do_user_login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {
        // Search for the user in the database by email
        User user = userRepo.findByEmail(email);
        
        // Check if user exists and password matches
        if (user != null && user.getPassword().equals(password)) {
            // Redirect to a success page or dashboard
            return "redirect:/user/index";
        } else {
            // If login fails, redirect back to login page with error message
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/user_login";
        }
    }
}
