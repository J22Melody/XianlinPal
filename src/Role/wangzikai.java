package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class wangzikai extends Role {
	

	public wangzikai(GamePanel Gp) {
		super(Gp);
		name="wangzikai";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.mt.going&&gp.pl.mt.level!=147){
			scene=11;
			locX=27;
			locY=20;
			direction=MainControler.DOWN;
			count=0;	
		
		}
			
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==69||gp.pl.mt.level==36){
			returnwords.add("舍友王子凯：大学生活终于开始了。");
			returnwords.add("舍友王子凯：相信像我这样才貌双全、无所不能的人一定会混得风生水起吧哈哈！");
		}
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101){
			returnwords.add("舍友王子凯：真受不了那两个人，一个就知道玩，一个就知道学。");
			returnwords.add("舍友王子凯：我可是要成就大事业的人。");
			returnwords.add("舍友王子凯：最近关注关注学生会和团委的招新呢！看看能不能混个一官半职的。");
		}
		
		
		if(gp.pl.mt.level==249||gp.pl.mt.level>=261){
			returnwords.add("舍友王子凯：这学期争取做个学生会主席。小舢，到时候哥罩你，也让你做个什么东西玩玩。");	
			returnwords.add("秦舢：。。。算了，我不行的。");	
		}
		
		
	}
}