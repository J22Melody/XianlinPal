package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class jiangqiang extends Role {
	

	public jiangqiang(GamePanel Gp) {
		super(Gp);
		name="jiangqiang";		
	}


	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.mt.going&&gp.pl.mt.level!=147){
			scene=11;
			locX=29;
			locY=19;
			direction=MainControler.DOWN;
			count=0;

		}
	
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==69||gp.pl.mt.level==36){
			returnwords.add("舍友江强：脱离了高中苦海，一定要好好玩啊！");
		}
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101){
			returnwords.add("舍友江强：据说开学七天后的一大早就会进行开学测试呢！好像没几天了。");
			returnwords.add("舍友江强：这个老师刘似乎很严厉。");
			returnwords.add("舍友江强：想到就毛骨悚然啊！");		
		}
		
		if(gp.pl.mt.level==249||gp.pl.mt.level>=261){
			returnwords.add("舍友江强：这学期有电竞大赛呢！Dota、魔兽、CS...");	
			returnwords.add("舍友江强：哈哈虐死他们。");
		}
		
		
	}
}