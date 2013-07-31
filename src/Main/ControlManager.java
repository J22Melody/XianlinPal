package Main;


import Controler.*;
import FightSystem.FightControler;


public class ControlManager {
	//记录此时场景
	public int state;
	
	
	public ControlManager(){
		//初始化为登陆界面
		state=0;
	}
	
	//选择控制器
	public void work(GamePanel gp){

		if(gp.scene!=state){
			state=gp.scene;

			if(state==0){
				gp.removeKeyListener(gp.kl);
				gp.kl=new LoginControler(gp);
				gp.addKeyListener(gp.kl);
			}
				
			if(state==50){
				gp.removeKeyListener(gp.kl);
				gp.kl=new MainMenuControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==51){
				gp.removeKeyListener(gp.kl);
				gp.kl=new ConditionMenuControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==52){
				gp.removeKeyListener(gp.kl);
				gp.kl=new ItemMenuControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==53){
				gp.removeKeyListener(gp.kl);
				gp.kl=new ItemFunctionControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==54){
				gp.removeKeyListener(gp.kl);
				gp.kl=new ItemChooseControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==55){
				gp.removeKeyListener(gp.kl);
				gp.kl=new ItemUseControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==56){
				gp.removeKeyListener(gp.kl);
				gp.kl=new SkillMenuControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==57){
				gp.removeKeyListener(gp.kl);
				gp.kl=new TaskMenuControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			
			if(state==58){
				gp.removeKeyListener(gp.kl);
				gp.kl=new SystemMenuControler(gp);
				gp.addKeyListener(gp.kl);
			}
				
			if(state==59){
				gp.removeKeyListener(gp.kl);
				gp.kl=new SaveMenuControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==60){
				gp.removeKeyListener(gp.kl);
				gp.kl=new LoadMenuControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==61){
				gp.removeKeyListener(gp.kl);
				gp.kl=new MusicControler(gp);
				gp.addKeyListener(gp.kl);
			
			}
			
			if(state==62){
				gp.removeKeyListener(gp.kl);
				gp.kl=new SoundControler(gp);
				gp.addKeyListener(gp.kl);
			
			}
			
			if(state==70){
				gp.removeKeyListener(gp.kl);
				gp.kl=new TalkControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==71){
				gp.removeKeyListener(gp.kl);
				gp.kl=new JumpControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==72){
				gp.removeKeyListener(gp.kl);
				gp.kl=new RoleTalkControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if((state>=10&&state<=49)||(state==99))	{			
				gp.removeKeyListener(gp.kl);
				gp.kl=new MainControler(gp);
				gp.addKeyListener(gp.kl);
			}
			if(state==80){
				gp.removeKeyListener(gp.kl);
				gp.kl=new FightControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==81){
				gp.removeKeyListener(gp.kl);
				gp.kl=new huazhongdianControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==82){
				gp.removeKeyListener(gp.kl);
				gp.kl=new BanZhuanControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==83){
				gp.removeKeyListener(gp.kl);
				gp.kl=new dakaControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==84){
				gp.removeKeyListener(gp.kl);
				gp.kl=new BanHuaControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if((state>=90&&state<200)||state==300){
				gp.removeKeyListener(gp.kl);
				gp.kl=new NullControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==148){
				gp.removeKeyListener(gp.kl);
				gp.kl=new FinalControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==200){
				gp.removeKeyListener(gp.kl);
				gp.kl=new MainTaskControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==201){
				gp.removeKeyListener(gp.kl);
				gp.kl=new OptionalTask1Controler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==202){
				gp.removeKeyListener(gp.kl);
				gp.kl=new OptionalTask2Controler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==203){
				gp.removeKeyListener(gp.kl);
				gp.kl=new OptionalTask3Controler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==204){
				gp.removeKeyListener(gp.kl);
				gp.kl=new OptionalTask4Controler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			
			if(state==205){
				gp.removeKeyListener(gp.kl);
				gp.kl=new OptionalTask5Controler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==206){
				gp.removeKeyListener(gp.kl);
				gp.kl=new OptionalTask6Controler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==207){
				gp.removeKeyListener(gp.kl);
				gp.kl=new OptionalTask7Controler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==208){
				gp.removeKeyListener(gp.kl);
				gp.kl=new OptionalTask8Controler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==209){
				gp.removeKeyListener(gp.kl);
				gp.kl=new dakaControler(gp);
				gp.addKeyListener(gp.kl);
			}
			
			if(state==210){
				gp.removeKeyListener(gp.kl);
				gp.kl=new PaoTuiControler(gp);
				gp.addKeyListener(gp.kl);
			}
	
			
		
		
		}
	}
}
