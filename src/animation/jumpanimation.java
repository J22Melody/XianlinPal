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

	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;
	
	//提示语
	public ArrayList<String> words;
	public String word;

	
	//每帧持续时间
	public static final int time=300;
	//总帧数
	public static final int num=10;
	
	public jumpanimation(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        
        words=new ArrayList<String>();
        
        words.add("当和伙伴一起行走时，按CTRL可以切换带领队伍的人。");
        words.add("多关注支线任务，这些过期不候的剧情很可能是你提升人物属性的关键。");
        words.add("珍惜每一天，还有力气学习就少睡觉，多做点事。");
        words.add("学校各处可以干各种事情，要想全面提高自己的素质就都体验一下吧。");
        words.add("没事就老实点在学校里呆着，别往校门外面跑。");
        
        word=words.get((int)(Math.random()*words.size()));

	
        
		gp.map=new Map(gp);

	
	}
	
	public void drawnext(Graphics g){
		
		g.drawImage(Method.ImageReader.work("jump/"+gp.pl.scene),0,0,null);
     	g.drawImage(Method.ImageReader.work("animation/Loading"),0,0,null);
     	g.setFont(new Font("宋体",Font.BOLD,14));
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

		
		//剧情添加
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
