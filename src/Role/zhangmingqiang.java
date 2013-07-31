package Role;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class zhangmingqiang extends Role {
	

	public zhangmingqiang(GamePanel Gp) {
		super(Gp);
		name="zhangmingqiang";		
	}

	
	
	public void update(){
		super.update();
		
		if(!istalking){
			if(gp.pl.mt.level==346){
				scene=32;
		        locX=45;
		        locY=17;
		        direction=MainControler.RIGHT;
			}
		}	
	
	}
	
	public void getwords(){

		
	}
}