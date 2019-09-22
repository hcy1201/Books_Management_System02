package com.woniuxy.books.provider;

import org.apache.ibatis.jdbc.SQL;

import com.woniuxy.books.pojo.BorrowItem;

public class BorrowItemProvider {
	
	/**
	 * INSERT INTO borrowitem(b_id,b_name,bi_price,bi_count,bi_describe,bm_id)
	 * VALUES();
	 * 
	 * @param item
	 * @return
	 */
	public String insertBorrowItem(BorrowItem item) {
		SQL sql = new SQL();
		sql.INSERT_INTO("borrowitem").VALUES("b_id,b_name,bi_price,bi_count,bi_describe,bm_id",
				item.getB_id() + ",'" + item.getB_name() + "'," + item.getBi_price() + ","
						+ item.getBi_count() + ",'" + item.getBi_describe() + "'," + item.getBm_id());
		return sql.toString();
	}
}
