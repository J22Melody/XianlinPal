package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class jiangqiang extends Role {
	

	public jiangqiang(GamePanel Gp) {
		super(Gp);
		name="jiangqiang";		
	}


	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.mt.going&&gp.pl.mt.level!=147){
			scene=11;
			locX=29;
			locY=19;
			direction=MainControler.DOWN;
			count=0;

		}
	
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==69||gp.pl.mt.level==36){
			returnwords.add("���ѽ�ǿ�������˸��пຣ��һ��Ҫ�ú��氡��");
		}
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101){
			returnwords.add("���ѽ�ǿ����˵��ѧ������һ����ͻ���п�ѧ�����أ�����û�����ˡ�");
			returnwords.add("���ѽ�ǿ�������ʦ���ƺ���������");
			returnwords.add("���ѽ�ǿ���뵽��ë���Ȼ����");		
		}
		
		if(gp.pl.mt.level==249||gp.pl.mt.level>=261){
			returnwords.add("���ѽ�ǿ����ѧ���е羺�����أ�Dota��ħ�ޡ�CS...");	
			returnwords.add("���ѽ�ǿ������Ű�����ǡ�");
		}
		
		
	}
}