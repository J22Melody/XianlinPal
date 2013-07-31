package Role;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class mum extends Role {
	

	public mum(GamePanel Gp) {
		super(Gp);
		name="mum";		
	}


	
	public void update(){
		super.update();
		if(gp.pl.mt.level>=14&&gp.pl.mt.level<=23){
			scene=11;
			locX=25;
			locY=9;
			direction=MainControler.DOWN;
			count=0;	
		}
		
		if(gp.pl.mt.level>24){
			scene=9999;
		}
	}
}
