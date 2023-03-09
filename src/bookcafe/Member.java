package bookcafe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;
import facade.UIData;
import mgr.Manageable;

public class Member implements Manageable, UIData {
	// 1 1q2w 강찬 010-2791-8593 1989 3 12
	int num; // 고유번호
	String password; // 비밀번호
	String name; // 이름
	String phone; // 전화번호
	int b_year; // 태어난 해
	int b_month; // 태어난 달
	int b_day; // 태어난 날
	String bDate; // 빌려간날
	String rDate; // 돌려줘야 하는 날
	ArrayList<Book> bList = new ArrayList<Book>(); // 빌린 책 리스트
	ArrayList<Entry> eList = new ArrayList<Entry>(); // 좌석 리스트
	ArrayList<Item> iList = new ArrayList<Item>();
	int total; // 총 가격
	static int lastNumber;

	public void getTotalPrice() {
		total = 0;
		for (Item it : iList) {
			total += it.price;
		}
	}

	@Override
	public void read(Scanner scan) {
		num = scan.nextInt();
		password = scan.next();
		name = scan.next();
		phone = scan.next();
		b_year = scan.nextInt();
		b_month = scan.nextInt();
		b_day = scan.nextInt();
		lastNumber = num;
	}

	@Override
	public void print() {
		System.out.printf("%d %s \n", num, name);
	}

	@Override
	public boolean matches(String kwd) {
		// 고유번호, 이름, 전화번호, 비밀번호 일치 할때 return true
		if (("" + num).equals(kwd))
			return true;
		if (name.equals(kwd))
			return true;
		if (phone.equals(kwd))
			return true;
		if (password.equals(kwd))
			return true;
		return false;
	}

	 /*
	 * // 대출일 세팅 
	 * public void setBorrowDay() {
	 * Calendar thisday = Calendar.getInstance(); 
	 * int year = thisday.get(Calendar.YEAR); 
	 * int month = thisday.get(Calendar.MONTH) + 1; 
	 * int day = thisday.get(Calendar.DATE);
	 * bDate = "" + year + month + day; 
	 * }
	 * 
	 * // 반납일 세팅 
	 * public void setReturnDay() { 
	 * Calendar thisday = Calendar.getInstance();
	 * int year = thisday.get(Calendar.YEAR); 
	 * int month = thisday.get(Calendar.MONTH) + 1; 
	 * int day = thisday.get(Calendar.DATE) + 7;
	 * rDate = "" + year + month + day; }
	 */
	
	// 빌린 책 리스트 확인
	public boolean checkMemberList(Book book) {
		// TODO Auto-generated method stub
		for (Book b : bList) {
			if (b.num == book.num) {
				bList.remove(b);
				return true;
			}
		}
		return false;
	}

	// 좌석 대여여부 확인
	public boolean checkSeatList(Entry entry) {
		// TODO Auto-generated method stub
		for (Entry e : eList) {
			if (e.num == entry.num) {
				eList.remove(e);
				return true;
			}
		}
		return false;
	}

	@Override
	public String[] getUiTexts() {
		return new String[] { "" + num, password, name, phone, b_year + "년" + b_month + "월" + b_day + "일" };
	}

	@Override
	public void set(Object[] row) {
		num = Integer.parseInt((String) row[0]);
		password = (String) row[1];
		name = (String) row[2];
		phone = (String) row[3];
		b_year = Integer.parseInt((String) row[4]);
		b_month = Integer.parseInt((String) row[5]);
		b_day = Integer.parseInt((String) row[6]);
	}
}
