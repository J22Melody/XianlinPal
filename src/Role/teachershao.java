package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class teachershao extends Role {
	

	public teachershao(GamePanel Gp) {
		super(Gp);
		name="teachershao";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking){
		
			
			if(gp.pl.mt.level==100||gp.pl.mt.level==101||gp.pl.mt.level==147||gp.pl.mt.level==170||gp.pl.mt.level==249||gp.pl.mt.level>=261){
				scene=17;
				locX=23;
				locY=15;
				direction=MainControler.DOWN;
						
			}
		
		}
		
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101||gp.pl.mt.level==249){
			returnwords.add("老师邵：我是你们辅导员的同事。");
			returnwords.add("老师邵：我已经在这里工作了30年了。");
			returnwords.add("老师邵：现在在教高年级呢！");

		}
		if(gp.pl.mt.level>=261){
			returnwords.add("老师邵：软件学院的荣誉可就靠你们了啊！");
		}
	}
}