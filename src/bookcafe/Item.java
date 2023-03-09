package bookcafe;

import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;
import facade.UIData;
import mgr.Manageable;

public class Item implements Manageable,UIData {
	// 1 음료 아메리카노 3500
	// num type name price
	int num;
	String type;
	String name;
	int price;

	public void read(Scanner sc) {
		num = sc.nextInt();
		type = sc.next();
		name = sc.next();
		price = sc.nextInt();
	}

	public void print() {
		System.out.format("[%s] %d %s - %s원\n", type, num, name, price);
	}

	public boolean matches(String kwd) {
		if (kwd.equals("" + num)) {
			return true;
		}
		if (type.equals(kwd)) {
			return true;
		}
		if (name.contains(kwd)) {
			return true;
		}
		if (kwd.equals("" + price))
			return true;
		return false;
	}

	@Override
	public void set(Object[] row) {
		// TODO Auto-generated method stub
		num = Integer.parseInt((String)row[0]);
		type = (String)row[1];
		name = (String)row[2];
		price = Integer.parseInt((String)row[3]);
	}

	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		return new String[] {name};
	}

}