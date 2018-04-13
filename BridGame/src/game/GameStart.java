package game;

import java.io.IOException;

import javax.swing.JFrame;

public class GameStart {

	public static void main(String[] args) throws IOException {
		JFrame j = new JFrame();
		BridGame game = new BridGame();
		j.add(game);
		j.setSize(440,670);
		j.setVisible(true);
		game.action();
	}
}
