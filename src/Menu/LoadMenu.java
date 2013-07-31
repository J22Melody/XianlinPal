package Menu;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import InterFaceAndAbstractClass.Menu;

public class LoadMenu extends Menu{

	public LoadMenu(Menu Decorated) {
		decorated=Decorated;
		state=0;
		maxstate=4;
		gp=decorated.gp;
	}
	
	public void draw(Graphics g){
		decorated.draw(g);
		
		g.drawImage(Method.ImageReader.work("Menu/Load"),220,90,null);
		g.setColor(Color.BLUE);
		g.drawRect(250,120+state*48,340,48);
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

}
