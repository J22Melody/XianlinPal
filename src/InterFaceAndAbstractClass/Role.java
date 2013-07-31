package InterFaceAndAbstractClass;

import java.awt.Graphics;
import java.util.ArrayList;

import Controler.MainControler;
import Main.GamePanel;
import Main.Map;

public abstract class Role {
	public static final int sizeX=32;
	public static final int sizeY=48;
	public boolean istalking;
	
	public GamePanel gp;
	
	public String name;
	public int scene;
	public int locX;
	public int locY;
	public int direction;
	public int count;
	public boolean isMoving;
	
	public int temp;
	
	//非剧情对话
	public ArrayList<String> returnwords;
	public int state;
	

	
	
	public Role(GamePanel Gp){
		gp=Gp;
		isMoving=false;
		istalking=false;
		state=0;
		returnwords=new ArrayList<String>();
		scene=9999;
		
		getwords();
	}
	
	//人物形象绘制
	public void draw(Graphics g){
		if(scene==gp.pl.scene){
			g.drawImage(Method.ImageReader.work("Role/"+name),locX*Map.sizeX+gp.map.offsetX,locY*Map.sizeY+gp.map.offsetY-16,locX*Map.sizeX+gp.map.offsetX+sizeX,locY*Map.sizeY+gp.map.offsetY-16+sizeY,count*sizeX,direction*sizeY,count*sizeX+sizeX,direction*sizeY+sizeY,null);	
		}
	}

	public void update() {
		if(isMoving){
			if(count!=3){
				count++;
			}else{
				count=0;
			}

			//还原原本地点的碰撞检测
			gp.map.map0[locY][locX]=0;
			
			switch (direction) {
			case 0:
				locY+=1;
				isMoving=false;	
				break;
			case 1:
				locX-=1;
				isMoving=false;	
				break;
			case 2:
				locX+=1;
				isMoving=false;
				break;
			case 3:
				locY-=1;
				isMoving=false;	
				break;
			}
		
		}else{
			if(count==0&&count==1){count=0;}
			if(count==2&&count==3){count=2;}
		}
		





		
		if(istalking){
			headtoplayer();		
		}
		
	}

	public void headtoplayer() {
		switch(gp.pl.direction){
		case MainControler.UP:
			direction=MainControler.DOWN;
			break;
		case MainControler.DOWN:
			direction=MainControler.UP;
			break;
		case MainControler.LEFT:
			direction=MainControler.RIGHT;
			break;
		case MainControler.RIGHT:
			direction=MainControler.LEFT;
			break;
		}
	}

	public void up() {
		direction=MainControler.UP;
		isMoving=true;
	}
	
    public void down() {
    	direction=MainControler.DOWN;
    	isMoving=true;
	}
    
    public void left() {
    	direction=MainControler.LEFT;
    	isMoving=true;
	}
    
    public void right() {
    	direction=MainControler.RIGHT;
    	isMoving=true;
	}

    //下一句返回对话
	public void nextwords() {
		if(state<returnwords.size()-1){
			state++;
		}else{
			istalking=false;
			state=0;
			gp.pl.talkwith=-1;
			gp.scene=gp.pl.scene;
			direction=temp;
		}
		
	}

	//绘制返回对话
	public void drawdialog(Graphics g) {
		if(istalking){

			g.drawImage(Method.ImageReader.work("menu/talk"),100,330,null);
			
			String s=returnwords.get(state);
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
			
		}
	}
    
	//子类重写此方法获得各种不同的对白
	public void getwords(){
		
	}

	public void disappear() {
		scene=9999;
		//还原原本地点的碰撞检测
		gp.map.map0[locY][locX]=0;
		
	}
 


}
