package Role;

import java.util.ArrayList;

import Controler.MainControler;
import InterFaceAndAbstractClass.Role;
import Main.GamePanel;

public class wangzikai extends Role {
	

	public wangzikai(GamePanel Gp) {
		super(Gp);
		name="wangzikai";		
	}


	
	public void update(){
		super.update();
		
		if(!istalking&&!gp.pl.mt.going&&gp.pl.mt.level!=147){
			scene=11;
			locX=27;
			locY=20;
			direction=MainControler.DOWN;
			count=0;	
		
		}
			
	}
	
	public void getwords(){
		returnwords=null;
		returnwords=new ArrayList<String>();
		
		if(gp.pl.mt.level==69||gp.pl.mt.level==36){
			returnwords.add("�������ӿ�����ѧ�������ڿ�ʼ�ˡ�");
			returnwords.add("�������ӿ�����������������ò˫ȫ���������ܵ���һ�����÷���ˮ��ɹ�����");
		}
		
		if(gp.pl.mt.level==100||gp.pl.mt.level==101){
			returnwords.add("�������ӿ������ܲ����������ˣ�һ����֪���棬һ����֪��ѧ��");
			returnwords.add("�������ӿ����ҿ���Ҫ�ɾʹ���ҵ���ˡ�");
			returnwords.add("�������ӿ��������ע��עѧ�������ί�������أ������ܲ��ܻ��һ�ٰ�ְ�ġ�");
		}
		
		
		if(gp.pl.mt.level==249||gp.pl.mt.level>=261){
			returnwords.add("�������ӿ�����ѧ����ȡ����ѧ������ϯ��С������ʱ������㣬Ҳ��������ʲô�������档");	
			returnwords.add("���������������ˣ��Ҳ��еġ�");	
		}
		
		
	}
}