package Painter;
import java.awt.*;

import InterFaceAndAbstractClass.Painter;
import Main.GamePanel;

public class dakaPainter implements Painter {
	private static final int DOWN = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    
	public GamePanel gp;

	public dakaPainter(GamePanel Gp) {
		gp=Gp;
	}
	
	public void draw(Graphics g){
		g.drawImage(gp.pl.dk.background, 0, 0, 800, 480, null);
		for(int i=0;i<10;i++){
			g.drawImage(gp.pl.dk.imageNPC[i], gp.pl.dk.npc[i].x , gp.pl.dk.npc[i].y , gp.pl.dk.npc[i].x  + 32, gp.pl.dk.npc[i].y  + 48,gp.pl.dk.count * 32, gp.pl.dk.direction[i] * 48, 32 +gp.pl.dk.count * 32, gp.pl.dk.direction[i] * 48 + 48,null);
		}
		


        if(!gp.pl.dk.gameover){
        	 if(gp.pl.dk.isMove){
             	switch(gp.pl.dk.directionRole){
             	case UP:
                 	if(gp.pl.dk.role.y>80)
                 		gp.pl.dk.role.y-=10;
                 	break;
                 case DOWN:
                 	if(gp.pl.dk.role.y<410)
                 		gp.pl.dk.role.y+=10;
                 	break;
                 case LEFT:
                 	if(gp.pl.dk.role.x>88)
                 		gp.pl.dk.role.x-=10;
                 	break;
                 case RIGHT:
                 	if(gp.pl.dk.role.x<570)
                 		gp.pl.dk.role.x+=10;
                 	break;
                 }
                 
             }
        	 

     	    if (gp.pl.dk.count == 3) {
     	    	gp.pl.dk.count = 1;
             } else if (gp.pl.dk.count == 1) {
             	gp.pl.dk.count = 3;
             }
             
             if(gp.pl.dk.isMove){
          	   if (gp.pl.dk.countRole == 3) {
          		  gp.pl.dk.countRole = 1;
                 } else if (gp.pl.dk.countRole == 1) {
                 	gp.pl.dk.countRole = 3;
                 } else if(gp.pl.dk.countRole==0){
                 	gp.pl.dk.countRole=3;
                 }
             }

            for(int j=0;j<10;j++){
          	  if(gp.pl.dk.count1%5==0){
          		 gp.pl.dk.direction[j]=(int)(Math.random()*4);  
          	  }
          	  if(isAllow(j)){
           			switch(gp.pl.dk.direction[j]){
           			case LEFT:gp.pl.dk.npc[j].x-=5;break;
           			case RIGHT:gp.pl.dk.npc[j].x+=5;break;
           			case UP:gp.pl.dk.npc[j].y-=5;break;
           			case DOWN:gp.pl.dk.npc[j].y+=5;break;
           			default:break;
           			}
           			
           			gp.pl.dk.count1++;
           		}
            	   else{
            		gp.pl.dk.direction[j]=reversal(gp.pl.dk.direction[j],j);
            		   switch(gp.pl.dk.direction[j]){
        			       case LEFT:gp.pl.dk.npc[j].x-=5;break;
        			       case RIGHT:gp.pl.dk.npc[j].x+=5;break;
        			       case UP:gp.pl.dk.npc[j].y-=5;break;
        			       case DOWN:gp.pl.dk.npc[j].y+=5;break;
        			       default:break;
        			       }
            		 
            	   }
            	               	   
              }
            
        }
       
		g.drawImage(gp.pl.dk.imageRole,gp.pl.dk.role.x,gp.pl.dk.role.y,gp.pl.dk.role.x+32,gp.pl.dk.role.y+48,gp.pl.dk.countRole*32,gp.pl.dk.directionRole*48,32+gp.pl.dk.countRole*32,gp.pl.dk.directionRole*48+48,null);
		g.drawImage(gp.pl.dk.imageMachine1, gp.pl.dk.machine1.x, gp.pl.dk.machine1.y, 32, 32, null);
		

       if(gp.pl.dk.isWin()){
       	g.drawImage(gp.pl.dk.win, 200, 150, null);
       	g.drawImage(gp.pl.dk.win1, 408, 150,null);
       	gp.pl.dk.isStop=false;
       	gp.pl.dk.gameover=true;
       
       }
       
		if(gp.pl.dk.isFailure()){
			g.drawImage(gp.pl.dk.fail, 180, 200, 128, 128, null);
			g.drawImage(gp.pl.dk.over, 308, 200, 171, 128, null);
			gp.pl.dk.isStop=false;
			gp.pl.dk.gameover=true;
		}

        

	}
	
	public boolean isAllow(int n){
		boolean isAllow=true;
		for(int i=0;i<10;i++){
			if(i!=n){
				if(gp.pl.dk.npc[n].intersects(gp.pl.dk.npc[i])||gp.pl.dk.npc[n].x<88||gp.pl.dk.npc[n].x>570||gp.pl.dk.npc[n].y>410||gp.pl.dk.npc[n].y<150){
					isAllow=false;
				}
			}
		}
		return isAllow;
	}
	

	

	
	public int reversal(int m,int n){
		switch(m){
		case LEFT:gp.pl.dk.direction[n]=RIGHT;break;
		case RIGHT:gp.pl.dk.direction[n]=LEFT;break;
		case UP:gp.pl.dk.direction[n]=DOWN;break;
		case DOWN:gp.pl.dk.direction[n]=UP;break;
		}
		return gp.pl.dk.direction[n];
	}
}