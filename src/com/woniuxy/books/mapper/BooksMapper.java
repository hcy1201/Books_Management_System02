package com.woniuxy.books.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.woniuxy.books.pojo.Books;
import com.woniuxy.books.pojo.BorrowItem;
import com.woniuxy.books.pojo.BorrowMess;
import com.woniuxy.books.provider.BooksProvider;

public interface BooksMapper {
	/**
	 * 查询图书信息
	 * @param bt_id
	 * @return
	 */
	@SelectProvider(type =BooksProvider.class,method = "findBooks" )
	public List<Books> findBooks(Books books) ;
	/**
	 * 通过图书编号删除图书 软删除 库存不为0时不能删除
	 * @param b_id
	 * @return
	 */
	@DeleteProvider(type =BooksProvider.class,method = "delectBookById" )
	public int delectBookById(int b_id) ;
	/**
	 * 添加图书
	 * @param books
	 * @return
	 */
	@InsertProvider(type = BooksProvider.class,method = "addBook")
	public int addBook(Books books);
	/**
	 * 修改图书信息
	 * @param books
	 * @return
	 */
	@UpdateProvider(type = BooksProvider.class,method = "updateBook")
	public int updateBook(Books books);
	/**
	 * 修改库存
	 * @param id
	 * @return
	 */
	@UpdateProvider(type = BooksProvider.class,method = "updateBookRepertory")
	public int updateBookRepertory(int id);
	/**
	 * 查询一行数据
	 * @param b_id
	 * @return
	 */
	@SelectProvider(type =BooksProvider.class,method = "findBooksOneRow" )
	public Books findBooksOneRow(int b_id);
	/**
	 * 查询借阅信息
	 * @param uid
	 * @return
	 */
	@Select("select * from borrowmess where u_id=#{uid}")
	@Results({
		@Result(id = true,column = "bm_id",property = "bm_id"),
		@Result(column = "bm_name",property = "bm_name"),
		@Result(column = "bm_number",property = "bm_number"),
		@Result(column = "bm_state",property = "bm_state"),
		@Result(column = "bm_out_date",property = "bm_out_date"),
		@Result(column = "bm_return_date",property = "bm_return_date"),
		@Result(column = "u_id",property = "u_id"),
		@Result(column = "bm_id",property = "item",many = @Many(select = "findBorrowItem"))
	})
	public List<BorrowMess> findBorrowMess(int uid);
	
	@Select("SELECT * from borrowitem where bm_id=#{bm_id}")
	public List<BorrowItem> findBorrowItem(int bm_id);

}
