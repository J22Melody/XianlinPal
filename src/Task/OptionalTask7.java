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
	
	//是否在进行
	public boolean going;
	
	//进度
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	
	
	public OptionalTask7(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//获得任务提示
	public String getintroduction() {
		String temp=null;
		if(gp.pl.mt.level>=261&&level==0){
	        temp="宿舍门口总有猫出没。";
	    }
		
		if(gp.pl.mt.level>=261&&level==24){
	        temp="去和逸夫楼的领导说说动物的事。";
	    }
        
		return temp;

	}

	//是否可触发对话
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
	
	//触发
	public void update(){
		if(CanGo()){
			gp.pl.wholeads=1;
			gp.pl.isMoving=false;
			going=true;
			gp.scene=207;
		}
	}
	
	//剧情发展
	public void next(){
		switch(level){
		case 7:
			gp.pl.introducer=new Introducer(gp,true,true,true,false,3,12);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 23:
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;	
		case 32:
			going=false;
			gp.scene=gp.pl.scene;
			
			gp.pl.Bag.add(new RPfruit(gp,gp.pl.Bag.size()));
			gp.pl.Money+=50;
			gp.pa=new promptanimation(gp,"获得奖励人品果实和金钱若干");
			break;
		}
		level++;
	}

	//剧情绘制
	public void draw(Graphics g){
	
		
		//对话	
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
