package com.kh.bookmanager.book;

import java.util.List;

public class BookController {
	
	private BookService bookService =  new BookService();

	public List<Book> searchBookByTitle(String keyword) {
		return bookService.selectBookByTitle(keyword);
	}

	public List<Book> searchBookWithRank() {
		return bookService.selectBookWithRank();
	}
	
	
}
