package com.woniuxy.books.service.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.books.mapper.BookTypeMapper;
import com.woniuxy.books.mapper.BooksMapper;
import com.woniuxy.books.mapper.BorrowItemMapper;
import com.woniuxy.books.mapper.BorrowMessMapper;
import com.woniuxy.books.pojo.BookType;
import com.woniuxy.books.pojo.Books;
import com.woniuxy.books.pojo.BorrowItem;
import com.woniuxy.books.pojo.BorrowMess;
import com.woniuxy.books.pojo.Users;
import com.woniuxy.books.service.BooksService;

import lombok.Data;

@Data
@Service
public class BooksServiceImp implements BooksService{
	@Autowired
	private BooksMapper booksMapper;
	@Autowired
	private BorrowMessMapper borrowMessMapper;
	@Autowired
	private BorrowItemMapper bItemMapper;
	private Scanner sc = new Scanner(System.in);
	@Autowired
	private BookTypeMapper bTypeMapper;
	/**
	 * 查询并显示图书类型信息
	 */
	@Override
	public List<BookType> getBooksType() {
		
		List<BookType> bookTypes = bTypeMapper.search();
		return bookTypes;
		
	}
	/**
	 * 查询并显示图书信息
	 * @param b
	 */
	public List<Books> findBooks(Books b) {
		List<Books> books = booksMapper.findBooks(b);
		return books;
	}

	// 字符串换行
	public void lineFeed(String describe) {
		for (int i = 0; i <= describe.length() / 40; i++) {
			if (i == describe.length() / 40) {
				System.out.println("\t" + describe.substring(i * 40, describe.length()));
			} else {
				System.out.println("\t" + describe.substring(i * 40, (i + 1) * 40));
			}

		}
	}

	/**
	 * 删除图书
	 */
	@Transactional
	public boolean delectBookById(int b_id) {
		boolean flag = false;
		if (booksMapper.delectBookById(b_id) > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 添加图书
	 * 
	 * @return
	 */
	// 添加图书
	@Transactional
	public boolean addBook(Books books) {
		boolean flag = false;
		if(booksMapper.addBook(books)>0) {
			flag=true;
		}
		return flag;
	}
	/**
	 *修改图书信息
	 * @param b_id
	 * @return
	 */
	@Transactional
	public boolean updateBook(Books books) {
		boolean flag = false;
		if(booksMapper.updateBook(books)>0) {
			flag=true;
		}
		return flag;
	}
	/**
	 * 借阅图书
	 * @param map 
	 */
	@Transactional
	public void borrowBooks(HashMap<String, Users> map) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		boolean flag=true;
		BorrowItem bItem=new BorrowItem();
		BorrowMess bMess=new BorrowMess();
		//Map<String, Integer> repertory=new HashMap<String, Integer>();
		//插入借阅单信息
		for(String key : map.keySet()){
			bMess.setBm_name(key);
			bMess.setU_id(map.get(key).getU_id());
		}
		bMess.setBm_number(String.valueOf((long) (new Date().getTime() + (Math.floor(Math.random() * 90) + 10))));
		bMess.setBm_state(0);
		bMess.setBm_out_date(dateFormat.format(new Date()));
		System.out.print("请输入预计还书时间:（2019-9-16）");
		
		try {
			bMess.setBm_return_date(dateFormat.format(dateFormat.parse(sc.next())));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		if (!borrowMessMapper.insertBorrowMess(bMess)) {
			return;
		}
		// 查询借阅单号id
		int bm_id = borrowMessMapper.findIdByBno(bMess.getBm_number());
		bItem.setBi_count(1);
		bItem.setBm_id(bm_id);
		while (flag) {
			//插入借阅详细信息
			System.out.print("图书编号：");
			int b_id=sc.nextInt();
			Books book = booksMapper.findBooksOneRow(b_id);
			
			if (book == null) {
				System.out.println("没有找到你需要的书籍");
				return;
			} else {
		
				if (book.getB_repertory() <= 0) {
					System.out.println("库存不足");
					return;
				}
				bItem.setB_id(book.getB_id());
				bItem.setB_name(book.getB_name());
				bItem.setBi_describe(book.getB_describe());
				bItem.setBi_price(book.getB_price());
		
			}
			
			//插入借阅详细信息
			if(!bItemMapper.insertBorrowItem(bItem)){
				return;
			}
			//更新图书信息
			//repertory.put("id", book.getB_id());
			if(booksMapper.updateBookRepertory(book.getB_id())==0) {
				return;
			}
			System.out.println("是否继续借阅图书（y/n）");
			String bKey=sc.next();
			if(bKey.toLowerCase().equals("y")) {
				flag=true;
			}else if (bKey.toLowerCase().equals("n")) {
				flag=false;
			}
		}
	}
	/**
	 * 查询图书借阅信息
	 * @param uid
	 */
	public Map<String, String> findBookBorrowMess(int uid) {
		List<BorrowMess> bList = booksMapper.findBorrowMess(uid);
		Map<String, String> map=new HashMap<String, String>();
		String state="";
		String number="";
		if(bList.size()<0) {
			System.out.println("没有找到你的借阅信息");
		}else {
			for (BorrowMess borrowMess : bList) {
				if(borrowMess.getBm_state()==0) {
					state="借阅中";
				}else if(borrowMess.getBm_state()==1){
					state="已归还";
				}
				number=borrowMess.getBm_number();
				map.put(number, state);
			}
		}
		return map;
		
	}
	/**
	 * 归还图书
	 * @param string
	 */
	@Transactional
	public void returnBooks(String string) {
		if(borrowMessMapper.returnBooks(string)>0) {
			//更新库存（+1）
			System.out.println("库存更新");
		}
		
	}

}
