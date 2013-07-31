package FightSystem;

import java.awt.Point;
import java.util.Random;

import Main.GamePanel;

public class Introducer {

	Player[] pls=new Player[4];
	Monster[] mos;
	int bossType=0;
	Random rand;
	int range=2;

	//exsitpl0,existpl1,existpl2,existpl3分别代表玩家0,1,2,3是否存在
	//monsternum表示怪物数量，不包括boss
	//bossType表示boss种类,0表示boss不存在，大于0表示不同种类的boss
	GamePanel gp;

	public Introducer(GamePanel Gp,boolean existpl0,boolean existpl1,boolean  existpl2,boolean existpl3,
			int monsterNum,int bossType){
		gp=Gp;
		rand=new Random();
		MonsterInfo.initialize();
		BossInfo.initialize();
		if(bossType!=0){
			mos=new Monster[1+monsterNum];
			mos[0]=new Monster("boss",100,280,150,150,300,10,10);
			switch(bossType){
			case 1://测验一
				mos[0].setMonsterAnim("image/actors/sboss1.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic1.png",new Point(5,3)));
				mos[0].setBossskill(new Animation("image/skills/bossskill1.png",new Point(5,13)));
				mos[0].setMagic(new Animation("image/magics/bossmagic1.png",new Point(5,3)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss1.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss1.png"));
				mos[0].loadInBossData(0);
				break;
			case 2://门卫
				mos[0].setMonsterAnim("image/actors/sboss2.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic2.png",new Point(5,2)));
				mos[0].setBossskill(new Animation("image/skills/bossskill2.png",new Point(5,14)));
				mos[0].setMagic(new Animation("image/magics/bossmagic2.png",new Point(5,4)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss2.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss2.png"));
				mos[0].loadInBossData(1);
				break;
			case 3://狼
				mos[0].setMonsterAnim("image/actors/sboss3.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic3.png",new Point(5,4)));
				mos[0].setBossskill(new Animation("image/skills/bossskill3.png",new Point(5,5)));
				mos[0].setMagic(new Animation("image/magics/bossmagic3.png",new Point(5,4)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss3.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss3.png"));
				mos[0].loadInBossData(2);
				break;
			case 4://测验二
				mos[0].setMonsterAnim("image/actors/sboss4.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic4.png",new Point(5,3)));
				mos[0].setBossskill(new Animation("image/skills/bossskill4.png",new Point(5,12)));
				mos[0].setMagic(new Animation("image/magics/bossmagic4.png",new Point(5,4)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss4.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss4.png"));
				mos[0].loadInBossData(3);
				break;
			case 5://码代码
				mos[0].setMonsterAnim("image/actors/sboss5.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic5.png",new Point(5,2)));
				mos[0].setBossskill(new Animation("image/skills/bossskill5.png",new Point(5,8)));
				mos[0].setMagic(new Animation("image/magics/bossmagic5.png",new Point(6,6)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss5.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss5.png"));
				mos[0].loadInBossData(4);
				break;
			case 6://张明强
				mos[0].setMonsterAnim("image/actors/sboss6.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic6.png",new Point(5,3)));
				mos[0].setBossskill(new Animation("image/skills/bossskill6.png",new Point(5,5)));
				mos[0].setMagic(new Animation("image/magics/bossmagic6.png",new Point(6,6)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss6.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss6.png"));
				mos[0].loadInBossData(5);
				break;
			case 7://老师刘
				mos[0].setMonsterAnim("image/actors/sboss7.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic7.png",new Point(5,4)));
				mos[0].setBossskill(new Animation("image/skills/bossskill7.png",new Point(5,4)));
				mos[0].setMagic(new Animation("image/magics/bossmagic7.png",new Point(5,6)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss7.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss7.png"));
				mos[0].loadInBossData(6);
				break;
			case 8://神秘人一
				mos[0].setMonsterAnim("image/actors/sboss8.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic8.png",new Point(5,5)));
				mos[0].setBossskill(new Animation("image/skills/bossskill8.png",new Point(5,6)));
				mos[0].setMagic(new Animation("image/magics/bossmagic8.png",new Point(5,4)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss8.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss8.png"));
				mos[0].loadInBossData(7);
				break;
			case 9://神秘人二
				mos[0].setMonsterAnim("image/actors/sboss9.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic9.png",new Point(5,6)));
				mos[0].setBossskill(new Animation("image/skills/bossskill9.png",new Point(5,6)));
				mos[0].setMagic(new Animation("image/magics/bossmagic9.png",new Point(6,6)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss9.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss9.png"));
				mos[0].loadInBossData(8);
				break;
			case 10://心魔
				mos[0].setMonsterAnim("image/actors/sboss10.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic10.png",new Point(5,8)));
				mos[0].setBossskill(new Animation("image/skills/bossskill10.png",new Point(5,4)));
				mos[0].setMagic(new Animation("image/magics/bossmagic10.png",new Point(6,6)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss10.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss10.png"));
				mos[0].loadInBossData(9);
				break;
			case 11://猫
				mos[0].setMonsterAnim("image/actors/sboss11.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic11.png",new Point(5,4)));
				mos[0].setBossskill(new Animation("image/skills/bossskill11.png",new Point(5,4)));
				mos[0].setMagic(new Animation("image/magics/bossmagic11.png",new Point(5,5)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss11.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss11.png"));
				mos[0].loadInBossData(10);
				break;
			case 12://逃课学生
				mos[0].setMonsterAnim("image/actors/sboss12.png",4,600,3);
				mos[0].setGroupMagic(new Animation("image/magics/bGMagic11.png",new Point(5,4)));
				mos[0].setBossskill(new Animation("image/skills/bossskill11.png",new Point(5,4)));
				mos[0].setMagic(new Animation("image/magics/bossmagic11.png",new Point(5,5)));
				mos[0].setDeathBoss(Animation.loadImage("image/actors/deathBoss12.png"));
				mos[0].setSuperBoss(Animation.loadImage("image/skills/superboss11.png"));
				mos[0].loadInBossData(10);
				break;
			
			}
			for(int i=1;i<mos.length;i++){
				if(range==0){
					int j=rand.nextInt(2);
					if(j==0){
						mos[i]=new Monster("mifeng",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/mifeng.png",new Point(5,4)));
						mos[i].loadInData(0);
					}else if(j==1){
						mos[i]=new Monster("yeshou",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/yeshou.png",new Point(5,3)));
						mos[i].loadInData(1);
					}
//					mos[i].moTypeDecide();
					mos[i].setMonsterAnim("image/actors/monsters/"+mos[i].getName()+".png",4,600,3);
					mos[i].setPrepare(new Animation("image/magics/prepare.png",new Point(6,6)));
					
				}
				if(range==1){
					int j=rand.nextInt(2);
					if(j==0){
						mos[i]=new Monster("she",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/she.png",new Point(5,4)));
						mos[i].loadInData(2);
					}else if(j==1){
						mos[i]=new Monster("chong",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/chong.png",new Point(5,3)));
						mos[i].loadInData(3);
					}
					mos[i].setMonsterAnim("image/actors/monsters/"+mos[i].getName()+".png",4,600,3);
					mos[i].setPrepare(new Animation("image/magics/prepare.png",new Point(6,6)));
					
				}
				if(range==2){
					int j=rand.nextInt(3);
					if(j==0){
						mos[i]=new Monster("studentA",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/studentA.png",new Point(5,3)));
						mos[i].loadInData(4);
					}else if(j==1){
						mos[i]=new Monster("studentB",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/studentB.png",new Point(5,5)));
						mos[i].loadInData(5);
					}else if(j==2){
						mos[i]=new Monster("studentC",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/studentC.png",new Point(5,5)));
						mos[i].loadInData(6);
					}
					mos[i].setMonsterAnim("image/actors/monsters/"+mos[i].getName()+".png",4,600,3);
					mos[i].setPrepare(new Animation("image/magics/prepare.png",new Point(6,6)));
					
				}
				if(range==3){
					int j=rand.nextInt(2);
					if(j==0){
						mos[i]=new Monster("shudaizi",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/shudaizi.png",new Point()));
						mos[i].loadInData(7);
					}else if(j==1){
						mos[i]=new Monster("xueba",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/xueba.png",new Point()));
						mos[i].loadInData(8);
						
					}
					mos[i].setMonsterAnim("image/actors/monsters/"+mos[i].getName()+".png",4,600,3);
					mos[i].setPrepare(new Animation("image/magics/prepare.png",new Point(6,6)));
				}
			}
		}else{
			mos=new Monster[monsterNum];
			for(int i=0;i<mos.length;i++){
				if(range==0){
					int j=rand.nextInt(2);
					if(j==0){
						mos[i]=new Monster("mifeng",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/mifeng.png",new Point(5,4)));
						mos[i].loadInData(0);
					}else if(j==1){
						mos[i]=new Monster("yeshou",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/yeshou.png",new Point(5,3)));
						mos[i].loadInData(1);
					}
//					mos[i].moTypeDecide();
					mos[i].setMonsterAnim("image/actors/monsters/"+mos[i].getName()+".png",4,600,3);
					mos[i].setPrepare(new Animation("image/magics/prepare.png",new Point(6,6)));
					
				}
				if(range==1){
					int j=rand.nextInt(2);
					if(j==0){
						mos[i]=new Monster("she",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/she.png",new Point(5,4)));
						mos[i].loadInData(2);
					}else if(j==1){
						mos[i]=new Monster("chong",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/chong.png",new Point(5,3)));
						mos[i].loadInData(3);
					}
					mos[i].setMonsterAnim("image/actors/monsters/"+mos[i].getName()+".png",4,600,3);
					mos[i].setPrepare(new Animation("image/magics/prepare.png",new Point(6,6)));
					
				}
				if(range==2){
					int j=rand.nextInt(3);
					if(j==0){
						mos[i]=new Monster("studentA",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/studentA.png",new Point(5,3)));
						mos[i].loadInData(4);
					}else if(j==1){
						mos[i]=new Monster("studentB",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/studentB.png",new Point(5,5)));
						mos[i].loadInData(5);
					}else if(j==2){
						mos[i]=new Monster("studentC",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/studentC.png",new Point(5,5)));
						mos[i].loadInData(6);
					}
					mos[i].setMonsterAnim("image/actors/monsters/"+mos[i].getName()+".png",4,600,3);
					mos[i].setPrepare(new Animation("image/magics/prepare.png",new Point(6,6)));
					
				}
				if(range==3){
					int j=rand.nextInt(2);
					if(j==0){
						mos[i]=new Monster("shudaizi",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/shudaizi.png",new Point()));
						mos[i].loadInData(7);
					}else if(j==1){
						mos[i]=new Monster("xueba",140+(70*(i-1)/3),220+30*((i-1)%3),60,60,rand.nextDouble()*200,5,5);
						mos[i].setMagic(new Animation("image/magics/monsters/xueba.png",new Point()));
						mos[i].loadInData(8);
						
					}
					mos[i].setMonsterAnim("image/actors/monsters/"+mos[i].getName()+".png",4,600,3);
					mos[i].setPrepare(new Animation("image/magics/prepare.png",new Point(6,6)));
				}
				
			}
		}
		this.bossType=bossType;
		
		
		if(existpl0){
			pls[0]=new Player(this,"秦舢",420,220,80,80,220,5,5);
			//设置人物
			pls[0].setPlayerAnim("image/actors/sactor0.png",4,600,3);
			pls[0].loadInData(1);
			System.out.println(pls[0].att);
		}
		if(existpl1){
			pls[1]=new Player(this,"何小婉",450,250,80,80,180,5,5);
			pls[1].setPlayerAnim("image/actors/sactor1.png",4,600,3);
			pls[1].loadInData(2);
			System.out.println(pls[1].att);
		}
		if(existpl2){
			pls[2]=new Player(this,"欧阳歆",420,280,80,80,260,5,5);
			pls[2].setPlayerAnim("image/actors/sactor2.png",4,600,3);
			pls[2].loadInData(3);
			System.out.println(pls[2].att);
		}
		if(existpl3){
			pls[3]=new Player(this,"杨枳",480,250,80,80,160,5,5);
			pls[3].setPlayerAnim("image/actors/sactor3.png",4,600,3);
			pls[3].loadInData(4);
			System.out.println(pls[3].att);
		}
		
	}
	
	public void setRange(int range){
		this.range=range;
	}
	
	public int getRange(){
		return range;
	}



}
