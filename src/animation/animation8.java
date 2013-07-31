package animation;

import java.awt.Color;
import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation8 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=200;
	//总帧数
	public static final int num=50;
	
	
	private String s;
	private String ss;
	private String sss;
	private int x;
	private int i1;
	private int t1;
	private int i2;
	private int t2;
	private int i3;
	private int t3;

	
	public animation8(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        
        s="zZZ.....";
        ss="第二天，秦舢开始了大学生活的第一天。";
        sss="与此同时..";
		x=30;
		i1=0;
		t1=1;
		i2=0;
		t2=1;
		i3=0;
		t3=1;

        
	}
	
	public void drawnext(Graphics g){
		if(state<=10){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String s1=s.substring(0,t1);
			
			int k=s1.length()/x;
			for(i1=0;i1<=k;i1++){
				String temp=null;
				if(i1!=k){
					temp=s1.substring(i1*x,(i1+1)*x);
				}else{
					temp=s1.substring(i1*x,s1.length());
				}
				if(i1==k&&t1!=s.length()){
					g.drawString(temp+"_",100,100+30*i1);
				}else{
					g.drawString(temp,100,100+30*i1);
				}
			
				
			}

			if(t1<s.length()){
				t1++;
			}

		}
		
		if(state>10&&state<=20){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String s1=ss.substring(0,t2);
			
			int k=s1.length()/x;
			for(i2=0;i2<=k;i2++){
				String temp=null;
				if(i2!=k){
					temp=s1.substring(i2*x,(i2+1)*x);
				}else{
					temp=s1.substring(i2*x,s1.length());
				}
				if(i2==k&&t2!=ss.length()){
					g.drawString(temp+"_",100,100+30*i2);
				}else{
					g.drawString(temp,100,100+30*i2);
				}
			
				
			}

			if(t2<ss.length()){
				t2++;
			}

		}
		
		if(state>20&&state<=30){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String s1=sss.substring(0,t3);
			
			int k=s1.length()/x;
			for(i3=0;i3<=k;i3++){
				String temp=null;
				if(i3!=k){
					temp=s1.substring(i3*x,(i3+1)*x);
				}else{
					temp=s1.substring(i3*x,s1.length());
				}
				if(i3==k&&t3!=sss.length()){
					g.drawString(temp+"_",100,100+30*i3);
				}else{
					g.drawString(temp,100,100+30*i3);
				}
			
				
			}

			if(t3<sss.length()){
				t3++;
			}

		}
		if(state>30){
			if(gp.map!=null){
				gp.map.draw(g);
			}
			
			if(gp.pl!=null){
				gp.pl.draw(g);
			}
		
		}
		
 

		if(go){
			count++;
			if(count==time*GameFrame.FPS/1000){
				if(state!=num-1){
					switch(state){
					case 30:
						gp.pl.exist=false;
				        gp.pl.scene=10;
				        gp.pl.locX=72;
				        gp.pl.locY=92;
				        gp.map=new Map(gp);
				        
				        gp.pl.roles.get(5).scene=10;
				        gp.pl.roles.get(5).locX=62;
				        gp.pl.roles.get(5).locY=90;
				        
				        gp.pl.roles.get(6).scene=10;
				        gp.pl.roles.get(6).locX=60;
				        gp.pl.roles.get(6).locY=90;
				        
				        gp.pl.roles.get(7).scene=10;
				        gp.pl.roles.get(7).locX=77;
				        gp.pl.roles.get(7).locY=86;
				        gp.pl.roles.get(7).direction=MainControler.UP;
				        break;
					case 31:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 32:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 33:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 34:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 35:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 36:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 37:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 38:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 39:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 40:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 41:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 42:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 43:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 44:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 45:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 48:
						gp.pl.roles.get(5).direction=MainControler.LEFT;
						gp.pl.roles.get(5).isMoving=false;
						gp.pl.roles.get(6).isMoving=false;
						break;
					}
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

		gp.scene=200;


	}
	

}