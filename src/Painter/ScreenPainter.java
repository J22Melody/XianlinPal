package Painter;

import java.awt.Graphics;

import animation.*;

import InterFaceAndAbstractClass.Painter;
import InterFaceAndAbstractClass.animation;
import Main.GamePanel;

public class ScreenPainter implements Painter{
	public GamePanel gp;
	public animation an;

	public ScreenPainter(GamePanel Gp) {
		gp=Gp;
		switch(gp.scene){
		//��ϰ
		case 97:
			an=new studyanimation(gp);
			an.play();
			break;
		//�Ͽ�
		case 98:
			an=new lessonanimation(gp);
			an.play();
			break;
		//˯��
		case 99:
			an=new sleepanimation(gp);
			an.play();
			break;
		//��ת
		case 100:
			an=new jumpanimation(gp);
			an.play();
		    break;
		//��������
		case 101:
			an=new beginanimation(gp);
			an.play();
			break;
	    //��ͷ��
		case 102:
			an=new hairanimation(gp);
			an.play();
			break;
		//��������
		case 103:
			an=new animation1(gp);
			an.play();
			break;
		//д��ǰ��
		case 104:
			an=new animation2(gp);
			an.play();
			break;
		//������ǰ
		case 105:
			an=new animation3(gp);
			an.play();
			break;
		//��ĸ�뿪
		case 106:
			an=new animation4(gp);
			an.play();
			break;
	    //�߻�����
		case 107:
			an=new animation5(gp);
			an.play();
			break;
		//���ӿ���������ѧ�ֲ�
		case 108:
			an=new animation6(gp);
			an.play();
			break;
	    //���ӿ���λ
		case 109:
			an=new animation7(gp);
			an.play();
			break;
		//����˯����Ů��ų���
		case 110:
			an=new animation8(gp);
			an.play();
			break;
		//Ů���ȥ����
		case 111:
			an=new animation9(gp);
			an.play();
			break;
		//˯��ͷ������
		case 112:
			an=new animation10(gp);
			an.play();
			break;
		//�����߽�����
		case 113:
			an=new animation11(gp);
			an.play();
			break;
		//��������
		case 114:
			an=new animation12(gp);
			an.play();
			break;
		//��ʦ���Ľ���
		case 115:
			an=new animation13(gp);
			an.play();
			break;
		//�����߿���ot3��
		case 116:
			an=new animation14(gp);
			an.play();
			break;
		//��������΢����
		case 117:
			an=new animation15(gp);
			an.play();
			break;
		//�����������ڶ���(ot2)
		case 118:
			an=new animation16(gp);
			an.play();
			break;
		//���������ڻ��䵱��
		case 119:
			an=new animation17(gp);
			an.play();
			break;
		//��������
		case 120:
			an=new animation18(gp);
			an.play();
			break;
		//�����������
		case 121:
			an=new animation19(gp);
			an.play();
			break;
		//��ʦ�۽���ŷ���
		case 122:
			an=new animation20(gp);
			an.play();
			break;	
		//��ʦ���뿪
		case 123:
			an=new animation21(gp);
			an.play();
			break;
		//����׷��
		case 124:
			an=new animation22(gp);
			an.play();
			break;
		//ŷ��째�������
		case 125:
			an=new animation23(gp);
			an.play();
			break;
		//��������
		case 126:
			an=new animation24(gp);
			an.play();
			break;
		//�ҵ�����
		case 127:
			an=new animation25(gp);
			an.play();
			break;
		//�뿪��ɽ
		case 128:
			an=new animation26(gp);
			an.play();
			break;
		//��һѧ�ڽ���
		case 129:
			an=new animation27(gp);
			an.play();
			break;
		//ŷ��짺���ʦ��̸������
		case 130:
		    an=new animation28(gp);
		    an.play();
			break;
		//������
		case 131:
			an=new animation29(gp);
			an.play();
			break;	
		//ŷ��짿���
		case 132:
			an=new animation30(gp);
			an.play();
			break;	
		//���˿�ʼѵ��
		case 133:
			an=new animation31(gp);
			an.play();
			break;	
	    //��ǿ������ǰ���칫��
		case 134:
			an=new animation32(gp);
			an.play();
			break;
		//ŷ����ó���֦
		case 135:
			an=new animation33(gp);
			an.play();
			break;	
		//����
		case 136:
			an=new animation34(gp);
			an.play();
			break;
		//������Ҷ��Ū��ˮ
		case 137:
			an=new animation35(gp);
			an.play();
			break;
		//ŷ����ռ�
		case 138:
			an=new animation36(gp);
			an.play();
			break;
		//������Ϯ
		case 139:
			an=new animation37(gp);
			an.play();
			break;
		//�����о���
		case 140:
			an=new animation38(gp);
			an.play();
			break;
		//��ʦ���ϵ��о���
		case 141:
			an=new animation39(gp);
			an.play();
			break;
		//��è��ѧ����
		case 142:
			an=new animation40(gp);
			an.play();
			break;
		//����˯��
		case 143:
			an=new animation41(gp);
			an.play();
			break;
		//������ͼ��ݻ�ȥ
		case 144:
			an=new animation42(gp);
			an.play();
			break;
		//���˸Ϲ�
		case 145:
			an=new animation43(gp);
			an.play();
			break;
		//սʤ��ħ��
		case 146:
			an=new animation44(gp);
			an.play();
			break;
		//���ǰ
		case 147:
			an=new animation45(gp);
			an.play();
			break;
		//��
		case 148:
			an=new animation46(gp);
			an.play();
			break;
		//gameover
		case 300:
			an=new gameoveranimation(gp);
			an.play();
			break;
		}
		
	}

	@Override
	public void draw(Graphics g) {

		an.drawnext(g);
		
	}

}
