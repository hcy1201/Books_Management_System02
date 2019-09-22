package com.woniuxy.books.provider;

import org.apache.ibatis.jdbc.SQL;

import com.woniuxy.books.pojo.Books;

public class BooksProvider {
	/**
	 * 查询
	 * @param books
	 * @return
	 */
	public String findBooks(Books books) {
		SQL sql = new SQL();
		sql.SELECT("*").FROM("books").WHERE("b_flag=0");
		if(books!=null&&books.getBt_id()!=0) {
			sql.WHERE("bt_id="+books.getBt_id());
		}
		return sql.toString();
	}
	
	/**
	 * 删除
	 * @param b_id UPDATE books SET b_flag =1 where b_id=#{b_id} and b_count=0
	 * @return
	 */
	public String delectBookById(int b_id) {
		SQL sql = new SQL();
		sql.UPDATE("books").SET("b_flag =1").WHERE("b_id="+b_id);
		sql.WHERE("b_count=0");
		return sql.toString();
	}
	
	/**
	 *图书类型查询 select bt_id,bt_name,bt_flag from booktype
	 * @return
	 */
	public String search() {
		SQL sql = new SQL();
		sql.SELECT("*").FROM("booktype");
		return sql.toString();
	}
	/**
	 * 添加图书
	 * @param books
	 * @return
	 */
	public String addBook(Books books) {
		SQL sql=new SQL();
		sql.INSERT_INTO("books").VALUES("bt_id,b_name,b_author,b_price,b_press,b_repertory,b_pub_date,b_total_repertory,b_describe",
				 books.getBt_id()+",'"+books.getB_name()+"','"+books.getB_author()+"','"+books.getB_price()+"','"
		+books.getB_press()+"',"+books.getB_repertory()+",'"+books.getB_pub_date()+"',"+books.getB_total_repertory()+",'"+books.getB_describe()+"'");
		return sql.toString();
	}
	/**
	 * 修改图书信息
	 * @param books
	 * @return
	 */
	public String updateBook(Books books) {
		SQL sql=new SQL();
		sql.UPDATE("books").SET("b_author='"+books.getB_author()+"',b_describe='"+books.getB_describe()+"'").WHERE("b_id="+books.getB_id());
		sql.WHERE("b_count=0");
		return sql.toString();
	}
	/**
	 * 修改库存
	 * @param id
	 * @return
	 */
	public String updateBookRepertory(int id) {
		SQL sql=new SQL();
		sql.UPDATE("books").SET("b_repertory=b_repertory-1").WHERE("b_id="+id);
		sql.WHERE("b_flag=0");
		return sql.toString();
	}
	/**
	 * 查询一行数据
	 * @param b_id
	 * @return
	 */
	public String findBooksOneRow(int b_id){
		SQL sql = new SQL();
		sql.SELECT("*").FROM("books").WHERE("b_id="+b_id);
		return sql.toString();
	}
	
	/*public String findBorrowMess(int uid) {
		SQL sql=new SQL();
		sql.SELECT("*").FROM("borrowmess").WHERE("mess.u_id="+uid);
		return sql.toString();
	}*/
}
