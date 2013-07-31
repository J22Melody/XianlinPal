package Main;

import Sound.MusicPlayer;

public class MusicManager {
	

	    //��¼��ʱ����
		public int state;
	
		public MusicManager(){
			//��ʼ��Ϊ��½����
			state=0;
		}
		
		//��������
		public void work(GamePanel gp){
			if(!gp.mp.On){
				gp.mp.stopPlaying();
			}else{
				if(gp.mp.isStopped()&&judge(gp)!=-1){
					play(gp);
				}
				
				if(state!=judge(gp)){
					if(judge(gp)!=-1){
						state=judge(gp);
						play(gp);
						
					}else{
						gp.mp.stopPlaying();
					}
					
				}
				
			}
			
			
			
		}
		
		//����
		public void play(GamePanel gp){

			gp.mp.stopPlaying();
			gp.mp=new MusicPlayer(""+state);
		
		}
		
		//���ݳ����б���������
		private int judge(GamePanel gp){
			//-1������������
			int i=-1;
			
			if(gp.scene==0){
				i=0;
			}else if(gp.scene==80){
				i=2;
			}else if(gp.scene==81){
				i=7;
			}else if(gp.scene==82){
				i=6;
			}else if(gp.scene==83){
				i=6;
			}else if(gp.scene==84){
				i=7;
			}else if(gp.scene<90||gp.scene==100||(gp.scene>200&&gp.scene<=210)){
				if((gp.pl.scene>=10&&gp.pl.scene<=24)||gp.pl.scene==26||gp.pl.scene==27||gp.pl.scene==33||gp.pl.scene==34){
					i=1;
				}
				if(gp.pl.scene==28){
					i=3;
				}
				if(gp.pl.scene==25){
					i=4;
				}
				if(gp.pl.scene==31||gp.pl.scene==32){
					i=5;
				}
			}
			
			return i;
			
		}

}
