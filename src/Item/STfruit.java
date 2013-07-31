package Item;

import Main.GamePanel;
import Main.Item;



public class STfruit extends Item{

	
	public STfruit(GamePanel Gp, int Pos) {
		super(Gp, Pos);
		num=4;
		Method.ItemInformation.work(this);
	}

	public void use(int k) {	
		super.use(k);
	    switch(k){
	    case 1:
	    	Useword="ÇØô®"+Useword;
	    	gp.pl.ST+=10;
	    	break;
	    case 2:
	    	Useword="ºÎÐ¡Íñ"+Useword;
	    	gp.pl.ST2+=10;
	    	break;
	    case 3:
	    	Useword="Ñîè×"+Useword;
	    	gp.pl.ST3+=10;
	    	break;
	    case 4:
	    	Useword="Å·Ñôì§"+Useword;
	    	gp.pl.ST4+=10;
	    	break;
	    }
	}
}