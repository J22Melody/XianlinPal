package animation;

import java.awt.Color;
import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation21 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=300;
	//总帧数
	public static final int num=120;
	
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String s5;
	private String s6;
	private String s7;
	private String s8;
	private String s9;
	private int x;
	private int i;
	private int t1;
	private int t2;
	private int t3;
	private int t4;
	private int t5;
	private int t6;
	private int t7;
	private int t8;
	private int t9;
	
	public animation21(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        
        s1="于是老师刘继续说着这次考试的情况。";
        s2="女生们的注意力早就转到了这位新来的助教身上。";
        s3="杨枳似乎有点心神不宁。";
        s4="不过这些好像都不是重点。";
        s5="至此猪脚们开始了他们的大学生活。";
        s6="一切都像流水般平静淌开，不知不觉已是三个月后。";
        s7="又是一个月黑风高的夜晚。";
        s8="舍友们有的学术，有的把妹，有的去HIGH，各干各的事去了。";
        s9="只剩下学不进去，玩不开心的秦舢，独自一人在宿舍习惯性的打开了电脑，打开了11对战平台 。。。";
		x=30;
		i=0;
		t1=1;
		t2=1;
		t3=1;
		t4=1;
		t5=1;
		t6=1;
		t7=1;
		t8=1;
		t9=1;



        
	}
	
	public void drawnext(Graphics g){
		
		if(state<=20){
			if(gp.map!=null){
				gp.map.draw(g);
			}
			
			if(gp.pl!=null){
				gp.pl.draw(g);
			}
		}
		
		if(state>20&&state<=30){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s1.substring(0,t1);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t1!=s1.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t1<s1.length()){
				t1++;
			}
			
		}
		
		if(state>30&&state<=40){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s2.substring(0,t2);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t2!=s2.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t2<s2.length()){
				t2++;
			}
			
		}
		
		if(state>40&&state<=50){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s3.substring(0,t3);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t3!=s3.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t3<s3.length()){
				t3++;
			}
		}
		
		if(state>50&&state<=60){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s4.substring(0,t4);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t4!=s4.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t4<s4.length()){
				t4++;
			}
			
		}
		
		if(state>60&&state<=70){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s5.substring(0,t5);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t5!=s5.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t5<s5.length()){
				t5++;
			}
			
		}
		
		if(state>70&&state<=80){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s6.substring(0,t6);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t6!=s6.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t6<s6.length()){
				t6++;
			}
			
		}
		
		if(state>80&&state<=90){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s7.substring(0,t7);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t7!=s7.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t7<s7.length()){
				t7++;
			}
			
		}
		
		if(state>90&&state<=100){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s8.substring(0,t8);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t8!=s8.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t8<s8.length()){
				t8++;
			}
		}
		
		if(state>100){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			String temps=s9.substring(0,t9);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t9!=s9.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t9<s9.length()){
				t9++;
			}
			
		}
	


		if(go){
			count++;
			if(count==time*GameFrame.FPS/1000){
				if(state!=num-1){
					switch(state){
					case 2:
						gp.pl.roles.get(9).down();
						break;
					case 4:
						gp.pl.roles.get(9).left();
						break;
					case 6:
						gp.pl.roles.get(9).left();
						break;
					case 8:
						gp.pl.roles.get(9).up();
						break;
					case 10:
						gp.pl.roles.get(9).left();
						break;
					case 12:
						gp.pl.roles.get(9).left();
						break;
					case 14:
						gp.pl.roles.get(9).left();
						break;
					case 16:
						gp.pl.roles.get(9).left();
						break;
					case 18:
						gp.pl.roles.get(9).disappear();
						break;
					case 21:
						gp.pl.roles.get(7).disappear();
						gp.pl.roles.get(6).disappear();
						gp.pl.roles.get(5).disappear();
						gp.pl.roles.get(8).disappear();
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

		gp.pl.scene=11;
		gp.pl.direction=MainControler.LEFT;
        gp.pl.locX=23;
        gp.pl.locY=22;
		gp.map=new Map(gp);
		gp.pl.roles.get(2).disappear();
		gp.pl.roles.get(3).disappear();
		gp.pl.roles.get(4).disappear();
		
		gp.scene=200;


	}
	

}