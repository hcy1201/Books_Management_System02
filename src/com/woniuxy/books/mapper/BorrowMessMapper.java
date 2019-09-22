package com.woniuxy.books.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.woniuxy.books.provider.BorrowMessProvider;
import com.woniuxy.books.pojo.BorrowMess;

public interface BorrowMessMapper {
	/**
	 * 
	 * @param bMess
	 * @return
	 */
	@InsertProvider(type =BorrowMessProvider.class,method = "insertBorrowMess")
	public boolean insertBorrowMess(BorrowMess bMess);

	/**
	 * 
	 * @param bm_number
	 * @return
	 */
	@SelectProvider(type =BorrowMessProvider.class,method = "findIdByBno")
	public int findIdByBno(String bm_number);
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	@UpdateProvider(type =BorrowMessProvider.class,method = "returnBooks")
	public int returnBooks(String string);

}
