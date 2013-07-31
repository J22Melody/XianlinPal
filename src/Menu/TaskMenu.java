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

		//�������
		if(substate==0){
			g.drawImage(Method.ImageReader.work("menu/taskmenu"+substate),200,10,null);
			g.drawRect(240,60+33*state,60, 26);
			g.drawString("�ɼ�����", 245,78);
			g.drawString("����Ϊ��", 245,111);
			g.drawString("�������", 245,144);
			g.drawString("���׷���", 245,177);
			g.drawString("ŷ������", 245,210);
			g.drawString("�ӿ�ѧ��", 245,243);
			g.drawString("��������", 245,276);
			g.drawString("У԰����", 245,309);
			g.drawString("����Ը��", 245,342);
//			g.drawString("�򿨇���", 245,408);
			g.drawString("�Ӵ���Ϣ", 245,375);
			
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("��",440,330);			
				}else{		
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("��",440,330);		
				}else{
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("��",440,330);		
				}else{
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("��",440,330);			
				}else{
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("��",440,330);		
				}else{
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("��",440,330);		
				}else{
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("��",440,330);	
					}else{
					
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
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
//					g.drawString("��",440,150);
//					g.drawString("��",440,240);
//					g.drawString("̬",440,330);
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
					g.drawString("��",440,150);
					g.drawString("��",440,240);
					g.drawString("̬",440,330);
				}
				break;
			}
	
		}
		
		
		
		//�ɾ����
		if(substate==1){
			g.drawImage(Method.ImageReader.work("menu/taskmenu"+substate),200,10,null);

			g.drawRect(241,60+33*state,42, 26);
			
			g.drawString("ѧ��", 250,78);
			g.drawString("ѧ��", 250,111);
			g.drawString("����", 250,144);
			g.drawString("�м�", 250,177);
			g.drawString("������", 245,210);
			g.drawString("֧����", 245,243);
			g.drawString("�߸�˧", 245,276);
			g.drawString("����", 245,309);
			g.drawString("��ѧ��", 245,342);
			g.drawString("��Ʒ��", 245,375);
			
			String[] s={"��ϰ10��","����10��","ȥ��������5��","ȥҽԺ����3��","�ɹ��Ứ���ש8��","�������֧��","��Ǯ�ﵽ1000","�ɹ���5��","�Ͽ�8��","�ӿα�ץ5��"};
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
