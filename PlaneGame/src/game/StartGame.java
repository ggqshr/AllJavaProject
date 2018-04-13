package game;

import javax.swing.JFrame;
import javax.xml.crypto.dsig.keyinfo.PGPData;

public class StartGame {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(480, 720);
		PlayPlaneGame planeGame = new PlayPlaneGame();
		jFrame.add(planeGame);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.addKeyListener(planeGame);
		planeGame.action();
	}
	
}
