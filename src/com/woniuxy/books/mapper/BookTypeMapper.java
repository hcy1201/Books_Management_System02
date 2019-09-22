package com.woniuxy.books.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.woniuxy.books.pojo.BookType;
import com.woniuxy.books.provider.BooksProvider;

public interface BookTypeMapper {
	
	/**
	 * //查询所有图书分类信息
	 * @param
	 * @return
	 */
	@SelectProvider(type =BooksProvider.class,method = "search" )
	public List<BookType> search();

}
