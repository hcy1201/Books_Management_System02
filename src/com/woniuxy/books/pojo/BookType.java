package com.woniuxy.books.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookType {
	private int bt_id;
	private String bt_name;
	private int bt_flag;

}
