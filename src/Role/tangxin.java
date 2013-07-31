package Role;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class tangxin extends Role {
	

	public tangxin(GamePanel Gp) {
		super(Gp);
		name="tangxin";		
	}

	
	
	public void update(){
		super.update();
		
		if(!istalking){
			if(gp.pl.mt.level==346){
				scene=32;
		        locX=46;
		        locY=17;
		        direction=MainControler.LEFT;
			}
		}	
	
	}
	
	public void getwords(){

		
	}
}