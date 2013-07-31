package animation;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation2 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间
	public static final int time=200;
	//总帧数
	public static final int num=40;
	
	private String s;
	private int x;
	private int i;
	private int t;
	
	public animation2(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        
        s="/*这是一个平凡的故事。" +
        		"有时候，最美好的或许就是在平常到无人知晓的黄昏里，树梢上婉转的低语。" +
        		"你我都曾、或正在经历。*/";
		x=20;
		i=0;
		t=1;

	}
	
	public void drawnext(Graphics g){
		g.fillRect(0, 0, 800, 480);
		g.setColor(Color.WHITE);
	
		g.drawString("写在前面：", 100,100);
		
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
				g.drawString(temp+"_",100,150+30*i);
			}else{
				g.drawString(temp,100,150+30*i);
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

		gp.scene=105;

	}
	

}