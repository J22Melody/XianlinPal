package Method;

import Event.*;

import InterFaceAndAbstractClass.Event;
import Main.GamePanel;


public abstract class EventReader {
	
	public static Event work(int a,GamePanel gp, String temps){
		//�Ե�ͼ��һ�п��ܳ��ֵ��¼�ͳһ��ţ��ڴ˷����а���Ŵ���
		Event temp = null;
		
		switch(a){
		//ʲôҲ����
		case 1:
			temp=new EndDialog(gp);
			temp.word=temps;
			break;
		//����¥��������ѧ
		case 2:
			temp=new Jump(gp,10,34,48);
			temp.word=temps;
			break;
		//��
		case 3:
			temp=new Hair(gp);
			temp.word=temps;
			break;
		//�������ᵽ������ѧ
		case 4:
			temp=new Jump(gp,10,33,97);
			temp.word=temps;
			break;
		//��һ��������ѧ
		case 5:
			temp=new Jump(gp,10,71,103);
			temp.word=temps;
			break;
		//�ɶ���������ѧ
		case 6:
			temp=new Jump(gp,10,73,108);
			temp.word=temps;
			break;
		//ͼ��ݵ�������ѧ
		case 7:
			temp=new Jump(gp,10,83,76);
			temp.word=temps;
			break;
		//�����ᵽ������ѧ
		case 8:
			temp=new Jump(gp,10,41,70);
			temp.word=temps;
			break;
		//������ѧ������
		case 9:
			temp=new Jump(gp,11,25,9);
			temp.word=temps;
			break;
		//������ѧ���ɶ�
		case 10:
			temp=new Jump(gp,13,14,13);
			temp.word=temps;
			break;	
		//������ѧ����һ
		case 11:
			temp=new Jump(gp,14,15,14);
			temp.word=temps;
			break;	
		//������ѧ��ͼ���
		case 12:
			temp=new Jump(gp,24,24,54);
			temp.word=temps;
			break;	
		//������ѧ��������
		case 13:
			temp=new Jump(gp,22,15,13);
			temp.word=temps;
			break;	
		//������ѧ������¥
		case 14:
			temp=new Jump(gp,19,14,14);
			temp.word=temps;
			break;	
	    //˯��
		case 15:
			temp=new Sleep(gp);
			temp.word=temps;
			break;
		//�Ͽ�
		case 16:
			temp=new Lesson(gp);
			temp.word=temps;
			break;
		//��ϰ
		case 17:
			temp=new Study(gp);
			temp.word=temps;
			break;
//		//���ص�
//		case 18:
//			temp=new HuaZhongDian(gp);
//			temp.word=temps;
//			break;
		//���ݷ�¥��������ѧ
		case 19:
			temp=new Jump(gp,10,71,127);
			temp.word=temps;
			break;	
		//��������ѧ���ݷ�¥
		case 20:
			temp=new Jump(gp,17,15,14);
			temp.word=temps;
			break;
		//��������ѧ��������
		case 21:
			temp=new Jump(gp,15,20,18);
			temp.word=temps;
			break;
		//�������ݵ�������ѧ
		case 22:
			temp=new Jump(gp,10,43,97);
			temp.word=temps;
			break;
		//��УҽԺ��������ѧ
		case 23:
			temp=new Jump(gp,10,28,57);
			temp.word=temps;
			break;
		//��������ѧ��УҽԺ
		case 24:
			temp=new Jump(gp,18,20,16);
			temp.word=temps;
			break;
		//��ʳ�õ�������ѧ
		case 25:
			temp=new Jump(gp,10,30,114);
			temp.word=temps;
			break;
		//��������ѧ��ʳ��
		case 26:
			temp=new Jump(gp,33,24,18);
			temp.word=temps;
			break;
		//УҽԺ������Ѫ�;���
		case 27:
			temp=new Heal(gp);
			temp.word=temps;
			break;
	    //ȥ��ɽ
		case 28:
			temp=new Jump(gp,28,147,152);
//			temp=new Jump(gp,28,78,46);
			temp.word=temps;
			break;
		//���ص�
		case 29:
			temp=new HuaZhongDian(gp);
			temp.word=temps;
			break;
		//��ɽ���͵�
		case 30:
			temp=new Jump(gp,28,155,32);
			temp.word=temps;
			break;
		case 31:
			temp=new Jump(gp,28,154,102);
			temp.word=temps;
			break;
		case 32:
			temp=new Jump(gp,28,110,140);
			temp.word=temps;
			break;
		case 33:
			temp=new Jump(gp,28,122,121);
			temp.word=temps;
			break;
		case 34:
			temp=new Jump(gp,28,90,128);
			temp.word=temps;
			break;
		case 35:
			temp=new Jump(gp,28,60,126);
			temp.word=temps;
			break;
		case 36:
			temp=new Jump(gp,28,155,32);
			temp.word=temps;
			break;
		//��������ѧ�������
		case 37:
			temp=new Jump(gp,23,22,23);
			temp.word=temps;
			break;
		//������굽������ѧ
		case 38:
			temp=new Jump(gp,10,29,70);
			temp.word=temps;
			break;
		//�ӳ���Ϧʰ��������ѧ
		case 39:
			temp=new Jump(gp,10,28,83);
			temp.word=temps;
			break;
		//��������ѧ������Ϧʰ
		case 40:
			temp=new Jump(gp,20,27,21);
			temp.word=temps;
			break;
		//�ӽ̳���������ѧ
		case 41:
			temp=new Jump(gp,10,44,83);
			temp.word=temps;
			break;
		//��������ѧ���̳�	
		case 42:
			temp=new Jump(gp,21,27,21);
			temp.word=temps;
			break;
		//��������ѧ������
		case 43:
			temp=new Jump(gp,16,31,20);
			temp.word=temps;
			break;
		//�ӻ�����������ѧ
		case 44:
			temp=new Jump(gp,10,37,123);
			temp.word=temps;
			break;
		//��������ѧ��ͨ����ϰ��
		case 45:
			temp=new Jump(gp,34,25,26);
			temp.word=temps;
			break;
		//��ͨ����ϰ�ҵ�������ѧ
		case 46:
			temp=new Jump(gp,10,27,101);
			temp.word=temps;
			break;
		//��������ѧ�����
		case 47:
			temp=new Jump(gp,26,14,19);
			temp.word=temps;
			break;
		//�Ӵ�������ѧ
		case 48:
			temp=new Jump(gp,10,67,75);
			temp.word=temps;
			break;
		//ͼ����Թ�
		case 49:
			temp = new Jump(gp, 25, 61, 79);
			temp.word = temps;
			break;
		case 50:
			temp = new Jump(gp, 25, 61, 22);
			temp.word = temps;
			break;
		case 51:
			temp = new Jump(gp, 25, 25, 50);
			temp.word = temps;
			break;
		case 52:
			temp = new Jump(gp, 25, 107, 50);
			temp.word = temps;
			break;
		case 53:
			temp = new Jump(gp, 25, 21, 18);
			temp.word = temps;
			break;
		case 54:
			temp = new Jump(gp, 25, 21, 83);
			temp.word = temps;
			break;
		case 55:
			temp = new Jump(gp, 25, 102, 13);
			temp.word = temps;
			break;
		case 56:
			temp = new Jump(gp, 25, 61, 55);
			temp.word = temps;
			break;
		case 57:
			temp = new Jump(gp, 25, 20, 55);
			temp.word = temps;
			break;
		case 58:
			temp = new Jump(gp, 25, 102, 55);
			temp.word = temps;
			break;
		case 59:
			temp = new Jump(gp, 25, 20, 22);
			temp.word = temps;
			break;
		case 60:
			temp = new Jump(gp, 25, 20, 88);
			temp.word = temps;
			break;
		case 61:
			temp = new Jump(gp, 25, 61, 46);
			temp.word = temps;
			break;
		case 62:
			temp = new Jump(gp, 25, 102, 22);
			temp.word = temps;
			break;
		case 63:
			temp = new Jump(gp, 25, 20, 46);
			temp.word = temps;
			break;
		case 64:
			temp = new Jump(gp, 25, 102, 46);
			temp.word = temps;
			break;
		case 65:
			temp = new Jump(gp, 25, 20, 13);
			temp.word = temps;
			break;
		case 66:
			temp = new Jump(gp, 25, 20, 79);
			temp.word = temps;
			break;
		case 67:
			temp = new Jump(gp, 25, 66, 83);
			temp.word = temps;
			break;
		case 68:
			temp = new Jump(gp, 25, 66, 17);
			temp.word = temps;
			break;
		case 69:
			temp = new Jump(gp, 25, 107, 17);
			temp.word = temps;
			break;
		case 70:
			temp = new Jump(gp, 25, 66, 50);
			temp.word = temps;
			break;
		case 71:
			temp = new Jump(gp, 25, 25, 17);
			temp.word = temps;
			break;
		case 72:
			temp = new Jump(gp, 25, 25, 83);
			temp.word = temps;
			break;
		case 73:
			temp = new Jump(gp, 25, 66, 83);
			temp.word = temps;
			break;
		case 74:
			temp = new Jump(gp, 25, 66, 17);
			temp.word = temps;
			break;
		case 75:
			temp = new Jump(gp, 25, 66, 50);
			temp.word = temps;
			break;
		case 76:
			temp = new Jump(gp, 25, 107, 17);
			temp.word = temps;
			break;
		case 77:
			temp = new Jump(gp, 25, 25, 17);
			temp.word = temps;
			break;
		case 78:
			temp = new Jump(gp, 25, 25, 83);
			temp.word = temps;
			break;
		case 79:
			temp = new Jump(gp, 25, 62, 83);
			temp.word = temps;
			break;
		case 80:
			temp = new Jump(gp, 25, 62, 17);
			temp.word = temps;
			break;
		case 81:
			temp = new Jump(gp, 25, 21, 50);
			temp.word = temps;
			break;
		case 82:
			temp = new Jump(gp, 25, 103, 50);
			temp.word = temps;
			break;
		case 83:
			temp = new Jump(gp, 25, 103, 18);
			temp.word = temps;
			break;
		case 84:
			temp = new Jump(gp, 25, 62, 50);
			temp.word = temps;
			break;
		case 85:
			temp = new Jump(gp, 25, 62, 84);
			temp.word = temps;
			break;
		case 86:
			temp = new Jump(gp, 25, 62, 18);
			temp.word = temps;
			break;
		case 87:
			temp = new Jump(gp, 25, 21, 51);
			temp.word = temps;
			break;
		case 88:
			temp = new Jump(gp, 25, 103, 51);
			temp.word = temps;
			break;
		case 89:
			temp = new Jump(gp, 25, 62, 51);
			temp.word = temps;
			break;
		case 90:
			temp = new Jump(gp, 25, 103, 17);
			temp.word = temps;
			break;
		case 91:
			temp = new Jump(gp, 25, 61, 13);
			temp.word = temps;
			break;
		case 92:
			temp = new Jump(gp, 25, 61, 88);
			temp.word = temps;
			break;
		case 93:
			temp = new Jump(gp, 25, 107, 50);
			temp.word = temps;
			break;
		case 94:
			temp = new Jump(gp, 25, 25, 50);
			temp.word = temps;
			break;
		case 95:
			temp = new Jump(gp, 25, 21, 84);
			temp.word = temps;
			break;
		case 96:
			temp = new Jump(gp, 25, 21, 17);
			temp.word = temps;
			break;
		//������ѧȥ��è��ѧ
		case 97:
			temp = new Jump(gp, 31, 61, 105);
			temp.word = temps;
			break;		
		//��è��ѧ�����о���
		case 98:
			temp = new Jump(gp,32,33,20);
			temp.word = temps;
			break;	
		//ͼ��ݵ�ͼ�������
	    case 99:
		    temp=new Jump(gp,30,29,19);
		    temp.word=temps;
		    break;
		 //��ש
	    case 100:
  			temp=new BanZhuan(gp);
  			temp.word=temps;
  			break;
  		//�Ứ
	    case 101:
  			temp=new BanHua(gp);
  			temp.word=temps;
  			break;
  		//��
	    case 102:
  			temp=new DaKa(gp);
  			temp.word=temps;
  			break;
		  		
		}		
		
		
		return temp;
	}
	
	

}
