package com.khaja.librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khaja.librarysystem.entity.Book;
import com.khaja.librarysystem.repository.BookRepository;

@Service
public class BookService {
 

private BookRepository bRepo;
@Autowired
public BookService(BookRepository bRepo) {
    this.bRepo = bRepo;
}

@Transactional // Added to handle transactions
public Book save(Book book) {
    return bRepo.save(book);
}

public List<Book> getAllBook(){
	return bRepo.findAll();
}
public Book getBookById(int id) {
	return bRepo.findById(id).get();
}
public void deleteById(int id) {
	bRepo.deleteById(id);
}
}
