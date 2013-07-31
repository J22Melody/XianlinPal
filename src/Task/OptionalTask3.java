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
	
	//是否在进行
	public boolean going;
	
	//进度
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask3(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//获得任务提示
	public String getintroduction() {
		String temp=null;
        if(gp.pl.mt.level==100&&level==0){
        	temp="听杨枳说，何小婉和她最近都为一件事很抓狂。";
        }
        if(gp.pl.mt.level==100&&level==28){
        	temp="为了帮何小婉渡过微积分难关，去图书馆跑一趟吧。";
        }
        if(gp.pl.mt.level==100&&level==42){
        	temp="管理员不给力，无奈之后在书架一本一本地找吧(按space），就当试试运气。";
        }
        if(gp.pl.mt.level==100&&level==53){
        	temp="问管理员借词典，这总该有。";
        }
        if(gp.pl.mt.level==100&&level==58){
        	temp="去右边的书架上看看。";
        }
        if(gp.pl.mt.level==100&&level==64){
        	temp="大功告成，把书给何小婉。";
        }
		return temp;

	}

	//是否可触发对话
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
	
	//触发
	public void update(){
		if(CanGo()){
			gp.pl.wholeads=1;
			gp.pl.isMoving=false;
			going=true;
			gp.scene=203;
		}
	}
	
	//剧情发展
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
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 41:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 52:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 57:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 59:
			gp.scene=117;
			break;
		case 62:
			gp.pl.Bag.add(new IQfruit(gp,gp.pl.Bag.size()));
			gp.pl.GPA+=10;
			gp.pa=new promptanimation(gp,"获得奖励智慧果实、GPA上升");
			break;
		case 63:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
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
			gp.pa=new promptanimation(gp,"任务达成");
			break;
		}
		level++;
	}

	//剧情绘制
    public void draw(Graphics g){
	
		
		//对话	
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
			
			//改变控制状态
			if(count!=0){
				if(count==4){
					count=0;
				}else{
					count++;
				}
			}
		}
	}
	
	//获取所有对话
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
