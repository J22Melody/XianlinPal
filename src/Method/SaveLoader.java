package Method;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Main.GamePanel;
import Main.Map;
import Main.Player;
import Role.*;

public abstract class SaveLoader {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void work(GamePanel gp,int a){
		
		
		
		ArrayList data=new ArrayList();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("script/save/"+a+".txt"));	
			
			while(true){
				String s = reader.readLine();
				if(s==null){
					break;
				}else{
					int n=Integer.parseInt(s);
					data.add(n);
				}
			}			
			
		
			
			reader.close();
			reader=null;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        if((int)data.size()!=0){
        	//还原登陆菜单
            gp.lm.state=0;
	        gp.lm.SubState=0;
	        gp.lm.SubMenuExist=false;
	        
        	gp.pl=new Player(gp);
        	
        	gp.pl.scene=(int) data.get(0);
        	gp.pl.TeamNum=(int) data.get(1);
    		gp.pl.locX=(int) data.get(2);
    		gp.pl.locY=(int) data.get(3);
    		gp.pl.direction=(int) data.get(4);
    		gp.pl.count=(int) data.get(5);
    		gp.pl.wholeads=(int) data.get(6);
    		gp.pl.Money=(int) data.get(7);
    		gp.pl.speed=(int) data.get(8);
    		
    		gp.pl.hp=(int) data.get(9);
    		gp.pl.mp=(int) data.get(10);
    		gp.pl.sp=(int) data.get(11);
    		gp.pl.RP=(int) data.get(12);
    		gp.pl.IQ=(int) data.get(13);
    		gp.pl.ST=(int) data.get(14);
    		gp.pl.GPA=(int) data.get(15);
    		gp.pl.VP=(int) data.get(16);
    		
    		gp.pl.hp2=(int) data.get(17);
    		gp.pl.mp2=(int) data.get(18);
    		gp.pl.sp2=(int) data.get(19);
    		gp.pl.RP2=(int) data.get(20);
    		gp.pl.IQ2=(int) data.get(21);
    		gp.pl.ST2=(int) data.get(22);
    		gp.pl.GPA2=(int) data.get(23);
    		gp.pl.VP2=(int) data.get(24);
    		
    		gp.pl.hp3=(int) data.get(25);
    		gp.pl.mp3=(int) data.get(26);
    		gp.pl.sp3=(int) data.get(27);
    		gp.pl.RP3=(int) data.get(28);
    		gp.pl.IQ3=(int) data.get(29);
    		gp.pl.ST3=(int) data.get(30);
    		gp.pl.GPA3=(int) data.get(31);
    		gp.pl.VP3=(int) data.get(32);
    		
    		gp.pl.hp4=(int) data.get(33);
    		gp.pl.mp4=(int) data.get(34);
    		gp.pl.sp4=(int) data.get(35);
    		gp.pl.RP4=(int) data.get(36);
    		gp.pl.IQ4=(int) data.get(37);
    		gp.pl.ST4=(int) data.get(38);
    		gp.pl.GPA4=(int) data.get(39);
    		gp.pl.VP4=(int) data.get(40);
    		
    		for(int i=41;i<61;i++){
    			if((int)data.get(i)==0){
    				break;
    			}else{
    				gp.pl.Bag.add(LoadItem.work((int)data.get(i),i-41,gp));
    			}
    		}

    		//剧情
    		gp.pl.mt.level=(int)data.get(61);
    		gp.pl.ot1.level=(int)data.get(62);
    		gp.pl.ot2.level=(int)data.get(63);
    		gp.pl.ot3.level=(int)data.get(64);
    		gp.pl.ot4.level=(int)data.get(65);
    		gp.pl.ot5.level=(int)data.get(66);
    		gp.pl.ot6.level=(int)data.get(67);
    		gp.pl.ot7.level=(int)data.get(68);
    		gp.pl.ot8.level=(int)data.get(69);
    		gp.pl.DK.level=(int)data.get(70);
    		gp.pl.PT.level=(int)data.get(71);
    		
    		//临时计数器
    		for(int i=0;i<100;i++){
    			gp.pl.Temp[i]=(int)data.get(72+i);
    		}

    		
    		//地图
    		gp.scene=gp.pl.scene;
    		gp.map=new Map(gp);
    		
    		//人物
    		gp.pl.roles.add(new mum(gp));
    		gp.pl.roles.add(new dad(gp));
    		gp.pl.roles.add(new wangzikai(gp));
    		gp.pl.roles.add(new jiangqiang(gp));
    		gp.pl.roles.add(new libin(gp));
    		gp.pl.roles.add(new role2(gp));
    		gp.pl.roles.add(new role3(gp));
    		gp.pl.roles.add(new role4(gp));
    		gp.pl.roles.add(new teatherliu(gp));
    		gp.pl.roles.add(new teachershao(gp));
    		gp.pl.roles.add(new wolf(gp));
    		gp.pl.roles.add(new wangqiang(gp));
    		gp.pl.roles.add(new zhangmingqiang(gp));
    		gp.pl.roles.add(new tangxin(gp));
    		gp.pl.roles.add(new jiangshun(gp));
    
        }
		
		

	}

}
