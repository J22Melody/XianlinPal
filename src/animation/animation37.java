package animation;

import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation37 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;
	

	
	//每帧持续时间
	public static final int time=200;
	//总帧数
	public static final int num=10;
	
	public animation37(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;

	
	}
	
	public void drawnext(Graphics g){
		g.fillRect(0, 0, 800, 480);

		
		g.drawImage(Method.ImageReader.work("animation/attack"),0,0,null);
	


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

		gp.pl.exist=true;
		gp.pl.TeamNum=4;
		gp.pl.scene=18;
		gp.pl.direction=MainControler.RIGHT;
		gp.pl.locX=15;
		gp.pl.locY=10;
		
		gp.pl.roles.get(5).scene=18;
		gp.pl.roles.get(5).locX=16;
		gp.pl.roles.get(5).locY=10;
		gp.pl.roles.get(5).direction=MainControler.LEFT;
		
		gp.pl.roles.get(6).scene=18;
		gp.pl.roles.get(6).locX=16;
		gp.pl.roles.get(6).locY=9;
		gp.pl.roles.get(6).direction=MainControler.LEFT;
		
		gp.pl.roles.get(7).scene=18;
		gp.pl.roles.get(7).locX=16;
		gp.pl.roles.get(7).locY=11;
		gp.pl.roles.get(7).direction=MainControler.LEFT;
		
		gp.pl.roles.get(8).scene=18;
		gp.pl.roles.get(8).locX=16;
		gp.pl.roles.get(8).locY=12;
		gp.pl.roles.get(8).direction=MainControler.LEFT;
		
		gp.map=new Map(gp);
	
		gp.scene=200;

	}
	

}