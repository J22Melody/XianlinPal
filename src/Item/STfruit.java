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
	    	Useword="����"+Useword;
	    	gp.pl.ST+=10;
	    	break;
	    case 2:
	    	Useword="��С��"+Useword;
	    	gp.pl.ST2+=10;
	    	break;
	    case 3:
	    	Useword="����"+Useword;
	    	gp.pl.ST3+=10;
	    	break;
	    case 4:
	    	Useword="ŷ���"+Useword;
	    	gp.pl.ST4+=10;
	    	break;
	    }
	}
}