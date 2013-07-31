package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class role3 extends Role {
	

	public role3(GamePanel Gp) {
		super(Gp);
		name="role3";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking){
			if((gp.pl.mt.level==69||gp.pl.mt.level==100||gp.pl.mt.level==101)&&gp.pl.ot3.going==false){
				 scene=13;
			     locX=17;
			     locY=20;
			     direction=MainControler.UP;
			}
			if(gp.pl.mt.level==496){
				locX=27;
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
			returnwords.add("杨枳：你是不是喜欢我们何小婉啊？");
			returnwords.add("秦舢：。。。哪有");
		}
	}
}