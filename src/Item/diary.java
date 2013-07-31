package Item;

import Main.GamePanel;
import Main.Item;

public class diary extends Item {

	public diary(GamePanel Gp, int Pos) {
		super(Gp, Pos);
		num=7;
		Method.ItemInformation.work(this);
	
	}
	
	public void use(int k) {	
		super.use(k);
	    switch(k){
	    case 1:
	    	Useword="ÇØô®"+Useword;
	    	gp.pl.IQ+=20;
	    	gp.pl.ST+=20;
	    	gp.pl.RP+=20;
	    	break;
	    case 2:
	    	Useword="ºÎÐ¡Íñ"+Useword;
	    	gp.pl.IQ2+=20;
	    	gp.pl.ST2+=20;
	    	gp.pl.RP2+=20;
	    	break;
	    case 3:
	    	Useword="Ñîè×"+Useword;
	    	gp.pl.IQ3+=20;
	    	gp.pl.ST3+=20;
	    	gp.pl.RP3+=20;
	    	break;
	    case 4:
	    	Useword="Å·Ñôì§"+Useword;
	    	gp.pl.IQ4+=20;
	    	gp.pl.ST4+=20;
	    	gp.pl.RP4+=20;
	    	break;
	    }
	}
	
	public void discard(){
		super.discard();
		gp.scene=138;
	}

}
