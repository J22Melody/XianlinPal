package Event;

import animation.promptanimation;
import InterFaceAndAbstractClass.Event;
import Main.GamePanel;

public class Hair extends Event {

	public Hair(GamePanel Gp) {
		gp=Gp;
	}
	
	public void occur(){
		gp.pl.talkwith=-1;
		if(gp.pl.Money>=10*gp.pl.TeamNum){
			double i=Math.random();
			if(i>0.5){
				
				gp.pl.sp+=10;
				if(gp.pl.TeamNum>=2){
					gp.pl.sp2+=10;
				}
				if(gp.pl.TeamNum>=3){
					gp.pl.sp3+=10;
				}
				if(gp.pl.TeamNum==4){
					gp.pl.sp4+=10;
				}
				gp.pa=new promptanimation(gp,"感觉不错,体力恢复。");
			}
			if(i<=0.5){
				gp.pl.sp-=10;
				if(gp.pl.TeamNum>=2){
					gp.pl.sp2-=10;
				}
				if(gp.pl.TeamNum>=3){
					gp.pl.sp3-=10;
				}
				if(gp.pl.TeamNum==4){
					gp.pl.sp4-=10;
				}
				gp.pa=new promptanimation(gp,"哎呀剪坏了！体力下降。");
			}
			
			
			gp.pl.Money-=10*gp.pl.TeamNum;
			
			gp.scene=102;
		}
		
		else{
			gp.pa=new promptanimation(gp,"没钱你还来！");
			gp.scene=gp.pl.scene;
		}
		
	}
	

}
