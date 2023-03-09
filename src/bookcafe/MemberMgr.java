package bookcafe;

import java.util.List;
import java.util.Scanner;

import facade.DataEngineInterface;
import mgr.Factory;
import mgr.Manager;

public class MemberMgr implements DataEngineInterface<Member> {

	private static MemberMgr mMgr = null;
	public static String userName;
	private MemberMgr() {
	}
	
	public static MemberMgr getInstance() {
		if(mMgr == null) {
			mMgr = new MemberMgr();
		}
		return mMgr;
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
	public List<Member> search(String kwd) {
		// TODO Auto-generated method stub
		if (kwd == null)
			return Bookcafe.memberMgr.mList;
		return Bookcafe.memberMgr.findAll(kwd);
	}

	@Override
	public void addNewItem(String[] uiTexts) {
		// TODO Auto-generated method stub
		Member mem = new Member();
		mem.set(uiTexts);
		Bookcafe.memberMgr.mList.add(mem);
	}


	@Override
	public void update(String[] uiTexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String kwd) {
		// TODO Auto-generated method stub
		Member mem = Bookcafe.memberMgr.find(kwd);
		Bookcafe.memberMgr.mList.remove(mem);
	}
	
	public void printAll() {
		for(Member m : Bookcafe.memberMgr.mList) {
			m.print();
		}
	}

}
