package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Controler.MainControler;

public class NPC {
	private static final int sizeX =32;

	private static final int sizeY =48;

	public GamePanel gp;
	
	public ArrayList<Dialog> dialog; 
	public String name;
	public int locX;
	public int locY;
	public boolean istalking;
	public int state;

	//当前方向
	public int direction;
	//默认方向
	public int Direction;


	
	public NPC(GamePanel Gp){
		gp=Gp;
		dialog=new ArrayList<Dialog>();
		istalking=false;
		state=0;
		
	
	}
	
	public void nextdialog(){
		if(state<dialog.size()-1){
			state++;
		}else{
			enddialog();
		}
	}
	
	public void enddialog(){
		state=0;
		for(int i=0;i<dialog.size();i++){
			dialog.get(i).state=0;
		}
		istalking=false;
		gp.pl.talkwith=-1;
		gp.scene=gp.pl.scene;
		direction=Direction;
	}

	public void draw(Graphics g) {
		
		
		g.drawImage(Method.ImageReader.work("NPC/"+name),locX*Map.sizeX+gp.map.offsetX,locY*Map.sizeY+gp.map.offsetY-16,locX*Map.sizeX+gp.map.offsetX+sizeX,locY*Map.sizeY+gp.map.offsetY-16+sizeY,0,direction*sizeY,sizeX,direction*sizeY+sizeY,null);	
	}

	public void drawdialog(Graphics g) {

		
		if(istalking){
			headtoplayer();
			

			g.drawImage(Method.ImageReader.work("menu/talk"),100,330,null);
			
			String s=dialog.get(state).content;
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
			
			if(dialog.get(state).canChoose){
				for(int j=0;j<dialog.get(state).event.size();j++){ 
					if(j==dialog.get(state).state){
						g.setColor(Color.YELLOW);
					}
					g.drawString(dialog.get(state).event.get(j).word,220,390+20*i+20*j);
					g.setColor(Color.BLACK);
				}
			}
		}
	}

	private void headtoplayer() {
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

}
