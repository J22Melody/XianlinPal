package animation;

import java.awt.Color;
import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation19 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=200;
	//总帧数
	public static final int num=18;
	
	private String s;
	private int x;
	private int i;
	private int t;

	
	public animation19(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;



        s="于是秦舢跟着老师刘来到教室。。。";
		x=30;
		i=0;
		t=1;
        
	}
	
	public void drawnext(Graphics g){

		g.fillRect(0, 0, 800, 480);
		g.setColor(Color.WHITE);
        String temps=s.substring(0,t);
		
		int k=temps.length()/x;
		for(i=0;i<=k;i++){
			String temp=null;
			if(i!=k){
				temp=temps.substring(i*x,(i+1)*x);
			}else{
				temp=temps.substring(i*x,temps.length());
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

		gp.pl.scene=13;
		gp.pl.locX=21;
		gp.pl.locY=20;
		gp.pl.direction=MainControler.UP;
		
		gp.pl.roles.get(9).disappear();
		gp.pl.roles.get(8).disappear();
		gp.pl.roles.get(8).scene=13;
		gp.pl.roles.get(8).locX=21;
		gp.pl.roles.get(8).locY=14;
		gp.pl.roles.get(8).direction=MainControler.DOWN;
		
		gp.map=new Map(gp);
		
		
		
		gp.scene=200;


	}
	

}