package Item;

import Main.GamePanel;
import Main.Item;



public class RPfruit extends Item{

	
	public RPfruit(GamePanel Gp, int Pos) {
		super(Gp, Pos);
		num=5;
		Method.ItemInformation.work(this);
	}

	public void use(int k) {	
		super.use(k);
	    switch(k){
	    case 1:
	    	Useword="ÇØô®"+Useword;
	    	gp.pl.RP+=10;
	    	break;
	    case 2:
	    	Useword="ºÎÐ¡Íñ"+Useword;
	    	gp.pl.RP2+=10;
	    	break;
	    case 3:
	    	Useword="Ñîè×"+Useword;
	    	gp.pl.RP3+=10;
	    	break;
	    case 4:
	    	Useword="Å·Ñôì§"+Useword;
	    	gp.pl.RP4+=10;
	    	break;
	    }
	}
}