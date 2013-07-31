package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class libin extends Role {
	

	public libin(GamePanel Gp) {
		super(Gp);
		name="libin";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.mt.going&&gp.pl.mt.level!=147){
			scene=11;
			locX=21;
			locY=19;
			direction=MainControler.DOWN;
			count=0;		
				
			}
				
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==69||gp.pl.mt.level==36||gp.pl.mt.level==101){
			returnwords.add("舍友李彬：是不是该预习一下新课的内容呢。");
			returnwords.add("舍友李彬：新的学期一定要好好学习！");
		}
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101){
			returnwords.add("舍友李彬：一起去图书馆刷微积分吗？");
			returnwords.add("秦舢：no！no！no！");
			returnwords.add("舍友李彬：那一起去仙二听Java课吗？");
			returnwords.add("秦舢：no！no！no！");
			returnwords.add("舍友李彬：要不一起去仙一做做阶段性小考？");
			returnwords.add("秦舢：（。。。学霸真可怕！）");
		}
		
		if(gp.pl.mt.level==249||gp.pl.mt.level>=261){
			returnwords.add("舍友李彬：听说3月份会有EL大赛。");	
			returnwords.add("舍友李彬：主题是什么坑爹的仙林软件奇侠传。");		
			returnwords.add("秦舢：传说中的Easy life，easy learning。");		
			
		}
		
	}
}