package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Login {
	public GamePanel gp;
	public int state;
	public boolean SubMenuExist;
	public int SubState;
	
	public Login(GamePanel Gp){
		gp=Gp;
		state=0;
		SubState=0;
		SubMenuExist=false;
	}


	public void draw(Graphics g) {

		g.drawImage(Method.ImageReader.work("login/word"),0,0,null);
		g.drawImage(Method.ImageReader.work("login/"+state),0,-50,null);

		if(SubMenuExist){

			if(gp.lm.state==1){
				g.drawImage(Method.ImageReader.work("Menu/Load"),220,90,null);
				g.setColor(Color.BLUE);
				g.drawRect(250,120+SubState*48,340,48);
				g.setColor(Color.BLACK);
				
				for(int i=0;i<5;i++){
					try {
						BufferedReader reader = new BufferedReader(new FileReader("script/save/time"+i+".txt"));
						String s=reader.readLine();
						if(s!=null){
							g.drawString(s,470,200+(i-1)*48);
							
							reader = new BufferedReader(new FileReader("script/save/"+i+".txt"));
							String temps = null;
							int scene=Integer.parseInt(reader.readLine());
							int roleNum=Integer.parseInt(reader.readLine());
							switch(scene){
							case 10:
								temps="������ѧ";
								break;
							case 11:
								temps="��������";
								break;
							case 13:
								temps="��һ";
								break;
							case 14:
								temps="�ɶ�";
								break;
							case 15:
								temps="������";
								break;
							case 16:
								temps="����";
								break;
							case 17:
								temps="�ݷ�¥";
								break;
							case 18:
								temps="УҽԺ";
								break;
							case 19:
								temps="����¥";
								break;
							case 20:
								temps="����Ϧʳ";
								break;
							case 21:
								temps="��������";
								break;
							case 22:
								temps="������";
								break;
							case 23:
								temps="�����";
								break;
							case 24:
								temps="ͼ���";
								break;
							case 25:
								temps="ͼ��ݷ���";
								break;
							case 26:
								temps="�����";
								break;
							case 27:
								temps="����";
								break;
							case 28:
								temps="��ɽ";
								break;
							case 30:
								temps="ͼ�������";
								break;
							case 31:
								temps="��è��ѧ";
								break;
							case 32:
								temps="�о���";
								break;
							case 33:
								temps="ʳ��";
								break;
							case 34:
								temps="ͨ����ϰ��";
								break;
							}
							g.drawString(temps,400,200+(i-1)*48);
							for(int j=0;j<roleNum;j++){
								g.drawImage(Method.ImageReader.work("role/head"+(j+1)),250+35*j,130+i*48,null);
							}
						}			
						
						reader.close();
						reader=null;
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}			
				}
			}
			
			if(gp.lm.state==2){
//				g.drawImage(Method.ImageReader.work("login/bg2"),0,0,null);
				g.drawImage(Method.ImageReader.work("login/words"),-150,-20,null);
			
			}
			
		}
	}
}
