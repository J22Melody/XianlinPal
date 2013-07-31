package Method;

import Item.*;
import Main.GamePanel;
import Main.Item;

public abstract class LoadItem {
	public static Item work(int a, int i, GamePanel gp){
		Item temp = null;
		switch(a){
		case 1:
			temp=new ManTou(gp,i);
			break;
		case 2:
			temp=new Egg(gp,i);
			break;
		case 3:
			temp=new XinShengShouCe(gp,i);
			break;
		case 4:
			temp=new STfruit(gp,i);
			break;
		case 5:
			temp=new RPfruit(gp,i);
			break;
		case 6:
			temp=new IQfruit(gp,i);
			break;
		case 7:
			temp=new diary(gp,i);
			break;
		}
		return temp;
	}

}
