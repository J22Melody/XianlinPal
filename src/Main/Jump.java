package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Jump {
	public GamePanel gp;
	
	public ArrayList<Dialog> dialog; 
	public String name;
	public int locX;
	public int locY;
	public boolean istalking;
	public int state;
	
	public int count;

	
	public Jump(GamePanel Gp){
		gp=Gp;
		dialog=new ArrayList<Dialog>();
		istalking=false;
		state=0;
		count=-2;
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
	}

	public void draw(Graphics g) {
		
		if(name.equals("leftarrows")){
			g.drawImage(Method.ImageReader.work("jump/"+name),locX*Map.sizeX+gp.map.offsetX+count,locY*Map.sizeY+gp.map.offsetY,null);
		}
		
		if(name.equals("rightarrows")){
			g.drawImage(Method.ImageReader.work("jump/"+name),locX*Map.sizeX+gp.map.offsetX-count,locY*Map.sizeY+gp.map.offsetY,null);
		}
		
		
		if(name.equals("uparrows")){
			g.drawImage(Method.ImageReader.work("jump/"+name),locX*Map.sizeX+gp.map.offsetX,locY*Map.sizeY+gp.map.offsetY+count,null);
		}
		
		if(name.equals("downarrows")){
			g.drawImage(Method.ImageReader.work("jump/"+name),locX*Map.sizeX+gp.map.offsetX,locY*Map.sizeY+gp.map.offsetY-count,null);
		}
		
		
		
		if(count!=2){
			count++;
		}else{
			count=-2;
		}
	
	}

	public void drawdialog(Graphics g) {
		if(istalking){
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
					g.drawString(dialog.get(state ).event.get(j).word,220,390+20*i+20*j);
					g.setColor(Color.BLACK);
				}
			}
		}
		
	}

}
