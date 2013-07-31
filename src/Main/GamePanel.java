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
	//��Ϸ���ʵ�����
	private int count;

	//������
	public KeyListener kl; 
	
	//��ͼ��
	public Painter pr;
	
	//���ֲ�����
	public MusicPlayer mp;
	
	//���ֲ��Ź�����
	public MusicManager mm;
	
	//��Ч������
	public SoundPlayer sp;
	
	//���ƹ�����
	public ControlManager cm;
	
	//��ͼ������
	public PainterManager pm;
	
	//��Ϸ��½
	public Login lm;
	
	//��Ϸ�˵�
	public Menu menu;
	
	//��Ҷ���
	public Player pl;
	
	//��ͼ����
	public Map map;
	
	//�������
	public int scene;

	//������ʾ��
	public promptanimation pa;

	//�ɾ���ʾ��
	public achieveanimation aa;

	
	//���췽��
	public GamePanel(){
		//�½���Ч������
		sp=new SoundPlayer();
		
		//�½�������
		pm=new PainterManager();
		cm=new ControlManager();
		mm=new MusicManager();
		
		//��ʼ��������Ϊ��½����
		kl=new LoginControler(this);
		addKeyListener(kl);
		
		//��ʼ����ͼ��Ϊ��½����
		pr=new LoginPainter(this);
		
		//��ʼ�����ֲ�����Ϊ��½����
		mp=new MusicPlayer("0");
		
		//���ص�½ѡ��
		lm=new Login(this);
		

		//��ʼ������Ϊ��½����
		scene=0;
		

		

	}
	
	//�߼�����
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

	//˫�����ͼ
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
	
	//���߳�
	public void run() {
		long t1,t2,dt,sleepTime;
		long period=1000/GameFrame.FPS;
		t1=System.nanoTime();
		
		while(true){
			//ִ����Ϸѭ��
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
			

			
			
			//�ȵ�֡��
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
