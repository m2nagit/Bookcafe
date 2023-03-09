package bookcafe;

import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;
import mgr.Manager;

public class ItemMgr implements DataEngineInterface {
	private static ItemMgr mgr = null;

	public ItemMgr() {
	}

	public static ItemMgr getInstance() {
		if (mgr == null)
			mgr = new ItemMgr();
		return mgr;
	}

	private String[] headers = { "name", "code", "price" };

	@Override
	public String[] getColumnNames() {
		return headers;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Item> search(String kwd) {
		// TODO Auto-generated method stub
		return Bookcafe.itemMgr.findAll(kwd);
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
