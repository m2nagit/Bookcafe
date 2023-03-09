package bookcafe;

import mgr.Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import mgr.Factory;

public class Bookcafe {
	private static Bookcafe bookcafe = null;
	
	private Bookcafe(){}
	
	public static Bookcafe getInstance() {
		if(bookcafe == null) {
			bookcafe = new Bookcafe();
		}
		return bookcafe;
	}
	
	static Manager<Member> memberMgr = new Manager<Member>(); // 멤버
	static Manager<Book> bookMgr = new Manager<Book>(); // 책
	static Manager<Entry> seatMgr = new Manager<Entry>(); // 열람실좌석
	static Manager<Item> itemMgr = new Manager<Item>(); // 음료,음식

	public void run() {
		bookMgr.readAll("book.txt", new Factory<Book>() {
			@Override
			public Book create() {
				// TODO Auto-generated method stub
				return new Book();
			}
		});
		booksort();
		bookMgr.printAll();
		
		memberMgr.readAll("member.txt", new Factory<Member>() {
			@Override
			public Member create() {
				// TODO Auto-generated method stub
				return new Member();
			}
		});
		memberMgr.printAll();
		
		seatMgr.readAll("seat.txt", new Factory<Entry>() {
			public Entry create() {
				return new Entry();
			}
		});
		seatMgr.printSeat();
		
		itemMgr.readAll("menu.txt", new Factory<Item>() {
			public Item create() {
				return new Item();
			}
		});
		itemMgr.printAll();
		bookcafeSystem();
	}

	// 북카페 시스템
	public void bookcafeSystem() {
		while (true) {
			System.out.println("=============== 북카페 ================");
			System.out.println("(1) 책현황   (2) 책대여   (3) 좌석현황  (4) 좌석관리  (5) 음료주문  (0) 종료");
			int menu = Manager.scan.nextInt();
			if (menu == 1)
				bookMgr.printAll();
			else if (menu == 2)
				checkOutBookSystem();
			else if (menu == 3)
				seatMgr.printSeat();
			else if (menu == 4)
				checkOutEntrySystem();
			else if (menu == 5)
				checkOutOrderSystem();
			else
				break;
		}
	}

	// 책 대여반납 시스템
	public void checkOutBookSystem() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("============= 책대출 ==============");
			System.out.print("(1) 대여   (2) 반납   (0) 돌아가기");
			int menu = Manager.scan.nextInt();
			if (menu == 1)
				borrowBook();
			else if (menu == 2)
				returnBook();
			else if (menu == 0)
				break;
			else
				break;
		}
	}

	// 책 대출 시스템
	private boolean borrowBook() {
		// TODO Auto-generated method stub
		Member mem = memberMgr.checkMember();
		Book book = checkBook();
		Book original = book;
		if (book.bookset == 0) {
			System.out.println("**책이 모두 대여중입니다.");
			return false;
		}
		book.borrowBook();
		//mem.setBorrowDay();
		//mem.setReturnDay();
		mem.bList.add(book);
		System.out.println("-책 대여가 완료되었습니다.");
		//System.out.println("-책의 대출일은 " + mem.bDate + "입니다.");
		//System.out.println("-책의 반납일은 " + mem.rDate + "입니다.");
		setBookList(original, book);
		return true;
	}

	// 책 반납 시스템
	private void returnBook() {
		// TODO Auto-generated method stub
		Member mem = memberMgr.checkMember();
		Book book = null;
		Book original = null;
		while (true) {
			book = checkBook();
			if (mem.checkMemberList(book)) {
				original = book;
				break;
			}
			System.out.println("**입력하신 책은 빌리신 책이 아닙니다. 다시입력해주세요.");
		}
		book.returnBook();
		setBookList(original, book);
		System.out.println("-책 반납을 완료했습니다.");
	}

	// 책 권수 실시간 업데이트
	private boolean setBookList(Book original, Book book) {
		// TODO Auto-generated method stub
		for (Book b : bookMgr.mList) {
			if (b.num == original.num) {
				bookMgr.mList.remove(original);
				bookMgr.mList.add(book);
				booksort();
				return true;
			}
		}
		return false;
	}

	public void booksort() {
		Collections.sort(bookMgr.mList,new Comparator<Book>() {
			@Override
			public int compare(Book b1,Book b2) {
				if(!b1.name.equals(b2.name)) {
					return b1.name.compareTo(b2.name);
				}
				return 0;
			}
		});
	}
	// 책 입력 및 확인
	private Book checkBook() {
		// TODO Auto-generated method stub
		Book b = null;
		do {
			System.out.print("-책의 고유 번호를 입력하세요.: ");
			int num = Manager.scan.nextInt();
			b = bookMgr.find(num + "");
			if (b == null)
				System.out.println("**존재하지 않는 책입니다. 다시 입력해주세요.");
		} while (b == null);

		return b;
	}

	// 열람실 좌석관리 시스템
	public void checkOutEntrySystem() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("============= 좌석 ==============");
			System.out.print("(1) 등록   (2) 반납   (0) 돌아가기");
			int menu = Manager.scan.nextInt();
			if (menu == 1)
				setSeat();
			else if (menu == 2)
				returnSeat();
			else if (menu == 0)
				break;
			else
				break;
		}
	}

	// 열람실 등록(좌석 등록)
	private boolean setSeat() {
		// TODO Auto-generated method stub
		Member mem = memberMgr.checkMember();
		Entry entry = checkSeat();

		//mem.setBorrowDay();
		//mem.setReturnDay();
		mem.eList.add(entry);
		System.out.println("-좌석 등록(입실)이 완료되었습니다.");
		entry.setSeat();
		return true;
	}

	// 열람실 퇴실(좌석 반납)
	private void returnSeat() {
		// TODO Auto-generated method stub
		Member mem = memberMgr.checkMember();
		Entry entry = null;
		while (true) {
			entry = checkSeat();
			if (mem.checkSeatList(entry)) {
				break;
			}
			System.out.println("**입력하신 좌석은 대여한 좌석이 아닙니다. 다시입력해주세요.");
		}
		entry.returnSeat();
		System.out.println("-퇴실 처리 완료했습니다.");
	}

	// 좌석입력 및 확인
	private Entry checkSeat() {
		// TODO Auto-generated method stub
		Entry b = null;
		do {
			System.out.print("좌석번호를 입력하세요.: ");
			int num = Manager.scan.nextInt();
			b = seatMgr.find(num + "");
			if (b == null)
				System.out.println("**존재하지 않는 좌석입니다. 다시 입력해주세요.");
		} while (b == null);

		return b;
	}

	// 음식주문시스템
	private void checkOutOrderSystem() {
		while (true) {
			System.out.println("============= 음식 주문 ==============");
			System.out.print("(1) 주문  (2) 현재 금액 (0) 돌아가기");
			int menu = Manager.scan.nextInt();
			if (menu == 1)
				orderMenu();
			else if (menu == 2)
				totalPrice();
			else if (menu == 0)
				break;
			else
				break;
		}
	}

	// 메뉴 입력 및 확인
	private ArrayList<Item> checkMenu() {
		// TODO Auto-generated method stub
		Item i = null;
		String name = null;
		ArrayList<Item> returnList = new ArrayList<Item>();
		do {
			System.out.print("-주문 음식 이름을 입력하세요.(end입력시 주문종료): ");
			name = Manager.scan.next();
			if (name.equals("end"))
				break;
			i = itemMgr.find(name);
			if (i == null)
				System.out.println("**존재하지 않는 메뉴입니다. 다시 입력해주세요.");
			else
				returnList.add(i);
		} while (true);
		return returnList;
	}

	// 메뉴 주문
	private boolean orderMenu() {
		// TODO Auto-generated method stub
		Member mem = memberMgr.checkMember();
		ArrayList<Item> rList = checkMenu();
		for (Item it : rList) {
			mem.iList.add(it);
		}

		System.out.println("-메뉴주문이 완료되었습니다.");
		System.out.printf("------- %s님 주문메뉴 ------- \n", mem.name);
		for (Item it : rList) {
			it.print();
		}
		System.out.printf("총 가격은 %d원 입니다.\n", total(rList));
		return true;
	}

	// 총 가격 반환
	private int total(ArrayList<Item> it) {
		int total = 0;
		for (Item i : it) {
			total += i.price;
		}
		return total;
	}

	// 총 가격 출력
	private void totalPrice() {
		// TODO Auto-generated method stub
		Member mem = memberMgr.checkMember();
		mem.getTotalPrice();
		System.out.println("=========== 주문 내역 ============");
		for (Item it : mem.iList) {
			it.print();
		}
		System.out.printf("총 가격은 %d원 입니다.\n", mem.total);
	}

	public static void main(String[] args) {
		Bookcafe bc = new Bookcafe();
		bc.run();

	}
}