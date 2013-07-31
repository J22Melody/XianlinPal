package Item;

import Main.GamePanel;
import Main.Item;



public class IQfruit extends Item{

	
	public IQfruit(GamePanel Gp, int Pos) {
		super(Gp, Pos);
		num=6;
		Method.ItemInformation.work(this);
	}

	public void use(int k) {
		super.use(k);
	    switch(k){
	    case 1:
	    	Useword="ÇØô®"+Useword;
	    	gp.pl.IQ+=10;
	    	break;
	    case 2:
	    	Useword="ºÎÐ¡Íñ"+Useword;
	    	gp.pl.IQ2+=10;
	    	break;
	    case 3:
	    	Useword="Ñîè×"+Useword;
	    	gp.pl.IQ3+=10;
	    	break;
	    case 4:
	    	Useword="Å·Ñôì§"+Useword;
	    	gp.pl.IQ4+=10;
	    	break;
	    }
	}
}