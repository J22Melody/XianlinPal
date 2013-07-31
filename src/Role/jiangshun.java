package Role;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class jiangshun extends Role {
	

	public jiangshun(GamePanel Gp) {
		super(Gp);
		name="jiangshun";		
	}

	
	
	public void update(){
		super.update();
		
		if(!istalking){
			if(gp.pl.mt.level==346){
				scene=32;
		        locX=46;
		        locY=18;
		        direction=MainControler.LEFT;
			}
		}	
	
	}
	
	public void getwords(){

		
	}
}