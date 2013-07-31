package Task;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import animation.promptanimation;

import Controler.MainControler;
import Item.STfruit;
import Main.GamePanel;

public class OptionalTask1 {

	public GamePanel gp;
	
	//�Ƿ��ڽ���
	public boolean going;
	
	//����
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask1(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//���������ʾ
	public String getintroduction() {
		String temp=null;
        if(gp.pl.mt.level>=100&&level==0){
        	temp="���������·���ƺ�������Ҫ������";
        }
        if(level==17){
        	temp="����λ���ߵ��˲�Աȥ�;�ѵ�Ľ̹�˵��������̹�ƽʱϲ��ƹ���򣬴�ʱӦ�����������";
        }
        if(level==24){
        	temp="�̹ٲ��ţ�����������ô���������Ȼ�ȥ�����Ǹ���ù���˲�Ա�ɡ�";
        }
        if(level==35){
        	temp="ȥУҽԺ���˰�æ��";
        }
        if(level==41){
        	temp="��ʿӦ��һ����ͻ�ȥ�ˣ���ȥ�����Ǹ�ͬѧ�Ǳߵ�����ɡ�";
        }
        if(level==46){
        	temp="�ٰ�����һ�������ݣ��ðɣ������߳������֧���е㹷Ѫ...�ⶼʲô�°�����";
        }
        if(level==63){
        	temp="���ڸ㶨�ˣ��Ѻ���Ϣ���ظ��Ǹ����˵�ͬѧ��";
        }
        
		return temp;

	}

	//�Ƿ�ɴ����Ի�
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
		case 0:
			if(gp.pl.scene==10&&((gp.pl.locX==18&&gp.pl.locY==91&&gp.pl.direction==MainControler.LEFT)||(gp.pl.locX==17&&gp.pl.locY==92&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==17&&gp.pl.locY==90&&gp.pl.direction==MainControler.DOWN))){
				temp=true;
			}
			break;
		case 17:
			if(gp.pl.scene==15&&gp.pl.locX==26&&gp.pl.locY==13&&gp.pl.direction==MainControler.RIGHT){
				temp=true;
			}
			break;
		case 24:
			if(gp.pl.scene==10&&((gp.pl.locX==18&&gp.pl.locY==91&&gp.pl.direction==MainControler.LEFT)||(gp.pl.locX==17&&gp.pl.locY==92&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==17&&gp.pl.locY==90&&gp.pl.direction==MainControler.DOWN))){
				temp=true;
			}
			break;
		case 35:
			if(gp.pl.scene==18&&((gp.pl.locX==17&&gp.pl.locY==15&&gp.pl.direction==MainControler.RIGHT)||(gp.pl.locX==18&&gp.pl.locY==14&&gp.pl.direction==MainControler.DOWN)||(gp.pl.locX==18&&gp.pl.locY==16&&gp.pl.direction==MainControler.UP))){
				temp=true;
			}
			break;
		case 41:
			if(gp.pl.scene==10&&((gp.pl.locX==18&&gp.pl.locY==91&&gp.pl.direction==MainControler.LEFT)||(gp.pl.locX==17&&gp.pl.locY==92&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==17&&gp.pl.locY==90&&gp.pl.direction==MainControler.DOWN))){
				temp=true;
			}
			break;
		case 46:
			if(gp.pl.scene==15&&gp.pl.locX==26&&gp.pl.locY==13&&gp.pl.direction==MainControler.RIGHT){
				temp=true;
			}
			break;
		case 63:
			if(gp.pl.scene==10&&((gp.pl.locX==18&&gp.pl.locY==91&&gp.pl.direction==MainControler.LEFT)||(gp.pl.locX==17&&gp.pl.locY==92&&gp.pl.direction==MainControler.UP)||(gp.pl.locX==17&&gp.pl.locY==90&&gp.pl.direction==MainControler.DOWN))){
				temp=true;
			}
			break;
		}
		
		return temp;	
	}
	
	//����
	public void update(){
		if(CanGo()){
			gp.pl.wholeads=1;
			gp.pl.isMoving=false;
			going=true;
			gp.scene=201;
		}
	}
	
	//���鷢չ
	public void next(){
		switch(level){
		case 16:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 23:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 34:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 40:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 45:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 62:
			going=false;
			gp.scene=gp.pl.scene;
			gp.pa=new promptanimation(gp,"�����и���");
			break;
		case 73:
			going=false;
			gp.scene=gp.pl.scene;
			
			gp.pl.Bag.add(new STfruit(gp,gp.pl.Bag.size()));
			gp.pl.Money+=50;
			gp.pa=new promptanimation(gp,"��ý������ʹ�ʵ�ͽ�Ǯ����");
			break;
		}
	
		
		level++;
	}

	//�������
    public void draw(Graphics g){
	
		
		//�Ի�	
		if(gp.scene==201){
			g.drawImage(Method.ImageReader.work("menu/talk"),100,330,null);
			
			String s=dialog.get(level);
			int x=33;
			int i=0;
			
			int k=s.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=s.substring(i*x,(i+1)*x);
				}else{
					temp=s.substring(i*x,s.length());
				}
				g.drawString(temp,200,390+20*i);
			}
			//�ı����״̬
			if(count!=0){
				if(count==4){
					count=0;
				}else{
					count++;
				}
			}
		}
	}
	
	//��ȡ���жԻ�
    public void getdialog() {
    	dialog=new ArrayList<String>();
	
    	try {
			BufferedReader reader = new BufferedReader(new FileReader("script/task/OptionalTask1.txt"));	
			
			while(true){
				String s = reader.readLine();
				if(s==null){
					break;
				}else{
					dialog.add(s);
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
