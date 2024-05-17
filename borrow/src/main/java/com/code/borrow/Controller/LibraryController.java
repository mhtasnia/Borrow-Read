package com.code.borrow.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.Properties;
import org.springframework.web.bind.annotation.RequestMapping;
import java.nio.file.Path;

import com.code.borrow.entities.Book;
import com.code.borrow.repository.BookRepo;

@Controller
@RequestMapping("/library")
public class LibraryController {

    @RequestMapping("/index")
    public String dashboard(Model m){
        m.addAttribute("title", "Library-dashboard");
        return "library_dashboard";
    }

    private static final String UPLOAD_DIR = "uploads/";

    @Value("${file.upload-dir}")
    private String uploads;

    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/do_addbook")
    public String addBook(@ModelAttribute Book book, @RequestParam("coverPage") MultipartFile coverPage) {
        if (!coverPage.isEmpty()) {
            try {
                // Ensure the uploads directory exists
                Path uploadPath = Paths.get(uploads);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Save the cover page file locally
                Path path = uploadPath.resolve(coverPage.getOriginalFilename());
                Files.write(path, coverPage.getBytes());

                // Set the relative path to the cover page in the book entity
                book.setCover_page(path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bookRepo.save(book);
        return "redirect:/library/index";
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "booklist";
    }
}
