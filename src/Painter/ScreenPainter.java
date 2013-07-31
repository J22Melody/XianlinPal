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
		//自习
		case 97:
			an=new studyanimation(gp);
			an.play();
			break;
		//上课
		case 98:
			an=new lessonanimation(gp);
			an.play();
			break;
		//睡觉
		case 99:
			an=new sleepanimation(gp);
			an.play();
			break;
		//跳转
		case 100:
			an=new jumpanimation(gp);
			an.play();
		    break;
		//开场动画
		case 101:
			an=new beginanimation(gp);
			an.play();
			break;
	    //剪头发
		case 102:
			an=new hairanimation(gp);
			an.play();
			break;
		//介绍秦舢
		case 103:
			an=new animation1(gp);
			an.play();
			break;
		//写在前言
		case 104:
			an=new animation2(gp);
			an.play();
			break;
		//三个月前
		case 105:
			an=new animation3(gp);
			an.play();
			break;
		//父母离开
		case 106:
			an=new animation4(gp);
			an.play();
			break;
	    //走回宿舍
		case 107:
			an=new animation5(gp);
			an.play();
			break;
		//王子凯给秦舢入学手册
		case 108:
			an=new animation6(gp);
			an.play();
			break;
	    //王子凯回位
		case 109:
			an=new animation7(gp);
			an.play();
			break;
		//秦舢睡觉，女猪脚出场
		case 110:
			an=new animation8(gp);
			an.play();
			break;
		//女猪脚去教室
		case 111:
			an=new animation9(gp);
			an.play();
			break;
		//睡过头的秦舢
		case 112:
			an=new animation10(gp);
			an.play();
			break;
		//秦舢走进教室
		case 113:
			an=new animation11(gp);
			an.play();
			break;
		//秦舢入座
		case 114:
			an=new animation12(gp);
			an.play();
			break;
		//老师刘的讲话
		case 115:
			an=new animation13(gp);
			an.play();
			break;
		//秦舢走开（ot3）
		case 116:
			an=new animation14(gp);
			an.play();
			break;
		//秦舢翻译微积分
		case 117:
			an=new animation15(gp);
			an.play();
			break;
		//秦舢做到吴磊对面(ot2)
		case 118:
			an=new animation16(gp);
			an.play();
			break;
		//秦舢和吴磊回忆当初
		case 119:
			an=new animation17(gp);
			an.play();
			break;
		//秦舢喝醉
		case 120:
			an=new animation18(gp);
			an.play();
			break;
		//秦舢测验结束
		case 121:
			an=new animation19(gp);
			an.play();
			break;
		//老师邵介绍欧阳歆
		case 122:
			an=new animation20(gp);
			an.play();
			break;	
		//老师邵离开
		case 123:
			an=new animation21(gp);
			an.play();
			break;
		//秦舢追出
		case 124:
			an=new animation22(gp);
			an.play();
			break;
		//欧阳歆跟着秦舢
		case 125:
			an=new animation23(gp);
			an.play();
			break;
		//门卫开门
		case 126:
			an=new animation24(gp);
			an.play();
			break;
		//找到杨枳
		case 127:
			an=new animation25(gp);
			an.play();
			break;
		//离开后山
		case 128:
			an=new animation26(gp);
			an.play();
			break;
		//第一学期结束
		case 129:
			an=new animation27(gp);
			an.play();
			break;
		//欧阳歆和老师刘谈话过后
		case 130:
		    an=new animation28(gp);
		    an.play();
			break;
		//找秦舢
		case 131:
			an=new animation29(gp);
			an.play();
			break;	
		//欧阳歆开工
		case 132:
			an=new animation30(gp);
			an.play();
			break;	
		//三人开始训练
		case 133:
			an=new animation31(gp);
			an.play();
			break;	
	    //王强和秦舢前往办公室
		case 134:
			an=new animation32(gp);
			an.play();
			break;
		//欧阳歆拿出树枝
		case 135:
			an=new animation33(gp);
			an.play();
			break;	
		//次日
		case 136:
			an=new animation34(gp);
			an.play();
			break;
		//秦舢把叶子弄入水
		case 137:
			an=new animation35(gp);
			an.play();
			break;
		//欧阳歆日记
		case 138:
			an=new animation36(gp);
			an.play();
			break;
		//秦舢遇袭
		case 139:
			an=new animation37(gp);
			an.play();
			break;
		//进入研究室
		case 140:
			an=new animation38(gp);
			an.play();
			break;
		//老师刘赶到研究室
		case 141:
			an=new animation39(gp);
			an.play();
			break;
		//红猫大学结束
		case 142:
			an=new animation40(gp);
			an.play();
			break;
		//秦舢睡着
		case 143:
			an=new animation41(gp);
			an.play();
			break;
		//秦舢从图书馆回去
		case 144:
			an=new animation42(gp);
			an.play();
			break;
		//四人赶工
		case 145:
			an=new animation43(gp);
			an.play();
			break;
		//战胜心魔后
		case 146:
			an=new animation44(gp);
			an.play();
			break;
		//结局前
		case 147:
			an=new animation45(gp);
			an.play();
			break;
		//终
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
