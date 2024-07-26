package com.khaja.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khaja.librarysystem.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
