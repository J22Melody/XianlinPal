package Main;

import FightSystem.FightPainter;
import Painter.*;

public class PainterManager {
	//记录此时场景
	public int state;
	
	
	public PainterManager(){
		//初始化为登陆界面
		state=0;
	}
	
	//选择绘图器
	public void work(GamePanel gp){

		if(gp.scene!=state){
			state=gp.scene;

			if(state==0){
				gp.pr=new LoginPainter(gp);
			}
				
            if(state>=50&&state<=69){
            	gp.pr=new MainMenuPainter(gp);
            }
         
            if((state>=10&&state<=49)||(state==99)||(state>=200)){
            	gp.pr=new MainPainter(gp);
            }
				
            if(state==80){
            	gp.pr=new FightPainter(gp);
            }
            
            if(state==81){
            	gp.pr=new huazhongdianPainter(gp);
            }
            
            if(state==82){
            	gp.pr=new banzhuanPainter(gp);
            }
            
            if(state==83){
            	gp.pr=new dakaPainter(gp);
            }
            
            if(state==84){
            	gp.pr=new banhuaPainter(gp);
            }
            
            if((state>=90&&state<200)||state==300){
            	gp.pr=new ScreenPainter(gp);
            }
      
			
		}
		
	}

}
