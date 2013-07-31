package Method;

import Controler.MainControler;
import Main.GamePanel;

public abstract class TryToTalk {
	
	public static void work(GamePanel gp){
		//’“npc
		for(int i=0;i<gp.map.npcs.size();i++){
			if(((gp.pl.locX==(gp.map.npcs.get(i).locX-1)&&gp.pl.locY==gp.map.npcs.get(i).locY&&gp.pl.direction==MainControler.RIGHT))||((gp.pl.locX==(gp.map.npcs.get(i).locX+1)&&gp.pl.locY==gp.map.npcs.get(i).locY&&gp.pl.direction==MainControler.LEFT))||((gp.pl.locX==gp.map.npcs.get(i).locX&&(gp.pl.locY==gp.map.npcs.get(i).locY-1)&&gp.pl.direction==MainControler.DOWN))||((gp.pl.locX==gp.map.npcs.get(i).locX&&gp.pl.locY==(gp.map.npcs.get(i).locY+1)&&gp.pl.direction==MainControler.UP))){
				gp.map.npcs.get(i).istalking=true;
				gp.scene=70;
				gp.pl.talkwith=i;
			}
		}
		
		//’“role
		for(int i=0;i<gp.pl.roles.size();i++){
			if((gp.pl.scene==gp.pl.roles.get(i).scene)&&(((gp.pl.locX==(gp.pl.roles.get(i).locX-1)&&gp.pl.locY==gp.pl.roles.get(i).locY&&gp.pl.direction==MainControler.RIGHT))||((gp.pl.locX==(gp.pl.roles.get(i).locX+1)&&gp.pl.locY==gp.pl.roles.get(i).locY&&gp.pl.direction==MainControler.LEFT))||((gp.pl.locX==gp.pl.roles.get(i).locX&&(gp.pl.locY==gp.pl.roles.get(i).locY-1)&&gp.pl.direction==MainControler.DOWN))||((gp.pl.locX==gp.pl.roles.get(i).locX&&gp.pl.locY==(gp.pl.roles.get(i).locY+1)&&gp.pl.direction==MainControler.UP)))){
				gp.pl.roles.get(i).temp=gp.pl.roles.get(i).direction;
				gp.pl.roles.get(i).istalking=true;
				gp.scene=72;
				gp.pl.talkwith=i;
		        
			}
		}
	
	}

}
