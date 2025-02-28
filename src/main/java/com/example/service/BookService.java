package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BookEntity;
import com.example.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookrepo;
	
	public void saveBook(BookEntity book) {
		bookrepo.save(book);
	}
	public List<BookEntity>getInfo() {
		return bookrepo.findAll();
	}
	public  BookEntity editBook(Long id) {
		return bookrepo.findById(id).orElse(null);
	}
	public void deleteBook(Long id) {
		bookrepo.deleteById(id);
	}
}
