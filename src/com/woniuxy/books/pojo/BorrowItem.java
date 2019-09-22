package com.woniuxy.books.pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowItem {
	private int bi_id;
	private int b_id;
	private String b_name;
	private BigDecimal bi_price;
	private int bi_count;
	private String bi_describe;
	private int bm_id;

}
