package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import animation.achieveanimation;
import animation.promptanimation;

import Controler.LoginControler;
import InterFaceAndAbstractClass.Menu;
import InterFaceAndAbstractClass.Painter;
import Painter.LoginPainter;
import Sound.MusicPlayer;
import Sound.SoundPlayer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{
	//游戏速率调节器
	private int count;

	//控制器
	public KeyListener kl; 
	
	//绘图器
	public Painter pr;
	
	//音乐播放器
	public MusicPlayer mp;
	
	//音乐播放管理器
	public MusicManager mm;
	
	//音效播放器
	public SoundPlayer sp;
	
	//控制管理器
	public ControlManager cm;
	
	//绘图管理器
	public PainterManager pm;
	
	//游戏登陆
	public Login lm;
	
	//游戏菜单
	public Menu menu;
	
	//玩家对象
	public Player pl;
	
	//地图对象
	public Map map;
	
	//场景编号
	public int scene;

	//弹出提示框
	public promptanimation pa;

	//成就提示框
	public achieveanimation aa;

	
	//构造方法
	public GamePanel(){
		//新建音效播放器
		sp=new SoundPlayer();
		
		//新建管理器
		pm=new PainterManager();
		cm=new ControlManager();
		mm=new MusicManager();
		
		//初始化控制器为登陆界面
		kl=new LoginControler(this);
		addKeyListener(kl);
		
		//初始化绘图器为登陆界面
		pr=new LoginPainter(this);
		
		//初始化音乐播放器为登陆音乐
		mp=new MusicPlayer("0");
		
		//加载登陆选项
		lm=new Login(this);
		

		//初始化场景为登陆界面
		scene=0;
		

		

	}
	
	//逻辑更新
	public void update(){
		cm.work(this);
		pm.work(this);
		mm.work(this);
		
		if(pl!=null){
			pl.update();
		}
		if(map!=null){
			map.update();
		}
		if(scene==80){
			pl.updater.update();
		}
	
	}

	//双缓冲绘图
	public void paint(Graphics g){
		super.paint(g);
		Image im=createImage(GameFrame.WIDTH,GameFrame.HEIGHT);
		Graphics2D g2=(Graphics2D) im.getGraphics();
		
        pr.draw(g2);
        if(pa!=null){
            pa.drawnext(g2);
        }
        if(aa!=null){
        	aa.drawnext(g2);
        }


		Graphics2D g3=(Graphics2D)(g);
	    g3.drawImage(im,0,0,null);
	    g3.dispose();
	}
	
	//主线程
	public void run() {
		long t1,t2,dt,sleepTime;
		long period=1000/GameFrame.FPS;
		t1=System.nanoTime();
		
		while(true){
			//执行游戏循环
			if(scene!=80){
				if(count==1){
					repaint();
					update();
					count=0;
				}else{
					count++;
				}
			}else{
				repaint();
				update();
			}
			

			
			
			//稳点帧率
			t2=System.nanoTime();
			dt=(t2-t1)/1000000L;
			sleepTime=period-dt;
			if(sleepTime<=0){
				sleepTime=2;
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			t1=System.nanoTime();
		}		
	}	
}
