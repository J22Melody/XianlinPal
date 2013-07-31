package Menu;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;

public class TaskMenu extends Menu{


	public TaskMenu(Menu Decorated){
		decorated=Decorated;
		gp=Decorated.gp;
		state=0;
	    maxstate=9;
	    
	    substate=0;
	}
	
	public void draw(Graphics g){
		decorated.draw(g);

		//任务面板
		if(substate==0){
			g.drawImage(Method.ImageReader.work("menu/taskmenu"+substate),200,10,null);
			g.drawRect(240,60+33*state,60, 26);
			g.drawString("仙件奇旅", 245,78);
			g.drawString("与人为善", 245,111);
			g.drawString("异地所惑", 245,144);
			g.drawString("婉枳烦恼", 245,177);
			g.drawString("欧阳旧事", 245,210);
			g.drawString("逃课学生", 245,243);
			g.drawString("阿姨困扰", 245,276);
			g.drawString("校园动物", 245,309);
			g.drawString("教授愿望", 245,342);
//			g.drawString("打卡囧事", 245,408);
			g.drawString("捎带消息", 245,375);
			
			switch(state){
			case 0:
				if(gp.pl.mt.getintroduction()!=null){
					String s=gp.pl.mt.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}
				break;
			case 1:
				if(gp.pl.ot1.getintroduction()!=null){
					String s=gp.pl.ot1.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}else if(gp.pl.ot1.level==74){
					g.drawString("已",440,150);
					g.drawString("完",440,240);
					g.drawString("成",440,330);			
				}else{		
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
					
				break;
			case 2:
				if(gp.pl.ot2.getintroduction()!=null){
					String s=gp.pl.ot2.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}else if(gp.pl.ot2.level==128){
					g.drawString("已",440,150);
					g.drawString("完",440,240);
					g.drawString("成",440,330);		
				}else{
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
				break;
			case 3:
				if(gp.pl.ot3.getintroduction()!=null){
					String s=gp.pl.ot3.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}else if(gp.pl.ot3.level==86){
					g.drawString("已",440,150);
					g.drawString("完",440,240);
					g.drawString("成",440,330);		
				}else{
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
				break;			
			case 4:
				if(gp.pl.ot4.getintroduction()!=null){
					String s=gp.pl.ot4.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}else if(gp.pl.ot4.level==68){
					g.drawString("已",440,150);
					g.drawString("完",440,240);
					g.drawString("成",440,330);			
				}else{
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
				break;
			case 5:
				if(gp.pl.ot5.getintroduction()!=null){
					String s=gp.pl.ot5.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}else if(gp.pl.ot5.level==73){
					g.drawString("已",440,150);
					g.drawString("完",440,240);
					g.drawString("成",440,330);		
				}else{
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
				break;
			case 6:
				if(gp.pl.ot6.getintroduction()!=null){
					String s=gp.pl.ot6.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}else if(gp.pl.ot6.level==52){
					g.drawString("已",440,150);
					g.drawString("完",440,240);
					g.drawString("成",440,330);		
				}else{
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
				break;
			case 7:
				if(gp.pl.ot7.getintroduction()!=null){
					String s=gp.pl.ot7.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}
				else if(gp.pl.ot7.level==33){
					g.drawString("已",440,150);
					g.drawString("完",440,240);
					g.drawString("成",440,330);	
					}else{
					
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
				break;
			case 8:
				if(gp.pl.ot8.getintroduction()!=null){
					String s=gp.pl.ot8.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}else{
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
				break;
//			case 9:
//				if(gp.pl.DK.getintroduction()!=null){
//					String s=gp.pl.DK.getintroduction();
//							
//					int x=15;
//					int i=0;
//					
//					int k=s.length()/x;
//					for(i=0;i<=k;i++){
//						String temp=null;
//						if(i!=k){
//							temp=s.substring(i*x,(i+1)*x);
//						}else{
//							temp=s.substring(i*x,s.length());
//						}
//						g.drawString(temp,370,120+20*i);
//					}
//				}else{
//					g.drawString("无",440,150);
//					g.drawString("动",440,240);
//					g.drawString("态",440,330);
//				}
//				break;
			case 9:
				if(gp.pl.PT.getintroduction()!=null){
					String s=gp.pl.PT.getintroduction();
							
					int x=15;
					int i=0;
					
					int k=s.length()/x;
					for(i=0;i<=k;i++){
						String temp=null;
						if(i!=k){
							temp=s.substring(i*x,(i+1)*x);
						}else{
							temp=s.substring(i*x,s.length());
						}
						g.drawString(temp,370,120+20*i);
					}
				}else{
					g.drawString("无",440,150);
					g.drawString("动",440,240);
					g.drawString("态",440,330);
				}
				break;
			}
	
		}
		
		
		
		//成就面板
		if(substate==1){
			g.drawImage(Method.ImageReader.work("menu/taskmenu"+substate),200,10,null);

			g.drawRect(241,60+33*state,42, 26);
			
			g.drawString("学霸", 250,78);
			g.drawString("学神", 250,111);
			g.drawString("潮人", 250,144);
			g.drawString("残疾", 250,177);
			g.drawString("好心人", 245,210);
			g.drawString("支线王", 245,243);
			g.drawString("高富帅", 245,276);
			g.drawString("打卡王", 245,309);
			g.drawString("好学生", 245,342);
			g.drawString("人品差", 245,375);
			
			String[] s={"自习10次","考试10次","去阿玛尼理发5次","去医院治疗3次","成功搬花或搬砖8次","完成所有支线","金钱达到1000","成功打卡5次","上课8次","逃课被抓5次"};
			g.drawString(s[state],390+6*(10-s[state].length()),152);
		
			switch(state){
			case 0:
				if(gp.pl.Temp[3]>=10){
					g.drawImage(Method.ImageReader.work("achievement/xueba"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 1:
				if(gp.pl.Temp[4]>=10){
					g.drawImage(Method.ImageReader.work("achievement/xueshen"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 2:
				if(gp.pl.Temp[5]>=5){
					g.drawImage(Method.ImageReader.work("achievement/chaoren"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 3:
				if(gp.pl.Temp[6]>=3){
					g.drawImage(Method.ImageReader.work("achievement/canji"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 4:
				if(gp.pl.Temp[7]>=8){
					g.drawImage(Method.ImageReader.work("achievement/haoxinren"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 5:
				if(gp.pl.Temp[8]>=1){
					g.drawImage(Method.ImageReader.work("achievement/zhixianwang"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 6:
				if(gp.pl.Temp[9]>=1){
					g.drawImage(Method.ImageReader.work("achievement/gaofushuai"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 7:
				if(gp.pl.Temp[10]>=5){
					g.drawImage(Method.ImageReader.work("achievement/dakawang"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 8:
				if(gp.pl.Temp[11]>=8){
					g.drawImage(Method.ImageReader.work("achievement/haoxuesheng"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			case 9:
				if(gp.pl.Temp[12]>=5){
					g.drawImage(Method.ImageReader.work("achievement/renpincha"),40,85,null);
				}else{
					g.drawImage(Method.ImageReader.work("achievement/notdone"),-37,10,null);
				}
				break;
			}
	
		}
		
		
	}
}
