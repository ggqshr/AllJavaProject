package game;

import javax.swing.JFrame;

public class Startgame {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		JFrame j = new JFrame();
		j.setSize(480,720);
		PlaneGame pg = new PlaneGame();
		j.add(pg);
		j.setLocationRelativeTo(null);//…Ë÷√æ”÷–
		j.setVisible(true);
		j.addKeyListener(pg);
		pg.action();
	}

}
