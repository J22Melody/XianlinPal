package Task;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Main.GamePanel;

public class OptionalTask8 {

	public GamePanel gp;
	
	//�Ƿ��ڽ���
	public boolean going;
	
	//����
	public int level;
	
	public ArrayList<String> dialog;
	
	public int count;
	
	public OptionalTask8(GamePanel Gp){
		gp=Gp;
		going=false;
        getdialog();

	}
	


	//���������ʾ
	public String getintroduction() {
		String temp=null;
        
		return temp;

	}

	//�Ƿ�ɴ����Ի�
	public boolean CanGo(){
		boolean temp=false;
		switch(level){
	
		}
		return temp;	
	}
	
	//����
	public void update(){
		if(CanGo()){
			gp.pl.wholeads=1;
			gp.pl.isMoving=false;
			going=true;
			gp.scene=208;
		}
	}
	
	//���鷢չ
	public void next(){
		switch(level){
		
		}
		level++;
	}

	//�������
    public void draw(Graphics g){
	
		
		//�Ի�	
		if(gp.scene==208){
			g.drawImage(Method.ImageReader.work("menu/talk"),100,330,null);
			
			String s=dialog.get(level);
			int x=33;
			int i=0;
			
			int k=s.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=s.substring(i*x,(i+1)*x);
				}else{
					temp=s.substring(i*x,s.length());
				}
				g.drawString(temp,200,390+20*i);
			}
			//�ı����״̬
			if(count!=0){
				if(count==4){
					count=0;
				}else{
					count++;
				}
			}
		}
	}
	
	//��ȡ���жԻ�
    public void getdialog() {
    	dialog=new ArrayList<String>();
	
    	try {
			BufferedReader reader = new BufferedReader(new FileReader("script/task/OptionalTask8.txt"));	
			
			while(true){
				String s = reader.readLine();
				if(s==null){
					break;
				}else{
					dialog.add(s);
				}
			}			
			
			reader.close();
			reader=null;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
