package FightSystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class FightControler implements KeyListener{
	Player[] pls;
	Monster[] mos;
	int bossType;
	int position=0;//决定谁是当前可操作的人物
	
	static boolean paused=false;//是否暂停
	GamePanel gp;
	public FightControler(GamePanel Gp){
		gp=Gp;
		pls=gp.pl.introducer.pls;
		mos=gp.pl.introducer.mos;
		bossType=gp.pl.introducer.bossType;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode=e.getKeyCode();
	
		if(keyCode==KeyEvent.VK_ENTER){
			if(Player.stateExist){
				Player.stateExist=false;
			}
		}
		//暂停键
		if(keyCode==KeyEvent.VK_P){
			if(paused){
				paused=false;
			}else{
				paused=true;
			}
		}
	
		if(keyCode==KeyEvent.VK_Z && !Fighter.superKeyPressed){
			if(pls[0]!=null && pls[0].ap>=80){
				pls[0].superSkillUse(mos);
			}
		}
		if(keyCode==KeyEvent.VK_X && !Fighter.superKeyPressed){
			if(pls[1]!=null && pls[1].ap>=80){
				pls[1].superSkillUse(mos);
			}
		}
		if(keyCode==KeyEvent.VK_C && !Fighter.superKeyPressed){
			if(pls[2]!=null && pls[2].ap>=80){
				pls[2].superSkillUse(mos);
			}
		}
		if(keyCode==KeyEvent.VK_V && !Fighter.superKeyPressed){
			if(pls[3]!=null && pls[3].ap>=80){
				pls[3].superSkillUse(mos);
			}
		}
		
		
		if(Player.stateExist){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(Player.statePosition.y==0){
					Player.statePosition.y=1;
				}else{
					Player.statePosition.y-=1;
				}
				break;
				
			case KeyEvent.VK_DOWN:
				Player.statePosition.y=(Player.statePosition.y+1)%2;
				break;
				
			case KeyEvent.VK_LEFT:
				if(Player.statePosition.x==0){
					Player.statePosition.x=1;
				}else{
					Player.statePosition.x-=1;
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				Player.statePosition.x=(Player.statePosition.x+1)%2;
				break;
			}
			
		}

		
			//键盘事件
		if(((pls[0]!=null &&!pls[0].ifSelect && !pls[0].hasSpeeded && !pls[0].enemySelect && !pls[0].magicSelect && !pls[0].downSelect)||(pls[0]==null) )
			&&((pls[1]!=null && !pls[1].ifSelect && !pls[1].hasHealed && !pls[1].enemySelect && !pls[1].magicSelect)||(pls[1]==null))
			&&((pls[2]!=null && !pls[2].ifSelect && !pls[2].hasSpeeded && !pls[2].enemySelect && !pls[2].magicSelect)||(pls[2]==null))
			&&((pls[3]!=null && !pls[3].ifSelect && !pls[3].hasHealed && !pls[3].enemySelect && !pls[3].magicSelect)||(pls[3]==null))
			&& !Player.stateExist &&!paused
				){
			switch(position){
			case 0:
				if( pls[0]!=null && pls[0].canKeyPress){
				switch(keyCode){
				case KeyEvent.VK_A:
					if(!pls[0].keyPressed){
						pls[0].keyPressed=true;
						pls[0].enemySelect=true;
					}
					break;
					
				case KeyEvent.VK_S:
					
					if(!pls[0].keyPressed){
						pls[0].keyPressed=true;
						pls[0].magicCount=0;
						
						if(pls[0].magicUseCount==0){
							pls[0].magicSelect=true;
						}
					}
					
					pls[0].magicUseCount=1;
//		
					break;
//				case KeyEvent.VK_D:
//					
//					if(!pls[0].keyPressed){
//						pls[0].keyPressed=true;
//						pls[0].magicCount=1;
//						if(pls[0].magicUseCount==0){
//							pls[0].magicSelect=true;
//						}
//					}
//					pls[0].magicUseCount=1;
//					break;
					
//				case KeyEvent.VK_W:
//					if(!pls[0].keyPressed){
//						pls[0].ifSelect=true;
//						pls[0].keyPressed=true;
//					}
//					
//					break;
					
//				case KeyEvent.VK_W:
//					if(!pls[0].keyPressed){
//						pls[0].downSelect=true;
//						pls[0].keyPressed=true;
//					}
//					break;
//				case KeyEvent.VK_E:
//					pls[0].escape(mos);
//					break;
				case KeyEvent.VK_F:
					pls[0].defend();
					break;
					
				case KeyEvent.VK_D:
					if(!pls[0].keyPressed){
						pls[0].keyPressed=true;
						pls[0].magicUseCount=1;
						pls[0].groupMagicPrepare();
						if(!pls[0].magicUsable){
							pls[0].groupMagicUseFalse();
						}
					}
					break;
					
				}
				break;
			}
				
			case 1:
				if(pls[1]!=null && pls[1].canKeyPress){
					switch(keyCode){
					case KeyEvent.VK_A:
						if(!pls[1].keyPressed){
							pls[1].enemySelect=true;
							pls[1].keyPressed=true;
						}
						break;
					case KeyEvent.VK_S:
						if(!pls[1].keyPressed){
							pls[1].keyPressed=true;
							pls[1].magicCount=0;
							if(pls[1].magicUseCount==0){
								pls[1].magicSelect=true;
							}
						}
						
						pls[1].magicUseCount=1;
//						pls[1].magicUse(boss);
						break;
//					case KeyEvent.VK_D:
//						if(!pls[1].keyPressed){
//							pls[1].keyPressed=true;
//							pls[1].magicCount=1;
//							if(pls[1].magicUseCount==0){
//								pls[1].magicSelect=true;
//							}
//						}
						
//						pls[1].magicUseCount=1;
////						pls[1].magicUse(boss);
//						break;
//					case KeyEvent.VK_W:
//						if(!pls[1].keyPressed){
//							pls[1].ifSelect=true;
//							pls[1].keyPressed=true;
//						}
////						
//						break;
//					case KeyEvent.VK_E:
//						pls[1].escape(mos);
//						break;
					case KeyEvent.VK_F:
						pls[1].defend();
						break;
					case KeyEvent.VK_D:
						if(!pls[1].keyPressed){
							pls[1].keyPressed=true;
							pls[1].magicUseCount=1;
							pls[1].groupMagicPrepare();
							if(!pls[1].magicUsable){
								pls[1].groupMagicUseFalse();
							}
						}
						break;	
					}
				break;
				
				}
			
				
			case 2:
				if(pls[2]!=null && pls[2].canKeyPress){
					switch(keyCode){
					case KeyEvent.VK_A:
						if(!pls[2].keyPressed){
							pls[2].enemySelect=true;
							pls[2].keyPressed=true;
						}
						
						break;
					case KeyEvent.VK_S:
						if(!pls[2].keyPressed){
							pls[2].keyPressed=true;
							pls[2].magicCount=0;
							if(pls[2].magicUseCount==0){
								pls[2].magicSelect=true;
//								pls[2].magicPrepare();
							}
						}
						pls[2].magicUseCount=1;
//						pls[2].magicUse(boss);
						break;
//					case KeyEvent.VK_D:
//						if(!pls[2].keyPressed){
//							pls[2].keyPressed=true;
//							pls[2].magicCount=1;
//							if(pls[2].magicUseCount==0){
//								pls[2].magicSelect=true;
//							}
//						}
//						pls[2].magicUseCount=1;
//						break;
//					case KeyEvent.VK_W:
//						if(!pls[2].keyPressed){
//							pls[2].ifSelect=true;
//							pls[2].keyPressed=true;
//						}
//						break;
//					case KeyEvent.VK_E:
//						pls[2].escape(mos);
//						break;
					case KeyEvent.VK_F:
						pls[2].defend();
						break;
					case KeyEvent.VK_D:
						if(!pls[2].keyPressed){
							pls[2].keyPressed=true;
							pls[2].magicUseCount=1;
							pls[2].groupMagicPrepare();
							if(!pls[2].magicUsable){
								pls[2].groupMagicUseFalse();
							}
						}
						break;	
					}
					break;
				}
				
			case 3:
				if(pls[3]!=null && pls[3].canKeyPress){
					switch(keyCode){
					case KeyEvent.VK_A:
						if(!pls[3].keyPressed){
							pls[3].enemySelect=true;
							pls[3].keyPressed=true;
						}
						break;
					case KeyEvent.VK_S:
						if(!pls[3].keyPressed){
							pls[3].keyPressed=true;
							pls[3].magicCount=0;
							if(pls[3].magicUseCount==0){
								pls[3].magicSelect=true;
							}
						}
						pls[3].magicUseCount=1;
//						pls[3].magicUse(boss);
						break;
//					case KeyEvent.VK_D:
//						if(!pls[3].keyPressed){
//							pls[3].keyPressed=true;
//							pls[3].magicCount=1;
//							if(pls[3].magicUseCount==0){
//								pls[3].magicSelect=true;
//							}
//						}
//						pls[3].magicUseCount=1;
//						break;
//					case KeyEvent.VK_W:
//						if(!pls[3].keyPressed){
//							pls[3].ifSelect=true;
//							pls[3].keyPressed=true;
//						}
//						break;
//					case KeyEvent.VK_E:
//						pls[3].escape(mos);
//						break;
					case KeyEvent.VK_F:
						pls[3].defend();
						break;
					case KeyEvent.VK_D:
						if(!pls[3].keyPressed){
							pls[3].keyPressed=true;
							pls[3].magicUseCount=1;
							pls[3].groupMagicPrepare();
							if(!pls[3].magicUsable){
								pls[3].groupMagicUseFalse();
							}
						}
						break;
						//群体治愈实验
//					case KeyEvent.VK_W:
//						if(!pls[3].keyPressed){
//							pls[3].keyPressed=true;
//							pls[3].groupHeal(pls);
//						}
//						break;
					}
					
				
				}
			}
		}
		
		if(pls[0]!=null && pls[0].downSelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[0].speedDownTarget!=0){
					pls[0].speedDownTarget-=1;
				}
				else {
					pls[0].speedDownTarget=mos.length-1;
				}
				speedDownTargetJudgeUp(pls[0]);
				break;
				
			case KeyEvent.VK_DOWN:
				pls[0].speedDownTarget=(pls[0].speedDownTarget+1)%mos.length;
				speedDownTargetJudgeDown(pls[0]);
				break;
				
			case KeyEvent.VK_LEFT:
				if(pls[0].speedDownTarget!=0){
					pls[0].speedDownTarget-=1;
				}
				else {
					pls[0].speedDownTarget=mos.length-1;
				}
				speedDownTargetJudgeUp(pls[0]);
				break;
				
			case KeyEvent.VK_RIGHT:
				pls[0].speedDownTarget=(pls[0].speedDownTarget+1)%mos.length;
				speedDownTargetJudgeDown(pls[0]);
				break;
			
			case KeyEvent.VK_SPACE:
				pls[0].speedDown(mos[pls[0].speedDownTarget]);
				pls[0].downSelect=false;
				break;
		    }
		}
	
		
		if(pls[0]!=null && pls[0].ifSelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[0].speedTarget!=0){
					pls[0].speedTarget-=1;
				}
				else {
					pls[0].speedTarget=3;
				}
				playerSpeedTargetJudgeUp(pls[0]);
				break;
				
			case KeyEvent.VK_DOWN:
				pls[0].speedTarget=(pls[0].speedTarget+1)%pls.length;
				playerSpeedTargetJudgeDown(pls[0]);
				break;
				
			case KeyEvent.VK_LEFT:
				if(pls[0].speedTarget!=0){
					pls[0].speedTarget-=1;
				}
				else {
					pls[0].speedTarget=3;
				}
				playerSpeedTargetJudgeUp(pls[0]);
				break;
				
			case KeyEvent.VK_RIGHT:
				pls[0].speedTarget=(pls[0].speedTarget+1)%pls.length;
				playerSpeedTargetJudgeDown(pls[0]);
				break;
			
			case KeyEvent.VK_SPACE:
				pls[0].speedUp(pls[pls[0].speedTarget]);
				pls[0].ifSelect=false;
				break;
		    }
		}
		
		if(pls[1]!=null && pls[1].ifSelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[1].healTarget!=0){
					pls[1].healTarget-=1;
				}else {
					pls[1].healTarget=3;
				}
				playerHealTargetJudgeUp(pls[1]);
				break;
			case KeyEvent.VK_DOWN:
				pls[1].healTarget=(pls[1].healTarget+1)%pls.length;
				playerHealTargetJudgeDown(pls[1]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[1].healTarget!=0){
					pls[1].healTarget-=1;
				}else {
					pls[1].healTarget=3;
				}
				playerHealTargetJudgeUp(pls[1]);
				break;
			case KeyEvent.VK_RIGHT:
				pls[1].healTarget=(pls[1].healTarget+1)%pls.length;
				playerHealTargetJudgeDown(pls[1]);
				break;
			case KeyEvent.VK_SPACE:
				pls[1].heal(pls[pls[1].healTarget]);
				pls[1].ifSelect=false;
				break;
			}
		}
		
		if(pls[2]!=null && pls[2].ifSelect ){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[2].speedTarget!=0){
					pls[2].speedTarget-=1;
				}
				else {
					pls[2].speedTarget=3;
				}
				playerSpeedTargetJudgeUp(pls[2]);
				break;
			case KeyEvent.VK_DOWN:
				pls[2].speedTarget=(pls[2].speedTarget+1)%pls.length;
				playerSpeedTargetJudgeDown(pls[2]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[2].speedTarget!=0){
					pls[2].speedTarget-=1;
				}
				else {
					pls[2].speedTarget=3;
				}
				playerSpeedTargetJudgeUp(pls[2]);
				break;
			case KeyEvent.VK_RIGHT:
				pls[2].speedTarget=(pls[2].speedTarget+1)%pls.length;
				playerSpeedTargetJudgeDown(pls[2]);
				break;
			case KeyEvent.VK_SPACE:
				pls[2].ifSelect=false;
				pls[2].speedUp(pls[pls[2].speedTarget]);
				break;
			}
		}
	
		
		if(pls[3]!=null && pls[3].ifSelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[3].healTarget!=0){
					pls[3].healTarget-=1;
				}
				else {
					pls[3].healTarget=3;
				}
				playerHealTargetJudgeUp(pls[3]);
				break;
			case KeyEvent.VK_DOWN:
				pls[3].healTarget=(pls[3].healTarget+1)%pls.length;
				playerHealTargetJudgeDown(pls[3]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[3].healTarget!=0){
					pls[3].healTarget-=1;
				}
				else {
					pls[3].healTarget=3;
				}
				playerHealTargetJudgeUp(pls[3]);
				break;
			case KeyEvent.VK_RIGHT:
				pls[3].healTarget=(pls[3].healTarget+1)%pls.length;
				playerHealTargetJudgeDown(pls[3]);
				break;
			case KeyEvent.VK_SPACE:
				pls[3].heal(pls[pls[3].healTarget]);
				pls[3].ifSelect=false;
				break;
			}
		}

			
		//攻击选择
		if(pls[0]!=null && pls[0].enemySelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[0].attackTarget!=0){
					pls[0].attackTarget-=1;
				}
				else {
					pls[0].attackTarget=mos.length-1;
				}
				playerAttackTargetJudgeUp(pls[0]);
				break;
			case KeyEvent.VK_DOWN:
				pls[0].attackTarget=(pls[0].attackTarget+1)%mos.length;
				playerAttackTargetJudgeDown(pls[0]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[0].attackTarget!=0){
					pls[0].attackTarget-=1;
				}
				else {
					pls[0].attackTarget=mos.length-1;
				}
				playerAttackTargetJudgeUp(pls[0]);
				break;
			case KeyEvent.VK_RIGHT:	
				pls[0].attackTarget=(pls[0].attackTarget+1)%mos.length;
				playerAttackTargetJudgeDown(pls[0]);
				break;
			case KeyEvent.VK_SPACE:	
				//先判断攻击目标
				
				pls[0].attack(mos[pls[0].attackTarget]);
				pls[0].enemySelect=false;
				break;
			}
		}
		
		if(pls[1]!=null && pls[1].enemySelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[1].attackTarget!=0){
					pls[1].attackTarget-=1;
				}
				else {
					pls[1].attackTarget=mos.length-1;
				}
				playerAttackTargetJudgeUp(pls[1]);
				break;
			case KeyEvent.VK_DOWN:
				pls[1].attackTarget=(pls[1].attackTarget+1)%mos.length;
				playerAttackTargetJudgeDown(pls[1]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[1].attackTarget!=0){
					pls[1].attackTarget-=1;
				}
				else{
					pls[1].attackTarget=mos.length-1;
				}
				playerAttackTargetJudgeUp(pls[1]);
				break;
			case KeyEvent.VK_RIGHT:	
				pls[1].attackTarget=(pls[1].attackTarget+1)%mos.length;
				playerAttackTargetJudgeDown(pls[1]);
				break;
			case KeyEvent.VK_SPACE:	
				pls[1].attack(mos[pls[1].attackTarget]);
				pls[1].enemySelect=false;
				break;
			}
		}
		
		if(pls[2]!=null && pls[2].enemySelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[2].attackTarget!=0){
					pls[2].attackTarget-=1;
				}
				else {
					pls[2].attackTarget=mos.length-1;
				}
				playerAttackTargetJudgeUp(pls[2]);
			case KeyEvent.VK_DOWN:
				pls[2].attackTarget=(pls[2].attackTarget+1)%mos.length;
				playerAttackTargetJudgeDown(pls[2]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[2].attackTarget!=0){
					pls[2].attackTarget-=1;
				}
				else{
					pls[2].attackTarget=mos.length-1;
				}
				playerAttackTargetJudgeUp(pls[2]);
				break;
			case KeyEvent.VK_RIGHT:	
				pls[2].attackTarget=(pls[2].attackTarget+1)%mos.length;
				playerAttackTargetJudgeDown(pls[2]);
				break;
			case KeyEvent.VK_SPACE:	
				
				pls[2].attack(mos[pls[2].attackTarget]);
				pls[2].enemySelect=false;
				break;
			}
		}
		
		if(pls[3]!=null && pls[3].enemySelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[3].attackTarget!=0){
					pls[3].attackTarget-=1;
				}
				else {
					pls[3].attackTarget=mos.length-1;
				}
				playerAttackTargetJudgeUp(pls[3]);
				break;
			case KeyEvent.VK_DOWN:
				pls[3].attackTarget=(pls[3].attackTarget+1)%mos.length;
				playerAttackTargetJudgeDown(pls[3]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[3].attackTarget!=0){
					pls[3].attackTarget-=1;
				}
				else{
					pls[3].attackTarget=mos.length-1;
				}
				playerAttackTargetJudgeUp(pls[3]);
				break;
			case KeyEvent.VK_RIGHT:	
				pls[3].attackTarget=(pls[3].attackTarget+1)%mos.length;
				playerAttackTargetJudgeDown(pls[3]);
				break;
			case KeyEvent.VK_SPACE:	
				
				pls[3].attack(mos[pls[3].attackTarget]);
				pls[3].enemySelect=false;
				break;
			}
		}
		
		//魔法攻击选择
		if(pls[0]!=null && pls[0].magicSelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[0].magicTarget!=0){
					pls[0].magicTarget-=1;
				}
				else {
					pls[0].magicTarget=mos.length-1;
				}
				playerMagicTargetJudgeUp(pls[0]);
				break;
			case KeyEvent.VK_DOWN:
				pls[0].magicTarget=(pls[0].magicTarget+1)%mos.length;
				playerMagicTargetJudgeDown(pls[0]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[0].magicTarget!=0){
					pls[0].magicTarget-=1;
				}
				else {
					pls[0].magicTarget=mos.length-1;
				}
				playerMagicTargetJudgeUp(pls[0]);
				break;
			case KeyEvent.VK_RIGHT:
				pls[0].magicTarget=(pls[0].magicTarget+1)%mos.length;
				playerMagicTargetJudgeDown(pls[0]);
				break;
			case KeyEvent.VK_SPACE:
				pls[0].magicSelect=false;
				pls[0].magicPrepare();
				if(!pls[0].magicUsable){
					pls[0].magicUseFalse();
				}
				break;
			}
		}
		
		if(pls[1]!=null && pls[1].magicSelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[1].magicTarget!=0){
					pls[1].magicTarget-=1;
				}
				else {
					pls[1].magicTarget=mos.length-1;
				}
				playerMagicTargetJudgeUp(pls[1]);
				break;
			case KeyEvent.VK_DOWN:
				pls[1].magicTarget=(pls[1].magicTarget+1)%mos.length;
				playerMagicTargetJudgeDown(pls[1]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[1].magicTarget!=0){
					pls[1].magicTarget-=1;
				}
				else {
					pls[1].magicTarget=mos.length-1;
				}
				playerMagicTargetJudgeUp(pls[1]);
				break;
			case KeyEvent.VK_RIGHT:
				pls[1].magicTarget=(pls[1].magicTarget+1)%mos.length;
				playerMagicTargetJudgeDown(pls[1]);
				break;
			case KeyEvent.VK_SPACE:
				
				pls[1].magicSelect=false;
				pls[1].magicPrepare();
				if(!pls[1].magicUsable){
					pls[1].magicUseFalse();
				}
				break;
			}
		}
		
		if(pls[2]!=null && pls[2].magicSelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[2].magicTarget!=0){
					pls[2].magicTarget-=1;
				}
				else {
					pls[2].magicTarget=mos.length-1;
				}
				playerMagicTargetJudgeUp(pls[2]);
				break;
			case KeyEvent.VK_DOWN:
				pls[2].magicTarget=(pls[2].magicTarget+1)%mos.length;
				playerMagicTargetJudgeDown(pls[2]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[2].magicTarget!=0){
					pls[2].magicTarget-=1;
				}
				else {
					pls[2].magicTarget=mos.length-1;
				}
				playerMagicTargetJudgeUp(pls[2]);
				break;
			case KeyEvent.VK_RIGHT:
				pls[2].magicTarget=(pls[2].magicTarget+1)%mos.length;
				playerMagicTargetJudgeDown(pls[2]);
				break;
			case KeyEvent.VK_SPACE:
				pls[2].magicSelect=false;
				pls[2].magicPrepare();
				if(!pls[2].magicUsable){
					pls[2].magicUseFalse();
				}
				break;
			}
		}
		
		if(pls[3]!=null && pls[3].magicSelect){
			switch(keyCode){
			case KeyEvent.VK_UP:
				if(pls[3].magicTarget!=0){
					pls[3].magicTarget-=1;
				}
				else {
					pls[3].magicTarget=mos.length-1;
				}
				playerMagicTargetJudgeUp(pls[3]);
				break;
			case KeyEvent.VK_DOWN:
				pls[3].magicTarget=(pls[3].magicTarget+1)%mos.length;
				playerMagicTargetJudgeDown(pls[3]);
				break;
			case KeyEvent.VK_LEFT:
				if(pls[3].magicTarget!=0){
					pls[3].magicTarget-=1;
				}
				else {
					pls[3].magicTarget=mos.length-1;
				}
				playerMagicTargetJudgeUp(pls[3]);
				break;
			case KeyEvent.VK_RIGHT:
				pls[3].magicTarget=(pls[3].magicTarget+1)%mos.length;
				playerMagicTargetJudgeDown(pls[3]);
				break;
			case KeyEvent.VK_SPACE:
				
				pls[3].magicSelect=false;
				pls[3].magicPrepare();
				if(!pls[3].magicUsable){
					pls[3].magicUseFalse();
				}
				break;
			}
		}
	}


	public void playerHealTargetJudge(Player pl){
		while(pls[pl.healTarget]==null){
			pl.healTarget=(pl.healTarget+1)%pls.length;
			if(pls[pl.healTarget]!=null){
				break;
			}
		}
	}
	
	public void playerHealTargetJudgeUp(Player pl){
		while(pls[pl.healTarget]==null){
			if(pl.healTarget==0){
				pl.healTarget=pls.length-1;
			}else{
				pl.healTarget-=1;
			}
			if(pls[pl.healTarget]!=null){
				break;
			}
		}
	}
	
	
	public void playerHealTargetJudgeDown(Player pl){
		while(pls[pl.healTarget]==null){
			pl.healTarget=(pl.healTarget+1)%pls.length;
			if(pls[pl.healTarget]!=null){
				break;
			}
		}
	}
	
	//不知道有么有问题,有问题，选择会卡主,草 两个方法弄饭了
	public void playerSpeedTargetJudgeDown(Player pl){
		for(int i=0;i<pls.length;i++){
			if(pls[pl.speedTarget]!=null && !pls[pl.speedTarget].fightable){
				pls[pl.speedTarget].selectable=false;
			}else if(pls[pl.speedTarget]!=null && pls[pl.speedTarget].fightable){
				pls[pl.speedTarget].selectable=true;
			}
		}
		while(((pls[pl.speedTarget]!=null && !pls[pl.speedTarget].selectable)||(pls[pl.speedTarget]==null))){
			pl.speedTarget=(pl.speedTarget+1)%pls.length;
			if(pls[pl.speedTarget]!=null && pls[pl.speedTarget].selectable){
				break;
			}
		}
		
	}
	
	//同上
	public void playerSpeedTargetJudgeUp(Player pl){
		for(int i=0;i<pls.length;i++){
			if(pls[pl.speedTarget]!=null && !pls[pl.speedTarget].fightable){
				pls[pl.speedTarget].selectable=false;
			}else if(pls[pl.speedTarget]!=null && pls[pl.speedTarget].fightable){
				pls[pl.speedTarget].selectable=true;
			}
		}
		while((pls[pl.speedTarget]!=null && !pls[pl.speedTarget].selectable)||(pls[pl.speedTarget]==null)){
			if(pl.speedTarget==0){
				pl.speedTarget=pls.length-1;
			}else{
				pl.speedTarget-=1;
			}
			if(pls[pl.speedTarget]!=null && pls[pl.speedTarget].selectable){
				break;
			}
		}
		
	}
	
	public void speedDownTargetJudgeDown(Player pl){
		for(int i=0;i<pls.length;i++){
			if(!mos[pl.speedDownTarget].fightable){
				mos[pl.speedDownTarget].selectable=false;
			}else if( mos[pl.speedDownTarget].fightable){
				mos[pl.speedDownTarget].selectable=true;
			}
		}
		while(!mos[pl.speedDownTarget].selectable){
			pl.speedDownTarget=(pl.speedDownTarget+1)%mos.length;
			if(mos[pl.speedDownTarget].selectable){
				break;
			}
		}
	}
	
	public void speedDownTargetJudgeUp(Player pl){
		for(int i=0;i<pls.length;i++){
			if(!mos[pl.speedDownTarget].fightable){
				mos[pl.speedDownTarget].selectable=false;
			}else if(mos[pl.speedDownTarget].fightable){
				mos[pl.speedDownTarget].selectable=true;
			}
		}
		while(!mos[pl.speedDownTarget].selectable){
			if(pl.speedDownTarget==0){
				pl.speedDownTarget=mos.length-1;
			}else{
				pl.speedDownTarget-=1;
			}
			if(mos[pl.speedDownTarget].selectable){
				break;
			}
		}
	}
	
	public void playerAttackTargetJudgeDown(Player pl){
		while(!mos[pl.attackTarget].fightable){
			pl.attackTarget=(pl.attackTarget+1)%mos.length;
			if(mos[pl.attackTarget].fightable){
				break;
			}
		}
	}
	
	public void playerAttackTargetJudgeUp(Player pl){
		while(!mos[pl.attackTarget].fightable){
			if(pl.attackTarget==0){
				pl.attackTarget=mos.length-1;
			}else{
				pl.attackTarget-=1;
			}
			if(mos[pl.attackTarget].fightable){
				break;
			}
		}
	}
	
	public void playerMagicTargetJudgeDown(Player pl){
		while(!mos[pl.magicTarget].fightable){
			pl.magicTarget=(pl.magicTarget+1)%mos.length;
			if(mos[pl.magicTarget].fightable){
				break;
			}
		}
		
	}
	
	public void playerMagicTargetJudgeUp(Player pl){
		while(!mos[pl.magicTarget].fightable){
			if(pl.magicTarget==0){
				pl.magicTarget=mos.length-1;
			}else{
				pl.magicTarget-=1;
			}
			if(mos[pl.magicTarget].fightable){
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}