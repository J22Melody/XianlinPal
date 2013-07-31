package Method;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import Main.Dialog;
import Main.GamePanel;
import Main.Jump;
import Main.Map;
import Main.NPC;

public abstract class MapReader {
	
	

	public static void work(Map map, GamePanel gp){
		
		try {
			String s=null;
			Scanner reader = new Scanner(new FileReader("script/map/"+gp.pl.scene+".txt"));
			
			while(true){
			    s= reader.nextLine();
				
				if(s.equals("<script>")){
					continue;
				}

				if (s.equals("</script>")) {
					reader.close();
					reader=null;
					break;
				}
				
				switch(s){
				case "<map0>":
					ArrayList<String> temp=new ArrayList<String>();
					while(true){
						s=reader.nextLine();
						if(s.equals("</map0>")){
							break;
						}
						temp.add(s);
					}
					//行数
					map.row=temp.size();
					//列数(!----------文件每行末尾必须打制表符---------!）
					map.column=0;
					for(int i=0;i<temp.get(0).length();i++){
						if(temp.get(0).charAt(i)=='\t'){
							map.column++;
						}
					}
					map.map0=new int[map.row][map.column];
					String a="";
					for(int i=0;i<temp.size();i++){
						int b=0;
						for(int j=0;j<temp.get(i).length()-1;j++){
							if(temp.get(i).charAt(j)!='\t'){
								a=a+(temp.get(i).charAt(j));
							}else{
								map.map0[i][b]=Integer.parseInt(a);
								b++;
								a="";
							}
						}
					}
					temp=null;
					break;
					
				case "<map1>":
					ArrayList<String> temp1=new ArrayList<String>();
					while(true){
						s=reader.nextLine();
						if(s.equals("</map1>")){
							break;
						}
						temp1.add(s);
					}
					map.map1=new int[map.row][map.column];
					a="";
					for(int i=0;i<temp1.size();i++){
						int b=0;
						for(int j=0;j<temp1.get(i).length()-1;j++){
							if(temp1.get(i).charAt(j)!='\t'){
								a=a+(temp1.get(i).charAt(j));
							}else{
								map.map1[i][b]=Integer.parseInt(a);
								b++;
								a="";
							}
						}
					}
					temp1=null;
					break;
					
				case "<map2>":
					ArrayList<String> temp2=new ArrayList<String>();
					while(true){
						s=reader.nextLine();
						if(s.equals("</map2>")){
							break;
						}
						temp2.add(s);
					}
					map.map2=new int[map.row][map.column];
					a="";
					for(int i=0;i<temp2.size();i++){
						int b=0;
						for(int j=0;j<temp2.get(i).length()-1;j++){
							if(temp2.get(i).charAt(j)!='\t'){
								a=a+(temp2.get(i).charAt(j));
							}else{
								map.map2[i][b]=Integer.parseInt(a);
								b++;
								a="";
							}
						}
					}
					temp2=null;
					break;
					
				case "<jump>":
					Jump jump=new Jump(gp);
					while(true){
						s=reader.nextLine();
						if(s.equals("</jump>")){
							break;
						}
						switch(s){
						case "<name>":
							s=reader.nextLine();
							jump.name=s;
							s=reader.nextLine();
							break;
						case "<locX>":
							s=reader.nextLine();
							jump.locX=Integer.parseInt(s);  
							s=reader.nextLine();
							break;
						case "<locY>":
							s=reader.nextLine();
							jump.locY=Integer.parseInt(s);
							s=reader.nextLine();
							break;
						case "<dialog>":
							Dialog d=new Dialog();
							while(true){
								s=reader.nextLine();
								if(s.equals("</dialog>")){
									break;		
								}
								switch(s){
								case "<content>":
									s=reader.nextLine();
					                d.content=s;
									s=reader.nextLine();
									break;
								case "<event>":
									d.canChoose=true;
									while(true){
										s=reader.nextLine();
										if(s.equals("</event>")){
											break;		
										}
										if(s.equals("<option>")){
											s=reader.nextLine();
											String temps=reader.nextLine();
											d.event.add(EventReader.work(Integer.parseInt(s),gp,temps));
											s=reader.nextLine();	
										}
									}						
									break;
								}
							}
							
							jump.dialog.add(d);
							break;
						}
					}
					map.jumps.add(jump);
					jump=null;
					break;
					
				case "<npc>":
					NPC npc=new NPC(gp);
					while(true){
						s=reader.nextLine();
						if(s.equals("</npc>")){
							break;
						}
						switch(s){
						case "<name>":
							s=reader.nextLine();
							npc.name=s;
							s=reader.nextLine();
							break;
						case "<direction>":
							s=reader.nextLine();
							npc.Direction=Integer.parseInt(s);
							npc.direction=npc.Direction;
							s=reader.nextLine();
							break;
						case "<locX>":
							s=reader.nextLine();
							npc.locX=Integer.parseInt(s);  
							s=reader.nextLine();
							break;
						case "<locY>":
							s=reader.nextLine();
							npc.locY=Integer.parseInt(s);
							s=reader.nextLine();
							break;
						case "<dialog>":
							Dialog d=new Dialog();
							while(true){
								s=reader.nextLine();
								if(s.equals("</dialog>")){
									break;		
								}
								switch(s){
								case "<content>":
									s=reader.nextLine();
					                d.content=s;
									s=reader.nextLine();
									break;
								case "<event>":
									d.canChoose=true;
									while(true){
										s=reader.nextLine();
										if(s.equals("</event>")){
											break;		
										}
										if(s.equals("<option>")){
											s=reader.nextLine();
											String temps=reader.nextLine();
											d.event.add(EventReader.work(Integer.parseInt(s),gp,temps));
											s=reader.nextLine();	
										}
									}						
									break;
								}
							}
							npc.dialog.add(d);
							break;
						}
					}
					map.map0[npc.locY][npc.locX]=1;
					map.npcs.add(npc);
					npc=null;
					break;
				}						
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//图书馆迷宫是否可通
		if(gp.pl.scene==24&&!(gp.pl.mt.level==449)){
			map.map0[8][24]=1;
		}
		
		//校门是否可通
		if(gp.pl.scene==10&&!(gp.pl.mt.level==346)){
			map.map0[144][85]=1;
		}
	}
	

}
