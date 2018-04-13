package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	
	private int x,y;
	private BufferedImage image;
	
	//���췽��
	public  Background(int x,int y) {
		this.x = x;
		this.y = y;
		try {
			image = ImageIO.read(getClass().getResource("background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void  step() {
		y += 5;
		if (y == 850) {
			y = -1700;
		}
		
	}
//set,get ����
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
