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
	public String[] zd={"��������","�ޱȴ﷨��","���ػ���","�������ն���","ƫ����","��������","���׵���","������","����","ȫ����","������ֹ�ʽ","˹�п�˹��ʽ","��˹��ʽ","��������","�߽���","��������ɢ��","��������","�ռ��������","�������","��˹��ʽ","�����","����Ҷ����","�߽�΢��","̩�չ�ʽ","������ֵ"};
	
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
				
				string[n]="��ϲ�㣬��Ʒ����һ��ĺð�������ϰ��"+zd[answer[n]]+" û������GPA����1��";

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
				
			    string[n]="ʲô��Ʒ����ﲻ��ϰ������..."+zd[answer[n]]+"��ô��Ҫ��Ȼ����ϰ";

		}
		
		
	}


	public void end() {
		gp.map.npcs.get(0).direction=MainControler.DOWN;
		gp.scene=gp.pl.scene;
		gp.pl.Temp[4]++;
		
	}



}
