package Painter;
import java.awt.*;

import InterFaceAndAbstractClass.Painter;
import Main.GamePanel;
public class banhuaPainter implements Painter {
	private static final int DOWN = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    
	public GamePanel gp;


	public banhuaPainter(GamePanel Gp) {
		gp=Gp;

	}
	
	public void draw(Graphics g){
		g.drawImage(gp.pl.bh.background,0,0,800,480,null);
    	drawPlace(g);
    	drawMap(g);
    		if(gp.pl.bh.isMove){
     	   if (gp.pl.bh.countRole == 3) {
     		  gp.pl.bh.countRole = 1;
            } else if (gp.pl.bh.countRole == 1) {
            	gp.pl.bh.countRole = 3;
            } else if(gp.pl.bh.countRole==0){
            	gp.pl.bh.countRole=3;
            }
        }

    	if(isWin()){
    		g.drawImage(Method.ImageReader.work("SmallGame/win"),0,0,null);
    		gp.pl.bh.gameover=true;
    
    		
    	}

	}
	public void drawMap(Graphics g){
		for (int x = 0; x < gp.pl.bh.row; x++) {
            for (int j = 0; j < gp.pl.bh.col; j++) {
                switch (gp.pl.bh.map[x][j]) {             
                case 0 : 
                        g.drawImage(gp.pl.bh.barrier, 250+j * gp.pl.bh.CS, 150+x * gp.pl.bh.CS, null);
                        break;
             
                case 1 :
                        g.drawImage(gp.pl.bh.box, 250+j * gp.pl.bh.CS, 150+x * gp.pl.bh.CS, null);
                        break;
                        
                case 2 :
                	    g.drawImage(gp.pl.bh.place, 250+j * gp.pl.bh.CS, 150+x * gp.pl.bh.CS, null);
                	    break;
                case 3 :
                	    g.drawImage(gp.pl.bh.roleImage,250+j*gp.pl.bh.CS,134+x*32,250+j*gp.pl.bh.CS+32,134+x*32+48,gp.pl.bh.countRole*32,gp.pl.bh.directionRole*48,32+gp.pl.bh.countRole*32,gp.pl.bh.directionRole*48+48,null);

                default: break;
                }
            }
		}
		
		if(gp.pl.bh.isMove){
			if(gp.pl.bh.directionRole==DOWN){
			    switch(gp.pl.bh.map[gp.pl.bh.roleX+1][gp.pl.bh.roleY]){
			        case 0:break;
			        case 1:{switch(gp.pl.bh.map[gp.pl.bh.roleX+2][gp.pl.bh.roleY]){
			                   case 0:break;
			                   case 1:break;
			                   case 2:gp.pl.bh.roleX+=1;gp.pl.bh.map[gp.pl.bh.roleX+1][gp.pl.bh.roleY]=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX-1][gp.pl.bh.roleY]=4;break;
			                   case 4:gp.pl.bh.roleX+=1;gp.pl.bh.map[gp.pl.bh.roleX+1][gp.pl.bh.roleY]=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX-1][gp.pl.bh.roleY]=4;break;
			                   default:break;
			        }};break;
			       case 2:gp.pl.bh.roleX+=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX-1][gp.pl.bh.roleY]=4;break;
			       case 4:gp.pl.bh.roleX+=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX-1][gp.pl.bh.roleY]=4;break;
			       default:break;
			    }
			}



			if(gp.pl.bh.directionRole==UP){
			    switch(gp.pl.bh.map[gp.pl.bh.roleX-1][gp.pl.bh.roleY]){
			        case 0:break;
			        case 1:{switch(gp.pl.bh.map[gp.pl.bh.roleX-2][gp.pl.bh.roleY]){
			                   case 0:break;
			                   case 1:break;
			                   case 2:gp.pl.bh.roleX-=1;gp.pl.bh.map[gp.pl.bh.roleX-1][gp.pl.bh.roleY]=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX+1][gp.pl.bh.roleY]=4;break;
			                   case 4:gp.pl.bh.roleX-=1;gp.pl.bh.map[gp.pl.bh.roleX-1][gp.pl.bh.roleY]=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX+1][gp.pl.bh.roleY]=4;break;
			                   default:break;
			        }};break;
			       case 2:gp.pl.bh.roleX-=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX+1][gp.pl.bh.roleY]=4;break;
			       case 4:gp.pl.bh.roleX-=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX+1][gp.pl.bh.roleY]=4;break;
			       default:break;
			    }
			}



			if(gp.pl.bh.directionRole==LEFT){
			    switch(gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY-1]){
			        case 0:break;
			        case 1:{switch(gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY-2]){
			                   case 0:break;
			                   case 1:break;
			                   case 2:gp.pl.bh.roleY-=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY-1]=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY+1]=4;break;
			                   case 4:gp.pl.bh.roleY-=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY-1]=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY+1]=4;break;
			                   default:break;
			        }};break;
			       case 2:gp.pl.bh.roleY-=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY+1]=4;break;
			       case 4:gp.pl.bh.roleY-=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY+1]=4;break;
			       default:break;
			    }
			}



			if(gp.pl.bh.directionRole==RIGHT){
			    switch(gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY+1]){
			        case 0:break;
			        case 1:{switch(gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY+2]){
			                   case 0:break;
			                   case 1:break;
			                   case 2:gp.pl.bh.roleY+=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY+1]=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY-1]=4;break;
			                   case 4:gp.pl.bh.roleY+=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY+1]=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY-1]=4;break;
			                   default:break;
			        }};break;
			       case 2:gp.pl.bh.roleY+=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY-1]=4;break;
			       case 4:gp.pl.bh.roleY+=1;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY]=3;gp.pl.bh.map[gp.pl.bh.roleX][gp.pl.bh.roleY-1]=4;break;
			       default:break;
			    }
			}
			
		}
	}
	
	public void drawPlace(Graphics g){
		for (int x = 0; x < gp.pl.bh.row; x++) {
            for (int j = 0; j < gp.pl.bh.col; j++) {
                switch (gp.pl.bh.location[x][j]) {                   
                    case 2 :
                	    g.drawImage(gp.pl.bh.place, 250+j * gp.pl.bh.CS, 150+x * gp.pl.bh.CS,null);
                	    break;
               
                    default: break;
                }
            }
		}
	}
	
	public boolean isWin(){
	    boolean key=true;
	    for(int i=0;i<gp.pl.bh.numberOfAnswer;i++){
	        if(gp.pl.bh.map[gp.pl.bh.answerX[i]][gp.pl.bh.answerY[i]]!=1)
	            key=false;
	    }
	    return key;
	}

}
