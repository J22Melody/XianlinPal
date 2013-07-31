package Menu;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;

public class ItemUseMenu extends Menu {

	public ItemUseMenu(Menu Decorated) {
		decorated=Decorated;
		gp=decorated.gp;
		
	}

	public void draw(Graphics g){
		decorated.draw(g);
		
		g.drawImage(Method.ImageReader.work("menu/itemuse"),290,220,null);
		
		g.drawString(gp.pl.Bag.get(decorated.state).Useword,340+6*(18-gp.pl.Bag.get(decorated.state).Useword.length()),240);
	}
}
