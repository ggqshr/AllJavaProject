package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	public BufferedImage image;
	public int x,y;
	public Ground() throws IOException {
		// TODO Auto-generated constructor stub
		image = ImageIO.read(Ground.class.getResource("/img/ground.png"));
		x = 0;
		y = 500;
	}
	public void step()
	{
		x--;
		if(x == -100)
		{
			x = 0;
		}
	}
}
