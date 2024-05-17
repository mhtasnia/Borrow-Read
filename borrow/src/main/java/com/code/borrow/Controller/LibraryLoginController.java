package com.code.borrow.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.code.borrow.entities.Library;
import com.code.borrow.repository.LibraryRepo;

@Controller
public class LibraryLoginController {
    
    private final LibraryRepo libraryRepo;

    public LibraryLoginController(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    @PostMapping("/do_library_login")
    public String login(@RequestParam("l_email") String email,
                        @RequestParam("l_password") String password,
                        RedirectAttributes redirectAttributes) {
        
        Library library = libraryRepo.findByLEmail(email);
        
        
        if (library != null && library.getL_password().equals(password)) {
           
            return "redirect:/library/index";
        } else {
            
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/library_login";
        }
    }
}
