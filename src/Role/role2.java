package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class role2 extends Role {
	

	public role2(GamePanel Gp) {
		super(Gp);
		name="role2";		
	}

	
	
	public void update(){
		super.update();
		
		if(!istalking){
			if((gp.pl.mt.level==69||gp.pl.mt.level==100||gp.pl.mt.level==101)&&gp.pl.ot3.going==false&&gp.pl.ot2.going==false){
				scene=13;
		        locX=19;
		        locY=20;
		        direction=MainControler.UP;
			}
			if(gp.pl.mt.level==496){
				locX=26;
				locY=20;
				direction=MainControler.UP;
				scene=16;
				
			}
		}	
	
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101){
			returnwords.add("何小婉：干嘛？");
			returnwords.add("秦舢：没，没什么。");
		}
	}
}