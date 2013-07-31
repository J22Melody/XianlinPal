package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class JumpControler implements KeyListener{
	public GamePanel gp;

	public JumpControler(GamePanel Gp) {
		gp=Gp;
	}


	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_UP:
			if(gp.map.jumps.get(gp.pl.talkwith).dialog.get(gp.map.jumps.get(gp.pl.talkwith).state).canChoose){
				gp.map.jumps.get(gp.pl.talkwith).dialog.get(gp.map.jumps.get(gp.pl.talkwith).state).last();
			}
			break;
		case KeyEvent.VK_DOWN:
			if(gp.map.jumps.get(gp.pl.talkwith).dialog.get(gp.map.jumps.get(gp.pl.talkwith).state).canChoose){
				gp.map.jumps.get(gp.pl.talkwith).dialog.get(gp.map.jumps.get(gp.pl.talkwith).state).next();
			}
			break;
		case KeyEvent.VK_SPACE:
			if(!gp.map.jumps.get(gp.pl.talkwith).dialog.get(gp.map.jumps.get(gp.pl.talkwith).state).canChoose){
				gp.map.jumps.get(gp.pl.talkwith).nextdialog();
			}else{
				gp.map.jumps.get(gp.pl.talkwith).dialog.get(gp.map.jumps.get(gp.pl.talkwith).state).occur();
			}
			break;
		}
	
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}