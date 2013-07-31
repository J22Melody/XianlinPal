package Task;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import animation.promptanimation;

import Controler.MainControler;
import Item.diary;
import Main.GamePanel;

public class OptionalTask4 {

	public GamePanel gp;
	
	//是否在进行
	public boolean going;
	
	//进度
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask4(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//获得任务提示
	public String getintroduction() {
		String temp=null;
		if(gp.pl.mt.level==261&&level==0){
	        temp="欧阳歆时常一个人在湖边。";
	    }
		if(gp.pl.mt.level==261&&level==37){
	        temp="做错了事就要弥补，那样东西看上去对欧阳歆很重要，一定要找回来，应该就在这片水里。";
	    }
		if(gp.pl.mt.level==261&&level==46){
	        temp="找到了叶子，快点去给欧阳歆吧，他平时应该呆在机房里。";
	    }
		return temp;

	}

	//是否可触发对话
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			if(gp.pl.mt.level==261&&gp.pl.locX==96&&gp.pl.locY==87&&gp.pl.scene==10&&gp.pl.direction==MainControler.UP){
				temp=true;
				gp.pl.roles.get(5).locX=95;
				gp.pl.roles.get(5).locY=87;
				gp.pl.roles.get(5).direction=MainControler.UP;
				gp.pl.roles.get(5).scene=10;
				gp.pl.roles.get(6).locX=97;
				gp.pl.roles.get(6).locY=87;
				gp.pl.roles.get(6).direction=MainControler.UP;
				gp.pl.roles.get(6).scene=10;
				
			}
			break;
		case 37:
			if(gp.pl.mt.level==261&&gp.pl.locX==101&&gp.pl.locY==83&&gp.pl.scene==10&&gp.pl.direction==MainControler.RIGHT){
				temp=true;
				gp.pl.roles.get(5).locX=100;
				gp.pl.roles.get(5).locY=83;
				gp.pl.roles.get(5).direction=MainControler.RIGHT;
				gp.pl.roles.get(5).scene=10;
				gp.pl.roles.get(6).locX=99;
				gp.pl.roles.get(6).locY=83;
				gp.pl.roles.get(6).direction=MainControler.RIGHT;
				gp.pl.roles.get(6).scene=10;
			}
			break;
		case 46:
			if(gp.pl.mt.level==261&&gp.pl.locX==20&&gp.pl.locY==28&&gp.pl.scene==16&&gp.pl.direction==MainControler.UP){
				temp=true;
				gp.pl.roles.get(5).locX=19;
				gp.pl.roles.get(5).locY=28;
				gp.pl.roles.get(5).direction=MainControler.UP;
				gp.pl.roles.get(5).scene=16;
				gp.pl.roles.get(6).locX=21;
				gp.pl.roles.get(6).locY=28;
				gp.pl.roles.get(6).direction=MainControler.UP;
				gp.pl.roles.get(6).scene=16;
				gp.pl.roles.get(6).direction=MainControler.UP;
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
			gp.scene=204;
		}
	}
	
	//剧情发展
	public void next(){
		switch(level){
		case 3:
			gp.pl.roles.get(7).direction=MainControler.DOWN;
			break;
		case 18:
			gp.scene=137;
			break;
		case 27:
			gp.pl.roles.get(7).disappear();
			break;
		case 36:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 45:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 67:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			going=false;
			gp.scene=gp.pl.scene;
			
			gp.pl.Bag.add(new diary(gp,gp.pl.Bag.size()));

			gp.pa=new promptanimation(gp,"获得日记本");
			break;
		}
		level++;
	}

	//剧情绘制
    public void draw(Graphics g){
	
		
		//对话	
		if(gp.scene==204){
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
			BufferedReader reader = new BufferedReader(new FileReader("script/task/OptionalTask4.txt"));	
			
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
