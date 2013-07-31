package Event;

import InterFaceAndAbstractClass.Event;
import Main.GamePanel;

public class Sleep extends Event{


	public Sleep(GamePanel Gp) {
		gp=Gp;
	
	
	}

	@Override
	public void occur() {
		gp.pl.talkwith=-1;
	
		//加满体力
		gp.pl.sp=gp.pl.SP;
		if(gp.pl.TeamNum>=2){
			gp.pl.sp2=gp.pl.SP2;
		}
		if(gp.pl.TeamNum>=3){
			gp.pl.sp3=gp.pl.SP3;
		}
		if(gp.pl.TeamNum>=4){
			gp.pl.sp4=gp.pl.SP4;
		}
		
		//睡觉次数计数器+1
		gp.pl.Temp[0]++;

		
		gp.scene=99;

	}

}
