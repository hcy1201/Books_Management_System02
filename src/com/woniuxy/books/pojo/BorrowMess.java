package com.woniuxy.books.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowMess {
	private int bm_id;
	private String bm_number;
	private String bm_name;
	private int bm_state;
	private String bm_out_date;
	private String bm_return_date;
	private int u_id;
	private List<BorrowItem> item;
}
