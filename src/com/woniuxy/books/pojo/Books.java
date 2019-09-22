package com.woniuxy.books.pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
	private int b_id;
	private int bt_id;
	private String b_name;
	private String b_author;//作者
	private BigDecimal b_price;//价格
	private String b_press;//出版社
	private int b_repertory;//库存
	private String b_pub_date;//出版时间
	private int b_total_repertory;//总库存
	private String b_describe;//描述
	private int b_flag;

}
