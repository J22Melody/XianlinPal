package animation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class jumpanimation extends animation{

	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;
	
	//��ʾ��
	public ArrayList<String> words;
	public String word;

	
	//ÿ֡����ʱ��
	public static final int time=300;
	//��֡��
	public static final int num=10;
	
	public jumpanimation(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        
        words=new ArrayList<String>();
        
        words.add("���ͻ��һ������ʱ����CTRL�����л����������ˡ�");
        words.add("���ע֧��������Щ���ڲ���ľ���ܿ������������������ԵĹؼ���");
        words.add("��ϧÿһ�죬��������ѧϰ����˯�����������¡�");
        words.add("ѧУ�������Ըɸ������飬Ҫ��ȫ������Լ������ʾͶ�����һ�°ɡ�");
        words.add("û�¾���ʵ����ѧУ����ţ�����У�������ܡ�");
        
        word=words.get((int)(Math.random()*words.size()));

	
        
		gp.map=new Map(gp);

	
	}
	
	public void drawnext(Graphics g){
		
		g.drawImage(Method.ImageReader.work("jump/"+gp.pl.scene),0,0,null);
     	g.drawImage(Method.ImageReader.work("animation/Loading"),0,0,null);
     	g.setFont(new Font("����",Font.BOLD,14));
     	g.setColor(Color.WHITE);
     	g.drawImage(Method.ImageReader.work("jump/prompt"),0,-25,null);
        g.drawString(word,30+(750-14*word.length())/2,443);

		if(go){
			count++;
			if(count==time*GameFrame.FPS/1000){
				if(state!=num-1){
					state++;
				}else{
					stop();
				}
				count=0;
			}
			
			
		}
	
	}
	
	
	public void play(){
		go=true;
		
	}
	
	public void stop(){
		go=false;

		gp.scene=gp.pl.scene;

		
		//�������
		if(gp.pl.mt.level==69){
			gp.pl.mt.update();
			gp.pl.direction=MainControler.RIGHT;
		}
		
		if(gp.pl.mt.level==319){
			gp.scene=139;
		}
		
		if(gp.scene==32&&gp.pl.mt.level==346){
			gp.scene=200;
			gp.pl.direction=MainControler.UP;
			
			gp.pl.roles.get(7).direction=MainControler.DOWN;
			gp.pl.roles.get(7).locX=34;
			gp.pl.roles.get(7).locY=17;
			gp.pl.roles.get(7).scene=32;
			
			gp.pl.roles.get(5).direction=MainControler.UP;
			gp.pl.roles.get(5).locX=33;
			gp.pl.roles.get(5).locY=18;
			gp.pl.roles.get(5).scene=32;
			
			gp.pl.roles.get(6).direction=MainControler.UP;
			gp.pl.roles.get(6).locX=33;
			gp.pl.roles.get(6).locY=19;
			gp.pl.roles.get(6).scene=32;
		}
		
		if(gp.scene==16&&gp.pl.mt.level==496){
			gp.pl.direction=MainControler.LEFT;
			gp.scene=200;
		}

	}
	

}
