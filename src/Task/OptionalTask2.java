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
	
	//是否在进行
	public boolean going;
	
	//进度
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask2(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//获得任务提示
	public String getintroduction() {
		String temp=null;
        if(level==0&&gp.pl.mt.level==100){
        	temp="听说高中同学吴磊最近闷闷不乐的，去和他聚聚吧，他应该在食堂。";
        }
        if(level==55&&gp.pl.mt.level==100){
        	temp="既然决定要帮老同学一把，那去找何小婉吧，她应该能联系到叶馨。";
        }
        if(level==96&&gp.pl.mt.level==100){
        	temp="回去找吴磊说个明白。";
        }
		return temp;

	}

	//是否可触发对话
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
	
	//触发
	public void update(){
		if(CanGo()){
			gp.pl.wholeads=1;
			gp.pl.isMoving=false;
			going=true;
			gp.scene=202;
		}
	}
	
	//剧情发展
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
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 95:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 124:
			gp.pa=new promptanimation(gp,"获得人品果实");
			gp.pl.Bag.add(new RPfruit(gp,gp.pl.Bag.size()));
			break;
		case 127:
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
