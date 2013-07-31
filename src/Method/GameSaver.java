package Method;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Main.GamePanel;

public abstract class GameSaver {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void work(GamePanel gp,int a){
		
		ArrayList data=new ArrayList();

		data.add(gp.pl.scene);
		data.add(gp.pl.TeamNum);
		data.add(gp.pl.locX);
		data.add(gp.pl.locY);
		data.add(gp.pl.direction);
		data.add(gp.pl.count);
		data.add(gp.pl.wholeads);
		data.add(gp.pl.Money);
		data.add(gp.pl.speed);
		
		data.add(gp.pl.hp);
		data.add(gp.pl.mp);
		data.add(gp.pl.sp);
		data.add(gp.pl.RP);
		data.add(gp.pl.IQ);
		data.add(gp.pl.ST);
		data.add(gp.pl.GPA);
		data.add(gp.pl.VP);
		
		data.add(gp.pl.hp2);
		data.add(gp.pl.mp2);
		data.add(gp.pl.sp2);
		data.add(gp.pl.RP2);
		data.add(gp.pl.IQ2);
		data.add(gp.pl.ST2);
		data.add(gp.pl.GPA2);
		data.add(gp.pl.VP2);
		
		data.add(gp.pl.hp3);
		data.add(gp.pl.mp3);
		data.add(gp.pl.sp3);
		data.add(gp.pl.RP3);
		data.add(gp.pl.IQ3);
		data.add(gp.pl.ST3);
		data.add(gp.pl.GPA3);
		data.add(gp.pl.VP3);
		
		data.add(gp.pl.hp4);
		data.add(gp.pl.mp4);
		data.add(gp.pl.sp4);
		data.add(gp.pl.RP4);
		data.add(gp.pl.IQ4);
		data.add(gp.pl.ST4);
		data.add(gp.pl.GPA4);
		data.add(gp.pl.VP4);
		
		for(int i=0;i<gp.pl.Bag.size();i++){
			data.add(gp.pl.Bag.get(i).num);
		}
		
		for(int i=0;i<20-gp.pl.Bag.size();i++){
			data.add(0);
		}
		
		data.add(gp.pl.mt.level);
		data.add(gp.pl.ot1.level);
		data.add(gp.pl.ot2.level);
		data.add(gp.pl.ot3.level);
		data.add(gp.pl.ot4.level);
		data.add(gp.pl.ot5.level);
		data.add(gp.pl.ot6.level);
		data.add(gp.pl.ot7.level);
		data.add(gp.pl.ot8.level);
		data.add(gp.pl.DK.level);
		data.add(gp.pl.PT.level);
		
		for(int i=0;i<100;i++){
			data.add(gp.pl.Temp[i]);
		}
		
		
		
		
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
		String s=sdf.format(date);
		
		
	
		 
		
		try {
			BufferedWriter timewriter=new BufferedWriter(new FileWriter("script/save/time"+a+".txt"));
			timewriter.write(s);
			timewriter.close();
			timewriter=null;
			
			BufferedWriter writer=new BufferedWriter(new FileWriter("script/save/"+a+".txt"));
			
			for(int i=0;i<data.size();i++){
				writer.write(String.valueOf(data.get(i)));
				writer.newLine();
			}
			
		
			
			writer.flush();
			writer.close();
			writer=null;
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	
	}

}
