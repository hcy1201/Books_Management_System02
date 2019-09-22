package com.woniuxy.books.provider;

import org.apache.ibatis.jdbc.SQL;

import com.woniuxy.books.pojo.BorrowMess;

public class BorrowMessProvider {
	/**
	 * INSERT INTO borrowmess(bm_name,bm_number,bm_state,bm_out_date,bm_return_date,u_id) VALUES(); 
	 * 插入借阅单信息
	 * @param bMess
	 * @return
	 */
	public String insertBorrowMess(BorrowMess bMess) {
		SQL sql=new SQL();
		sql.INSERT_INTO("borrowmess").VALUES("bm_name,bm_number,bm_state,bm_out_date,bm_return_date,u_id",
				 "'"+bMess.getBm_name()+"','"+bMess.getBm_number()+"',"+bMess.getBm_state()+",'"+bMess.getBm_out_date()+"','"
		+bMess.getBm_return_date()+"',"+bMess.getU_id());
		return sql.toString();
		
	}
	/**
	 * 查询借阅单号id
	 * @param bm_number
	 * @return
	 */
	public String findIdByBno(String bm_number) {
		SQL sql = new SQL();
		sql.SELECT("bm_id").FROM("borrowmess").WHERE("bm_number="+"'"+bm_number+"'");
		
		return sql.toString();
	}
	/**
	 * 归还图书
	 * @param string
	 * @return
	 */
	public String returnBooks(String string) {
		SQL sql = new SQL();
		sql.UPDATE("borrowmess").SET("bm_state=1").WHERE("bm_number="+string);
		
		return sql.toString();
	}

}
