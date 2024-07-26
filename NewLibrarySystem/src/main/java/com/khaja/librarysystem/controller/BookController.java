package com.khaja.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.khaja.librarysystem.entity.Book;
import com.khaja.librarysystem.entity.MyBookList;
import com.khaja.librarysystem.entity.RegisterUser;
import com.khaja.librarysystem.service.BookService;
import com.khaja.librarysystem.service.MyBookService;
import com.khaja.librarysystem.service.RegisterUserService;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
@Autowired
private MyBookService mybookService;
	

@Autowired
private RegisterUserService registeruserservice;
	
@GetMapping("/")
public String home() {
	return "home";
}
@GetMapping("/book_register")
public String bookRegister() {
	return "bookRegister";
}
@GetMapping("/available_books")
public ModelAndView getAllBook() {
	 List<Book> list=service.getAllBook();
	 ModelAndView m=new ModelAndView();
	 m.setViewName("BookList");
	 m.addObject("book",list);
	 return m;
}

@PostMapping("/save")
public String addBook(@ModelAttribute Book b) {
	service.save(b);
	return "redirect:/available_books";

}

@GetMapping("/my_books")
public String getMyBooks(Model model) {
	List<MyBookList> list=mybookService.getAllBooks();
	model.addAttribute("book",list);
	
	return "MyBooks";
}

@RequestMapping("/mylist/{id}")
public String getMyList(@PathVariable("id") int id) {
	Book b=service.getBookById(id);
	MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
	mybookService.saveMyBook(mb);
	return "redirect:/my_books";
}

@RequestMapping("/editBook/{id}")
public String editBook(@PathVariable("id") int id,Model model) {
	Book b = service.getBookById(id);
	model.addAttribute("book",b);
	 
	return "BookEdit";
}
@RequestMapping("/deleteBook/{id}")
public String deleteBook(@PathVariable("id") int id) {
	service.deleteById(id);
	return "redirect/available_books";
}


@GetMapping("/register")
public String registerForm(Model model) {
	model.addAttribute("registeruser",new RegisterUser());
	return "Register";
}
@PostMapping("/register")
public String registerUser(@ModelAttribute("registeruser") RegisterUser registeruser) {
	registeruserservice.save(registeruser);
	return "redirect:/login";
}
@GetMapping("/login")
public String loginForm(Model model) {
    model.addAttribute("user", new RegisterUser());
    return "login";
}
@PostMapping("/login")
public String loginUser(@ModelAttribute RegisterUser registeruser, Model model) {
	RegisterUser savedRegisterUser = registeruserservice.findByRegisterUsername(registeruser.getUsername());
	if(savedRegisterUser !=null && savedRegisterUser.getPassword().equals(registeruser.getPassword())) {
		return "redirect:/welcome";
	}else {
		model.addAttribute("error", "Invalid username or password");
		return "login";
	}
}
@GetMapping("/welcome")
public String welcome() {
	return "welcome";
}
}
