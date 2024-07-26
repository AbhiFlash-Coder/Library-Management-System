package com.khaja.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khaja.librarysystem.entity.MyBookList;
@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
