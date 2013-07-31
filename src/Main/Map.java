package Main;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Map {
	public GamePanel gp;
	//每块大小
	public final static int sizeX=32;
	public final static int sizeY=32;
	
	//地图编号
	public int scene;
	
	//行数
	public int row;
	
	//列数
	public int column;
	
	//背景地图
	public Image BG;
	
	//碰撞检测地图
	public int[][] map0;
	
	//底层地图
	public int[][] map1;
	
	//上层地图
	public int[][] map2;
	
	//NPC
	public ArrayList<NPC> npcs;
	
	//跳转
	public ArrayList<Jump> jumps;
	
	//玩家相对位置	
	public int offsetX;
	public int offsetY;


	
	public Map(GamePanel Gp){
		gp=Gp;
		scene=gp.pl.scene;
		npcs=new ArrayList<NPC>();
		jumps=new ArrayList<Jump>();
		
		offsetX = GameFrame.WIDTH/2-gp.pl.locX*sizeX;
	    offsetY = GameFrame.HEIGHT/2-gp.pl.locY*sizeY;

		Method.MapReader.work(this,gp);
	}


	public void draw(Graphics g) {
		g.drawImage(Method.ImageReader.work("map/BG"+scene),offsetX,offsetY,null);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {	
				if(map1[i][j]!=0){
					g.drawImage(Method.ImageReader.work("map/"+map1[i][j]),sizeX* j+ offsetX, sizeY*i+ offsetY, null);
				}
				if(map2[i][j]!=0){
					g.drawImage(Method.ImageReader.work("map/"+map2[i][j]),sizeX* j+ offsetX, sizeY*i+ offsetY, null);
				}		
			}	
		}
		for(int i=0;i<npcs.size();i++){
			npcs.get(i).draw(g);
		}
		for(int i=0;i<jumps.size();i++){
			jumps.get(i).draw(g);
		}
	}
	
	public void update(){
		offsetX = GameFrame.WIDTH/2-gp.pl.locX*sizeX;
	    offsetY = GameFrame.HEIGHT/2-gp.pl.locY*sizeY;
	    
		for(int i=0;i<jumps.size();i++){
			if(gp.pl.locX==jumps.get(i).locX&&gp.pl.locY==jumps.get(i).locY){
				gp.scene=71;
				jumps.get(i).istalking=true;
				gp.pl.talkwith=i;
				gp.pl.isMoving=false;
		    	gp.cm.work(gp);
			}
		}
		

		//role所占位置
        if(gp.scene<80){
        	for(int i=0;i<gp.pl.roles.size();i++){
    			if(gp.pl.roles.get(i).scene==gp.scene){
    				gp.map.map0[gp.pl.roles.get(i).locY][gp.pl.roles.get(i).locX]=1;
    			}
    			
    		}
        }
		
	
        //剧情监测
        if(gp.pl.scene==28&&gp.pl.mt.level==170&&gp.pl.locX==78&&gp.pl.locY==38){
        	gp.pl.isMoving=false;
        	gp.pl.mt.update();
        	gp.cm.work(gp);
        }
			
		
	}
	

}
