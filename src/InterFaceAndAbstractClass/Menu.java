package InterFaceAndAbstractClass;

import java.awt.Graphics;

import Main.GamePanel;

public abstract class Menu {
	public int state;
	public int maxstate;
	public GamePanel gp;
	public Menu decorated;
	
	//±∏”√
	public int substate;
	
	public void draw(Graphics g) {
		
	}
	
	public void next(){
		gp.sp.play("choose");
		if(state!=maxstate){
			state++;
		}else{
			state=0;
		}
	}
	
	public void last(){
		gp.sp.play("choose");
		if(state!=0){
			state--;
		}else{
			state=maxstate;
		}
	}

}
