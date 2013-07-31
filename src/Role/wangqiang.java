package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class wangqiang extends Role {
	

	public wangqiang(GamePanel Gp) {
		super(Gp);
		name="wangqiang";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.ot5.going){
		
			
			if(gp.pl.mt.level==100||gp.pl.mt.level==101||gp.pl.mt.level==147||gp.pl.mt.level==170||gp.pl.mt.level==249||gp.pl.mt.level==261){
				scene=24;
				locX=17;
				locY=40;
				direction=MainControler.UP;
						
			}
		
		}
		
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		returnwords.add("王强：。");
		returnwords.add("秦舢：怪人一个。");

		
	}
}