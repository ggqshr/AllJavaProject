package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BridGame extends JPanel{
	/**
	 * 
	 */
	public int state;
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int GAMEOVER = 2;
	//背景
	public BufferedImage backgrountImage;
	//开始界面
	public BufferedImage startImage;
	//结束界面
	public BufferedImage overImage;
	//得分
	public int score;
	
	public Brid brid;
	public Ground ground;
	public ArrayList<Column> columns = new ArrayList<>();
	
	public BridGame() throws IOException {
		// TODO Auto-generated constructor stub
		state = START;
		backgrountImage = ImageIO.read(BridGame.class.getResource("/img/bg.png"));
		startImage = ImageIO.read(BridGame.class.getResource("/img/start.png"));
		overImage = ImageIO.read(BridGame.class.getResource("/img/gameover.png"));
		score=0;
		brid = new Brid();
		ground = new Ground();
		for (int i = 0;i < 2;i++)
		{
			columns.add(new Column());
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(backgrountImage, 0, 0, null);
		for ( int i = 0 ;i < 2;i++)
		{
			Column column=columns.get(i);
			g.drawImage(ground.image, ground.x, ground.y, null);
			g.drawImage(column.image,column.x-column.width/2, column.y-column.height/2, null);
			
			Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
			g.setFont(font);
			g.drawString(""+score, 40, 50);
			
			g.setColor(Color.white);

			Graphics2D graphics2d = (Graphics2D) g;
			
			graphics2d.drawImage(brid.image, brid.x - brid.width, brid.y - brid.height, null);
			switch (state) {
			case START:
				g.drawImage(startImage, 0, 0, null);
				break;
			case GAMEOVER:
				g.drawImage(overImage, 0, 0, null);
				break;
			default:
				break;
			}
		}
	}
	public void action()
	{
		BridGameListener bridGameListener=new BridGameListener();
		this.addMouseListener(bridGameListener);
		while(true)
		{
			
			switch (state) {
			case START:
				brid.fly();
				ground.step();
				break;
			case RUNNING:
				ground.step();
				brid.fly();
				brid.down();
//				brid.step();
				for(int i = 0;i<2;i++)
				{
					Column column = columns.get(i);
					column.step();
				}
				for(int i = 0; i<2;i++)
				{
					System.out.println("@@@");
					Column column = columns.get(i);
					if(brid.x == column.x+column.width)
					{
						score++;
					}
				}
				for(int i = 0;i<2;i++)
				{
					Column column = columns.get(i);
					if(brid.f(column))
					{
						state = 2;
					}
					if(brid.f(ground))
					{
						state = 2;
					}
				}
				break;
			default:
				break;
			}
			repaint();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class BridGameListener extends MouseAdapter
	{

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mousePressed(e);
			switch (state) {
			case START:
				state = RUNNING;
				break;
			case RUNNING:
				brid.step();
				break;
			case GAMEOVER:
				state = 0;
				score = 0;
				try {
					brid = new Brid();
					ground = new Ground();
					columns =new ArrayList<>();
					for ( int i=0;i<2;i++)
					{
						columns.add(new Column());
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			}
		}
		
	}
}
