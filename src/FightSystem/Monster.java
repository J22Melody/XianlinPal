package FightSystem;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Monster extends Fighter{
	
	Animation prepare;
	Animation magic;//每个小怪有一个魔法
	Animation groupMagic;
	Animation bossskill;
	
	BufferedImage deathBoss;
	BufferedImage superBoss;
	
	int target=0;//攻击和使用魔法的目标
	int moType=0;//决定使用哪种类型的小怪
	int moTypeNums=3;
	int bossType=0;
	int bossTypeNums=2;
	
	int magicType=0;//魔法种类
	
	Random rand;
	
	CharacterAnimation cAnim;
	
	public Monster(String name, int locX, int locY, int hp, int mp,
			double speed, int att, int matt) {
		super(name, locX, locY, hp, mp, speed, att, matt);
		// TODO Auto-generated constructor stub
		rand=new Random();

	}
	
	public void setMonsterAnim(String filename,int num,int animSpeed,int animTotalTime){
		if(cAnim==null){
			cAnim=new CharacterAnimation(filename,num,animSpeed,animTotalTime);
		}else{
			System.out.println("CharacterAnimation error");
		}
	}
	
	public void display(Graphics g){
		cAnim.display(g, locX, locY);
	}

	@Override
	public void attack(Fighter f) {
		// TODO Auto-generated method stub
		hasAttacked=true;
		f.hasBeenAttacked=true;//敌人被攻击
		
		
		attackMissCheck(f);
	    distanceX=f.initialX-this.locX;
	    distanceY=f.initialY-this.locY;
		
		plocation=360;
	}

	@Override
	public void magicUse(Fighter f) {
		// TODO Auto-generated method stub
		magicPrepared=false;
		magicPrepareComplete=false;
		magicUsed=true;
		
		f.trembleCount=0;
		
		magicMissCheck(f);
	}

	public void magicUseFalse(){
		magicPrepared=false;
		plocation=360;
	}
	
	public void magicPrepare(){
		magicPrepared=true;
	}
	@Override
	public void attackOver(Fighter f) {
		// TODO Auto-generated method stub
		hasAttacked=false;
		attackCount=0;
		f.hasBeenAttacked=false;
		
		f.trembleCount=0;
		
		
		if(!attackMissed && !f.hasDefended){
			f.hp-=this.actualAtt;

			ap+=10+rand.nextInt(3);
			attackNumCount=0;
			f.ap+=12+rand.nextInt(4);
			if(ap>=300){
				ap=300;
			}
			if(f.hp<=0){

				f.die();
			}
		}
		if(f.hasDefended){
			f.defendCount=0;
			f.defendOver();
		}
	}

	@Override
	public void magicUseOver(Fighter f) {
		// TODO Auto-generated method stub
		magicUsed=false;
		if(!magicMissed){
			ap+=10+rand.nextInt(3);
			if(ap>=300){
				ap=300;
			}
			f.hp-=this.matt;
			f.ap+=12+rand.nextInt(4);
			if(f.hp<=0){

				f.die();
			}
			this.mp-=mpkill;//设置错误
			if(this.mp<=0){
				this.mp=0;
				magicUsable=false;
			}
		}
		
	}

	@Override
	public void magicMissCheck(Fighter f) {
		// TODO Auto-generated method stub
		if(this.magicPrepared && (this.hasBeenAttacked || f.hasAttacked)){
			magicMissed=true;
		}
		else{
			magicMissed=false;
		}
		
	}
	
	public void groupMagicPrepare(){
		groupMagicPrepared=true;
	}
			
	public void groupMagicUse(Fighter[] fs){
		groupMagicUsed=true;
		groupMagicPrepared=false;
		groupPrepareComplete=false;
		groupMagicMissCheck(fs);
		
		for(int i=0;i<fs.length;i++){
			if(fs[i]!=null){
				fs[i].trembleCount=0;
			}
		}
		
	}
	
	public void groupMagicUseOver(Fighter[] fs){
		if(!groupMagicMissed){
			ap+=10+rand.nextInt(3);
			if(ap>=160){
				ap=160;
			}
			for(int i=0;i<fs.length;i++){
				if(fs[i]!=null && fs[i].beenMagiced){
					fs[i].hp-=this.matt;
					fs[i].ap+=12+rand.nextInt(4);
					if(fs[i].hp<=0){
						fs[i].die();
					}
					fs[i].beenMagiced=false;
				}
			}
			
		}
		this.mp-=mpkill;//设置错误
		if(this.mp<=0){
			this.mp=0;
			magicUsable=false;
		}
		gMagicNumCount=0;//画数字
		groupMagicUsed=false;
	}
	
	public void groupMagicMissCheck(Fighter[] fs){
		if(this.groupMagicPrepared && this.hasBeenAttacked){
			groupMagicMissed=true;
			groupMagicPrepared=false;
			groupPrepareComplete=false;

		}else if(this.groupMagicPrepared && !this.hasBeenAttacked){
			groupMagicMissed=false;
			for(int i=0;i<fs.length;i++){
				if(fs[i]!=null && fs[i].hasAttacked){
					fs[i].beenMagiced=false;
				}else if(fs[i]!=null && !fs[i].hasAttacked){
					fs[i].beenMagiced=true;
				}
			}
		}else {
			groupMagicMissed=false;
		}
	}
	
	public void groupMagicUseFalse(){
		groupMagicPrepared=false;
		groupPrepareComplete=false;
		plocation=360;
	}

	@Override
	public void attackMissCheck(Fighter f) {
		// TODO Auto-generated method stub
		if(this.hasAttacked && f.hasAttacked){
			attackMissed=true;
			missCount=0;
		}else if(this.hasAttacked && !f.hasAttacked){
			attackMissed=false;
		}
	}
	
	public void superSkillUse(Fighter[] fs){
		superSkillUsed=true;
		superCount=0;
		Fighter.superKeyPressed=true;

	}
	
	public void superSkillUseOver(Fighter[] fs){
		superSkillUsed=false;
		for(int i=0;i<fs.length;i++){
			if(fs[i]!=null ){
				fs[i].hp-=superAtt;
				fs[i].ap+=20+rand.nextInt(10);
				if(fs[i].hp<=0){

					fs[i].die();
				}
			}
			Fighter.superKeyPressed=false;
		}
		ap=0;
		superCount=-1;
		superNumCount=0;
	}

	@Override
	public void positionUpdate() {
		// TODO Auto-generated method stub
		
		//加速
		if(hasBeenSpeeded){
			if(plocation==360){
				speedCount+=1;
			}
			if(speedCount>=speedMaxCount){
				speedCount=0;
				speed=initialSpeed;
				hasBeenSpeeded=false;
			}
		}
		//减速
		if(speedDowned){
			if(plocation==360){
				speedDownCount+=1;
			}
			if(speedDownCount>=speedDownMaxCount){
				speedDownCount=0;
				speed=initialSpeed;
				speedDowned=false;
			}
		}
		
		if(hasDefended){
			if(plocation<=160){
			
				defendOver();
			}
		}
		plocation-=speed/10;
		
	}
	
	public void die(){
		fightable=false;
		magicPrepared=false;
		magicPrepareComplete=false;
		magicUsed=false;
		hasAttacked=false;
		hasBeenAttacked=false;
		superSkillUsed=false;
		superCount=-1;
		bombCount=0;
		hp=0;
		ap=0;
	}
	
	//怪物也会防御
	public void defend(){
		hasDefended=true;
	}
	
	public void defendOver(){
		hasDefended=false;
	
	}
	
	//设定怪物的速度
	public void setSpeed(double speed ){
		this.speed=speed;
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	public void moTypeDecide(){
		moType=rand.nextInt(moTypeNums);
	}
	
	public int getMoType(){
		return moType;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		cAnim.stateUpdate();
	}

	@Override
	public void runBack() {
		// TODO Auto-generated method stub
		cAnim.imPosition=0;
	}

	@Override
	public void tremble() {
		// TODO Auto-generated method stub
		if(trembleCount>=0){
			int a=rand.nextInt(4);
			switch(a){
			case 0:
				locX-=5;
				break;
			case 1:
				locX+=5;
				break;
			case 2:
				locY-=5;
				break;
			case 3:
				locY+=5;
				break;
		
			}
			trembleCount+=1;
		}
		if(trembleCount>=trembleMaxCount){
			trembleCount=-1;
			locX=initialX;
			locY=initialY;
		}
		
	}
	
	public void setMagic(Animation magic){
		this.magic=magic;
	}
	
	public void setPrepare(Animation prepare){
		this.prepare=prepare;
	}
	
	public void setGroupMagic(Animation groupMagic){
		this.groupMagic=groupMagic;
	}

	
//导入数据
	public void loadInData(int i){
		att=MonsterInfo.atts.get(i);
		actualAtt=att;
		matt=MonsterInfo.matts.get(i);
		actualMatt=matt;
		hp=MonsterInfo.hps.get(i);
		HP=hp;
		speed=MonsterInfo.speeds.get(i)+rand.nextInt(5);
		mp=MonsterInfo.mps.get(i);
		mpkill=MonsterInfo.mpkills.get(i);
	}
	//导入bosss数据
	public void loadInBossData(int i){
		att=BossInfo.atts.get(i);
		actualAtt=att;
		superAtt=att*3;
		if(superAtt>=999){
			superAtt=999;
		}
		matt=BossInfo.matts.get(i);
		actualMatt=matt;
		hp=BossInfo.hps.get(i);
		HP=hp;
		speed=BossInfo.speeds.get(i);
		mp=BossInfo.mps.get(i);
		MP=mp;
		mpkill=BossInfo.mpkills.get(i);
	}
	
	public void setBossskill(Animation bossskill){
		this.bossskill=bossskill;
	}
	
	public void setDeathBoss(BufferedImage deathBoss){
		this.deathBoss=deathBoss;
	}
	
	public void setSuperBoss(BufferedImage superBoss){
		this.superBoss=superBoss;
	}

//	public void setBossType(int bossType){
//		this.bossType=bossType;
//	}
//	
//	public int getBossType(){
//		return bossType;
//	}

}
