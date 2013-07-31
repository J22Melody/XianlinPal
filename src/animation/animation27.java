package animation;

import java.awt.Color;
import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation27 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;
	
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private int x;
	private int i;
	private int t1;
	private int t2;
	private int t3;
	private int t4;

	
	//ÿ֡����ʱ��
	public static final int time=300;
	//��֡��
	public static final int num=65;
	
	public animation27(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;

		s1="�о������գ���ɽ֮�����Ǹ�һ���䡣";
		s2="ʱ����ţ�������ѧ����ĵ�һ��ѧ��ת�۱��ȥ�ˡ�";
	    s3="�����������������������죬ո�µ�һ�ж��ոտ�ʼ��";
	    s4="������ѧ�ĵڶ���ѧ�ڡ���ʦ���칫�ҡ�";
		x=30;
		i=0;
		t1=1;
		t2=1;
		t3=1;
		t4=1;
	}
	
	public void drawnext(Graphics g){
		g.fillRect(0, 0, 800, 480);
		g.setColor(Color.WHITE);
		
		
		if(state<15){
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
		
		if(state>=15&&state<30){
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
		
		if(state>=30&&state<45){
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
		
		
		if(state>=45){
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

		gp.pl.scene=17;
		gp.pl.exist=false;
		gp.pl.locX=22;
		gp.pl.locY=14;
		
		gp.pl.roles.get(8).direction=MainControler.LEFT;
				
		gp.pl.roles.get(7).direction=MainControler.RIGHT;
		gp.pl.roles.get(7).scene=17;
		gp.pl.roles.get(7).locX=19;
		gp.pl.roles.get(7).locY=15;
		
		gp.map=new Map(gp);
		
		
		gp.scene=200;

	}
	

}