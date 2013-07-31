package Event;

import animation.promptanimation;
import InterFaceAndAbstractClass.Event;
import Main.GamePanel;

public class Heal extends Event {

	public Heal(GamePanel Gp) {
		gp=Gp;
	}
	
	public void occur(){
		gp.pl.talkwith=-1;
		if(gp.pl.Money>=100){

			
			gp.pl.mp=gp.pl.MP;
			gp.pl.hp=gp.pl.HP;
			
			if(gp.pl.TeamNum>=2){
				gp.pl.mp2=gp.pl.MP2;
				gp.pl.hp2=gp.pl.HP2;
			}
			
			if(gp.pl.TeamNum>=3){
				gp.pl.mp3=gp.pl.MP3;
				gp.pl.hp3=gp.pl.HP3;
			}
			
			if(gp.pl.TeamNum==4){
				gp.pl.mp4=gp.pl.MP4;
				gp.pl.hp4=gp.pl.HP4;
			}
			
			gp.pa=new promptanimation(gp,"气血、精神恢复满值");
		
			
			gp.pl.Money-=100;
			
			gp.scene=gp.pl.scene;
			gp.pl.Temp[6]++;

			
		}
		
		else{
			gp.pa=new promptanimation(gp,"金钱不足");
			gp.scene=gp.pl.scene;
		}
		
	}
	

}