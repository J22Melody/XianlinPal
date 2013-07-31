package animation;

import java.awt.Color;
import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation9 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=200;
	//总帧数
	public static final int num=30;
	
	private String s;
	private int x;
	private int i;
	private int t;
	
	public animation9(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        
        s="何小婉和杨枳匆匆赶到了仙一教学楼...";
		x=30;
		i=0;
		t=1;

        
	}
	
	public void drawnext(Graphics g){
		
		if(state>15&&state<=29){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
	
			String s1=s.substring(0,t);
			
			int k=s1.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=s1.substring(i*x,(i+1)*x);
				}else{
					temp=s1.substring(i*x,s1.length());
				}
				if(i==k&&t!=s.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t<s.length()){
				t++;
			}
		}

		if(state<=15){
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
					case 0:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 1:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 2:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 3:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 4:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 5:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 6:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 7:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 8:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 9:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
						break;
					case 10:
						gp.pl.roles.get(5).right();
						gp.pl.roles.get(6).right();
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

		gp.pl.roles.get(5).disappear();
		gp.pl.roles.get(6).disappear();
		gp.pl.roles.get(7).disappear();
		
        gp.pl.scene=13;
        gp.pl.locX=21;
        gp.pl.locY=18;
        gp.map=new Map(gp);
        
        gp.pl.roles.get(5).scene=13;
        gp.pl.roles.get(5).locX=19;
        gp.pl.roles.get(5).locY=20;
        gp.pl.roles.get(5).direction=MainControler.UP;
        
        gp.pl.roles.get(6).scene=13;
        gp.pl.roles.get(6).locX=17;
        gp.pl.roles.get(6).locY=20;
        gp.pl.roles.get(6).direction=MainControler.UP;
     
        gp.pl.roles.get(8).scene=13;
        gp.pl.roles.get(8).locX=21;
        gp.pl.roles.get(8).locY=14;
        gp.pl.roles.get(8).direction=MainControler.DOWN;
        
		gp.scene=200;


	}
	

}