package com.code.borrow.Controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.borrow.entities.Book;
import com.code.borrow.entities.Borrow;
import com.code.borrow.entities.User;
import com.code.borrow.repository.BookRepo;
import com.code.borrow.repository.BorrowRepo;
import com.code.borrow.repository.UserRepo;

@Controller
public class BorrowController {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BorrowRepo borrowRepo;

    @GetMapping("/borrow/{bookId}")
    public String borrowPage(@PathVariable("bookId") long bookId, Model model, Principal principal) {
        // Get the logged-in user
        User user = getCurrentUser(principal);
    
        // Get the book
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + bookId));
    
        // Calculate deposit amount and get user's currency
        Double depositAmount = book.getDepositeamount();
        double userCurrency = user.getCurrency();
    
        // Add attributes to the model
        model.addAttribute("depositAmount", depositAmount);
        model.addAttribute("userCurrency", userCurrency);
        model.addAttribute("bookId", bookId);
    
        return "borrow";
    }
    
    

    @PostMapping("/confirmBorrow")
    public String confirmBorrow(@RequestParam("bookId") long bookId, Principal principal) {
        // Get the logged-in user
        User user = getCurrentUser(principal);

        // Get the book
        Book book = bookRepo.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + bookId));

        // Deduct deposit amount from user's currency
        user.setCurrency(user.getCurrency() - book.getDepositeamount());
        userRepo.save(user);

        LocalDateTime borrowedAt = LocalDateTime.now(); // Assuming borrowedAt should be set to the current time
        Borrow borrow = new Borrow(null, user, book, borrowedAt);
        borrowRepo.save(borrow);

        return "redirect:/user/books"; // Redirect to books page or any other page after successful borrow
    }

    @PostMapping("/cancelBorrow")
    public String cancelBorrow() {
        return "redirect:/user/books"; // Redirect to books page or any other page if the borrow request is cancelled
    }

    // Helper method to get the current logged-in user
    private User getCurrentUser(Principal principal) {
        String userEmail = principal.getName();
        return userRepo.findByEmail(userEmail);
    }
}
