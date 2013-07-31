package FightSystem;

public class AttackJudger {
	
	Player pl;
	public AttackJudger(Player pl){
		this.pl=pl;
	}
	
	public void judgeAttack(){
		if(pl.hasAttacked){
			judgeEffect();
			//可以根据state的值判断攻击力
			pl.actualAtt=(int) (pl.att*20/(pl.plocation-140));
			if(pl.actualAtt>=(int)(pl.att*2.5)){
				pl.actualAtt=(int) (pl.att*2.5);
			}
			if(pl.actualAtt>=999){
				pl.actualAtt=999;
			}
		}
	}
	
	public void judgeMagic(){
		if(pl.magicPrepared){
			judgeEffect();
			pl.actualMatt=(int)(pl.matt*20/(pl.plocation-140));
			if(pl.actualMatt>=(int)(pl.matt*2.5)){
				pl.actualMatt=(int)(pl.matt*2.5);
			}
			if(pl.actualMatt>=999){
				pl.actualMatt=999;
			}
		}
	}
	
	public void judgeGroupMagic(){
		if(pl.groupMagicPrepared){
			judgeEffect();
			pl.actualGMatt=(int)(pl.gMatt*20/(pl.plocation-140));
			if(pl.actualGMatt>=(int)(pl.gMatt*2.5)){
				pl.actualGMatt=(int)(pl.gMatt);
			}
		}
	}
	
	
	public void judgeEscape(Monster[] mos){
		if(pl.escapePrepared){
			pl.escapable=true;
			for(int i=0;i<mos.length;i++){
				if(mos[i].hasAttacked){
					pl.escapable=false;
				}
			}
		}
	}
	

	public void judgeEffect(){
		
		if(pl.plocation<=160 && pl.plocation>155){
			pl.setState(Player.cool);
			
		}else if(pl.plocation<=155 && pl.plocation>145){
			pl.setState(Player.good);
			
		}else if(pl.plocation<=145 && pl.plocation>=140){
			pl.setState(Player.perfect);
			
		}
	}

}
