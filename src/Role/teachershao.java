package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class teachershao extends Role {
	

	public teachershao(GamePanel Gp) {
		super(Gp);
		name="teachershao";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking){
		
			
			if(gp.pl.mt.level==100||gp.pl.mt.level==101||gp.pl.mt.level==147||gp.pl.mt.level==170||gp.pl.mt.level==249||gp.pl.mt.level>=261){
				scene=17;
				locX=23;
				locY=15;
				direction=MainControler.DOWN;
						
			}
		
		}
		
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101||gp.pl.mt.level==249){
			returnwords.add("��ʦ�ۣ��������Ǹ���Ա��ͬ�¡�");
			returnwords.add("��ʦ�ۣ����Ѿ������﹤����30���ˡ�");
			returnwords.add("��ʦ�ۣ������ڽ̸��꼶�أ�");

		}
		if(gp.pl.mt.level>=261){
			returnwords.add("��ʦ�ۣ����ѧԺ�������ɾͿ������˰���");
		}
	}
}