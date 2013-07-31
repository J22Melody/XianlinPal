package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class TalkControler implements KeyListener{
	public GamePanel gp;

	public TalkControler(GamePanel Gp) {
		gp=Gp;
		gp.pl.wholeads=1;
		gp.pl.isMoving=false;
	}


	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_UP:
			if(gp.map.npcs.get(gp.pl.talkwith).dialog.get(gp.map.npcs.get(gp.pl.talkwith).state).canChoose){
				gp.map.npcs.get(gp.pl.talkwith).dialog.get(gp.map.npcs.get(gp.pl.talkwith).state).last();
			}
			break;
		case KeyEvent.VK_DOWN:
			if(gp.map.npcs.get(gp.pl.talkwith).dialog.get(gp.map.npcs.get(gp.pl.talkwith).state).canChoose){
				gp.map.npcs.get(gp.pl.talkwith).dialog.get(gp.map.npcs.get(gp.pl.talkwith).state).next();
			}
			break;
		case KeyEvent.VK_SPACE:
			if(gp.pl.talkcount==0){
				if(!gp.map.npcs.get(gp.pl.talkwith).dialog.get(gp.map.npcs.get(gp.pl.talkwith).state).canChoose){
					gp.map.npcs.get(gp.pl.talkwith).nextdialog();
			    }else{
				    gp.map.npcs.get(gp.pl.talkwith).dialog.get(gp.map.npcs.get(gp.pl.talkwith).state).occur();
			    }
				gp.pl.talkcount++;
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
