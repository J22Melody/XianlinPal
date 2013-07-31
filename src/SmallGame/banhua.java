package SmallGame;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Controler.MainControler;
import Main.GamePanel;

public class banhua {
	private static final int DOWN = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    
    public int CS=32;
	public int col;
	public int row;
    public int[][] map;
    public int[][] location;
    public int directionRole;
    public int countRole=0;
    public int numberOfAnswer;
    public int[] answerX;
    public int[] answerY;
    public int roleX;
	public int roleY;
    int numberOfMap=(int)(Math.random()*4);
    
    public boolean isMove=false;
    
    Image im=null;
    public Image background=Toolkit.getDefaultToolkit().getImage("image/SmallGame/±³¾°Í¼Æ¬2.png");
    public Image barrier=Toolkit.getDefaultToolkit().getImage("image/SmallGame/barrier.gif");
    public Image box=Toolkit.getDefaultToolkit().getImage("image/SmallGame/box.png");
    public Image place=Toolkit.getDefaultToolkit().getImage("image/SmallGame/place.png");
    public Image roleImage=Toolkit.getDefaultToolkit().getImage("image/SmallGame/roleImage.png");
	public GamePanel gp;
	public boolean gameover;
    
    
    
    public banhua(GamePanel Gp) {
    	gp=Gp;
    	try {
			readMap();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		gameover=false;
		
	}
    
   

    public void readMap() throws FileNotFoundException{
		File file=new File("script/smallgamemap/ÍÆÏä×ÓµØÍ¼"+numberOfMap+".txt");
		Scanner input=new Scanner(file);
		String ROW=input.next();
		String COL=input.next();
		row=Integer.parseInt(ROW);
		col=Integer.parseInt(COL);
		map=new int[row][col];
		location=new int[row][col];

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				map[i][j]=Integer.parseInt(input.next());
				location[i][j]=map[i][j];
			}
		}
		
		
		numberOfAnswer=Integer.parseInt(input.next());
		answerX=new int[numberOfAnswer];
		answerY=new int[numberOfAnswer];
		for(int i=0;i<numberOfAnswer;i++){
            answerX[i]=Integer.parseInt(input.next());		
		}
		for(int i=0;i<numberOfAnswer;i++){
            answerY[i]=Integer.parseInt(input.next());		
		}
		
		roleX=Integer.parseInt(input.next());
		roleY=Integer.parseInt(input.next());
		
		input.close();

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(map[i][j]+" ");
			}
		}
	}
}
