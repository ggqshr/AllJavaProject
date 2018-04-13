package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PlayPlaneGame extends JPanel implements KeyListener{

//	游戏状态属性
	public int state;
//	游戏的三种状态
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int GAMEOVER = 2;
	
	public BufferedImage name;
	public BufferedImage over;
	
	public Background bgi1;
	public Background bgi2;
	
//	大飞机
	public MyPlane myPlane;
//	小飞机
	public ArrayList<Enemy> enemys = new ArrayList<>(); 
//	子弹
	public Bullet bullet;
	
	public PlayPlaneGame() {
		// TODO Auto-generated constructor stub
		try {
			name = ImageIO.read(PlayPlaneGame.class.getResource("/img/name.png"));
			over = ImageIO.read(PlayPlaneGame.class.getResource("/img/over.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bgi1 = new Background(0, -720);
		bgi2 = new Background(0, 0);
		myPlane = new MyPlane();
		bullet = new Bullet(myPlane);
		for ( int i =0 ;i < 7;i++)
		{
			enemys.add(new Enemy((int)(Math.random()*(7-1+1)+1), (int )(0.5 *i + 1)));
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		myPlane.move(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(bgi1.getImage(), bgi1.getX(), bgi1.getY(), null);
			g.drawImage(bgi2.getImage(), bgi2.getX(), bgi2.getY(), null);
			if (state == START)
			{
				g.drawImage(name, 25, 213, null);
				Font font = new Font(Font.SANS_SERIF, Font.BOLD, 36);
				g.setFont(font);
				g.drawString("--简约版", 50, 300);
			}
			else if(state == RUNNING)
			{
				System.out.println("%%%%%%%%%%%");
				g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
				g.drawImage(myPlane.getImage(), myPlane.getX(), myPlane.getY(), null);
				for (Enemy enemy : enemys) {
					g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), null);
				}
			}
			else {
				g.drawImage(over, 0, 0, null);
			}
		}
//	操控飞机的过程
	public void action ()
	{
		MouseListener mouseListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				switch (state) {
				case START:
					System.out.println("@@@@@@");
					state = RUNNING;
					break;
				case GAMEOVER:
					state = START;
					myPlane = new MyPlane();
					bullet = new Bullet(myPlane);
					enemys = new ArrayList<>();
					for ( int i =0 ;i < 7;i++)
					{
						enemys.add(new Enemy((int)(Math.random()*(7-1+1)+1), (int )(0.5 *i + 1)));
					}
					break;
				default:
					
					break;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		this.addMouseListener(mouseListener);
		while(true)
		{
			
			switch (state) {
			case START:
				bgi1.step();
				bgi2.step();
				break;
			case RUNNING:
				System.out.println("@@@@");
				myPlane.fly();
				bullet.step(myPlane);
				for (Enemy enemy : enemys) {
					enemy.step();
				}
				bgi1.step();
				bgi2.step();
				for (Enemy enemy : enemys) {
					if(enemy.hit(bullet))
					{
						enemy.boom();
					}
					if(myPlane.hit(enemy))
					{
						state = GAMEOVER;
					}
				}
				break;
			default:
				break;
			}
			repaint();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
