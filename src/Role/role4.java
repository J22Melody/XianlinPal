package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class role4 extends Role {
	

	public role4(GamePanel Gp) {
		super(Gp);
		name="role4";		
	}

	
	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.ot4.going){
			if(gp.pl.mt.level==261&&gp.pl.ot4.level==0){
				gp.pl.roles.get(7).direction=MainControler.UP;
				gp.pl.roles.get(7).locX=96;
				gp.pl.roles.get(7).locY=86;
				gp.pl.roles.get(7).scene=10;
			}
			if(gp.pl.mt.level==262||(gp.pl.ot4.level!=0&&gp.pl.mt.level==261)){
				gp.pl.roles.get(7).direction=MainControler.UP;
				gp.pl.roles.get(7).locX=20;
				gp.pl.roles.get(7).locY=27;
				gp.pl.roles.get(7).scene=16;
			}
			if(gp.pl.mt.level==496){
				locX=28;
				locY=20;
				direction=MainControler.UP;
				scene=16;
				
			}
		}
		  	
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		returnwords.add("≈∑—ÙÏß£∫‡≈£ø");
		
		
	}
}