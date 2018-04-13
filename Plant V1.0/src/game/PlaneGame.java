package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlaneGame extends JPanel implements KeyListener{

	//成员
	//游戏状态属性
	public int state;
	public static final int START  = 0;
	public static final int RUNNING  = 1;
	public static final int GAMEOVER  = 2;
	public static final int AFTERBOOM  = 3;
	int count = 0;
	int score = 0;
	int life = 3;
	
	public BufferedImage name;
	public BufferedImage over;
	
	public Background bgi1;//背景图片1，2
	public Background bgi2;
	public Background bgi3;
	
	//创建Boss
	Boss boss = null;
	//boss子弹
	BossBullet bossBullet = null;
	BossBullet bossBullet1 = null;
	BossBullet bossBullet2 = null;
	//创建大飞机
	
	public MyPlane plane = null;
	//创建小飞机
	public Enemy[] enemies;
	
	public Enemy1[] enemy1s;
	//子弹
	public Bullet bullet;
	//核弹
	public Prop prop;
	//构造方法
	public PlaneGame(){
		try {
			name = ImageIO.read(getClass().getResource("name.png"));
			over = ImageIO.read(getClass().getResource("over.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bgi1 = new Background(0,-850);
		bgi2 = new Background(0,-1700);
		bgi3 = new Background(0,0);
		
		plane = new MyPlane();
		bullet = new Bullet(plane);
		enemies = new Enemy[7];
		enemy1s = new Enemy1[1];
		boss = new Boss();
		
		prop = new Prop();
		for (int i = 0; i < enemies.length; i++) {
			enemies[i] = new Enemy((int)(Math.random()*10 +1),(int)(0.5*i+1));
		}
		enemy1s[0] = new Enemy1((int)(Math.random()*10 +1),(int)(0.5*0+1));
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		plane.move(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//开始界面
	public void  paint(Graphics g) {
		super.paint(g);
		g.drawImage(bgi1.getImage(),bgi1.getX(),bgi1.getY(),null);
		g.drawImage(bgi2.getImage(),bgi2.getX(),bgi2.getY(),null);
		g.drawImage(bgi3.getImage(),bgi3.getX(),bgi3.getY(),null);
		Font font = new Font(Font.SANS_SERIF,Font.BOLD,40);
		if (state ==START) {
			g.drawImage(name,25,213,null);
			
			g.setFont(font);
			g.drawString("---LowB版"	,260,391);
		}
		else if(state == RUNNING){
			g.setFont(font);
			g.drawString(score+"", 20, 40);
			if(bossBullet!=null)
			{
				g.drawImage(bossBullet.getImage(), (int)bossBullet.getX(), (int )bossBullet.getY(), null);
				g.drawImage(bossBullet1.getImage(),(int) bossBullet1.getX(),(int) bossBullet1.getY(), null);
				g.drawImage(bossBullet2.getImage(),(int) bossBullet2.getX(),(int) bossBullet2.getY(), null);
			}
			g.drawImage(bullet.getImage(),bullet.getX(),bullet.getY(),null);
			g.drawImage(plane.getImage(),plane.getX(),plane.getY(),null);
			g.drawImage(prop.getImage(),prop.getX()	, prop.getY(), null);
			g.drawImage(boss.getImage(), boss.getX(), boss.getY(), null);
			for (int i = 0; i < enemies.length; i++) {
				Enemy enemy = enemies[i];
				g.drawImage(enemy.getImage(),enemy.getX(),enemy.getY(),null);
			}
				Enemy1 enemy1 = enemy1s[0];
				g.drawImage(enemy1.getImage(),enemy1.getX(),enemy1.getY(),null);
		}
		else if(state == AFTERBOOM){
			if(bossBullet!=null)
			{
				g.drawImage(bossBullet.getImage(), (int)bossBullet.getX(), (int )bossBullet.getY(), null);
				g.drawImage(bossBullet1.getImage(),(int) bossBullet1.getX(),(int) bossBullet1.getY(), null);
				g.drawImage(bossBullet2.getImage(),(int) bossBullet2.getX(),(int) bossBullet2.getY(), null);
			}
			g.drawImage(bullet.getImage(),bullet.getX(),bullet.getY(),null);
			g.drawImage(plane.getImage(),plane.getX(),plane.getY(),null);
			g.drawImage(prop.getImage(),prop.getX()	, prop.getY(), null);
			g.drawImage(boss.getImage(), boss.getX(), boss.getY(), null);
			for (int i = 0; i < enemies.length; i++) {
				Enemy enemy = enemies[i];
				g.drawImage(enemy.getImage(),enemy.getX(),enemy.getY(),null);
//				System.out.println("PPPPPPPPPPPPPP");
			}
				Enemy1 enemy1 = enemy1s[0];
				g.drawImage(enemy1.getImage(),enemy1.getX(),enemy1.getY(),null);
		}
		else if (state == GAMEOVER) {
			g.drawImage(over,0,0,null);
		}
	}
	
	public void action() throws Throwable {
		MouseListener mouseListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				switch (state) {
				case START:
					state = RUNNING;
					break;
				case RUNNING:
					break;
				case GAMEOVER:
					state = START;
					plane = new MyPlane();
					bullet = new Bullet(plane);
					enemy1s = new Enemy1[1];
					for (int i = 0; i < enemies.length; i++) {		
						enemies[i] = new Enemy((int)(Math.random()*10 +1),(int)(0.5*i+1));
					}
					enemy1s[0] = new Enemy1((int)(Math.random()*10 +1),(int)(0.5*0+1));
					boss = new Boss();
					bossBullet = null;
					bossBullet1 = null;
					bossBullet2 = null;
					prop  = new Prop();
					score = 0;
					break;
				default:
					break;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		this.addMouseListener(mouseListener);
		while (true) {
			switch (state) {
			case START:
				bgi1.step();
				bgi2.step();
				bgi3.step();
				break;
			
			case AFTERBOOM:
				count ++;
				plane.fly();
				bullet.step(plane);
				prop.step();
				for (int i = 0; i < enemies.length; i++) {
					enemies[i].step();
				}
				enemy1s[0].step();
				bgi1.step();
				bgi2.step();
				bgi3.step();
				for (int i = 0; i < enemies.length; i++) {
					if (enemies[i].getIndex() >=3){
						enemies[i].boom();
						enemies[i] = new Enemy((int)(Math.random()*8 +1),(int)-1000);//(int)(0.5*i - 600));
//						System.out.println("@@@@@");
					}
					if (enemies[i].getIndex() ==2){
						enemies[i].boom();
					}
					if (enemies[i].getIndex() ==1){
						enemies[i].boom();
					}
				}
				if (enemy1s[0].getIndex() >=3){
					enemy1s[0].boom();
					enemy1s[0] = new Enemy1((int)(Math.random()*8 +1),(int)(0.5*0 - 300));
				}
				if (enemy1s[0].getIndex() ==2){
					enemy1s[0].boom();
				}
				if (enemy1s[0].getIndex() ==1){
					enemy1s[0].boom();
				}
				if(count == 3)
				{
					state = RUNNING;
					count = 0;
				}
				break;
			case RUNNING:
				plane.fly();
				bullet.step(plane);
				prop.step();
				boss.step();
				if(boss.getY()>=0&&bossBullet==null){
			bossBullet = new BossBullet(boss);
			bossBullet1 = new BossBullet(boss);
			bossBullet2 = new BossBullet(boss);
				}
					if(bossBullet!=null)
					{
						bossBullet.step();
						bossBullet1.step1();
						bossBullet2.step2();
					}
				for (int i = 0; i < enemies.length; i++) {
					enemies[i].step();
				}
				enemy1s[0].step();
				bgi1.step();
				bgi2.step();
				bgi3.step();
				
				////子弹击中重生
				for (int i = 0; i < enemies.length; i++) {
					if (enemies[i].getIndex() >=3){
						score+=10;
						enemies[i] = new Enemy((int)(Math.random()*8 +1),(int)(Math.random()* 50 +1));
					}
					if (enemies[i].getIndex() ==2){
						enemies[i].boom();
					}
					if (enemies[i].getIndex() ==1){
						enemies[i].boom();
					}
					if (enemies[i].hit(bullet)) {
						enemies[i].boom();
						bullet = new Bullet(plane);
					}
					if (plane.hit(enemies[i])) {
						state = GAMEOVER;
					}
				}
				
				
				
				////爆炸重生
				if(prop.hit(plane))
				{
					prop.getBoom();
					state = AFTERBOOM;
					if(bossBullet!=null)
					{
						bossBullet = new BossBullet(boss);
						bossBullet1 = new BossBullet(boss);
						bossBullet2 = new BossBullet(boss);
					}
				
					for (int i = 0; i < enemies.length; i++) {
						if (enemies[i].getIndex() ==0){
							enemies[i].boom();
						}
					}
					if (enemy1s[0].getIndex() ==0){
						enemy1s[0].boom();
					}
				}
				if (enemy1s[0].getIndex() >=3){
					enemy1s[0].boom();
					score+=50;
					enemy1s[0] = new Enemy1((int)(Math.random()*8 +1),(int)(0.5*0+1));
				}
				if (enemy1s[0].getIndex() ==2){
					enemy1s[0].boom();
				}
				if (enemy1s[0].hit(bullet)) {
					enemy1s[0].boom();
					bullet = new Bullet(plane);
				}
				if (plane.hit1(enemy1s[0])) {
					state = GAMEOVER;
				}
				if(bossBullet!=null)
				{
					if(plane.hitBossBullet(bossBullet))
					{
						state = GAMEOVER;
					}
					if(plane.hitBossBullet(bossBullet1))
					{
						state = GAMEOVER;
					}
					if(plane.hitBossBullet(bossBullet2))
					{
						state = GAMEOVER;
					}
				}
				
				if(boss.getIndex() == 1)
				{
					boss.afterHit();
					boss.setIndex(0);
				}
				if(boss.getIndex1()==25)
				{
					score += 100;
					boss = new Boss();
					bossBullet=null;
					bossBullet1=null;
					bossBullet2=null;
				}
				if(boss.hit(bullet))
				{
					boss.afterHit();
					boss.boom();
					bullet = new Bullet(plane);
				}
				if(plane.hitBoss(boss))
				{
					state = GAMEOVER;
				}
				break;
			case GAMEOVER:
				bossBullet = new BossBullet(boss);
				bossBullet1 = new BossBullet(boss);
				bossBullet2 = new BossBullet(boss);
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
}
