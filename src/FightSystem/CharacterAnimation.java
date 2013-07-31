package FightSystem;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class CharacterAnimation {
	
	BufferedImage[] bims;
	BufferedImage bim;
	int imPosition;
	
	
	int animTime;
	int animTotalTime;
	int showTime;
	int animSpeed;
	
	int width;
	int height;
	int imWidth;
	int imHeight;
	
	int num;
	Graphics cg;
	
	
	public CharacterAnimation(String filename,int num,int animSpeed,int animTotalTime){
		imageInitialize(filename);
		imPosition=0;
		animTime=0;
		this.num=num;
		this.animSpeed=animSpeed;
		this.animTotalTime=animTotalTime;
		bims=setAnims();
	}
	
	public BufferedImage[] setAnims(){
		BufferedImage[] ims=new BufferedImage[num];
		width=bim.getWidth();
		height=bim.getHeight();
		imWidth=width/num;
		imHeight=height;
		for(int i=0;i<num;i++){
			ims[i]=new BufferedImage(imWidth,imHeight,BufferedImage.TYPE_INT_ARGB);
			cg=ims[i].getGraphics();
			cg.drawImage(bim,0,0,imWidth,imHeight,i*imWidth,0,i*imWidth+imWidth,imHeight,null);
			cg.dispose();
		}
		return ims;
	}
	
	//展示当前图像
	public void display(Graphics g,int x ,int y){
		g.drawImage(bims[imPosition],x,y,null);
	}
	
	//初始化图像
	public void imageInitialize(String filename){
		bim=Animation.loadImage(filename);
	}
	
	//人物形态更新
	public void stateUpdate(){
		animTime=(animTime+animSpeed)%(animTotalTime*1000);
		showTime=animTotalTime*1000/num;
		imPosition=animTime/showTime;
	}

}
