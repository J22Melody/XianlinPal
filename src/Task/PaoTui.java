package Task;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import animation.promptanimation;

import Controler.MainControler;
import Main.GamePanel;

public class PaoTui {

	public GamePanel gp;
	
	//是否在进行
	public boolean going;
	
	//进度
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	
	public PaoTui(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//获得任务提示
	public String getintroduction() {
		String temp=null;
        if(level==8){
        	temp="平时多做好事攒攒RP总没错，快帮这位大哥把话带给他的朋友吧。她应该就在蓝鲸大学西北的校门附近。";
        }
		return temp;

	}

	//是否可触发对话
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			if(gp.pl.scene==10&&gp.pl.locX==106&&gp.pl.locY==87&&gp.pl.direction==MainControler.UP){
				temp=true;
			}
	        break;
		case 8:
			if(gp.pl.scene==10&&gp.pl.locX==25&&gp.pl.locY==44&&gp.pl.direction==MainControler.UP){
				temp=true;
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
			gp.scene=210;
		}
	}
	
	//剧情发展
	public void next(){
		switch(level){
		case 7:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 13:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pl.Money+=10;
			gp.pa=new promptanimation(gp,"获得10元RMB");
			level=-1;
			break;
		}
		level++;
	}

	//剧情绘制
    public void draw(Graphics g){
	
		
		//对话	
		if(going){
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
			BufferedReader reader = new BufferedReader(new FileReader("script/task/PaoTui.txt"));	
			
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
