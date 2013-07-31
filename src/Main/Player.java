package Main;

import java.awt.Graphics;
import java.util.ArrayList;

import Controler.MainControler;
import FightSystem.FighterUpdater;
import FightSystem.Introducer;
import InterFaceAndAbstractClass.Role;
import SmallGame.*;
import Task.*;


public class Player {
	public GamePanel gp;
	
	public final static int sizeX=32;
	public final static int sizeY=48;
	
	//关于战斗
	public Introducer introducer;
	public FighterUpdater updater;
	
	//小游戏
	public huazhongdian hzd;
	public banzhuan bz;
	public banhua bh;
	public daka dk;
	
	/*-------------------------从文件中读取的数据--------------------------------*/
	
	//场景
	public int scene;
	
	//队伍人数
    public int TeamNum;

	//坐标
	public int locX;
	public int locY;
	//方向
	public int direction;
    //行走态
	public int count;

	
	//队伍带头人（1、2、3、4）
	public int wholeads;

	//钱
	public int Money;
	//移动速度
	public int speed;
	
	//角色一（秦舢）属性
	//当前气血	
	public int hp;
	//当前精力
	public int mp;
	//当前体力
	public int sp;
	//人品
	public int RP;
	//智商
	public int IQ;
	//体质
	public int ST;
	//学分绩
	public int GPA;
	//反应力
	public int VP;
	
	//角色二（何小婉）属性
	public int hp2;
	public int mp2;
	public int sp2;
	public int RP2;
	public int IQ2;
	public int ST2;
	public int GPA2;	
	public int VP2;
	
	//角色三（杨枳）属性
	public int hp3;
	public int mp3;
	public int sp3;
	public int RP3;
	public int IQ3;
	public int ST3;
	public int GPA3;
	public int VP3;
	
	//角色四（欧阳歆）属性
	public int hp4;
	public int mp4;
	public int sp4;
	public int RP4;
	public int IQ4;
	public int ST4;
	public int GPA4;
	public int VP4;

	//物品栏状态
	public ArrayList<Item> Bag;
	
	//主线剧情
	public MainTask mt;
	
	//支线剧情
	public OptionalTask1 ot1;
	public OptionalTask2 ot2;
	public OptionalTask3 ot3;
	public OptionalTask4 ot4;
	public OptionalTask5 ot5;
	public OptionalTask6 ot6;
	public OptionalTask7 ot7;
	public OptionalTask8 ot8;
	public DaKa DK;
	public PaoTui PT;
	
	//备用计数器
	public int[] Temp;
	
	//其他任务
	
	/*-------------------------计算得到的数据--------------------------------*/
	
	
	//气血上限
	public int HP;
	//精力上限
	public int MP;
	//体力上限
	public int SP;
	//爆发力
	public int EP;
	
	public int HP2;
	public int MP2;
	public int SP2;
	public int EP2;
	
	public int HP3;
	public int MP3;
	public int SP3;
	public int EP3;

	public int HP4;
	public int MP4;
	public int SP4;
	public int EP4;
	
	//剧情人物
	public ArrayList<Role> roles;
	
	/*------------------------华丽的分割线--------------------------------*/
	
	
	//可否移动
	public boolean movable;
	//是否在移动
	public boolean isMoving;

	//是否和某个NPC或Jump对话(-1代表无）
	public int talkwith;
	
	//防止过快对话
	public int talkcount;

	//用于剧情过程中主角不在时
	public boolean exist;





	
	
	//玩家构造方法
	public Player(GamePanel Gp){
		gp=Gp;
		movable=true;
		isMoving=false;
		talkwith=-1;
		exist=true;
		
		mt=new MainTask(gp);
		ot1=new OptionalTask1(gp);
		ot2=new OptionalTask2(gp);
		ot3=new OptionalTask3(gp);
		ot4=new OptionalTask4(gp);
		ot5=new OptionalTask5(gp);
		ot6=new OptionalTask6(gp);
		ot7=new OptionalTask7(gp);
		ot8=new OptionalTask8(gp);
		DK=new DaKa(gp);
		PT=new PaoTui(gp);
		
		Bag=new ArrayList<Item>();
		
		roles=new ArrayList<Role>();
		
		Temp=new int[100];



	}
	
	public void draw(Graphics g) {


		for(int i=0;i<roles.size();i++){
			roles.get(i).draw(g);
		}
		
		if(exist){
			if(isMoving){
				g.drawImage(Method.ImageReader.work("role/role"+wholeads),GameFrame.WIDTH/2,GameFrame.HEIGHT/2-sizeY/2+5,GameFrame.WIDTH/2+sizeX,GameFrame.HEIGHT/2+sizeY/2+5,count*sizeX,direction*sizeY,count*sizeX+sizeX,direction*sizeY+sizeY,null);	
			}else{
				if(count==0||count==1){count=0;}
				if(count==2||count==3){count=2;}
				g.drawImage(Method.ImageReader.work("role/role"+wholeads),GameFrame.WIDTH/2,GameFrame.HEIGHT/2-sizeY/2+5,GameFrame.WIDTH/2+sizeX,GameFrame.HEIGHT/2+sizeY/2+5,count*sizeX,direction*sizeY,count*sizeX+sizeX,direction*sizeY+sizeY,null);	
			}	
		}
		
		
		mt.draw(g);
		ot1.draw(g);
		ot2.draw(g);
		ot3.draw(g);
		ot4.draw(g);
		ot5.draw(g);
		ot6.draw(g);
		ot7.draw(g);
		ot8.draw(g);
		PT.draw(g);
		DK.draw(g);
	}

	public void update() {
		//秦舢
	  	
    	HP=ST*10;
    	MP=IQ*10;
    	SP=ST*10;
    	EP=(int)((Math.sqrt((double)RP))*10-20);
    	
		hp=Math.min(HP,hp);
		mp=Math.min(MP,mp);
		sp=Math.min(SP,sp);
		EP=Math.min(EP,100);
		mp=Math.max(0,mp);
		sp=Math.max(0,sp);
		EP=Math.max(0,EP);
		VP=Math.max(0,VP);
		IQ=Math.max(0,IQ);
		ST=Math.max(0,ST);
		RP=Math.max(0,RP);
		Money=Math.max(0,Money);
		
		
	    //何小婉
	
    	  	
    	HP2=ST2*10;
    	MP2=IQ2*10;
    	SP2=ST2*10;
    	EP2=(int)((Math.sqrt((double)RP2))*10-20);
    	
		hp2=Math.min(HP2,hp2);
		mp2=Math.min(MP2,mp2);
		sp2=Math.min(SP2,sp2);
		EP2=Math.min(EP2,100);
		mp2=Math.max(0,mp2);
		sp2=Math.max(0,sp2);
		EP2=Math.max(0,EP2);
		VP2=Math.max(0,VP2);
		IQ2=Math.max(0,IQ2);
		ST2=Math.max(0,ST2);
		RP2=Math.max(0,RP2);
		
		
		//杨枳
	
    	  	
    	HP3=ST3*10;
    	MP3=IQ3*10;
    	SP3=ST3*10;
    	EP3=(int)((Math.sqrt((double)RP3))*10-20);
    	
		hp3=Math.min(HP3,hp3);
		mp3=Math.min(MP3,mp3);
		sp3=Math.min(SP3,sp3);
		EP3=Math.min(EP3,100);
		mp3=Math.max(0,mp3);
		sp3=Math.max(0,sp3);
		EP3=Math.max(0,EP3);
		VP3=Math.max(0,VP3);
		IQ3=Math.max(0,IQ3);
		ST3=Math.max(0,ST3);
		RP3=Math.max(0,RP3);
		
		
		//欧阳歆
	
    	  	
    	HP4=ST4*10;
    	MP4=IQ4*10;
    	SP4=ST4*10;
    	EP4=(int)((Math.sqrt((double)RP4))*10-20);
    	
		hp4=Math.min(HP4,hp4);
		mp4=Math.min(MP4,mp4);
		sp4=Math.min(SP4,sp4);
		EP4=Math.min(EP4,100);
		mp4=Math.max(0,mp4);
		sp4=Math.max(0,sp4);
		EP4=Math.max(0,EP4);
		VP4=Math.max(0,VP4);
		IQ4=Math.max(0,IQ4);
		ST4=Math.max(0,ST4);
		RP4=Math.max(0,RP4);
		
		if(isMoving){
//			Method.WalkCounter.work(gp);
			
			if(count!=3){
				count++;
			}else{
				gp.sp.play("walk");
				count=0;
			}

			switch (direction) {
			case 0:
				if (gp.map.map0[locY+1][locX] == 0) {
					locY+=speed;
				}
				break;
			case 1:
				if (gp.map.map0[locY][locX-1] == 0) {
					locX-=speed;
				}
				break;
			case 2:
				if (gp.map.map0[locY][locX+1] == 0) {
					locX+=speed;
				}
				break;
			case 3:
				if (gp.map.map0[locY-1][locX] == 0) {
					locY-=speed;

				}
				break;
			}	
		
		}
		for(int i=0;i<roles.size();i++){
			roles.get(i).update();
		}
		
		if(talkwith!=-1){
			isMoving=false;
		}
		
		//改变控制状态
		if(talkcount!=0){
			if(talkcount==5){
				talkcount=0;
			}else{
				talkcount++;
			}
		}
		
		//成就
		Method.AchievementUpdater.work(gp);
	}

	//变换领队人物
	public void ChangeLeader() {
		if(wholeads<TeamNum){
			wholeads++;
		}else{
			wholeads=1;
		}
		
	}		
	
	public void up() {
		direction=MainControler.UP;
		isMoving=true;
	}
	
    public void down() {
    	direction=MainControler.DOWN;
    	isMoving=true;
	}
    
    public void left() {
    	direction=MainControler.LEFT;
    	isMoving=true;
	}
    
    public void right() {
    	direction=MainControler.RIGHT;
    	isMoving=true;
	}
	

}
