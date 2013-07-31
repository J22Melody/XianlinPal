package Main;

public class Item{
	
	public String name;
	public GamePanel gp;
	public int pos;
	public String Useword;
	public String Lookword;
	public int num;
	


	
	public Item(GamePanel Gp,int Pos){
		pos=Pos;
		gp=Gp;			
	}
	

	public void use(int i) {
		gp.sp.play("itemuse");
	}

	public void discard() {
		gp.pl.Bag.remove(pos);
		for(int i=0;i<gp.pl.Bag.size();i++){
			gp.pl.Bag.get(i).pos-=1;
		}
	}

	

}