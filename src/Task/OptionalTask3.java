package Task;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import animation.promptanimation;

import Controler.MainControler;
import Item.IQfruit;
import Main.GamePanel;

public class OptionalTask3 {

	public GamePanel gp;
	
	//�Ƿ��ڽ���
	public boolean going;
	
	//����
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask3(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//���������ʾ
	public String getintroduction() {
		String temp=null;
        if(gp.pl.mt.level==100&&level==0){
        	temp="������˵����С����������Ϊһ���º�ץ��";
        }
        if(gp.pl.mt.level==100&&level==28){
        	temp="Ϊ�˰��С��ɹ�΢�����ѹأ�ȥͼ�����һ�˰ɡ�";
        }
        if(gp.pl.mt.level==100&&level==42){
        	temp="����Ա������������֮�������һ��һ�����Ұ�(��space�����͵�����������";
        }
        if(gp.pl.mt.level==100&&level==53){
        	temp="�ʹ���Ա��ʵ䣬���ܸ��С�";
        }
        if(gp.pl.mt.level==100&&level==58){
        	temp="ȥ�ұߵ�����Ͽ�����";
        }
        if(gp.pl.mt.level==100&&level==64){
        	temp="�󹦸�ɣ��������С��";
        }
		return temp;

	}

	//�Ƿ�ɴ����Ի�
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			if(gp.pl.scene==13&&gp.pl.mt.level==100&&((gp.pl.direction==MainControler.RIGHT&&gp.pl.locX==18&&gp.pl.locY==20)||(gp.pl.direction==MainControler.LEFT&&gp.pl.locX==20&&gp.pl.locY==20))){
				temp=true;
				gp.pl.roles.get(5).headtoplayer();
			}
			break;
		case 28:
			if(gp.pl.mt.level==100&&gp.pl.scene==24&&((gp.pl.direction==MainControler.UP&&gp.pl.locX==25&&gp.pl.locY==52)||(gp.pl.direction==MainControler.LEFT&&gp.pl.locX==26&&gp.pl.locY==51)||(gp.pl.direction==MainControler.DOWN&&gp.pl.locX==25&&gp.pl.locY==50))){
				temp=true;
			}
			break;
		case 42:
			if(gp.pl.mt.level==100&&gp.pl.scene==24&&gp.pl.direction==MainControler.UP&&gp.pl.locX==33&&gp.pl.locY==12){
				temp=true;
			}
			break;
		case 53:
			if(gp.pl.mt.level==100&&gp.pl.scene==24&&((gp.pl.direction==MainControler.UP&&gp.pl.locX==25&&gp.pl.locY==52)||(gp.pl.direction==MainControler.LEFT&&gp.pl.locX==26&&gp.pl.locY==51)||(gp.pl.direction==MainControler.DOWN&&gp.pl.locX==25&&gp.pl.locY==50))){
				temp=true;
			}
			break;
		case 58:
			if(gp.pl.mt.level==100&&gp.pl.scene==24&&gp.pl.direction==MainControler.UP&&gp.pl.locX==28&&gp.pl.locY==50){
				temp=true;
			}
			break;
		case 64:
			if(gp.pl.mt.level==100&&gp.pl.scene==13&&gp.pl.mt.level==100&&((gp.pl.direction==MainControler.RIGHT&&gp.pl.locX==18&&gp.pl.locY==20)||(gp.pl.direction==MainControler.LEFT&&gp.pl.locX==20&&gp.pl.locY==20))){
				temp=true;
				gp.pl.roles.get(5).headtoplayer();
			}
			break;
		}
		return temp;	
	}
	
	//����
	public void update(){
		if(CanGo()){
			gp.pl.wholeads=1;
			gp.pl.isMoving=false;
			going=true;
			gp.scene=203;
		}
	}
	
	//���鷢չ
	public void next(){
		switch(level){
		case 1:
			gp.pl.roles.get(6).direction=MainControler.RIGHT;
			break;
		case 15:
			gp.scene=116;
			break;
		case 27:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 41:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 52:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 57:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 59:
			gp.scene=117;
			break;
		case 62:
			gp.pl.Bag.add(new IQfruit(gp,gp.pl.Bag.size()));
			gp.pl.GPA+=10;
			gp.pa=new promptanimation(gp,"��ý����ǻ۹�ʵ��GPA����");
			break;
		case 63:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 64:
			gp.pl.roles.get(6).direction=MainControler.RIGHT;
			break;
		case 65:
			gp.pl.direction=MainControler.LEFT;
			break;	
		case 73:
			gp.pl.direction=MainControler.RIGHT;
			break;
		case 74:
			gp.pl.direction=MainControler.LEFT;
			break;
		case 78:
			gp.pl.direction=MainControler.RIGHT;
			break;
		case 85:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"������");
			break;
		}
		level++;
	}

	//�������
    public void draw(Graphics g){
	
		
		//�Ի�	
		if(gp.scene==203){
			g.drawImage(Method.ImageReader.work("menu/talk"),100,330,null);
			
			String s=dialog.get(level);
			int x=33;
			int i=0;
			
			int k=s.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=s.substring(i*x,(i+1)*x);
				}else{
					temp=s.substring(i*x,s.length());
				}
				g.drawString(temp,200,390+20*i);
			}
			
			//�ı����״̬
			if(count!=0){
				if(count==4){
					count=0;
				}else{
					count++;
				}
			}
		}
	}
	
	//��ȡ���жԻ�
    public void getdialog() {
    	dialog=new ArrayList<String>();
	
    	try {
			BufferedReader reader = new BufferedReader(new FileReader("script/task/OptionalTask3.txt"));	
			
			while(true){
				String s = reader.readLine();
				if(s==null){
					break;
				}else{
					dialog.add(s);
				}
			}			
			
			reader.close();
			reader=null;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
