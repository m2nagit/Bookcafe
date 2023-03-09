package bookcafe;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;

public class BookMgr implements DataEngineInterface{
	public ArrayList<Book> Abooks = new ArrayList<>();
	public ArrayList<Book> Bbooks = new ArrayList<>();
	
	public static void main(String[] args) {
		BookMgr a = new BookMgr();
		a.mymain();
	}

	private void mymain() {
		readAll("book.txt");
	}
	
	public void readAll(String fileName) {
		Scanner fileIn = openFile(fileName);
		Book b = null;
		fileIn.nextLine();
		while (fileIn.hasNext()) {
			b = new Book();
			b.read(fileIn);
			if(b.part.equals("A")) //구역이 A구역이면 Abooks에 넣고, 구역이 B구역이면 Bbooks에 넣는다
				Abooks.add(b);
			if(b.part.equals("B"))
				Bbooks.add(b);
		}
		fileIn.close();
	}
	
	void printAllA() {
		for(Book b: Abooks)
			b.print();
	}

	void printAllB() {
		for(Book b: Bbooks)
			b.print();
	}
	
	Scanner openFile(String fileName) {
		Scanner fileIn = null;
		File f = new File(fileName);
		try {
			fileIn = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return fileIn;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List search(String kwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewItem(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String kwd) {
		// TODO Auto-generated method stub
		
	}

}
