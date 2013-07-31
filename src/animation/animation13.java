package animation;

import java.awt.Color;
import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation13 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=200;
	//��֡��
	public static final int num=50;
	
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String s5;
	private int x;
	private int i;
	private int t1;
	private int t2;
	private int t3;
	private int t4;
	private int t5;

	
	public animation13(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        
        s1="��ʦ����Ȼ��֪ƣ���balabala�š�����";
        s2="�������Ҳû�����������ͺ�С��Ĺ�ϵ��";
        s3="���ǵ�һ���Ͽξ���ôƽ������ؽ����ˡ�";
        s4="Ȼ������������˵���ڶ���һ����ʹ�ࡣ";
        s5="�ڶ��졣����";
		x=30;
		i=0;
		t1=1;
		t2=1;
		t3=1;
		t4=1;
		t5=1;

        
	}
	
	public void drawnext(Graphics g){
		
		if(gp.map!=null){
			gp.map.draw(g);
		}
		
		if(gp.pl!=null){
			gp.pl.draw(g);
		}

		if(state<=10){
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
		
		if(state>10&&state<=20){
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
		
		if(state>20&&state<=30){
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
		
		if(state>30&&state<=40){
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
		
		if(state>40){
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
		gp.pl.roles.get(8).disappear();
		
		gp.pl.direction=MainControler.DOWN;
        gp.pl.scene=11;
        gp.pl.locX=20;
        gp.pl.locY=21;	
        gp.map=new Map(gp);
        
        gp.scene=200;
    	go=false;
		


	}
	

}