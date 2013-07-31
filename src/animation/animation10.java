package animation;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation10 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=200;
	//总帧数
	public static final int num=20;
	
	
	private String s;
	private int x;
	private int i;
	private int t;

	
	public animation10(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;

        gp.pl.scene=10;
        gp.pl.locX=62;
        gp.pl.locY=90;
        gp.pl.exist=true;
        gp.map=new Map(gp);
        
        s="此时的秦舢呢？";
		x=30;
		i=0;
		t=1;
        
	}
	
	public void drawnext(Graphics g){
		
		if(state<=10){
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

		if(state>10){
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
					case 11:
						gp.pl.right();				
						break;					
					case 14:
						gp.pl.isMoving=false;
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