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
import Item.STfruit;
import Main.GamePanel;

public class OptionalTask6 {

	public GamePanel gp;
	
	//是否在进行
	public boolean going;
	
	//进度
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask6(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//获得任务提示
	public String getintroduction() {
		String temp=null;
		if(gp.pl.mt.level>=261&&level==0){
	        temp="环科楼的清洁阿姨最近好像有一些烦恼。";
	    }
		if(gp.pl.mt.level>=261&&level==13){
			temp="看看附近有没有阿姨所说的可恶的学生。";
		}
		if(gp.pl.mt.level>=261&&level==30){
			temp="去找校领导谈谈相关的事，他应该在逸夫楼。";
		}
		return temp;

	}

	//是否可触发对话
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			if(gp.pl.mt.level>=261&&gp.pl.scene==19&&((gp.pl.locX==26&&gp.pl.locY==12&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==27&&gp.pl.locY==13&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==28&&gp.pl.locY==12&&gp.pl.direction==MainControler.LEFT))){
				temp=true;
				gp.pl.wholeads=1;
			}
			break;
		case 13:
			if(gp.pl.mt.level>=261&&gp.pl.scene==19&&((gp.pl.locX==35&&gp.pl.locY==12&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==36&&gp.pl.locY==13&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==37&&gp.pl.locY==12&&gp.pl.direction==MainControler.LEFT))){
				temp=true;
				gp.pl.wholeads=1;
			}
			break;
		case 30:
			if(gp.pl.mt.level>=261&&gp.pl.scene==17&&((gp.pl.locX==27&&gp.pl.locY==13&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==28&&gp.pl.locY==14&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==29&&gp.pl.locY==13&&gp.pl.direction==MainControler.LEFT)||(gp.pl.locX==28&&gp.pl.locY==12&&gp.pl.direction==MainControler.DOWN))){
				temp=true;
				gp.pl.wholeads=1;
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
			gp.scene=206;
		}
	}
	
	//剧情发展
	public void next(){
		switch(level){
		case 12:
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;	
		case 23:
			gp.pl.introducer=new Introducer(gp,true,true,true,false,3,11);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 29:
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;	
		case 51:
			going=false;
			gp.scene=gp.pl.scene;
			
			gp.pl.Bag.add(new STfruit(gp,gp.pl.Bag.size()));
			gp.pl.Money+=50;
			gp.pa=new promptanimation(gp,"获得奖励体质果实和金钱若干");
			break;
		}
		
		level++;
	}

	//剧情绘制
	public void draw(Graphics g){
	
		
		//对话	
		if(gp.scene==206){
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
			BufferedReader reader = new BufferedReader(new FileReader("script/task/OptionalTask6.txt"));	
			
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
