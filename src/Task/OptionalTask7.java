package Task;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import animation.promptanimation;

import Controler.MainControler;
import FightSystem.FighterUpdater;
import FightSystem.Introducer;
import Item.RPfruit;
import Main.GamePanel;

public class OptionalTask7 {

	public GamePanel gp;
	
	//�Ƿ��ڽ���
	public boolean going;
	
	//����
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	
	
	public OptionalTask7(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//���������ʾ
	public String getintroduction() {
		String temp=null;
		if(gp.pl.mt.level>=261&&level==0){
	        temp="�����ſ�����è��û��";
	    }
		
		if(gp.pl.mt.level>=261&&level==24){
	        temp="ȥ���ݷ�¥���쵼˵˵������¡�";
	    }
        
		return temp;

	}

	//�Ƿ�ɴ����Ի�
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			if(gp.pl.mt.level>=261&&gp.pl.scene==10&&((gp.pl.locX==31&&gp.pl.locY==91&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==32&&gp.pl.locY==92&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==33&&gp.pl.locY==91&&gp.pl.direction==MainControler.LEFT)||(gp.pl.locX==32&&gp.pl.locY==90&&gp.pl.direction==MainControler.DOWN))){
				temp=true;
				gp.pl.wholeads=1;
			}
			break;
		case 24:
		    if(gp.pl.mt.level>=261&&gp.pl.scene==17&&((gp.pl.locX==27&&gp.pl.locY==13&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==28&&gp.pl.locY==14&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==29&&gp.pl.locY==13&&gp.pl.direction==MainControler.LEFT)||(gp.pl.locX==28&&gp.pl.locY==12&&gp.pl.direction==MainControler.DOWN))){
			    temp=true;
			    gp.pl.wholeads=1;
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
			gp.scene=207;
		}
	}
	
	//���鷢չ
	public void next(){
		switch(level){
		case 7:
			gp.pl.introducer=new Introducer(gp,true,true,true,false,3,12);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"����ս��");
			break;
		case 23:
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			going=false;
			break;	
		case 32:
			going=false;
			gp.scene=gp.pl.scene;
			
			gp.pl.Bag.add(new RPfruit(gp,gp.pl.Bag.size()));
			gp.pl.Money+=50;
			gp.pa=new promptanimation(gp,"��ý�����Ʒ��ʵ�ͽ�Ǯ����");
			break;
		}
		level++;
	}

	//�������
	public void draw(Graphics g){
	
		
		//�Ի�	
		if(gp.scene==207){
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
			BufferedReader reader = new BufferedReader(new FileReader("script/task/OptionalTask7.txt"));	
			
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
