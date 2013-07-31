package SmallGame;

import java.awt.*;
import java.awt.event.KeyListener;


import Controler.MainControler;
import Main.GamePanel;

public class daka {
	private static final int DOWN = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
   
    public int direction[]=new int[10];
    public int directionRole=UP;
    public int count=1;
	public int count1=0;
	public int countRole=1;
    
    boolean isWin=false;
    boolean isFailure=false;
    public boolean isStop=true;
    public boolean isMove=false;
    Image im=null;
    
    
    
    
    public Image background=Toolkit.getDefaultToolkit().getImage("image/SmallGame/±³¾°Í¼Æ¬4.png");
    Image imageNPC0=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc0.png");
    Image imageNPC1=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc1.png");
	Image imageNPC2=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc2.png");
	Image imageNPC3=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc3.png");
	Image imageNPC4=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc4.png");
	Image imageNPC5=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc5.png");
	Image imageNPC6=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc6.png");
	Image imageNPC7=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc7.png");
	Image imageNPC8=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc8.png");
	Image imageNPC9=Toolkit.getDefaultToolkit().getImage("image/SmallGame/npc9.png");
	public Image fail=Toolkit.getDefaultToolkit().getImage("image/SmallGame/º¹.gif");
	public Image over=Toolkit.getDefaultToolkit().getImage("image/SmallGame/½áÊø.png");
	public Image win=Toolkit.getDefaultToolkit().getImage("image/SmallGame/win.gif");
	public Image win1=Toolkit.getDefaultToolkit().getImage("image/SmallGame/win1.png");
	
	public Image[] imageNPC={imageNPC0,imageNPC1,imageNPC2,imageNPC3,imageNPC4,imageNPC5,imageNPC6,imageNPC7,imageNPC8,imageNPC9};
	
	public Image imageRole=Toolkit.getDefaultToolkit().getImage("image/SmallGame/role.png");

	
	public Image imageMachine1=Toolkit.getDefaultToolkit().getImage("image/SmallGame/machine.png");
	Image imageMachine2=Toolkit.getDefaultToolkit().getImage("image/SmallGame/machine.png");

	
	Rectangle npc0=new Rectangle(120,180,28,44);
	Rectangle npc1=new Rectangle(500,290,28,44);
	Rectangle npc2=new Rectangle(290,370,28,44);
	Rectangle npc3=new Rectangle(550,379,28,44);
	Rectangle npc4=new Rectangle(464,386,28,44);
	Rectangle npc5=new Rectangle(90,312,28,44);
	Rectangle npc6=new Rectangle(364,230,28,44);
	Rectangle npc7=new Rectangle(342,278,28,44);
	Rectangle npc8=new Rectangle(130,385,28,44);
	Rectangle npc9=new Rectangle(411,370,28,44);
	public Rectangle machine1=new Rectangle(340,150,32,32);
	Rectangle machine2=new Rectangle(500,80,32,32);
	public Rectangle role=new Rectangle(300,430,25,35);

	
	public Rectangle[] npc={npc0,npc1,npc2,npc3,npc4,npc5,npc6,npc7,npc8,npc9};

	public Rectangle[] machine={machine1,machine2};
	public GamePanel gp;
	public boolean gameover;
	
	public daka(GamePanel Gp){
		gp=Gp;
		for(int j=0;j<10;j++){
     	   direction[j]=(int)(Math.random()*4);
		}
		gameover=false;
		directionRole=UP;
		
		
	}
	
	public boolean isWin(){
		boolean key=false;
		for(int i=0;i<2;i++){
			if(gp.pl.dk.role.intersects(gp.pl.dk.machine[i])){
				key=true;
			}
		}
		return key;
	}
	
	public boolean isFailure(){
		boolean key=false;
		for(int i=0;i<10;i++){
			if(gp.pl.dk.role.intersects(gp.pl.dk.npc[i])){
				key=true;
			}
		}
		return key;
	}
	
	

}
