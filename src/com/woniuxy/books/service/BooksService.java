package com.woniuxy.books.service;

import java.util.List;

import com.woniuxy.books.pojo.BookType;
import com.woniuxy.books.pojo.Books;

public interface BooksService {
	
	/**
	 * 查询图书类型信息
	 */
	public List<BookType> getBooksType();
	
	/**
	 * 查询图书信息
	 * @param b
	 */
	public List<Books> findBooks(Books b);

}
