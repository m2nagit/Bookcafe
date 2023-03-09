package mgr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager <T extends Manageable>	{
	public static Scanner scan = new Scanner(System.in);
	public ArrayList<T> mList = new ArrayList<T>();
	public ArrayList<T> uList = new ArrayList<T>();
	public T find(String name) {
		for (T p : mList) {
			if (p.matches(name))
				return p;
		}
		return null;
	}

	public void readAll(String filename, Factory<T> fac) {
		Scanner filein = openFile(filename);
		T m = null;
		while (filein.hasNext()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}

	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(0);
		}
		return filein;
	}

	public void printAll() {
		for (T m : mList) {
			m.print();
		}
	}
	
	public void printSeat() {
		int cnt = 0;
		for (T m : mList) {
			m.print();
			cnt ++;
			if(cnt%10==0)
				System.out.println();
		}
	}

	// 맞는 회원번호 입력할 때까지 입력
	public T checkMember() {
		// TODO Auto-generated method stub
		T mem = null;
		do {
			System.out.print("-본인의 고유 번호를 입력해 주세요. :");
			int num = scan.nextInt();
			mem = find(num + "");
			if (mem == null) {
				System.out.println("**존재하지 않는 고유번호입니다. 다시 입력해 주세요.");
			}
		} while (mem == null);

		while (true) {
			System.out.print("-본인의 비밀번호를 입력해주세요.");
			String password = scan.next();
			if (!mem.matches(password)) {
				System.out.println("**비밀번호가 틀렸습니다. 다시 입력해주세요.");
				continue;
			}
			break;
		}
		return mem;
	}

	public List<T> findAll(String kwd) {
		// TODO Auto-generated method stub
		List<T> results = new ArrayList<T>();
		for(T m: mList) {
			results.add(m);
		}
		return results;
	}
}
