package bookcafe;

import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;
import facade.UIData;
import mgr.Manageable;

public class Entry implements Manageable,UIData { 
	//  1  A-01  미지정
	// num seat state
	int num; 
	String seat; 
	String state; // 좌석상태 (지정됨 or 미지정)
	
	public void read(Scanner sc) {
		num = sc.nextInt();
		seat = sc.next();
		state = sc.next();
	}

	public void print() {
		System.out.format("[%s] %s ", seat, state);
	}

	public boolean matches(String kwd) {
		if (("" + num).equals(kwd))
			return true;
		if (seat.equals(kwd))
			return true;
		return false;
	}
	
	public void setSeat() {
		state = "ㅡㅡㅡ"; // 지정됨 
	}
	
	public void returnSeat() {
		state = "미지정";
	}

	@Override
	public void set(Object[] row) {
		// TODO Auto-generated method stub
		num = Integer.parseInt((String)row[0]);
		seat = (String)row[1];
		state = (String)row[2];
	}

	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		return new String[] {"" + num, seat, state };
	}
}
