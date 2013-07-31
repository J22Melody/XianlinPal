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
						temps="蓝鲸大学";
						break;
					case 11:
						temps="男生宿舍";
						break;
					case 13:
						temps="仙一";
						break;
					case 14:
						temps="仙二";
						break;
					case 15:
						temps="体育馆";
						break;
					case 16:
						temps="机房";
						break;
					case 17:
						temps="逸夫楼";
						break;
					case 18:
						temps="校医院";
						break;
					case 19:
						temps="环科楼";
						break;
					case 20:
						temps="朝华夕食";
						break;
					case 21:
						temps="教育超市";
						break;
					case 22:
						temps="阿玛尼";
						break;
					case 23:
						temps="面包屋";
						break;
					case 24:
						temps="图书馆";
						break;
					case 25:
						temps="图书馆房间";
						break;
					case 26:
						temps="活动中心";
						break;
					case 27:
						temps="大活顶层";
						break;
					case 28:
						temps="后山";
						break;
					case 30:
						temps="图书馆密室";
						break;
					case 31:
						temps="红猫大学";
						break;
					case 32:
						temps="研究室";
						break;
					case 33:
						temps="食堂";
						break;
					case 34:
						temps="通宵自习室";
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
