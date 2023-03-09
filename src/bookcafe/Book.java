package bookcafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;
import facade.UIData;
import mgr.Manageable;

public class Book implements Manageable, UIData {
	// 2 구덩이 민음사 2007 2 808.8 Platonov_Andrei
	int num; // 책 고유번호
	public String part; //구역의 위치
	public String name; // 책 이름
	String pub; // 출판사
	int year; // 출판년도
	public int bookset; // 책 개수
	String Symbol; // 분류기호 -> 책의 장르를 나타내기도 함
	ArrayList<String> authors = new ArrayList<>(); // 저자

	@Override
	public void read(Scanner scan) {
		num = scan.nextInt();
		part = scan.next();
		name = scan.next();
		pub = scan.next();
		year = scan.nextInt();
		bookset = scan.nextInt();
		Symbol = scan.next();
		String token = null;
		while (true) {
			token = scan.next();
			if (token.equals("0"))
				break;
			authors.add(token);
		}
	}

	@Override
	public void print() {
		System.out.printf("책이름: [%s]\t (%d권/%s/%s/%d년)\t <저자: ", name, bookset, pub, Symbol, year);
		for (String s : authors)
			System.out.printf("%s ", s);
		System.out.println(">");
	}

	@Override
	public boolean matches(String kwd) {
		// 번호 대여가능여부 책이름 분류기호 도서기호 부차적기호 저자
		if (("" + num).equals(kwd))
			return true;
		if (name.equals(kwd))
			return true;
		if (Symbol.equals(kwd))
			return true;
		for (String s : authors)
			if (s.equals(kwd))
				return true;
		return false;
	}
	
	public void borrowBook() {
		bookset--; 
	}

	public void returnBook() {
		bookset++;
	}

	private String getAuthors() {
		String fullAuthors = "";
		for (String s : authors) {
			fullAuthors += s;
		}
		return fullAuthors;
	}

	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		return new String[] {name, pub, "" + year, "" + bookset, Symbol, getAuthors() };
	}
	
	
	@Override
	public void set(Object[] row) {
		num = Integer.parseInt((String) row[0]);
		name = (String) row[1];
		pub = (String) row[2];
		year = Integer.parseInt((String) row[3]);
		bookset = Integer.parseInt((String) row[4]);
		Symbol = (String) row[5];
		authors.add((String) row[6]);
	}

}
