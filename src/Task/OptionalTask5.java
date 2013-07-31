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

public class OptionalTask5 {

	public GamePanel gp;
	
	//�Ƿ��ڽ���
	public boolean going;
	
	//����
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask5(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//���������ʾ
	public String getintroduction() {
		String temp=null;
		if(gp.pl.mt.level>=261&&level==0){
	        temp="��˵����ʦ��һ���칫�ҵ���ʦ������ܲ��á�";
	    }
		if(gp.pl.mt.level>=261&&level==18){
	        temp="ȥͼ��ݰ����ղ������µ���ǿ����������ʦ�۴��á�";
	    }
		return temp;

	}

	//�Ƿ�ɴ����Ի�
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			if(gp.pl.mt.level>=261&&((gp.pl.scene==17&&gp.pl.locX==24&&gp.pl.locY==15&&gp.pl.direction==MainControler.LEFT)||(gp.pl.scene==17&&gp.pl.locX==23&&gp.pl.locY==16&&gp.pl.direction==MainControler.UP))){
				temp=true;
				gp.pl.roles.get(9).headtoplayer();
			}
			break;
		case 18:
			if(gp.pl.mt.level>=261&&gp.pl.scene==24&&gp.pl.locX==18&&gp.pl.locY==40&&gp.pl.direction==MainControler.LEFT){
				temp=true;
				gp.pl.roles.get(11).headtoplayer();
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
			gp.scene=205;
		}
	}
	
	//���鷢չ
	public void next(){
		switch(level){
		case 17:
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			going=false;
			break;	
		case 24:
			gp.pl.roles.get(11).headtoplayer();
			break;
		case 31:
//			gp.pl.introducer=new Introducer(gp,true,true,true,false,3,11);
//			gp.pl.updater=new FighterUpdater(gp);
//			gp.scene=80;
//			gp.pa=new promptanimation(gp,"����ս��");
			break;
		case 33:
			gp.scene=134;
			break;
		case 48:
			gp.pl.roles.get(11).disappear();
			break;
		case 72:
			going=false;
			gp.scene=gp.pl.scene;
			
			gp.pl.Bag.add(new IQfruit(gp,gp.pl.Bag.size()));
			gp.pl.Money+=50;
			gp.pa=new promptanimation(gp,"��ý������̹�ʵ�ͽ�Ǯ����");
			break;
			
		}
		level++;
	}

	//�������
    public void draw(Graphics g){
	
		
		//�Ի�	
		if(gp.scene==205){
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
			BufferedReader reader = new BufferedReader(new FileReader("script/task/OptionalTask5.txt"));	
			
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
