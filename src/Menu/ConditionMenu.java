package Menu;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;

public class ConditionMenu extends Menu{


	public ConditionMenu(Menu Decorated){
		decorated=Decorated;
		gp=Decorated.gp;
	
	}

	public void draw(Graphics g) {
		decorated.draw(g);

		g.drawImage(Method.ImageReader.work("menu/conditionmenu"),180,20,null);
		
		g.drawString("���� ", 290,80);
		g.drawString("��Ѫ          "+gp.pl.hp+"/"+gp.pl.HP, 260,100);
		g.drawString("����          "+gp.pl.mp+"/"+gp.pl.MP, 260,130);
		g.drawString("����         "+gp.pl.sp+"/"+gp.pl.SP,260,160);
		g.drawString("������     "+gp.pl.EP+"%", 260,190);
		g.drawString("���ݶ�     "+gp.pl.VP,260,220);

		g.drawString("����         "+gp.pl.ST, 260,250);
		g.drawString("����         "+gp.pl.IQ, 260,280);
		g.drawString("��Ʒ         "+gp.pl.RP, 260,310);
		g.drawString("ѧ�ּ�     "+gp.pl.GPA, 260,340);
	
		
	    if(gp.pl.TeamNum>1){
	    	g.drawString("��С�� ", 405,80);
	    	g.drawString("��Ѫ          "+gp.pl.hp2+"/"+gp.pl.HP2, 375,100);
			g.drawString("����          "+gp.pl.mp2+"/"+gp.pl.MP2, 375,130);
			g.drawString("����         "+gp.pl.sp2+"/"+gp.pl.SP2, 375,160);
			g.drawString("������     "+gp.pl.EP2+"%", 375,190);
			g.drawString("���ݶ�     "+gp.pl.VP2,375,220);

			g.drawString("����          "+gp.pl.ST2, 375,250);
			g.drawString("����         "+gp.pl.IQ2, 375,280);
			g.drawString("��Ʒ         "+gp.pl.RP2, 375,310);
			g.drawString("ѧ�ּ�     "+gp.pl.GPA2, 375,340);
	    }
	    
	    if(gp.pl.TeamNum>2){
	    	g.drawString("���� ", 520,80);
	    	g.drawString("��Ѫ          "+gp.pl.hp3+"/"+gp.pl.HP3, 490,100);
			g.drawString("����          "+gp.pl.mp3+"/"+gp.pl.MP3, 490,130);
			g.drawString("����         "+gp.pl.sp3+"/"+gp.pl.SP3,490,160);
			g.drawString("������     "+gp.pl.EP3+"%", 490,190);
			g.drawString("���ݶ�     "+gp.pl.VP3,490,220);

			g.drawString("����          "+gp.pl.ST3,490,250);
			g.drawString("����         "+gp.pl.IQ3, 490,280);
			g.drawString("��Ʒ         "+gp.pl.RP3, 490,310);
			g.drawString("ѧ�ּ�     "+gp.pl.GPA3, 490,340);
	    }
	    
	    if(gp.pl.TeamNum>3){
	    	g.drawString("ŷ���", 635,80);
	    	g.drawString("��Ѫ          "+gp.pl.hp4+"/"+gp.pl.HP4,605,100);
			g.drawString("����          "+gp.pl.mp4+"/"+gp.pl.MP4,605,130);
			g.drawString("����         "+gp.pl.sp4+"/"+gp.pl.SP4,605,160);
			g.drawString("������     "+gp.pl.EP4+"%", 605,190);
			g.drawString("���ݶ�     "+gp.pl.VP3,605,220);

			g.drawString("����          "+gp.pl.ST4, 605,250);
			g.drawString("����         "+gp.pl.IQ4, 605,280);
			g.drawString("��Ʒ         "+gp.pl.RP4,605,310);
			g.drawString("ѧ�ּ�     "+gp.pl.GPA4,605,340);
	    }
	    
		g.drawString("��Ǯ          "+gp.pl.Money,430,376);
	}

}
