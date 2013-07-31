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
		
		g.drawString("秦舢 ", 290,80);
		g.drawString("气血          "+gp.pl.hp+"/"+gp.pl.HP, 260,100);
		g.drawString("精力          "+gp.pl.mp+"/"+gp.pl.MP, 260,130);
		g.drawString("体力         "+gp.pl.sp+"/"+gp.pl.SP,260,160);
		g.drawString("暴击率     "+gp.pl.EP+"%", 260,190);
		g.drawString("敏捷度     "+gp.pl.VP,260,220);

		g.drawString("体质         "+gp.pl.ST, 260,250);
		g.drawString("智商         "+gp.pl.IQ, 260,280);
		g.drawString("人品         "+gp.pl.RP, 260,310);
		g.drawString("学分绩     "+gp.pl.GPA, 260,340);
	
		
	    if(gp.pl.TeamNum>1){
	    	g.drawString("何小婉 ", 405,80);
	    	g.drawString("气血          "+gp.pl.hp2+"/"+gp.pl.HP2, 375,100);
			g.drawString("精力          "+gp.pl.mp2+"/"+gp.pl.MP2, 375,130);
			g.drawString("体力         "+gp.pl.sp2+"/"+gp.pl.SP2, 375,160);
			g.drawString("暴击率     "+gp.pl.EP2+"%", 375,190);
			g.drawString("敏捷度     "+gp.pl.VP2,375,220);

			g.drawString("体质          "+gp.pl.ST2, 375,250);
			g.drawString("智商         "+gp.pl.IQ2, 375,280);
			g.drawString("人品         "+gp.pl.RP2, 375,310);
			g.drawString("学分绩     "+gp.pl.GPA2, 375,340);
	    }
	    
	    if(gp.pl.TeamNum>2){
	    	g.drawString("杨枳 ", 520,80);
	    	g.drawString("气血          "+gp.pl.hp3+"/"+gp.pl.HP3, 490,100);
			g.drawString("精力          "+gp.pl.mp3+"/"+gp.pl.MP3, 490,130);
			g.drawString("体力         "+gp.pl.sp3+"/"+gp.pl.SP3,490,160);
			g.drawString("暴击率     "+gp.pl.EP3+"%", 490,190);
			g.drawString("敏捷度     "+gp.pl.VP3,490,220);

			g.drawString("体质          "+gp.pl.ST3,490,250);
			g.drawString("智商         "+gp.pl.IQ3, 490,280);
			g.drawString("人品         "+gp.pl.RP3, 490,310);
			g.drawString("学分绩     "+gp.pl.GPA3, 490,340);
	    }
	    
	    if(gp.pl.TeamNum>3){
	    	g.drawString("欧阳歆", 635,80);
	    	g.drawString("气血          "+gp.pl.hp4+"/"+gp.pl.HP4,605,100);
			g.drawString("精力          "+gp.pl.mp4+"/"+gp.pl.MP4,605,130);
			g.drawString("体力         "+gp.pl.sp4+"/"+gp.pl.SP4,605,160);
			g.drawString("暴击率     "+gp.pl.EP4+"%", 605,190);
			g.drawString("敏捷度     "+gp.pl.VP3,605,220);

			g.drawString("体质          "+gp.pl.ST4, 605,250);
			g.drawString("智商         "+gp.pl.IQ4, 605,280);
			g.drawString("人品         "+gp.pl.RP4,605,310);
			g.drawString("学分绩     "+gp.pl.GPA4,605,340);
	    }
	    
		g.drawString("金钱          "+gp.pl.Money,430,376);
	}

}
