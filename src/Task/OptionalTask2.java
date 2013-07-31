package Task;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import animation.promptanimation;

import Controler.MainControler;
import Item.RPfruit;
import Main.GamePanel;

public class OptionalTask2 {

	public GamePanel gp;
	
	//�Ƿ��ڽ���
	public boolean going;
	
	//����
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask2(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//���������ʾ
	public String getintroduction() {
		String temp=null;
        if(level==0&&gp.pl.mt.level==100){
        	temp="��˵����ͬѧ����������Ʋ��ֵģ�ȥ�����۾۰ɣ���Ӧ����ʳ�á�";
        }
        if(level==55&&gp.pl.mt.level==100){
        	temp="��Ȼ����Ҫ����ͬѧһ�ѣ���ȥ�Һ�С��ɣ���Ӧ������ϵ��Ҷܰ��";
        }
        if(level==96&&gp.pl.mt.level==100){
        	temp="��ȥ������˵�����ס�";
        }
		return temp;

	}

	//�Ƿ�ɴ����Ի�
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			if(gp.pl.mt.level==100&&gp.pl.scene==33&&gp.pl.locX==14&&gp.pl.locY==18&&gp.pl.direction==MainControler.UP){
				temp=true;
				gp.map.npcs.get(2).direction=MainControler.DOWN;
			}
			break;
		case 55:
			if(gp.pl.mt.level==100&&gp.pl.scene==13&&gp.pl.mt.level==100&&((gp.pl.direction==MainControler.RIGHT&&gp.pl.locX==18&&gp.pl.locY==20)||(gp.pl.direction==MainControler.LEFT&&gp.pl.locX==20&&gp.pl.locY==20))){
				temp=true;

				gp.pl.roles.get(5).headtoplayer();
			}
			break;
		case 96:
			if(gp.pl.mt.level==100&&gp.pl.scene==33&&gp.pl.locX==14&&gp.pl.locY==18&&gp.pl.direction==MainControler.UP){
				temp=true;
				gp.map.npcs.get(2).direction=MainControler.DOWN;
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
			gp.scene=202;
		}
	}
	
	//���鷢չ
	public void next(){
		switch(level){
		case 2:
			gp.scene=118;
			gp.map.npcs.get(2).direction=MainControler.RIGHT;
			break;
		case 40:
			gp.scene=119;
			break;
		case 48:
			gp.scene=120;
			break;
		case 54:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 95:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 124:
			gp.pa=new promptanimation(gp,"�����Ʒ��ʵ");
			gp.pl.Bag.add(new RPfruit(gp,gp.pl.Bag.size()));
			break;
		case 127:
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
		if(gp.scene==202){
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
			BufferedReader reader = new BufferedReader(new FileReader("script/task/OptionalTask2.txt"));	
			
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
