package GUI;

import javax.swing.JFrame;

import bookcafe.Bookcafe;

public class GUIMain {
	// 싱글톤 패턴 적용 부분
	private static GUIMain main = null;
	private GUIMain() {}
	public static GUIMain getInstance() {
		if (main == null)
			main = new GUIMain();
		return main;
	}
	// 엔진의 인스턴스를 편리를 위해 변수에 저장한다
    static Bookcafe bookcafe = Bookcafe.getInstance();
    public static void main(String args[]) {
    	bookcafe.run();
    	startGUI();
    	new Login();
    }
    public static void startGUI() {
        // 이벤트 처리 스레드를 만들고 
        // 거기서 GUI를 생성하고 보여준다.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUIMain.getInstance().createAndShowGUI();
            }
        });
    }
    /**
     * GUI를 생성하여 보여준다. 스레드 안전을 위하여
     * 이 메소드는 이벤트 처리 스레드에서 불려져야 한다.
     */
	static JFrame mainFrame = new JFrame("TableSelectionDemo");
    private void createAndShowGUI() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}