package FightSystem;

import java.awt.Point;

public abstract class Fighter {
	String name;
	
	//��ǰ��Ѫ	
			public int hp;
			//��ǰ����
			public int mp;
			//��ǰ����
			public int sp;
			//��Ʒ
			public int RP;
			//����
			public int IQ;
			//����
			public int ST;
			//ѧ�ּ�
			public int GPA;
			//��Ӧ��
			public int VP;
			
			
			public int HP;
			//��������
			public int MP;
			//��������
			public int SP;
			//������
			public int EP;

	int locX;
	int locY;
	int initialX;
	int initialY;
	
	//����ʱ��ֹ���ȥ����
	int attackTempLocX;
	int attackTemPlocY;
	
//	int hp;
//	int HP;//���ֵ
//	int mp;
//	int MP;//���ֵ
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
	
	boolean hasDefended=false;//�Ƿ��ڷ���״̬
	int defendCount=-1;
	int defendMaxCount=15;
	double defendX;
	double defendY;
	
	boolean superSkillUsed=false;//��ɱ��
	int superCount=-1;
	int superMaxCount=25;
	static boolean superKeyPressed=false;
	
	boolean hasHealed=false;
	
	boolean ifSelect=false;
	boolean enemySelect=false;//����ʱѡ�����
	boolean magicSelect=false;//ʹ��ħ��ʱѡ�����
	
	boolean downSelect=false;
	
	boolean selectable=true;//�ܷ�ѡ�񹥻�����٣�������˾Ͳ���
	
	boolean hasSpeeded=false;
	boolean hasBeenSpeeded=false;
	
	int speedCount=0;//�����ٶ����ٵ�ʱ��ĿǰΪ4�غ�
	int speedMaxCount=4;
	int speedPlus=40;//�ӵ��ٶ�
	
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
	
	int hpPlus=10;//�� ��Ѫ��
	
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
	int speedDownMaxCount=4;//�����Ļغ�
	
	int speedMinus=40;//�����ٶ�
	
	int speedDownTarget=0;
	
	int speedDownNumCount=-1;
	int speedDownNumMaxCount=15;
	double speedDownNumX;
	double speedDownNumY;
	
	
	int superNumCount=-1;
	int superNumMaxCount=15;
	
	//Ⱥ��ħ��ʹ��
		boolean groupMagicPrepared=false;
		boolean groupPrepareComplete=false;
		boolean groupMagicUsed=false;
		boolean groupMagicMissed=false;//
		
		boolean beenMagiced=false;
	
	int gMagicNumCount=-1;
	int gMagicMaxCount=15;
	
	int mpkill=5;//ħ��ֵ����
	
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
		
		//������
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
	
	//����ʱ�������
	public abstract void run();
	
	//�������ܻ���
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
