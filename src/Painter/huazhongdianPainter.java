package Painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import InterFaceAndAbstractClass.Painter;
import Main.GamePanel;

public class huazhongdianPainter implements Painter {
	public GamePanel gp;

	public huazhongdianPainter(GamePanel Gp) {
		gp=Gp;
	}

	public void draw(Graphics g){

		gp.pl.hzd.background=Toolkit.getDefaultToolkit().getImage("image/SmallGame/background.jpg");
		g.drawImage(gp.pl.hzd.background,0,0,null);
		if(gp.pl.hzd.start==true){
			g.setColor(Color.BLACK);
			g.drawLine(0, 110, 480, 110);
			g.drawLine(0, 180, 480, 180);
			g.drawLine(0, 250, 480, 250);
			g.drawLine(0, 320, 480, 320);
			g.drawLine(0, 390, 480, 390);
			g.drawLine(0, 460, 480, 460);
			g.drawLine(5, 110, 5, 460);
			g.drawLine(100, 110, 100, 460);
			g.drawLine(195, 110, 195, 460);
			g.drawLine(290, 110, 290, 460);
			g.drawLine(385, 110, 385, 460);
			g.drawLine(480, 110, 480, 460);
			
			
			g.setColor(gp.pl.hzd.color[0]);
			g.drawString(gp.pl.hzd.zd[0], 12, 140);
			g.setColor(gp.pl.hzd.color[1]);
			g.drawString(gp.pl.hzd.zd[1], 12, 215);
			g.setColor(gp.pl.hzd.color[2]);
			g.drawString(gp.pl.hzd.zd[2], 12, 280);
			g.setColor(gp.pl.hzd.color[3]);
			g.drawString(gp.pl.hzd.zd[3], 12, 355);
			g.setColor(gp.pl.hzd.color[4]);
			g.drawString(gp.pl.hzd.zd[4], 12, 430);
			g.setColor(gp.pl.hzd.color[5]);
			g.drawString(gp.pl.hzd.zd[5], 105, 140);
			g.setColor(gp.pl.hzd.color[6]);
			g.drawString(gp.pl.hzd.zd[6], 105, 215);
			g.setColor(gp.pl.hzd.color[7]);
			g.drawString(gp.pl.hzd.zd[7], 105, 280);
			g.setColor(gp.pl.hzd.color[8]);
			g.drawString(gp.pl.hzd.zd[8], 105, 355);
			g.setColor(gp.pl.hzd.color[9]);
			g.drawString(gp.pl.hzd.zd[9], 105, 430);
			g.setColor(gp.pl.hzd.color[10]);
			g.drawString(gp.pl.hzd.zd[10], 200, 140);
			g.setColor(gp.pl.hzd.color[11]);
			g.drawString(gp.pl.hzd.zd[11], 200, 215);
			g.setColor(gp.pl.hzd.color[12]);
			g.drawString(gp.pl.hzd.zd[12], 200, 280);
			g.setColor(gp.pl.hzd.color[13]);
			g.drawString(gp.pl.hzd.zd[13], 200, 355);
			g.setColor(gp.pl.hzd.color[14]);
			g.drawString(gp.pl.hzd.zd[14], 200, 430);
			g.setColor(gp.pl.hzd.color[15]);
			g.drawString(gp.pl.hzd.zd[15], 295, 140);
			g.setColor(gp.pl.hzd.color[16]);
			g.drawString(gp.pl.hzd.zd[16], 295, 215);
			g.setColor(gp.pl.hzd.color[17]);
			g.drawString(gp.pl.hzd.zd[17], 295, 280);
			g.setColor(gp.pl.hzd.color[18]);
			g.drawString(gp.pl.hzd.zd[18], 295, 355);
			g.setColor(gp.pl.hzd.color[19]);
			g.drawString(gp.pl.hzd.zd[19], 295, 430);
			g.setColor(gp.pl.hzd.color[20]);
			g.drawString(gp.pl.hzd.zd[20], 390, 140);
			g.setColor(gp.pl.hzd.color[21]);
			g.drawString(gp.pl.hzd.zd[21], 390, 215);
			g.setColor(gp.pl.hzd.color[22]);
			g.drawString(gp.pl.hzd.zd[22], 390, 280);
			g.setColor(gp.pl.hzd.color[23]);
			g.drawString(gp.pl.hzd.zd[23], 390, 355);
			g.setColor(gp.pl.hzd.color[24]);
			g.drawString(gp.pl.hzd.zd[24], 390, 430);
			
			g.setColor(Color.BLACK);
			g.drawString("游戏说明", 530, 150);
			g.drawString("快考试了啊", 500, 220);
			g.drawString("总有那么点来不及复习", 500, 250);
			g.drawString("所以呢.嘿嘿，漏掉点重点", 500, 280);
			g.drawString("上下左右控制方向", 500, 310);
			g.drawString("空格是确定或者取消", 500, 340);
			g.drawString("选好不复习的后按回车", 500, 370);
			g.drawString("一切靠人品，good luck", 500, 400);
			
			g.drawString("划重点", 180, 70);
			g.setColor(Color.RED);
			g.drawRect(5+gp.pl.hzd.m*95, 110+gp.pl.hzd.n*70, 95, 70);
			
		}
		if(gp.pl.hzd.end==true){
		    for(int i=0,n=0;i<gp.pl.hzd.NUMBER;i++,n+=50){
			    g.drawString(gp.pl.hzd.string[i], 100, 200+n);
			    
			    g.drawString("按Enter键退出", 220, 400);
		    }
		}
	}

}
