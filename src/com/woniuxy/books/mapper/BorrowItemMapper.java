package com.woniuxy.books.mapper;

import org.apache.ibatis.annotations.InsertProvider;

import com.woniuxy.books.provider.BorrowItemProvider;
import com.woniuxy.books.pojo.BorrowItem;

public interface BorrowItemMapper {

	@InsertProvider(type =BorrowItemProvider.class,method = "insertBorrowItem")
	public boolean insertBorrowItem(BorrowItem item);

	/*@SelectProvider(type =BorrowItemProvider.class,method = "findIdByBno")
	public int findIdByBno(String bm_number);*/

}
