package Event;

import animation.promptanimation;
import InterFaceAndAbstractClass.Event;
import Main.GamePanel;
import SmallGame.banhua;

public class BanHua extends Event{


	public BanHua(GamePanel Gp) {
		gp=Gp;
	
	
	}

	@Override
	public void occur() {
		gp.pl.talkwith=-1;
	
		
		switch(gp.pl.TeamNum){
		case 1:
			if(gp.pl.sp>=20){
				gp.pl.sp-=20;
				gp.pl.bh=new banhua(gp);
			    gp.scene=84;
			    
			}else{
				gp.pa=new promptanimation(gp,"没力气了吧！");
				gp.scene=gp.pl.scene;
			}
			break;
		case 2:
			if(gp.pl.sp>=20&&gp.pl.sp2>=20){
				gp.pl.sp-=20;
				gp.pl.sp2-=20;
				gp.pl.bh=new banhua(gp);
			    gp.scene=84;
				
			}else{
				gp.pa=new promptanimation(gp,"没力气了吧！");
				gp.scene=gp.pl.scene;
			}
			break;
		case 3:
			if(gp.pl.sp>=20&&gp.pl.sp2>=20&&gp.pl.sp3>=20){
				gp.pl.sp-=20;
				gp.pl.sp2-=20;
				gp.pl.sp3-=20;
				gp.pl.bh=new banhua(gp);
			    gp.scene=84;
				
			}else{
				gp.pa=new promptanimation(gp,"没力气了吧！");
				gp.scene=gp.pl.scene;
			}
			break;
		case 4:
			if(gp.pl.sp>=20&&gp.pl.sp2>=20&&gp.pl.sp3>=20&&gp.pl.sp4>=20){
				gp.pl.sp-=20;
				gp.pl.sp2-=20;
				gp.pl.sp3-=20;
				gp.pl.sp4-=20;
				gp.pl.bh=new banhua(gp);
			    gp.scene=84;
				
			}else{
				gp.pa=new promptanimation(gp,"没力气了吧！");
				gp.scene=gp.pl.scene;
			}
			break;
		}	
	}

}