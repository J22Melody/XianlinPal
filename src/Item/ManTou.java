package Item;

import Main.GamePanel;
import Main.Item;



public class ManTou extends Item{

	
	public ManTou(GamePanel Gp, int Pos) {
		super(Gp, Pos);
		num=1;
		Method.ItemInformation.work(this);
	}

	public void use(int k) {	
		super.use(k);
	    switch(k){
	    case 1:
	    	Useword="����"+Useword;
	    	gp.pl.sp+=10;
	    	break;
	    case 2:
	    	Useword="��С��"+Useword;
	    	gp.pl.sp2+=10;
	    	break;
	    case 3:
	    	Useword="����"+Useword;
	    	gp.pl.sp3+=10;
	    	break;
	    case 4:
	    	Useword="ŷ���"+Useword;
	    	gp.pl.sp4+=10;
	    	break;
	    }
	}


}
