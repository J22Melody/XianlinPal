package Item;

import Main.GamePanel;
import Main.Item;

public class XinShengShouCe extends Item {

	public XinShengShouCe(GamePanel Gp, int Pos) {
		super(Gp, Pos);
		num=3;
		Method.ItemInformation.work(this);
	}

}
