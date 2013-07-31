package FightSystem;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Player extends Fighter{
	AttackJudger judger;
	boolean escapable=false;//判断能否逃跑
	boolean escapePrepared=false;
	
	
	static boolean stateExist=false;
	static Point statePosition=new Point(0,0);
	
	int state=0;
	
	static final int cool=0;
	static final int good=1;
	static final int perfect=2;

	int magicUseCount=0;
	
	int magicCount=0;
//	int healCount=0;
	
	int speedTarget=0;
	int healTarget=0;
	
	boolean keyPressed=false;
	boolean canKeyPress=false;
	
	double specX;
	double specY;
	
	CharacterAnimation cAnim;
	
	Random rand;
	
	Introducer introducer;
	
	public Player(Introducer introducer,String name,int locX,int locY,int hp, int mp,double speed,int att,int matt){
		super(name,locX,locY,hp,mp,speed,att,matt);
		this.introducer=introducer;
		rand=new Random();
		judger=new AttackJudger(this);
	}

	//设置人物
	public void setPlayerAnim(String filename,int num,int animSpeed,int animTotalTime){
		if(cAnim==null){
			cAnim=new CharacterAnimation(filename,num,animSpeed,animTotalTime);
		}else{
			System.out.println("CharacterAniamtion error");
		}
	}
	@Override
	public void attack(Fighter f) {
		// TODO Auto-generated method stub
		
		hasAttacked=true;
		f.hasBeenAttacked=true;//敌人被攻击
		judger.judgeAttack();
		
		attackMissCheck(f);
	    distanceX=f.initialX-this.locX;
	    distanceY=f.initialY-this.locY;
		
		plocation=360;
	}
	
	//检测攻击是否miss
	public void attackMissCheck(Fighter f){
		if(this.hasAttacked && f.hasAttacked){		
			attackMissed=true;
			missCount=0;
		}else if(this.hasAttacked && !f.hasAttacked){
			attackMissed=false;
		}
	}
	
	//攻击完成
	public void attackOver(Fighter f){
		if(!attackMissed){
			f.hp-=this.actualAtt;
			ap+=8+rand.nextInt(5);
			f.ap+=10+rand.nextInt(4);
			attackNumCount=0;
			if(ap>=160){
				ap=160;
			}
		}
		
		if(f.hp<=0){

			f.die();
		}
		hasAttacked=false;
		attackCount=0;
		
		f.hasBeenAttacked=false;
		
		f.trembleCount=0;
	}
	
	//魔法准备
	public void magicPrepare(){
		magicPrepared=true;
		judger.judgeMagic();
//		}
	}
	
	//魔法值为0时不能使用魔法
	public void magicUseFalse(){
		magicPrepared=false;
		keyPressed=false;
		plocation=360;
	}

	//魔法使用
	public void magicUse(Fighter f) {
		// TODO Auto-generated method stub
		magicUsed=true;
		magicPrepared=false;
		magicPrepareComplete=false;
		magicMissCheck(f);
		
		f.trembleCount=0;
		
	}
	
	//检测魔法是否被打断
	public void magicMissCheck(Fighter f){
		if(this.magicPrepared && (f.hasAttacked || this.hasBeenAttacked)){
			magicMissed=true;
			magicPrepared=false;
			magicPrepareComplete=false;
			magicUseCount=0;
			keyPressed=false;
			plocation=360;
			interruptCount=0;
		}else {
			magicMissed=false;
		}
	}	
	
	//魔法使用完成
	public void magicUseOver(Fighter f){
		if(!magicMissed){
			ap+=8+rand.nextInt(5);
			if(ap>=160){
				ap=160;
			}
			f.ap+=10+rand.nextInt(4);
			
//			judger.judgeMagic();
			f.hp-=this.matt;
			if(f.hp<=0){
				f.die();
			}
			this.mp-=mpkill;//设置错误
			if(this.mp<=0){
				this.mp=0;
				magicUsable=false;
			}
		}
		magicNumCount=0;//画数字
		keyPressed=false;
		magicUsed=false;
		magicUseCount=0;
	}		
			
	public void groupMagicPrepare(){
		groupMagicPrepared=true;
		judger.judgeGroupMagic();
	}
			
	public void groupMagicUse(Fighter[] fs){
		groupMagicUsed=true;
		groupMagicPrepared=false;
		groupPrepareComplete=false;
		groupMagicMissCheck(fs);
		
		for(int i=0;i<fs.length;i++){
			fs[i].trembleCount=0;
		}
		
	}
	
	public void groupMagicUseOver(Fighter[] fs){
		if(!groupMagicMissed){
			ap+=8+rand.nextInt(5);
			if(ap>=160){
				ap=160;
			}
//			judger.judgeMagic();
			for(int i=0;i<fs.length;i++){
				if(fs[i].beenMagiced){
					//如果被魔法集中的话
					fs[i].hp-=this.actualGMatt;
					fs[i].ap+=10+rand.nextInt(4);
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
		keyPressed=false;
		groupMagicUsed=false;
		magicUseCount=0;
	}
	
	public void groupMagicMissCheck(Fighter[] fs){
		if(this.groupMagicPrepared && this.hasBeenAttacked){
			groupMagicMissed=true;
			groupMagicPrepared=false;
			groupPrepareComplete=false;
			magicUseCount=0;
			keyPressed=false;
			plocation=360;
			interruptCount=0;
		}else if(this.groupMagicPrepared && !this.hasBeenAttacked){
			groupMagicMissed=false;
			for(int i=0;i<fs.length;i++){
				if(fs[i].hasAttacked){
					fs[i].beenMagiced=false;
				}else{
					fs[i].beenMagiced=true;
				}
			}
		}else {
			groupMagicMissed=false;
		}
	}
	
	//群魔法使用失败
	public void groupMagicUseFalse(){
		groupMagicPrepared=false;
		keyPressed=false;
		plocation=360;
	}
			
	
	
	//使用必杀技
	public void superSkillUse(Fighter[] fs){
		superSkillUsed=true;
		superCount=0;
		Fighter.superKeyPressed=true;
	}
	
	//必杀技使用结束
	public void superSkillUseOver(Fighter[] fs){
		superSkillUsed=false;
		for(int i=0;i<fs.length;i++){
			fs[i].hp-=superAtt;
			fs[i].ap+=20+rand.nextInt(10);
			if(fs[i].hp<=0){

				fs[i].die();
			}
		}
		ap=0;
		superCount=-1;
		Fighter.superKeyPressed=false;
		superNumCount=0;

	}	
	
	//治愈
	public void heal(Player pl){
		this.hasHealed=true;
		
	}
	
	//治愈完成
	public void healOver(Player pl){
		pl.hp+=hpPlus;
		if(!pl.fightable){
			pl.fightable=true;
			pl.bombed=false;//设为没爆炸
		}
		if(pl.hp>=80){
			pl.hp=80;
		}
		plocation=360;
		this.hasHealed=false;
		keyPressed=false;
		healNumCount=0;
	}
	
	public void groupHeal(Player[] pls){
		this.groupHealed=true;
	}
	
	public void groupHealOver(Player[] pls){
		for(int i=0;i<pls.length;i++){
			if(pls[i]!=null){
				pls[i].hp+=hpPlus/2;
				if(!pls[i].fightable){
					pls[i].fightable=true;
					pls[i].bombed=false;
				}
				if(pls[i].hp>=80){
					pls[i].hp=80;
				}
				plocation=360;
				this.groupHealed=false;
				keyPressed=false;
				gHealNumCount=0;
			}
		}
	}
	
	//加速
	public void speedUp(Player pl){
		this.hasSpeeded=true;
		pl.hasBeenSpeeded=true;
		
	}
	
	//加速完成
	public void speedUpOver(Player pl){
		this.hasSpeeded=false;
		pl.speed+=speedPlus;
		if(pl.speed>=360){
			pl.speed=360;
		}
		pl.speedCount=0;
		plocation=360;
		keyPressed=false;
		speedNumCount=0;
	}
	
	//使敌人减速
    public void speedDown(Monster mo){
		this.speedDown=true;
		mo.speedDowned=true;
	}
    
    public void speedDownOver(Monster mo){
    	this.speedDown=false;
    	mo.speed-=speedMinus;
    	if(mo.speed<=180){
    		mo.speed=180;
    	}
    	mo.speedDownCount=0;
    	plocation=360;
    	keyPressed=false;
    	speedDownNumCount=0;
    }
	
	//逃跑
	public void escape(Monster[] mos){
		escapePrepared=true;
		judger.judgeEscape(mos);
		if(escapable){
			System.exit(0);
		}else{
			//逃跑失败
		}
	}
	
	
	
	//更新位置
	public void positionUpdate(){
		plocation-=speed/4;
		
		if(plocation>=140 && plocation<=160){
			canKeyPress=true;
		}else {
			canKeyPress=false;
		}
		if(plocation<=140 && !magicPrepared && !groupMagicPrepared){
			plocation=360;
		}else if(plocation<=140 && magicPrepared){
			if(plocation<=100){
				magicPrepareComplete=true;
				plocation=360;
			}
		}else if(plocation<=140 && groupMagicPrepared){
			if(plocation<=100){
				groupPrepareComplete=true;
				plocation=360;
			}
		}

		
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
		
	
		if(hasDefended){
			if(plocation<=160){
				
				defendOver();

			}
		}
	}
	
	
	//防御
	public void defend(){
		hasDefended=true;
		plocation=360;
	}
	
	//防御结束
	public void defendOver(){
		hasDefended=false;
		
	}
	
	//玩家死亡
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
		plocation=360;
		ap=0;
		hp=0;
	}
	
	//设置状态
	public void setState(int state){
		this.state=state;
	}

	
	//展示人物形象
	public void display(Graphics g){
		cAnim.display(g, locX, locY);
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
	
	public void loadOutData(int n){
		switch(n){
		case 1:
			introducer.gp.pl.hp=hp;
			introducer.gp.pl.mp=mp;
			introducer.gp.pl.sp=sp;
			introducer.gp.pl.RP=RP;
			introducer.gp.pl.IQ=IQ;
			introducer.gp.pl.ST=ST;
			introducer.gp.pl.GPA=GPA;
			introducer.gp.pl.VP=VP;
			introducer.gp.pl.HP=HP;
			introducer.gp.pl.MP=MP;
			introducer.gp.pl.SP=SP;
			introducer.gp.pl.EP=EP;
			break;
		case 2:
			introducer.gp.pl.hp2=hp;
			introducer.gp.pl.mp2=mp;
			introducer.gp.pl.sp2=sp;
			introducer.gp.pl.RP2=RP;
			introducer.gp.pl.IQ2=IQ;
			introducer.gp.pl.ST2=ST;
			introducer.gp.pl.GPA2=GPA;
			introducer.gp.pl.VP2=VP;
			introducer.gp.pl.HP2=HP;
			introducer.gp.pl.MP2=MP;
			introducer.gp.pl.SP2=SP;
			introducer.gp.pl.EP2=EP;
			break;
		case 3:
			introducer.gp.pl.hp3=hp;
			introducer.gp.pl.mp3=mp;
			introducer.gp.pl.sp3=sp;
			introducer.gp.pl.RP3=RP;
			introducer.gp.pl.IQ3=IQ;
			introducer.gp.pl.ST3=ST;
			introducer.gp.pl.GPA3=GPA;
			introducer.gp.pl.VP3=VP;
			introducer.gp.pl.HP3=HP;
			introducer.gp.pl.MP3=MP;
			introducer.gp.pl.SP3=SP;
			introducer.gp.pl.EP3=EP;
			break;
		case 4:
			introducer.gp.pl.hp4=hp;
			introducer.gp.pl.mp4=mp;
			introducer.gp.pl.sp4=sp;
			introducer.gp.pl.RP4=RP;
			introducer.gp.pl.IQ4=IQ;
			introducer.gp.pl.ST4=ST;
			introducer.gp.pl.GPA4=GPA;
			introducer.gp.pl.VP4=VP;
			introducer.gp.pl.HP4=HP;
			introducer.gp.pl.MP4=MP;
			introducer.gp.pl.SP4=SP;
			introducer.gp.pl.EP4=EP;
			break;
			
		}
	}
	
	//导入数据
	public void loadInData(int n){
		switch(n){
		case 1:
			hp=introducer.gp.pl.hp;
			
			mp=introducer.gp.pl.mp;
			sp=introducer.gp.pl.sp;

			RP=introducer.gp.pl.RP;
			IQ=introducer.gp.pl.IQ;
			ST=introducer.gp.pl.ST;
			GPA=introducer.gp.pl.GPA;
			VP=introducer.gp.pl.VP;
			HP=introducer.gp.pl.HP;
			MP=introducer.gp.pl.MP;
			SP=introducer.gp.pl.SP;
			EP=introducer.gp.pl.EP;
			att=ST*10;
			actualAtt=ST*10;
			superAtt=att*3;
			if(superAtt>=999){
				superAtt=999;
			}
			matt=IQ*15;
			actualMatt=IQ*15;
			gMatt=IQ*10;
			actualGMatt=IQ*10;
			speed=VP;
			break;
		case 2:
			hp=introducer.gp.pl.hp2;
			mp=introducer.gp.pl.mp2;
			sp=introducer.gp.pl.sp2;
		
			RP=introducer.gp.pl.RP2;
			IQ=introducer.gp.pl.IQ2;
			ST=introducer.gp.pl.ST2;
			GPA=introducer.gp.pl.GPA2;
			VP=introducer.gp.pl.VP2;
			HP=introducer.gp.pl.HP2;
			MP=introducer.gp.pl.MP2;
			SP=introducer.gp.pl.SP2;
			EP=introducer.gp.pl.EP2;
			att=ST*10;
			actualAtt=ST*10;
			superAtt=att*3;
			if(superAtt>=999){
				superAtt=999;
			}
			matt=IQ*15;
			actualMatt=IQ*15;
			gMatt=IQ*10;
			actualGMatt=IQ*10;
			speed=VP;
			break;
		case 3:
			hp=introducer.gp.pl.hp3;
			mp=introducer.gp.pl.mp3;
			sp=introducer.gp.pl.sp3;
		
			RP=introducer.gp.pl.RP3;
			IQ=introducer.gp.pl.IQ3;
			ST=introducer.gp.pl.ST3;
			GPA=introducer.gp.pl.GPA3;
			VP=introducer.gp.pl.VP3;
			HP=introducer.gp.pl.HP3;
			MP=introducer.gp.pl.MP3;
			SP=introducer.gp.pl.SP3;
			EP=introducer.gp.pl.EP3;
			att=ST*10;
			actualAtt=ST*10;
			superAtt=att*3;
			if(superAtt>=999){
				superAtt=999;
			}
			matt=IQ*15;
			actualMatt=IQ*15;
			gMatt=IQ*10;
			actualGMatt=IQ*10;
			speed=VP;
			break;
		case 4:
			hp=introducer.gp.pl.hp4;
			mp=introducer.gp.pl.mp4;
			sp=introducer.gp.pl.sp4;
	
			RP=introducer.gp.pl.RP4;
			IQ=introducer.gp.pl.IQ4;
			ST=introducer.gp.pl.ST4;
			GPA=introducer.gp.pl.GPA4;
			VP=introducer.gp.pl.VP4;
			HP=introducer.gp.pl.HP4;
			MP=introducer.gp.pl.MP4;
			SP=introducer.gp.pl.SP4;
			EP=introducer.gp.pl.EP4;
			att=ST*10;
			actualAtt=ST*10;
			superAtt=att*3;
			if(superAtt>=999){
				superAtt=999;
			}
			matt=IQ*15;
			actualMatt=IQ*15;
			gMatt=IQ*10;
			actualGMatt=IQ*10;
			speed=VP;
			break;
			
		}
	}

}
