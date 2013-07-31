package FightSystem;

import java.awt.Point;

public abstract class Fighter {
	String name;
	
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
			
			
			public int HP;
			//精力上限
			public int MP;
			//体力上限
			public int SP;
			//爆发力
			public int EP;

	int locX;
	int locY;
	int initialX;
	int initialY;
	
	//攻击时防止打回去重来
	int attackTempLocX;
	int attackTemPlocY;
	
//	int hp;
//	int HP;//最大值
//	int mp;
//	int MP;//最大值
	int ap=0;
	int att;
	int matt;
	int actualAtt;
	int actualMatt;
	int superAtt;
	double speed;
	double initialSpeed;
	double plocation=360;
	
	int attackCount=-1;
	
	int bombCount=-1;
	boolean bombed=false;

	double missX;
	double missY;
	double initialMissX;
	double initialMissY;
	int missCount=-1;
	int missMaxCount=20;
	
	double distanceX;
	double distanceY;
	
	double interruptX;
	double interruptY;
	int interruptCount=-1;
	int interruptMaxCount=15;
	
	int attackTarget=0;
	int magicTarget=0;
	
	boolean fightable=true;
	
	boolean attackMissed=false;
	boolean magicMissed=false;
	
	boolean magicUsable=true;
	boolean hasAttacked=false;
	boolean hasBeenAttacked=false;
	
	boolean magicPrepared=false;
	boolean magicPrepareComplete=false;
	boolean magicUsed=false;
	
	boolean hasDefended=false;//是否处于防御状态
	int defendCount=-1;
	int defendMaxCount=15;
	double defendX;
	double defendY;
	
	boolean superSkillUsed=false;//必杀技
	int superCount=-1;
	int superMaxCount=25;
	static boolean superKeyPressed=false;
	
	boolean hasHealed=false;
	
	boolean ifSelect=false;
	boolean enemySelect=false;//攻击时选择敌人
	boolean magicSelect=false;//使用魔法时选择敌人
	
	boolean downSelect=false;
	
	boolean selectable=true;//能否被选择攻击或加速，如果死了就不行
	
	boolean hasSpeeded=false;
	boolean hasBeenSpeeded=false;
	
	int speedCount=0;//限制速度增速的时间目前为4回合
	int speedMaxCount=4;
	int speedPlus=40;//加的速度
	
	boolean hasTrembled=false;
	int trembleCount=-1;
	int trembleMaxCount=5;
	
	int attackNumCount=-1;
	int attackNumMaxCount=15;
	double attackNumX;
	double attackNumY;
	
	int magicNumCount=-1;
	int magicNumMaxCount=15;
	double magicNumX;
	double magicNumY;
	
	int healNumCount=-1;
	int healNumMaxCount=15;
	double healNumX;
	double healNumY;
	
	int hpPlus=10;//加 的血量
	
	boolean groupHealed=false;
	int gHealNumCount=-1;
	int gHealNumMaxCount=15;
	
	int speedNumCount=-1;
	int speedNumMaxCount=15;
	double speedNumX;
	double speedNumY;
	double initialNumX;
	double initialNumY;
	
	boolean speedDown=false;
	boolean speedDowned=false;
	int speedDownCount=0;
	int speedDownMaxCount=4;//减速四回合
	
	int speedMinus=40;//减的速度
	
	int speedDownTarget=0;
	
	int speedDownNumCount=-1;
	int speedDownNumMaxCount=15;
	double speedDownNumX;
	double speedDownNumY;
	
	
	int superNumCount=-1;
	int superNumMaxCount=15;
	
	//群体魔法使用
		boolean groupMagicPrepared=false;
		boolean groupPrepareComplete=false;
		boolean groupMagicUsed=false;
		boolean groupMagicMissed=false;//
		
		boolean beenMagiced=false;
	
	int gMagicNumCount=-1;
	int gMagicMaxCount=15;
	
	int mpkill=5;//魔力值消耗
	
	int gMatt;
	int actualGMatt;

	public Fighter(String name,int locX,int locY,int hp, int mp,double speed,int att,int matt){
		this.name=name;
		this.locX=locX;
		this.locY=locY;
		
		initialX=this.locX;
		initialY=this.locY;
		
		interruptX=this.locX;
		interruptY=this.locY;
		
		defendX=this.locX;
		defendY=this.locY;
		
		initialMissX=640/2;
		initialMissY=480/2;
		missX=initialMissX;
		missY=initialMissY;
		
		initialNumX=initialX;
		initialNumY=initialY-20;
		attackNumX=initialNumX;
		attackNumY=initialNumY;
		
		magicNumX=initialNumX;
		magicNumY=initialNumY;
		
		healNumX=initialNumX;
		healNumY=initialNumY;
		
		speedNumX=initialNumX;
		speedNumY=initialNumY;
		
		//新增的
		speedDownNumX=initialNumX;
		speedDownNumY=initialNumY;
		
		this.hp=hp;
		this.HP=hp;
		this.mp=mp;
		this.MP=mp;
		this.speed=speed;
		this.initialSpeed=this.speed;
		this.att=att;
		this.matt=matt;
		this.gMatt=matt*2/3;
		this.actualGMatt=gMatt;
		this.actualAtt=this.att;
		this.actualMatt=this.matt;
		this.superAtt=this.att*3;
	}
	
	public abstract void attack(Fighter f);
	
	public abstract void magicUse(Fighter f);
	
	public abstract void attackOver(Fighter f);
	
	public abstract void magicUseOver(Fighter f);
	
	public abstract void magicMissCheck(Fighter f);
	
	public abstract void attackMissCheck(Fighter f);

	public abstract void positionUpdate();
	
	public abstract void die();
	
	//攻击时跑向敌人
	public abstract void run();
	
	//攻击完跑回来
	public abstract void runBack();
	
	
	public abstract void defend();
	
	public abstract void defendOver();
	
	public abstract void tremble();
	
	public void setLocation(Point location){
		locX=location.x;
		locY=location.y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMP() {
		return MP;
	}

	public void setMP(int mP) {
		MP = mP;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getMatt() {
		return matt;
	}

	public void setMatt(int matt) {
		this.matt = matt;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getMpkill() {
		return mpkill;
	}

	public void setMpkill(int mpkill) {
		this.mpkill = mpkill;
	}
	
	

}
