package Method;

import animation.promptanimation;
import FightSystem.FighterUpdater;
import FightSystem.Introducer;
import Main.GamePanel;

public abstract class WalkCounter {

	public static void work(GamePanel gp){
		if(gp.pl.scene==25||gp.pl.scene==28||gp.pl.scene==31){

			//��è��ѧ
            if(gp.pl.Temp[2]==30){
				gp.pl.Temp[2]=0;
				
				gp.pl.introducer=new Introducer(gp,true,true,true,true,4,0);
				gp.pl.updater=new FighterUpdater(gp);
				gp.scene=80;
				gp.pa=new promptanimation(gp,"����ս��");
				gp.pl.isMoving=false;
			}		
            
            //��ɽ
            if(gp.pl.Temp[2]==28){
            	gp.pl.Temp[2]=0;
				
				gp.pl.introducer=new Introducer(gp,true,true,true,false,3,0);
				gp.pl.updater=new FighterUpdater(gp);
				gp.scene=80;
				gp.pa=new promptanimation(gp,"����ս��");
				gp.pl.isMoving=false;
			}	
            
            //ͼ��ݷ���
            if(gp.pl.Temp[2]==25){
            	gp.pl.Temp[2]=0;
				
				gp.pl.introducer=new Introducer(gp,true,false,false,false,1,0);
				gp.pl.updater=new FighterUpdater(gp);
				gp.scene=80;
				gp.pa=new promptanimation(gp,"����ս��");
				gp.pl.isMoving=false;
			}
			gp.pl.Temp[2]++;
			
		}
	}
}
