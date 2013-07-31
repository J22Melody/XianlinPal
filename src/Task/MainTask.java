package Task;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import animation.promptanimation;

import Controler.MainControler;
import FightSystem.FighterUpdater;
import FightSystem.Introducer;
import Main.GamePanel;
import Main.Map;

public class MainTask {

	public GamePanel gp;
	
	//是否在进行
	public boolean going;
	
	//进度
	public int level;
	
	public ArrayList<String> dialog;

	public int count;
	
	
	
	public MainTask(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();
        count=0;

	}
	


	//获得任务提示
	public String getintroduction() {
		String temp=null;
        if(level==36){
        	temp="开学的第一天，对这里的一切都还很新奇，心情好的话可以出门随便逛逛，实在无聊可以翻看翻看《学生手册》，如果累了什么都不想做的话，就在宿舍的床上美美地睡一觉吧！";
        	}
        if(level==69){
        	temp="第一天就迟到了，快赶去仙二教学楼！";
        	}
        if(level==100){
        	temp="紧张的学习生活开始了，不同地点不同的NPC处可以进行不同的修炼，努力提高自己的各项属性吧，别忘了7天后的测试喔！记住，7天，也就是说你只有7次睡觉的机会(还剩"+(7-gp.pl.Temp[0])+"次）";
        }
        if(level==101){
            temp="7天到了，快去老师刘的办公室（逸夫楼内）接受检验吧(需战斗）";
        }
        if(level==147){
        	temp="快去找何小婉吧，听她在电话里说的，她可能自己去了后山，后山就在学校的北边。";
        }
        if(level==170){
        	temp="前往后山深处寻找杨枳。";
        }
        if(level==249){
        	temp="何小婉经不住杨枳的死缠烂打，秦舢更经不住何小婉的死缠烂打。罢了，就帮欧阳歆这一把吧，虽然不知能不能帮得上，先去找老师刘。";
        }
        if(level==261){
        	temp="花5天时间努力提升3人的能力，5天后去找老师刘接受考验。";
        }
        if(level==262){
        	temp="经过这段时间的学习，大家多多少少有了进步，去逸夫楼找老师刘，看看下一步怎么做(需战斗）。";
        }
        if(level==268){
        	temp="终于可以开始了，去机房与欧阳歆会合。";
        }
        if(level==306){
        	temp="去逸夫楼问问老师刘下来到底如何做。";
        }
        if(level==313){
        	temp="去机房最大的机器(进门右手边）上开始工作吧（需战斗）。";
        }
        if(level==319){
        	temp="把硬盘交给老师刘，小心别弄丢了。";
        }
        if(level==346){
        	temp="前往红猫大学一探究竟，从校门口乘地铁。";
        }
        if(level==449){
        	temp="不管如何，去图书馆看看吧，就当是最后一点希望。";
        }
        if(level>=467&&level<=474){
        	temp="那个老人家又闪了，图书馆的这个地方似乎从没听人说起过。书架上已经积了一层厚厚的灰，隐然感觉有光芒溢出。只记得老人家说要按顺序找到并读完八卷书，甚至连书名也没有交待。("+(level-467)+"/8)";
        }
        if(level==496){
        	temp="快去机房找何小婉他们吧。";
        }
        
		return temp;

	}

	//是否可触发对话
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			temp=true;
			break;
		case 36:
			if((gp.pl.scene==11&&gp.pl.direction==MainControler.RIGHT&&gp.pl.locX==20&&gp.pl.locY==21)||(gp.pl.scene==11&&gp.pl.direction==MainControler.UP&&gp.pl.locX==21&&gp.pl.locY==22)){
				temp=true;
			}
			break;
		case 69:
			if(gp.pl.scene==13&&gp.pl.locX==14&&gp.pl.locY==13){
				temp=true;
			}
			break;
		case 101:
			if(gp.scene==17&&((gp.pl.locX==19&&gp.pl.locY==15&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==20&&gp.pl.locY==16&&gp.pl.direction==MainControler.UP))){
				temp=true;
			}
			gp.pl.roles.get(8).headtoplayer();
			break;
		case 147:
			if(gp.scene==10&&gp.pl.direction==MainControler.UP&&gp.pl.locX==52&&gp.pl.locY==41){
				temp=true;
			}
			break;
		case 170:
			if(gp.pl.scene==28&&gp.pl.mt.level==170&&gp.pl.locX==78&&gp.pl.locY==38){
				temp=true;
				gp.pl.direction=MainControler.DOWN;
				gp.pl.roles.get(5).scene=28;
				gp.pl.roles.get(5).locX=78;
				gp.pl.roles.get(5).locY=40;
				gp.pl.roles.get(5).direction=MainControler.UP;
				gp.pl.roles.get(6).scene=28;
				gp.pl.roles.get(6).locX=79;
				gp.pl.roles.get(6).locY=21;
				gp.pl.roles.get(6).direction=MainControler.UP;
				gp.pl.roles.get(10).scene=28;
				gp.pl.roles.get(10).locX=79;
				gp.pl.roles.get(10).locY=19;
				gp.pl.roles.get(10).direction=MainControler.DOWN;
			}
			break;
		case 249:
			if(gp.scene==17&&((gp.pl.locX==19&&gp.pl.locY==15&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==20&&gp.pl.locY==16&&gp.pl.direction==MainControler.UP))){
				temp=true;
				gp.pl.roles.get(5).locX=18;
				gp.pl.roles.get(5).locY=15;
				gp.pl.roles.get(5).direction=MainControler.RIGHT;
				gp.pl.roles.get(5).scene=17;
				gp.pl.roles.get(6).locX=17;
				gp.pl.roles.get(6).locY=15;
				gp.pl.roles.get(6).direction=MainControler.RIGHT;
				gp.pl.roles.get(6).scene=17;
				gp.pl.roles.get(8).headtoplayer();
				
			}
			
			break;
		case 262:
			if(gp.scene==17&&((gp.pl.locX==19&&gp.pl.locY==15&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==20&&gp.pl.locY==16&&gp.pl.direction==MainControler.UP))){
				temp=true;
				gp.pl.roles.get(5).locX=18;
				gp.pl.roles.get(5).locY=15;
				gp.pl.roles.get(5).direction=MainControler.RIGHT;
				gp.pl.roles.get(5).scene=17;
				gp.pl.roles.get(6).locX=17;
				gp.pl.roles.get(6).locY=15;
				gp.pl.roles.get(6).direction=MainControler.RIGHT;
				gp.pl.roles.get(6).scene=17;
				gp.pl.roles.get(8).headtoplayer();
				
			}
			break;
		case 268:
			if(gp.scene==16&&gp.pl.locX==20&&gp.pl.locY==28&&gp.pl.direction==MainControler.UP){
				temp=true;
				gp.pl.wholeads=1;
				gp.pl.roles.get(7).direction=MainControler.DOWN;
				gp.pl.roles.get(5).locX=21;
				gp.pl.roles.get(5).locY=28;
				gp.pl.roles.get(5).direction=MainControler.UP;
				gp.pl.roles.get(5).scene=16;
				gp.pl.roles.get(6).locX=22;
				gp.pl.roles.get(6).locY=28;
				gp.pl.roles.get(6).direction=MainControler.UP;
				gp.pl.roles.get(6).scene=16;
				gp.pl.roles.get(8).locX=19;
				gp.pl.roles.get(8).locY=28;
				gp.pl.roles.get(8).direction=MainControler.UP;
				gp.pl.roles.get(8).scene=16;
			}
			break;
		case 306:
			if(gp.scene==17&&((gp.pl.locX==19&&gp.pl.locY==15&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==20&&gp.pl.locY==16&&gp.pl.direction==MainControler.UP))){
				temp=true;
				gp.pl.roles.get(5).locX=17;
				gp.pl.roles.get(5).locY=15;
				gp.pl.roles.get(5).direction=MainControler.RIGHT;
				gp.pl.roles.get(5).scene=17;
				gp.pl.roles.get(6).locX=16;
				gp.pl.roles.get(6).locY=15;
				gp.pl.roles.get(6).direction=MainControler.RIGHT;
				gp.pl.roles.get(6).scene=17;
				gp.pl.roles.get(7).locX=18;
				gp.pl.roles.get(7).locY=15;
				gp.pl.roles.get(7).direction=MainControler.RIGHT;
				gp.pl.roles.get(7).scene=17;
				gp.pl.roles.get(8).headtoplayer();
			}
			break;
		case 313:
			if(gp.scene==16&&gp.pl.locX==26&&gp.pl.locY==20&&gp.pl.direction==MainControler.UP){
				temp=true;
				gp.pl.wholeads=1;
				gp.pl.roles.get(5).locX=26;
				gp.pl.roles.get(5).locY=21;
				gp.pl.roles.get(5).direction=MainControler.UP;
				gp.pl.roles.get(5).scene=16;
				gp.pl.roles.get(6).locX=27;
				gp.pl.roles.get(6).locY=21;
				gp.pl.roles.get(6).direction=MainControler.UP;
				gp.pl.roles.get(6).scene=16;
				gp.pl.roles.get(7).locX=27;
				gp.pl.roles.get(7).locY=20;
				gp.pl.roles.get(7).direction=MainControler.UP;
				gp.pl.roles.get(7).scene=16;
			}
			break;
		case 449:
			if(gp.scene==30&&((gp.pl.locX==21&&gp.pl.locY==16&&gp.pl.direction==MainControler.LEFT)||(gp.pl.locX==20&&gp.pl.locY==17&&gp.pl.direction==MainControler.UP))){
				temp=true;
			}
			break;
		case 467:
			if(gp.scene==25&&gp.pl.locX==22&&gp.pl.locY==13&&gp.pl.direction==MainControler.UP){
				level++;
				gp.pa=new promptanimation(gp,"发现并阅读卷一");
			}
			break;
		case 468:
			if(gp.scene==25&&gp.pl.locX==65&&gp.pl.locY==13&&gp.pl.direction==MainControler.UP){
				level++;
				gp.pa=new promptanimation(gp,"发现并阅读卷二");
			}
			break;
		case 469:
			if(gp.scene==25&&gp.pl.locX==106&&gp.pl.locY==13&&gp.pl.direction==MainControler.UP){
				level++;
				gp.pa=new promptanimation(gp,"发现并阅读卷三");
			}
			break;
		case 470:
			if(gp.scene==25&&gp.pl.locX==16&&gp.pl.locY==46&&gp.pl.direction==MainControler.LEFT){
				level++;
				gp.pa=new promptanimation(gp,"发现并阅读卷四");
			}
			break;
		case 471:
			if(gp.scene==25&&gp.pl.locX==57&&gp.pl.locY==46&&gp.pl.direction==MainControler.UP){
				level++;
				gp.pa=new promptanimation(gp,"发现并阅读卷五");
			}
			break;
		case 472:
			if(gp.scene==25&&gp.pl.locX==106&&gp.pl.locY==46&&gp.pl.direction==MainControler.RIGHT){
				level++;
				gp.pa=new promptanimation(gp,"发现并阅读卷六");
			}
			break;
		case 473:
			if(gp.scene==25&&gp.pl.locX==24&&gp.pl.locY==87&&gp.pl.direction==MainControler.DOWN){
				level++;
				gp.pa=new promptanimation(gp,"发现并阅读卷七");
			}
			break;
		case 474:
			if(gp.scene==25&&gp.pl.locX==65&&gp.pl.locY==85&&gp.pl.direction==MainControler.RIGHT){
				gp.pa=new promptanimation(gp,"发现并阅读卷八");
				temp=true;
			}
			break;
		}
	
		return temp;	
	}
	
	//触发
	public void update(){
		if(CanGo()){
			gp.pl.wholeads=1;
			gp.pl.isMoving=false;
			going=true;
			gp.scene=200;
			
		}
	}
	
	//剧情发展
	public void next(){
		switch(level){
		case 9:
			gp.scene=103;
			break;
		case 13:
			gp.scene=104;
			break;
		case 23:
			//设置舍友状态
			gp.pl.roles.get(2).scene=11;
			gp.pl.roles.get(2).locX=27;
			gp.pl.roles.get(2).locY=20;
			gp.pl.roles.get(2).direction=MainControler.DOWN;
			gp.pl.roles.get(2).isMoving=false;	
			
			gp.pl.roles.get(3).scene=11;
			gp.pl.roles.get(3).locX=29;
			gp.pl.roles.get(3).locY=19;
			gp.pl.roles.get(3).direction=MainControler.DOWN;
			gp.pl.roles.get(3).isMoving=false;	
			
			gp.pl.roles.get(4).scene=11;
			gp.pl.roles.get(4).locX=21;
			gp.pl.roles.get(4).locY=19;
			gp.pl.roles.get(4).direction=MainControler.DOWN;
			gp.pl.roles.get(4).isMoving=false;	
			
			gp.scene=106;	
			break;
		case 24:
			gp.scene=107;
			break;
		case 27:
			gp.pl.roles.get(3).direction=MainControler.LEFT;
			break;
		case 28:
			gp.pl.roles.get(4).direction=MainControler.RIGHT;
			gp.pl.direction=MainControler.LEFT;
			break;
		case 30:
			gp.pl.roles.get(4).direction=MainControler.DOWN;
			gp.pl.roles.get(3).direction=MainControler.DOWN;
			gp.pl.direction=MainControler.RIGHT;
			break;
		case 31:
			gp.scene=108;
			break;
		case 33:
			gp.scene=109;
			break;
		case 35:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 36:
			gp.scene=110;
			break;
		case 43:
			gp.pl.roles.get(5).direction=MainControler.UP;
			break;
		case 51:
			gp.pl.roles.get(6).direction=MainControler.UP;
			break;
		case 52:
			gp.pl.roles.get(5).direction=MainControler.LEFT;
			break;
		case 55:
			gp.pl.roles.get(6).direction=MainControler.RIGHT;
			break;
		case 56:
			gp.scene=111;
			break;
		case 66:
			gp.scene=112;
			break;
		case 68:
			gp.scene=gp.pl.scene;
			going=false;
			gp.pl.roles.get(7).disappear();
			gp.pa=new promptanimation(gp,"任务有更新");
			break;
		case 69:
			gp.pl.roles.get(8).direction=MainControler.LEFT;
			break;
		case 75:
			gp.scene=113;
			break;
		case 78:
			gp.pl.roles.get(6).direction=MainControler.RIGHT;
			break;
		case 80:
			gp.pl.roles.get(5).direction=MainControler.LEFT;
			break;
		case 82:
			gp.pl.roles.get(5).direction=MainControler.UP;
			break;
		case 83:
			gp.pl.roles.get(6).direction=MainControler.UP;
			break;
		case 86:
			gp.scene=114;
			break;
		case 93:
			gp.scene=115;
			break;
		case 99:
			gp.scene=gp.pl.scene;
			gp.pl.Temp[0]=0;
			gp.pl.Temp[1]=0;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		//战斗
		case 103:
			gp.pl.introducer=new Introducer(gp,true,false,false,false,0,1);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 106:
		    gp.scene=121;
			break;
		case 111:
			gp.scene=122;
			break;
		case 128:
			gp.scene=123;
			break;
		case 137:
			gp.pl.scene=12;
			gp.pl.locX=21;
			gp.pl.locY=21;
			gp.pl.exist=false;
			gp.pl.roles.get(5).scene=12;
			gp.pl.roles.get(5).locX=20;
			gp.pl.roles.get(5).locY=21;
			gp.pl.roles.get(5).direction=MainControler.DOWN;
			gp.map=new Map(gp);
			break;
		case 141:
			gp.pl.roles.get(5).disappear();
			gp.pl.scene=11;
			gp.pl.locX=23;
			gp.pl.locY=22;
			gp.pl.exist=true;
			gp.map=new Map(gp);
			break;
		case 144:
			gp.scene=124;
			break;
		case 145:
			gp.scene=125;
			break;
		case 146:
			gp.scene=gp.pl.scene;
			gp.pl.roles.get(7).disappear();
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 152:
			gp.pl.introducer=new Introducer(gp,true,false,false,false,0,2);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			gp.pl.locY-=2;
			gp.pl.locX--;
			gp.pl.direction=MainControler.LEFT;
			gp.pl.roles.get(5).direction=MainControler.LEFT;
			gp.pl.roles.get(5).locX=42;
			gp.pl.roles.get(5).locY=37;
			gp.pl.roles.get(5).scene=10;
			break;
		case 156:
			gp.pl.roles.get(5).direction=MainControler.RIGHT;
			break;
		case 159:
			gp.scene=126;
			break;
		case 169:
			gp.pl.roles.get(5).disappear();
			gp.pl.TeamNum=2;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 173:
			gp.scene=127;
			break;
		case 175:
			gp.pl.TeamNum=3;
			gp.pl.introducer=new Introducer(gp,true,true,true,false,0,3);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			gp.pl.roles.get(10).disappear();
			gp.pl.roles.get(7).scene=28;
			gp.pl.roles.get(7).locX=75;
			gp.pl.roles.get(7).locY=25;
			gp.pl.roles.get(7).direction=MainControler.RIGHT;
			gp.pl.roles.get(6).direction=MainControler.DOWN;
			break;
		case 190:
			gp.scene=128;
			break;
		case 191:
			gp.scene=129;
			break;
		case 211:
			gp.scene=130;
			gp.pl.roles.get(7).disappear();
			break;
		case 234:
			gp.scene=131;
			break;
		case 248:
			gp.pl.TeamNum=3;
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 256:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.scene=132;
			break;
		case 259:
			gp.pl.roles.get(7).disappear();
			gp.pl.roles.get(8).disappear();
			gp.scene=133;
			break;
		case 260:			
			gp.pl.Temp[0]=0;
			gp.pl.Temp[1]=0;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			gp.pl.roles.get(7).direction=MainControler.UP;
			gp.pl.roles.get(7).locX=96;
			gp.pl.roles.get(7).locY=86;
			gp.pl.roles.get(7).scene=10;
			going=false;
			break;			
		case 264:
			gp.pl.introducer=new Introducer(gp,true,true,true,false,0,4);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 267:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.pl.roles.get(8).disappear();
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;	
		case 274:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(8).disappear();
			gp.pl.roles.get(7).direction=MainControler.RIGHT;
			gp.pl.exist=false;
			break;
		case 275:
			gp.pl.roles.get(6).direction=MainControler.LEFT;
			break;
		case 276:
			gp.pl.roles.get(7).direction=MainControler.RIGHT;
			break;
		case 287:
			gp.scene=135;
			break;
		case 304:
			gp.pl.roles.get(6).disappear();
			gp.pl.roles.get(7).disappear();
			gp.scene=136;
			break;
		case 305:
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;	
		case 312:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.pl.roles.get(7).disappear();
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 313:
			gp.pl.introducer=new Introducer(gp,true,true,true,true,0,5);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 318:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.pl.roles.get(7).disappear();
			gp.pl.TeamNum=1;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 345:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.pl.roles.get(7).disappear();
			gp.pl.roles.get(8).disappear();
			gp.pl.TeamNum=4;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 346:
			gp.scene=140;
			break;
		case 352:
			gp.pl.roles.get(12).direction=MainControler.LEFT;
			break;
		case 358:
			gp.pl.introducer=new Introducer(gp,true,true,true,true,0,6);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 364:
			gp.pl.roles.get(12).disappear();
			gp.pl.roles.get(13).disappear();
			gp.pl.roles.get(14).disappear();
			break;
		case 365:
			gp.scene=141;
			break;
		case 366:
			gp.pl.direction=MainControler.LEFT;
			gp.pl.roles.get(5).direction=MainControler.LEFT;
			gp.pl.roles.get(6).direction=MainControler.LEFT;
			gp.pl.roles.get(7).direction=MainControler.LEFT;
			break;
		case 400:
			gp.pl.introducer=new Introducer(gp,true,true,true,true,0,7);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 403:
			gp.pl.roles.get(8).disappear();
			break;
		case 404:
			gp.pl.roles.get(6).direction=MainControler.RIGHT;
			break;
		case 405:
			gp.pl.roles.get(5).direction=MainControler.RIGHT;
			break;
		case 423:
			gp.pl.roles.get(5).disappear();
			gp.pl.roles.get(6).disappear();
			gp.pl.roles.get(7).disappear();
			gp.pl.TeamNum=1;
			gp.pl.wholeads=1;
			gp.pl.scene=31;
			gp.pl.locX=61;
			gp.pl.locY=34;
			gp.pl.exist=false;
			gp.pl.roles.get(8).locX=61;
			gp.pl.roles.get(8).locY=34;
			gp.pl.roles.get(8).scene=31;
			gp.pl.roles.get(8).direction=MainControler.DOWN;
			gp.map=new Map(gp);
			break;
		case 426:
			gp.scene=142;
			break;
		case 430:
			gp.pl.scene=29;
			gp.map=new Map(gp);
			gp.scene=143;
			break;
		case 439:
			gp.pl.scene=11;
			gp.map=new Map(gp);
			break;
		case 448:
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 451:
			gp.pl.introducer=new Introducer(gp,true,false,false,false,0,8);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 462:
			gp.pl.scene=25;
			gp.map=new Map(gp);
			gp.pl.locX=20;
		    gp.pl.locY=14;
			break;
		case 466:
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 476:
			gp.pl.scene=30;
			gp.map=new Map(gp);
			gp.pl.locX=20;
			gp.pl.locY=17;
			gp.pl.direction=MainControler.UP;
			break;
		case 484:
			gp.pl.introducer=new Introducer(gp,true,false,false,false,0,9);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			break;
		case 492:
			gp.scene=144;
			break;
		case 495:
			gp.pl.roles.get(7).locX=28;
			gp.pl.roles.get(7).locX=20;
			gp.pl.roles.get(7).direction=MainControler.UP;
			gp.pl.roles.get(7).scene=16;
			
			gp.pl.roles.get(6).locX=27;
			gp.pl.roles.get(6).locX=20;
			gp.pl.roles.get(6).direction=MainControler.UP;
			gp.pl.roles.get(6).scene=16;
			
			gp.pl.roles.get(5).locX=26;
			gp.pl.roles.get(5).locX=20;
			gp.pl.roles.get(5).direction=MainControler.UP;
			gp.pl.roles.get(5).scene=16;
			
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"任务有更新");
			going=false;
			break;
		case 496:
			gp.pl.roles.get(7).direction=MainControler.RIGHT;
			gp.pl.roles.get(6).direction=MainControler.RIGHT;
			gp.pl.roles.get(5).direction=MainControler.RIGHT;
			break;
		case 506:
			gp.scene=145;
			break;
		case 524:
			gp.pl.introducer=new Introducer(gp,true,false,false,false,3,10);
			gp.pl.updater=new FighterUpdater(gp);
			gp.scene=80;
			gp.pa=new promptanimation(gp,"进入战斗");
			gp.scene=146;
			break;
		case 526:
			gp.pl.exist=false;
			gp.pl.scene=12;
			gp.pl.locX=21;
			gp.pl.locY=21;
			gp.pl.direction=MainControler.DOWN;
			gp.pl.roles.get(5).scene=12;
			gp.pl.roles.get(5).locX=21;
			gp.pl.roles.get(5).locY=21;
			gp.pl.roles.get(5).direction=MainControler.DOWN;
			gp.map=new Map(gp);
			break;
		case 528:
			gp.scene=147;
			break;
		case 554:
			gp.scene=148;
			break;
		}
		level++;
		
		for(int i=0;i<gp.pl.roles.size();i++){
			gp.pl.roles.get(i).getwords();
		}
	}

	//剧情绘制
    public void draw(Graphics g){
	
		
		//对话	
		if(gp.scene==200){
			g.drawImage(Method.ImageReader.work("menu/talk"),100,330,null);
			
			String s=dialog.get(level);
			int x=33;
			int i=0;
			
			int k=s.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=s.substring(i*x,(i+1)*x);
				}else{
					temp=s.substring(i*x,s.length());
				}
				g.drawString(temp,200,390+20*i);
			}
			
			//改变控制状态
			if(count!=0){
				if(count==4){
					count=0;
				}else{
					count++;
				}
			}
		}
	}
	
	//获取主线所有对话
    public void getdialog() {
    	dialog=new ArrayList<String>();
	
    	try {
			BufferedReader reader = new BufferedReader(new FileReader("script/task/MainTask.txt"));	
			
			while(true){
				String s = reader.readLine();
				if(s==null){
					break;
				}else{
					dialog.add(s);
				}
			}			
			
			reader.close();
			reader=null;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
