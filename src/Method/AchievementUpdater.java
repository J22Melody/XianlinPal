package Method;

import animation.achieveanimation;
import Main.GamePanel;


public abstract class AchievementUpdater {
	
	public static void work(GamePanel gp){
		//学霸
		if(gp.pl.Temp[3]==10){
			gp.aa=new achieveanimation(gp,"xueba");
			gp.pl.Temp[3]++;
		}
		//学神
		if(gp.pl.Temp[4]==10){
			gp.aa=new achieveanimation(gp,"xueshen");
			gp.pl.Temp[4]++;
		}
		//潮人
		if(gp.pl.Temp[5]==5){
			gp.aa=new achieveanimation(gp,"chaoren");
			gp.pl.Temp[5]++;
		}
		//残疾
		if(gp.pl.Temp[6]==3){
			gp.aa=new achieveanimation(gp,"canji");
			gp.pl.Temp[6]++;
		}
		//好心人
		if(gp.pl.Temp[7]==8){
			gp.aa=new achieveanimation(gp,"haoxinren");
			gp.pl.Temp[7]++;
		}
		//支线王
		if(gp.pl.Temp[8]==0&&gp.pl.ot1.level==74&&gp.pl.ot2.level==128&&gp.pl.ot3.level==86&&gp.pl.ot4.level==68&&gp.pl.ot5.level==73&&gp.pl.ot6.level==52&&gp.pl.ot7.level==33){
			gp.aa=new achieveanimation(gp,"zhixianwang");
			gp.pl.Temp[8]++;
		}
		//高富帅
		if(gp.pl.Temp[9]==0&&gp.pl.Money>=1000){
			gp.aa=new achieveanimation(gp,"gaofushuai");
			gp.pl.Temp[8]++;
		}
		//打卡王
		if(gp.pl.Temp[10]==5){
			gp.aa=new achieveanimation(gp,"dakawang");
			gp.pl.Temp[10]++;
		}
		//好学生
		if(gp.pl.Temp[11]==8){
			gp.aa=new achieveanimation(gp,"haoxuesheng");
			gp.pl.Temp[11]++;
		}
		//人品差
		if(gp.pl.Temp[12]==5){
			gp.aa=new achieveanimation(gp,"renpincha");
			gp.pl.Temp[12]++;
		}
	
	}

}
