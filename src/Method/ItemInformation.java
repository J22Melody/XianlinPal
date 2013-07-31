package Method;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Main.Item;

public abstract class ItemInformation {
	public static void work(Item a){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("script/item/"+a.num+".txt"));
			a.name=reader.readLine();
			a.Useword=reader.readLine();
			a.Lookword=reader.readLine();
			reader.close();
			reader=null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
