package Painter;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Painter;
import Main.GamePanel;

public class banzhuanPainter implements Painter{
	
	public GamePanel gp;
	public int count;

	public banzhuanPainter(GamePanel Gp) {
		gp=Gp;
		count=0;
	}


	   // ������ĵķ���
    public void draw(Graphics g) {
    	g.drawImage(Method.ImageReader.work("SmallGame/BZBG"),0,0,null);
    	
    	//��Ϸ������
    	if((gp.pl.bz.gameover(gp.pl.bz.x, gp.pl.bz.y))==0){
    		 // ����ǰ����
            for (gp.pl.bz.j = 0; gp.pl.bz.j < 16; gp.pl.bz.j++) {
                if (gp.pl.bz.shapes[gp.pl.bz.blockType][gp.pl.bz.turnState][gp.pl.bz.j] == 1) {
                	g.drawImage(Method.ImageReader.work("SmallGame/block"),200+(gp.pl.bz.j % 4 + gp.pl.bz.x + 1) * 20,10+(gp.pl.bz.j / 4 + gp.pl.bz.y) * 20, null);
                }
            }
            // ���Ѿ��̶��ķ���
            for (gp.pl.bz.j = 0; gp.pl.bz.j < 22; gp.pl.bz.j++) {
                for (gp.pl.bz.i = 0; gp.pl.bz.i < 12; gp.pl.bz.i++) {
                    if (gp.pl.bz.map[gp.pl.bz.i][gp.pl.bz.j] == 1) {
                        g.drawImage(Method.ImageReader.work("SmallGame/block"),200+gp.pl.bz.i * 20,10+gp.pl.bz.j * 20,null);

                    }
                    if (gp.pl.bz.map[gp.pl.bz.i][gp.pl.bz.j] == 2) {
                        g.drawRect(200+gp.pl.bz.i * 20,10+gp.pl.bz.j * 20, 20, 20);

                    }
                }
            }
            g.drawString("score=" + gp.pl.bz.score, 500, 20);
            
            
            //����
            if(count==0){
                gp.pl.bz.update();
            }
            if(count!=5){
            	count++;
            }else{
            	count=0;
            }

    	}
    	
    	//��Ϸ�ѽ�����ʧ�ܣ�
    	if((gp.pl.bz.gameover(gp.pl.bz.x, gp.pl.bz.y))==1){
    		g.drawString("LOSE��",300,200);
    		g.drawString("��SPACE�˳�",300,220);
    	
    	}
    	
    	//��Ϸ�ѽ������ɹ���
    	if((gp.pl.bz.gameover(gp.pl.bz.x, gp.pl.bz.y))==2){
    		g.drawString("WIN��",300,200);
    		g.drawString("��SPACE�˳�",300,220);
        	
    	}
 
    }
}
