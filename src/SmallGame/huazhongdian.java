package SmallGame;

import java.awt.Color;
import java.awt.Image;

import Controler.MainControler;
import Main.GamePanel;




public class huazhongdian {
	public GamePanel gp;
	public int state;
	
	public Image background=null;
	Image im;
	public final int NUMBER=4;
	public boolean[] isZd=new boolean[25];
	public boolean start=true;
	public boolean end=false;
	public Color[] color=new Color[25];

	
	public int m=0;
	public int n=0;
	public int i=0;
	public int number=0;
	int[] answer=new int[NUMBER];
	
	public String[] string=new String[NUMBER];
	public String[] zd={"不定积分","罗比达法则","三重积分","拉格朗日定理","偏导数","二次曲面","二阶导数","隐函数","格林","全导数","麦克劳林公式","斯托克斯公式","高斯公式","反常积分","高阶求导","级数的敛散性","向量代数","空间解析几何","曲面积分","高斯公式","无穷级数","傅里叶级数","高阶微分","泰勒公式","条件极值"};
	
	public huazhongdian(GamePanel Gp){
		gp=Gp;
		
		state=0;
		
		for(int j=0;j<25;j++){
			color[j]=Color.BLACK;
		}
		
		for(int j=0;j<NUMBER;j++){
			answer[j]=(int)(Math.random()*16);
		}
		
		
	}
		
	
	public void isTrue(){
		for(int n=0;n<NUMBER;n++){
			if(isZd[answer[n]]==true){
				
				string[n]="恭喜你，人品不是一般的好啊，不复习的"+zd[answer[n]]+" 没考啊！GPA上升1。";

				switch(gp.pl.TeamNum){
				case 1:
					gp.pl.GPA++;
					break;
				case 2:
					gp.pl.GPA++;
					gp.pl.GPA2++;
					break;
				case 3:
					gp.pl.GPA++;
					gp.pl.GPA2++;
					gp.pl.GPA3++;
					break;
				case 4:
					gp.pl.GPA++;
					gp.pl.GPA2++;
					gp.pl.GPA3++;
					gp.pl.GPA4++;
					break;
				}
			

			}
			else
				
			    string[n]="什么人品嘛，哪里不复习考哪里..."+zd[answer[n]]+"那么重要居然不复习";

		}
		
		
	}


	public void end() {
		gp.map.npcs.get(0).direction=MainControler.DOWN;
		gp.scene=gp.pl.scene;
		gp.pl.Temp[4]++;
		
	}



}
