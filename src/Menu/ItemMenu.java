package Menu;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;

public class ItemMenu extends Menu{

	public ItemMenu(Menu Decorated) {
		decorated=Decorated;
		gp=decorated.gp;
		state=0;
		
	}
	
	public void draw(Graphics g){
		decorated.draw(g);
		
		g.drawImage(Method.ImageReader.work("Menu/ItemMenu"),185,80,null);
		g.setColor(Color.GREEN);
		g.drawRect(221+90*(state%5),100+70*(state/5),90,67);
		g.setColor(Color.BLACK);
		
		if(state<gp.pl.Bag.size()){
			g.drawString(gp.pl.Bag.get(state).Lookword,320+6*(22-gp.pl.Bag.get(state).Lookword.length()),390);
		}
		
		for(int i=0;i<gp.pl.Bag.size();i++){
			g.drawString(gp.pl.Bag.get(i).name,221+90*(i%5)+6*(8-gp.pl.Bag.get(i).name.length()),140+70*(i/5));
		}

	}

}
