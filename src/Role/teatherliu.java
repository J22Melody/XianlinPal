package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class teatherliu extends Role {
	

	public teatherliu(GamePanel Gp) {
		super(Gp);
		name="teacherliu";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.mt.going){
			if(gp.pl.mt.level==69){
				scene=13;
		        locX=21;
		        locY=14;
		        direction=MainControler.DOWN;
			}
			
			if(gp.pl.mt.level==100||gp.pl.mt.level==101||gp.pl.mt.level==170||gp.pl.mt.level==147||gp.pl.mt.level==249||gp.pl.mt.level==261||gp.pl.mt.level==262||gp.pl.mt.level==306||gp.pl.mt.level==313){
				scene=17;
				locX=20;
				locY=15;
				direction=MainControler.DOWN;
						
			}
		
		}
		
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==100){
			returnwords.add("老师刘：准备的怎么样了？");
			returnwords.add("秦舢：还，还不行呢。");

		}
		
		if(gp.pl.mt.level>=261){
			returnwords.add("老师刘：加油啊！");
		}
		
		
	}
}