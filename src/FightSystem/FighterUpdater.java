package FightSystem;

import java.util.Random;

import Main.GamePanel;

public class FighterUpdater implements Updater{
	
	Player[] pls;
	Monster[] mos;
	int bossType;
	Random rand;
    boolean movable=true;

    GamePanel gp;
    public FighterUpdater(GamePanel Gp){
		gp=Gp;
		
		pls=gp.pl.introducer.pls;
		mos=gp.pl.introducer.mos;
		bossType=gp.pl.introducer.bossType;
		rand=new Random();
	}
    
    //胜利检测器
    public void WinJudger(){
        boolean win=true;
     	
        for(int i=0;i<mos.length;i++){
			if(mos[i].hp>0){
				win=false;
			}
		}
        
        if(win){
        	if(gp.pl.mt.going){
        		gp.scene=200;
        	}else if(gp.pl.ot6.going){
        		gp.scene=206;
        	}else if(gp.pl.ot7.going){
        		gp.scene=207;
        	}else{
        		gp.scene=gp.pl.scene;
        	}
        
        
        }
	
    }
    //失败检测器
    public void LoseJudger(){
     	boolean lose=true;
     	
        for(int i=0;i<gp.pl.TeamNum;i++){
			if(pls[i].hp>0){
				lose=false;
			}
		}
        
        if(lose){
        	if(gp.pl.mt.level==452){
        		gp.scene=200;
        		gp.pl.hp=10;
        	}else{
            	gp.scene=300;
        	}

        }
    }
  
	public void update() {
		WinJudger();
		LoseJudger();

		if((pls[0]!=null && (pls[0].magicUsed || pls[0].ifSelect || pls[0].hasSpeeded || pls[0].enemySelect || pls[0].magicSelect ||pls[0].superSkillUsed || pls[0].downSelect))
				||(pls[1]!=null &&(pls[1].magicUsed || pls[1].ifSelect || pls[1].hasHealed || pls[1].enemySelect || pls[1].magicSelect || pls[1].superSkillUsed))
				||(pls[2]!=null && (pls[2].magicUsed || pls[2].ifSelect || pls[2].hasSpeeded || pls[2].enemySelect || pls[2].magicSelect || pls[2].superSkillUsed))
				||(pls[3]!=null && (pls[3].magicUsed || pls[3].ifSelect || pls[3].hasHealed || pls[3].enemySelect || pls[3].magicSelect || pls[3].superSkillUsed))
				||(bossType!=0 && mos[0].superSkillUsed
				||Player.stateExist
				||FightControler.paused)){
			movable=false;
		}
	
		else{
			movable=true;
		}
		if(movable){
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null && pls[i].fightable && !pls[i].hasAttacked){
					pls[i].magicMissCheck(mos[pls[i].magicTarget]);
					pls[i].positionUpdate();
				}
			}
			if(bossType==0){
				for(int i=0;i<mos.length;i++){
					if(mos[i].fightable){
						mos[i].positionUpdate();
						if(mos[i].plocation<=140 && mos[i].hp>=40){
							enemyAttack(mos[i]);
							mos[i].plocation=360;
						}else if(mos[i].plocation<=140 && mos[i].hp<=40){
							if(!mos[i].magicPrepared){
								monsterMagicUse(mos[i]);
								if(!mos[i].magicUsable){
									mos[i].magicUseFalse();
									enemyAttack(mos[i]);
								}
							}
							if(mos[i].magicPrepared && !mos[i].magicPrepareComplete){
								if(mos[i].plocation<=100){
									mos[i].magicPrepareComplete=true;
									mos[i].magicUse(pls[mos[i].target]);
									mos[i].plocation=360;
								}
							}
						}
						if(mos[i].plocation<=100){
							mos[i].plocation=360;
						}
						
					}
					
				}
			}else{
				if(mos[0].fightable){
					if(mos[0].ap>=200){
						mos[0].superSkillUse(pls);
					}
					mos[0].positionUpdate();
					if(mos[0].plocation<=140 && mos[0].hp>120){
						enemyAttack(mos[0]);
						mos[0].plocation=360;
					}else if(mos[0].plocation<=140 && mos[0].hp<=120 && mos[0].hp>=80){
						//发动魔法
						
							if(!mos[0].magicPrepared){
								bossMagicUse(mos[0]);
								//如果不能使用魔法，就转为普通攻击
								if(!mos[0].magicUsable){
									mos[0].magicUseFalse();
									enemyAttack(mos[0]);
								}
							}
							
							if(mos[0].magicPrepared && !mos[0].magicPrepareComplete){
								if(mos[0].plocation<=100){
									mos[0].magicPrepareComplete=true;
									mos[0].magicUse(pls[mos[0].target]);
									mos[0].plocation=360;
								}
							}
					}else if(mos[0].plocation<=140 && mos[0].hp<=80){	
							if(!mos[0].groupMagicPrepared){
								bossGMagicUse(mos[0]);
								//如果不能使用魔法，就转为普通攻击
								if(!mos[0].magicUsable){
									mos[0].groupMagicUseFalse();
									enemyAttack(mos[0]);
								}
							}
							
							if(mos[0].groupMagicPrepared && !mos[0].groupPrepareComplete){
								if(mos[0].plocation<=100){
									mos[0].groupPrepareComplete=true;
									mos[0].groupMagicUse(pls);
									mos[0].plocation=360;
								}
							}
						
						
					}
					if(mos[0].plocation<=100){
						mos[0].plocation=360;
					}
				}
				
				for(int i=1;i<mos.length;i++){
					if(mos[i].fightable){
						mos[i].positionUpdate();
						if(mos[i].plocation<=140 && mos[i].hp>=40){
							enemyAttack(mos[i]);
							mos[i].plocation=360;
						}else if(mos[i].plocation<=140 && mos[i].hp<=40){
							if(!mos[i].magicPrepared){
								monsterMagicUse(mos[i]);
								if(!mos[i].magicUsable){
									mos[i].magicUseFalse();
									enemyAttack(mos[i]);
								}
							}
							if(mos[i].magicPrepared && !mos[i].magicPrepareComplete){
								if(mos[i].plocation<=100){
									mos[i].magicPrepareComplete=true;
									mos[i].magicUse(pls[mos[i].target]);
									mos[i].plocation=360;
								}
							}
						}
						if(mos[i].plocation<=100){
							mos[i].plocation=360;
						}
						
					}
					
				}
			}
		}
		
	}
	
	
	public void targetJudge(Monster mo){
		if(pls[mo.target]==null || (pls[mo.target]!=null && !pls[mo.target].fightable)){
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null && pls[i].fightable){
					mo.target=i;
     				break;
				}
			}
		}
	}

	public void enemyAttack(Monster mo){
		mo.target=rand.nextInt(pls.length);
		targetJudge(mo);
		mo.attack(pls[mo.target]);
	}
	
	//小怪魔法
	public void monsterMagicUse(Monster mo){
		if(mo.magicUsable){
			mo.target=rand.nextInt(pls.length);
			targetJudge(mo);
			mo.magicPrepare();
		}
	}
	
	//boss魔法
	public void bossMagicUse(Monster mo){
		if(mo.magicUsable){
			mo.target=rand.nextInt(pls.length);
			targetJudge(mo);
			mo.magicType=rand.nextInt(2);
			mo.magicPrepare();
		}
	}

	public void bossGMagicUse(Monster mo){
		if(mo.magicUsable){
			mo.groupMagicPrepare();
		}
	}
	
}
