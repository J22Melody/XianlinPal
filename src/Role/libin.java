package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class libin extends Role {
	

	public libin(GamePanel Gp) {
		super(Gp);
		name="libin";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.mt.going&&gp.pl.mt.level!=147){
			scene=11;
			locX=21;
			locY=19;
			direction=MainControler.DOWN;
			count=0;		
				
			}
				
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==69||gp.pl.mt.level==36||gp.pl.mt.level==101){
			returnwords.add("��������ǲ��Ǹ�Ԥϰһ���¿ε������ء�");
			returnwords.add("��������µ�ѧ��һ��Ҫ�ú�ѧϰ��");
		}
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101){
			returnwords.add("�������һ��ȥͼ���ˢ΢������");
			returnwords.add("������no��no��no��");
			returnwords.add("���������һ��ȥ�ɶ���Java����");
			returnwords.add("������no��no��no��");
			returnwords.add("�������Ҫ��һ��ȥ��һ�����׶���С����");
			returnwords.add("��������������ѧ������£���");
		}
		
		if(gp.pl.mt.level==249||gp.pl.mt.level>=261){
			returnwords.add("���������˵3�·ݻ���EL������");	
			returnwords.add("�������������ʲô�ӵ������������������");		
			returnwords.add("��������˵�е�Easy life��easy learning��");		
			
		}
		
	}
}