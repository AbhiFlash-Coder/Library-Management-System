package com.khaja.librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khaja.librarysystem.entity.MyBookList;
import com.khaja.librarysystem.repository.MyBookRepository;

@Service
public class MyBookService {
	@Autowired
	private MyBookRepository mybook;
public void saveMyBook(MyBookList book) {
	mybook.save(book);
}
public MyBookService(MyBookRepository mybook) {
    this.mybook = mybook;
}

public void saveMyBook(List<MyBookList> myBookList) {
    mybook.saveAll(myBookList);
}

public List<MyBookList> getAllBooks(){
	return mybook.findAll();
}

public void deleteById(int id) {
	mybook.deleteById(id);
}
}
