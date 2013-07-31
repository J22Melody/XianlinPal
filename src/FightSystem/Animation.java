package FightSystem;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Animation {
	
	BufferedImage bim;
	BufferedImage[] ims;
	
	Point num;
	int imPosition=0;
	boolean canPlay=false;
	
	public Animation(String filename,Point num){
		bim=loadImage(filename);
		this.num=num;
		ims=setAnims();
	}
	
	public BufferedImage[] setAnims(){
		Graphics g;
		BufferedImage[] bims=new BufferedImage[num.x*num.y];
		int width=bim.getWidth();
		int height=bim.getHeight();
		int imWidth=width/num.x;
		int imHeight=height/num.y;
		for(int j=0;j<num.y;j++){
			for(int i=0;i<num.x;i++){
				bims[i+j*num.x]=new BufferedImage(imWidth,imHeight,BufferedImage.TYPE_INT_ARGB);
				g=bims[i+j*num.x].getGraphics();
				g.drawImage(bim, 0, 0, imWidth, imHeight, i*imWidth,j*imHeight,i*imWidth+imWidth, j*imHeight+imHeight,null);
				g.dispose();
			}
		}
		return bims;
	}
	
	public void playAnimation(Graphics g,int locX,int locY){
		if(canPlay){
			g.drawImage(ims[imPosition],locX,locY,null);
		}
		imPosition+=1;
		if(imPosition>=num.x*num.y){
			imPosition=0;
			canPlay=false;
		}
	}
	
	public static BufferedImage loadImage(String filename){
		File file=new File(filename);
		try {
			BufferedImage im=ImageIO.read(file);
			return im;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("loadImage error");
			return null;
		}
	}
	
	public static BufferedImage[] setAnims(BufferedImage bimg,Point num){
		Graphics g;
		BufferedImage[] bims=new BufferedImage[num.x*num.y];
		int width=bimg.getWidth();
		int height=bimg.getHeight();
		int imWidth=width/num.x;
		int imHeight=height/num.y;
		for(int j=0;j<num.y;j++){
			for(int i=0;i<num.x;i++){
				bims[i+j*num.x]=new BufferedImage(imWidth,imHeight,BufferedImage.TYPE_INT_ARGB);
				g=bims[i+j*num.x].getGraphics();
				g.drawImage(bimg, 0, 0, imWidth, imHeight, i*imWidth,j*imHeight,i*imWidth+imWidth, j*imHeight+imHeight,null);
				g.dispose();
			}
		}
		return bims;
	}

}