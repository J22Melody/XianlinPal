package FightSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

import InterFaceAndAbstractClass.Painter;
import Main.GamePanel;


public class FightPainter implements Painter{
	Player[] pls;
	Monster[] mos;
	Animation[] magics=new Animation[3];
	Animation[] bmagics=new Animation[3];
	Animation[] cmagics=new Animation[3];
	Animation[] dmagics=new Animation[3];
	Animation[] prepares;

	Animation[] superskills=new Animation[4];
	
	Animation gMagic;//群魔法
	Animation gMagic1;
	Animation gMagic2;
	Animation gMagic3;
	
	
	Animation gHeal;
	Animation speedDown;
	
	BufferedImage back;
	BufferedImage battleback;
	BufferedImage[] actors=new BufferedImage[4];
	BufferedImage[] sactors=new BufferedImage[4];
	BufferedImage[] pactors=new BufferedImage[4];
	BufferedImage[] dactors=new BufferedImage[4];
	BufferedImage[] supers=new BufferedImage[4];
	
	
	BufferedImage[] penemies;
	BufferedImage[] senemies;
	
	BufferedImage skillback;
	BufferedImage stateback;
	
	BufferedImage enemy0;
	BufferedImage progress;
	
	BufferedImage miss;
	BufferedImage cool;
	BufferedImage good;
	BufferedImage perfect;
	BufferedImage interrupt;
	BufferedImage defend;
	
	BufferedImage arrow;
	BufferedImage shadow;
	BufferedImage defendImage;
	
	BufferedImage number;
	BufferedImage[] numbers;//数字(加)
	BufferedImage negativeNumber;
	BufferedImage[] negativeNumbers;
	BufferedImage magicNumber;
	BufferedImage[] magicNumbers;//数字(减)
	BufferedImage attackNumber;
	BufferedImage[] attackNumbers;
	
	
	BufferedImage attack;
	BufferedImage[] attacks;
	
	BufferedImage bomb;
	BufferedImage[] bombs;
	
	BufferedImage model;
	BufferedImage bossModel;
	int bossType;
	Random rand;
	
	Image img;
	Graphics sg;
	Image img2;
	Graphics csg;
	
	int barHeight=10;
	
	int position=0;
	
	int a=0;//数字的百，十，个位
	int b=0;
	int c=0;
	
	GamePanel gp;
	
	public FightPainter(GamePanel Gp){
		gp=Gp;
		pls=gp.pl.introducer.pls;
		mos=gp.pl.introducer.mos;
		bossType=gp.pl.introducer.bossType;

		initialize();
	}

	public void initialize(){
		rand=new Random();
	
		if(pls[0]!=null){
			magics[0]=new Animation("image/magics/magic.png",new Point(5,4));
			magics[1]=new Animation("image/magics/magic.png",new Point(5,4));
			magics[2]=new Animation("image/magics/speedUp.png",new Point(5,6));
			superskills[0]=new Animation("image/skills/superskill0.png",new Point(5,5));
		}
		
		if(pls[1]!=null){
			bmagics[0]=new Animation("image/magics/bmagic.png",new Point(5,5));
			bmagics[1]=new Animation("image/magics/bmagic.png",new Point(5,5));
			bmagics[2]=new Animation("image/magics/heal.png",new Point(5,6));
			superskills[1]=new Animation("image/skills/superskill1.png",new Point(5,15));
		}
		if(pls[2]!=null){
			cmagics[0]=new Animation("image/magics/cmagic.png",new Point(6,6));
			cmagics[1]=new Animation("image/magics/cmagic.png",new Point(6,6));
			cmagics[2]=new Animation("image/magics/speedUp.png",new Point(5,6));
			superskills[2]=new Animation("image/skills/superskill2.png",new Point(2,16));
		}
		
		if(pls[3]!=null){
			dmagics[0]=new Animation("image/magics/dmagic.png",new Point(5,5));
			dmagics[1]=new Animation("image/magics/dmagic.png",new Point(5,5));
			dmagics[2]=new Animation("image/magics/heal.png",new Point(5,6));
			superskills[3]=new Animation("image/skills/superskill3.png",new Point(2,25));
		}
		
		prepares=new Animation[mos.length+pls.length];
		for(int i=0;i<prepares.length;i++){
			prepares[i]=new Animation("image/magics/prepare.png",new Point(6,6));
		}
		
		//群魔法

		gMagic=new Animation("image/magics/gMagic0.png",new Point(5,3));
		gMagic1=new Animation("image/magics/gMagic1.png",new Point(5,4));
		gMagic2=new Animation("image/magics/gMagic2.png",new Point(6,6));
		gMagic3=new Animation("image/magics/gMagic3.png",new Point(5,5));
		
		gHeal=new Animation("image/magics/gHeal.png",new Point(5,5));
		speedDown=new Animation("image/magics/speedDown.png",new Point(5,6));
		
		
		back=Animation.loadImage("image/backs/back.png");
		battleback=Animation.loadImage("image/backs/battleback.png");
		
		for(int i=0;i<pls.length;i++){
			if(pls[i]!=null){
				actors[i]=Animation.loadImage("image/actors/actor"+i+".png");
				sactors[i]=Animation.loadImage("image/actors/sactor"+i+".png");
				pactors[i]=Animation.loadImage("image/actors/pactor"+i+".png");
				dactors[i]=Animation.loadImage("image/actors/death"+i+".png");
				supers[i]=Animation.loadImage("image/skills/super"+i+".png");
			}
		}
		senemies=new BufferedImage[mos.length];
		penemies=new BufferedImage[mos.length];
		if(bossType!=0){
			enemy0=Animation.loadImage("image/actors/boss"+bossType+".png");
			senemies[0]=Animation.loadImage("image/actors/sboss"+bossType+".png");
			penemies[0]=Animation.loadImage("image/actors/pboss"+bossType+".png");
//			superboss=Animation.loadImage("image/skills/superboss"+bossType+".png");
			for(int i=1;i<mos.length;i++){
//				mos[i].moTypeDecide();//在之前已经用过
				senemies[i]=Animation.loadImage("image/actors/monsters/"+mos[i].getName()+".png");
				penemies[i]=Animation.loadImage("image/actors/monsters/p"+mos[i].getName()+".png");
			}
		}else{
			for(int i=0;i<mos.length;i++){
				senemies[i]=Animation.loadImage("image/actors/monsters/"+mos[i].getName()+".png");
				penemies[i]=Animation.loadImage("image/actors/monsters/p"+mos[i].getName()+".png");
			}
		}
		
		progress=Animation.loadImage("image/actors/progress.png");
		skillback=Animation.loadImage("image/skills/skillback.png");
		
		miss=Animation.loadImage("image/effects/miss.png");
		cool=Animation.loadImage("image/effects/cool.png");
		good=Animation.loadImage("image/effects/good.png");
		perfect=Animation.loadImage("image/effects/perfect.png");
		interrupt=Animation.loadImage("image/effects/interrupt.png");
		defend=Animation.loadImage("image/effects/defend.png");
		
		model=Animation.loadImage("image/pictures/model.png");
		bossModel=Animation.loadImage("image/pictures/bossModel.png");
		
		arrow=Animation.loadImage("image/pictures/arrow.png");
		shadow=Animation.loadImage("image/pictures/shadow.png");
		defendImage=Animation.loadImage("image/pictures/defendImage.png");
		
		attack=Animation.loadImage("image/pictures/attack.png");
		attacks=Animation.setAnims(attack,new Point(5,2));
		
		
		bomb=Animation.loadImage("image/pictures/bomb.png");
		bombs=Animation.setAnims(bomb,new Point(5,2));

		//加载数字
		number=Animation.loadImage("image/pictures/number.png");
		numbers=Animation.setAnims(number,new Point(11,1));
		negativeNumber=Animation.loadImage("image/pictures/negativeNumber.png");
		negativeNumbers=Animation.setAnims(negativeNumber,new Point(11,1));
		magicNumber=Animation.loadImage("image/pictures/magicNumber.png");
		magicNumbers=Animation.setAnims(magicNumber,new Point(11,1));
		attackNumber=Animation.loadImage("image/pictures/attackNumber.png");
		attackNumbers=Animation.setAnims(attackNumber,new Point(11,1));

	}
	//
	public void draw(Graphics g) {
		g.drawImage(Method.ImageReader.work("menu/fightintroduction"),640,-18,null);
		drawBackground(g);
		drawCharacter(g);
		drawState(g);
		drawProgress(g);
		
		if(pls[0]!=null){
			if( pls[0].keyPressed){
				drawPlayerPrepare(g,prepares[0],pls[0],mos[pls[0].magicTarget]);
				//
				drawPlayerMagic(g,magics[pls[0].magicCount],pls[0],mos[pls[0].magicTarget]);
				drawPlayerSpeedUp(g,magics[2],pls[0],pls[pls[0].speedTarget]);
//				
				drawPlayerGPrepare(g,prepares[0],pls[0]);
				drawPlayerGMagic(g,gMagic,pls[0]);
				drawPlayerSpeedDown(g,speedDown,pls[0],mos[pls[0].speedDownTarget]);
			}
		}
		
		if(pls[1]!=null){
			if(pls[1].keyPressed){
				drawPlayerPrepare(g,prepares[1],pls[1],mos[pls[1].magicTarget]);
				drawPlayerMagic(g,bmagics[pls[1].magicCount],pls[1],mos[pls[1].magicTarget]);
				drawPlayerHeal(g,bmagics[2],pls[1],pls[pls[1].healTarget]);
				
				drawPlayerGPrepare(g,prepares[1],pls[1]);
				drawPlayerGMagic(g,gMagic1,pls[1]);
			}
		}
		if(pls[2]!=null){
			if(pls[2].keyPressed){
				drawPlayerPrepare(g,prepares[2],pls[2],mos[pls[2].magicTarget]);
				drawPlayerMagic(g,cmagics[pls[2].magicCount],pls[2],mos[pls[2].magicTarget]);
				drawPlayerSpeedUp(g,cmagics[2],pls[2],pls[pls[2].speedTarget]);
				
				drawPlayerGPrepare(g,prepares[2],pls[2]);
				drawPlayerGMagic(g,gMagic2,pls[2]);
			}
		}
	    if(pls[3]!=null){
	    	if(pls[3].keyPressed){
				drawPlayerPrepare(g,prepares[3],pls[3],mos[pls[3].magicTarget]);
				drawPlayerMagic(g,dmagics[pls[3].magicCount],pls[3],mos[pls[3].magicTarget]);
				drawPlayerHeal(g,dmagics[2],pls[3],pls[pls[3].healTarget]);
				
				drawPlayerGPrepare(g,prepares[3],pls[3]);
				drawPlayerGMagic(g,gMagic3,pls[3]);
				
				drawPlayerGHeal(g,gHeal,pls[3]);
			}
	    }
		
		//boss魔法准备和使用
	    if(bossType!=0){
	    	if(mos[0].fightable){
	    		drawMonsterPrepare(g,prepares[4],mos[0],pls[mos[0].target]);
	    		//现在只有一种魔法
				drawMonsterMagic(g,mos[0].magic,mos[0],pls[mos[0].target]);
				
				drawMonsterGPrepare(g,prepares[4],mos[0]);
				drawMonsterGMagic(g,mos[0].groupMagic,mos[0]);
				drawMonsterEffect(g,mos[0]);
	    	}
	    	for(int i=1;i<mos.length;i++){
	    		if(mos[i].fightable){
	    			drawMonsterPrepare(g,mos[i].prepare,mos[i],pls[mos[i].target]);
	    			drawMonsterMagic(g,mos[i].magic,mos[i],pls[mos[i].target]);
	    			
	    			drawMonsterEffect(g,mos[i]);
	    		}
	    	}
	    	
	    }else{
	    	for(int i=0;i<mos.length;i++){
	    		if(mos[i].fightable){
	    			drawMonsterPrepare(g,mos[i].prepare,mos[i],pls[mos[i].target]);
	    			drawMonsterMagic(g,mos[i].magic,mos[i],pls[mos[i].target]);
	    			
	    			drawMonsterEffect(g,mos[i]);
	    		}
	    	}
	    }
		
		if(pls[0]!=null){
			drawSpecEffect(g,pls[0]);
		}
		if(pls[1]!=null){
			drawSpecEffect(g,pls[1]);
		}
		if(pls[2]!=null){
			drawSpecEffect(g,pls[2]);
		}
		if(pls[3]!=null){
			drawSpecEffect(g,pls[3]);
		}
		
		
		if(pls[0]!=null && pls[0].superSkillUsed){
			img=gp.createImage(640,300);
			if(img==null){
				System.out.println("no  img1");
			}
			sg=img.getGraphics();
			drawSuperSkill(sg,superskills[0],pls[0]);
			g.drawImage(img,0,80,null);
		}
		if(pls[1]!=null && pls[1].superSkillUsed){
			img=gp.createImage(640,300);
			if(img==null){
				System.out.println("no  img1");
			}
			sg=img.getGraphics();
			drawSuperSkill(sg,superskills[1],pls[1]);
			g.drawImage(img,0,80,null);
		}
		if(pls[2]!=null && pls[2].superSkillUsed){
			img=gp.createImage(640,300);
			if(img==null){
				System.out.println("no  img1");
			}
			sg=img.getGraphics();
			drawSuperSkill(sg,superskills[2],pls[2]);
			g.drawImage(img,0,80,null);
		}
		if(pls[3]!=null && pls[3].superSkillUsed){
			img=gp.createImage(640,300);
			if(img==null){
				System.out.println("no  img1");
			}
			sg=img.getGraphics();
			drawSuperSkill(sg,superskills[3],pls[3]);
			g.drawImage(img,0,80,null);
		}
		
		if(bossType!=0 && mos[0].superSkillUsed){
			img=gp.createImage(640,300);
			if(img==null){
				System.out.println("no img1");
			}
			sg=img.getGraphics();
			drawSuperSkill(sg,mos[0].bossskill,mos[0]);
			g.drawImage(img,0,80,null);
		}
		
		if(Player.stateExist){
			img2=gp.createImage(640,480);
			if(img2==null){
				System.out.println("no img2");
			}
			csg=img2.getGraphics();
			drawCharacterState(csg);
			g.drawImage(img2,0,0,null);
		}
	}
	
	
	
	public void drawBackground(Graphics g){
		g.drawImage(back,0,0,null);
		g.drawImage(battleback,0,0,null);
	}
	
	//画站立人物的方法
	public void drawCharacter(Graphics g){
		for(int i=0;i<pls.length;i++){
			if(pls[i]!=null){
				if(pls[i].fightable){
					
					if(pls[i].hasDefended){
						g.drawImage(defendImage,pls[i].locX-5,pls[i].locY,null);
					}
					if(pls[i].enemySelect){
						
						playerAttackTargetJudge(pls[i]);
						g.drawImage(arrow,mos[pls[i].attackTarget].locX,mos[pls[i].attackTarget].locY-15,null);
						g.drawImage(shadow,mos[pls[i].attackTarget].locX,mos[pls[i].attackTarget].locY+20,null);
					}
					
					if(pls[i].magicSelect){
						playerMagicTargetJudge(pls[i]);
						
						g.drawImage(arrow,mos[pls[i].magicTarget].locX,mos[pls[i].magicTarget].locY-15,null);
						g.drawImage(shadow,mos[pls[i].magicTarget].locX,mos[pls[i].magicTarget].locY+20,null);
					}
					if(pls[i].downSelect){
						speedDownTargetJudge(pls[i]);
						
						g.drawImage(arrow,mos[pls[i].speedDownTarget].locX,mos[pls[i].speedDownTarget].locY-15,null);
						g.drawImage(shadow,mos[pls[i].speedDownTarget].locX,mos[pls[i].speedDownTarget].locY+20,null);
					}
					if(pls[i].hasAttacked){
						pls[i].locX+=pls[i].distanceX/30;
						pls[i].locY+=pls[i].distanceY/30;
						
						pls[i].run();
						
						if(pls[i].locX<=mos[pls[i].attackTarget].locX+35){

							pls[i].attackOver(mos[pls[i].attackTarget]);
							pls[i].keyPressed=false;//此时能够重新按键
						}
						
					}else{
						pls[i].locX=pls[i].initialX;
						pls[i].locY=pls[i].initialY;
						pls[i].runBack();
					}
					
					
					pls[i].tremble();
					
					pls[i].display(g);
					
					drawPlayerAttack(g,pls[i],mos[pls[i].attackTarget]);
			
					
					drawPlayerAttackNumber(g,pls[i].actualAtt,pls[i]);
					drawPlayerMagicNumber(g,pls[i].actualMatt,pls[i]);
					drawPlayerGroupMagicNumber(g,pls[i].actualGMatt,pls[i]);
					drawPlayerHealNumber(g,pls[i].hpPlus,pls[i]);
					drawPlayerGroupHealNumber(g,pls[i].hpPlus/2,pls[i]);
					drawPlayerSpeedUpNumber(g,pls[i].speedPlus,pls[i]);
					drawMonsterSpeedDownNumber(g,pls[i].speedMinus,pls[i]);
			
					drawPlayerSuperAttackNumber(g,pls[i].superAtt,pls[i]);

				}
				else if(!pls[i].fightable){
					//为了使死的自然
					drawPlayerBomb(g,pls[i]);
					g.drawImage(dactors[i],pls[i].locX,pls[i].locY+10,null);
				}
			}
			
		}
		
		if(bossType==0){
			for(int i=0;i<mos.length;i++){
				
				if(mos[i].fightable){
					if(mos[i].hasAttacked){
						mos[i].locX+=mos[i].distanceX/20;
						mos[i].locY+=mos[i].distanceY/20;
						
						mos[i].run();
						
						if(mos[i].locX>=pls[mos[i].target].locX-35){
							mos[i].attackOver(pls[mos[i].target]);
						}
					}
					else {
						mos[i].locX=mos[i].initialX;
						mos[i].locY=mos[i].initialY;
						
						mos[i].runBack();
					}
					
					mos[i].tremble();
					mos[i].display(g);
					drawMonsterAttack(g,mos[i],pls[mos[i].target]);

					drawMonsterAttackNumber(g,mos[i].actualAtt,mos[i]);

				}else{
					drawMonsterBomb(g,mos[i]);
				}
			}
		}else{
			if(mos[0].fightable){
				if(mos[0].hasAttacked){
					mos[0].locX+=mos[0].distanceX/30;
					mos[0].locY+=mos[0].distanceY/30;
					
					mos[0].run();
					
					if(mos[0].locX>=pls[mos[0].target].locX-35){
						mos[0].attackOver(pls[mos[0].target]);
					}
				}else{
					mos[0].locX=mos[0].initialX;
					mos[0].locY=mos[0].initialY;
					mos[0].runBack();
				}
				mos[0].tremble();
				mos[0].display(g);
				drawMonsterAttack(g,mos[0],pls[mos[0].target]);
				drawMonsterAttackNumber(g,mos[0].actualAtt,mos[0]);
				drawMonsterMagicNumber(g,mos[0].actualMatt,mos[0]);
				drawBossSuperAttackNumber(g,mos[0].superAtt,mos[0]);
				drawMonsterGroupMagicNumber(g,mos[0].matt,mos[0]);
			}else{
				drawMonsterBomb(g, mos[0]);
				g.drawImage(mos[0].deathBoss,mos[0].locX,mos[0].locY+10,null);
			}
			for(int i=1;i<mos.length;i++){
				
				if(mos[i].fightable){
					if(mos[i].hasAttacked){
						mos[i].locX+=mos[i].distanceX/30;
						mos[i].locY+=mos[i].distanceY/30;
						mos[i].run();
						
						if(mos[i].locX>=pls[mos[i].target].locX-35){
							mos[i].attackOver(pls[mos[i].target]);
						}
					}
					else {
						mos[i].locX=mos[i].initialX;
						mos[i].locY=mos[i].initialY;
						mos[i].runBack();
					}
					mos[i].tremble();
					mos[i].display(g);
					drawMonsterAttack(g,mos[i],pls[mos[i].target]);
					drawMonsterAttackNumber(g,mos[i].actualAtt,mos[i]);
				}else{
					drawMonsterBomb(g,mos[i]);
				}
			}
		}
		
			
	}
	
	//画人物状态
	public void drawState(Graphics g){
		for(int i=0;i<pls.length;i++){
			if(pls[i]!=null){
				g.drawImage(model,i*160,380,null);
				g.drawImage(actors[i],i*160,380,null);
				g.setColor(Color.red);
				g.fillRect(i*160+80,393,(int)(80.0*((double)(pls[i].hp)/(double)(pls[i].HP))), barHeight);
				g.drawRect(i*160+80,393,dataToFight(pls[i].HP),barHeight);
				g.setColor(Color.blue);
				g.fillRect(i*160+80,415,(int)(80.0*((double)(pls[i].mp)/(double)(pls[i].MP))),barHeight);
				g.drawRect(i*160+80,415,dataToFight(pls[i].MP),barHeight);
				g.setColor(Color.orange);
				if(pls[i].ap<=80){
					g.fillRect(i*160+80,439,pls[i].ap,barHeight);
					g.drawRect(i*160+80,439,80,barHeight);
				}
				else if(pls[i].ap>=80){
					if(pls[i].ap>=160){
						pls[i].ap=160;
					}
					g.fillRect(i*160+80,440,80,barHeight);
					g.drawRect(i*160+80,440,80,barHeight);
					g.setColor(Color.green);
					g.fillRect(i*160+80,440,pls[i].ap-80,barHeight);
					g.setColor(Color.orange);
					g.drawRect(i*160+80,440,pls[i].ap-80,barHeight);
				}
			}
			}
		
		//画小怪的状态
		if(bossType!=0){
			for (int i=1;i<mos.length;i++){
				if(mos[i].fightable){

					g.setColor(Color.red);
					g.fillRect(mos[i].locX-12,mos[i].locY-3,(int)(60.0*((double)(mos[i].hp)/(double)(mos[i].HP))),3);
					g.drawRect(mos[i].locX-12,mos[i].locY-3,dataToFight(mos[i].HP,60),3);
				}
			}
			
			//操作角色
			positionDecide();
			
			g.drawRect(160*position,380,160,80);
			g.drawImage(bossModel,0,0,null);
			g.drawImage(enemy0,0,0,null);
			g.setColor(Color.red);
			g.fillRect(100,18,(int)(150.0*(double)(mos[0].hp)/(double)(mos[0].HP)),barHeight);
			g.drawRect(100,18,dataToFight(mos[0].HP,150),barHeight);
			g.setColor(Color.blue);
			g.fillRect(100,50, (int)(150.0*(double)(mos[0].mp)/(double)(mos[0].MP)), barHeight);
			g.drawRect(100,50, dataToFight(mos[0].MP,150), barHeight);
	     
			monsterTargetJudge(mos[0]);
			if(mos[0].fightable){
				g.drawRect(160*mos[0].target,380,160,80);
			}
			
			g.setColor(Color.orange);
			if(mos[0].ap<=150){
				g.fillRect(100,80,mos[0].ap,barHeight);
				g.drawRect(100,80,150,barHeight);
			}
			else if(mos[0].ap>=150){
				g.fillRect(100,80,150,barHeight);
				g.drawRect(100,80,150,barHeight);
				if(mos[0].ap>=300){
					mos[0].ap=300;
				}
				g.setColor(Color.green);
				g.fillRect(100,80,mos[0].ap-150,barHeight);
				g.setColor(Color.orange);
				g.drawRect(100,80,150,barHeight);
			}
			

		}else{
			for (int i=0;i<mos.length;i++){
				if(mos[i].fightable){
					g.setColor(Color.red);
					g.fillRect(mos[i].locX-12,mos[i].locY-3,(int)(60.0*((double)(mos[i].hp)/(double)(mos[i].HP))),3);
					g.drawRect(mos[i].locX-12,mos[i].locY-3,dataToFight(mos[i].HP,60),3);
				}
			}
			
		    positionDecide();
			g.drawRect(160*position,380,160,80);
		}
		

	}
	
	//画进度条
	public void drawProgress(Graphics g){
		g.drawImage(progress,7,100,null);
		for(int i=0;i<pls.length;i++){
			if(pls[i]!=null){
				g.drawImage(pactors[i],0,(int)pls[i].plocation,null);
			}
		}
		for(int i=0;i<penemies.length;i++){
			//如果不能战斗就从进度条上消失
			if(mos[i].fightable){
				g.drawImage(penemies[i],0,(int)mos[i].plocation,null);
			}
			
		}
	}
	
	//画出玩家攻击效果
	public void drawPlayerAttack(Graphics g,Animation anim,Player attacker,Monster victim){
		if(anim.canPlay){
			anim.playAnimation(g,victim.locX,victim.locY);
		}
	}
	
	//画出怪物攻击效果
	public void drawMonsterAttack(Graphics g,Animation anim,Monster attacker,Player victim){
		if(anim.canPlay){
			anim.playAnimation(g,victim.locX,victim.locY);
		}
	}
	
	public void drawPlayerPrepare(Graphics g,Animation anim,Player attacker,Monster victim){
		if(attacker.magicPrepared && !attacker.magicPrepareComplete){
			anim.canPlay=true;
			
			anim.playAnimation(g,attacker.locX-30,attacker.locY-30);
			//检测
			attacker.magicMissCheck(victim);
		}

		else if(attacker.magicPrepared && attacker.magicPrepareComplete){
			anim.canPlay=false;
			anim.imPosition=0;
			attacker.magicUse(victim);
		}
		
	}
	
	public void drawPlayerMagic(Graphics g,Animation anim,Player attacker,Monster victim){
		if(attacker.magicUsed){
			anim.canPlay=true;
			attacker.canKeyPress=false;
			anim.playAnimation(g,victim.locX-25,victim.locY-20);
		}

		
		if(!anim.canPlay && attacker.magicUsed){
			attacker.magicUseOver(victim);

		}
	}
	
	public void drawPlayerGPrepare(Graphics g,Animation anim,Player attacker){
		if(attacker.groupMagicPrepared && !attacker.groupPrepareComplete){
			anim.canPlay=true;
			anim.playAnimation(g,attacker.locX-30,attacker.locY-30);
			//检测
			attacker.groupMagicMissCheck(mos);
		}
		else if(attacker.groupMagicPrepared && attacker.groupPrepareComplete){
			anim.canPlay=false;
			anim.imPosition=0;
			attacker.groupMagicUse(mos);
		}
	
	}
	
	public void drawPlayerGMagic(Graphics g,Animation anim,Player attacker){
		if(attacker.groupMagicUsed){
			attacker.canKeyPress=false;
			for(int i=0;i<mos.length;i++){
				if(mos[i].beenMagiced){
					anim.canPlay=true;
					
				}
			}
			anim.playAnimation(g,50,160);
		}
		if(!anim.canPlay && attacker.groupMagicUsed){
			attacker.groupMagicUseOver(mos);
		}
	}
	
	public void drawMonsterGPrepare(Graphics g,Animation anim,Monster attacker){
		if(attacker.groupMagicPrepared && !attacker.groupPrepareComplete){
			anim.canPlay=true;
			anim.playAnimation(g,attacker.locX-30,attacker.locY-30);
			//检测
			attacker.groupMagicMissCheck(pls);//原来是这边错了
		}
		else if(attacker.groupMagicPrepared && attacker.groupPrepareComplete){
			anim.canPlay=false;
			anim.imPosition=0;
			attacker.groupMagicUse(pls);
		}
	}
	
	public void drawMonsterGMagic(Graphics g,Animation anim,Monster attacker){
		if(attacker.groupMagicUsed){
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null && pls[i].beenMagiced){
					anim.canPlay=true;
					
				}
			}
			anim.playAnimation(g,350,160);
		}
		
		
		if(!anim.canPlay && attacker.groupMagicUsed){
			attacker.groupMagicUseOver(pls);
		}
		
	}
	
	//画怪物魔法准备
	public void drawMonsterPrepare(Graphics g,Animation anim,Monster attacker,Player victim){
		if(attacker.magicPrepared && !attacker.magicPrepareComplete){
			anim.canPlay=true;
			anim.playAnimation(g,attacker.locX-30,attacker.locY-30);
		}
		else if(attacker.magicPrepared && attacker.magicPrepareComplete){
			anim.canPlay=false;
			anim.imPosition=0;
			attacker.magicUse(victim);
		}
	}
	
	//画怪物魔法攻击
	public void drawMonsterMagic(Graphics g,Animation anim,Monster attacker,Player victim){
		if(attacker.magicUsed){
			anim.canPlay=true;
			anim.playAnimation(g,victim.locX-25,victim.locY-20);
		}
		
		if(!anim.canPlay && attacker.magicUsed){
			attacker.magicUseOver(victim);
		}
	}
	
	public void drawSuperSkill(Graphics g,Animation anim,Fighter f){
		if(f==pls[0] && pls[0]!=null){
			if(pls[0].superSkillUsed){
				g.drawImage(skillback,0,0,null);
			
				if(pls[0].superCount>=0 && pls[0].superCount<pls[0].superMaxCount){
					g.drawImage(supers[0],pls[0].superCount*16,0,null);
					pls[0].superCount+=1;
				}
				if(pls[0].superCount>=pls[0].superMaxCount){
					g.drawImage(supers[0],pls[0].superMaxCount*16,0,null);
					anim.canPlay=true;
					anim.playAnimation(g,0,0);
					if(!anim.canPlay){
						pls[0].superSkillUseOver(mos);
					}
				}
			}
		}
		
		else if(f==pls[1] && pls[1]!=null){
			if(pls[1].superSkillUsed){
				g.drawImage(skillback,0,0,null);
				if(pls[1].superCount>=0 && pls[1].superCount<pls[1].superMaxCount){
					g.drawImage(supers[1],pls[1].superCount*16,0,null);
					pls[1].superCount+=1;
				}
				if(pls[1].superCount>=pls[1].superMaxCount){
					g.drawImage(supers[1],pls[1].superMaxCount*16,0,null);
					anim.canPlay=true;
					anim.playAnimation(g,0,0);
					if(!anim.canPlay){
						pls[1].superSkillUseOver(mos);
					}
				}
			}
		}
		
		else if(f==pls[2] && pls[2]!=null){
			if(pls[2].superSkillUsed){
				g.drawImage(skillback,0,0,null);
				if(pls[2].superCount>=0 && pls[2].superCount<pls[2].superMaxCount){
					g.drawImage(supers[2],pls[2].superCount*16,0,null);
					pls[2].superCount+=1;
				}
				if(pls[2].superCount>=pls[2].superMaxCount){
					g.drawImage(supers[2],pls[2].superMaxCount*16,0,null);
					anim.canPlay=true;
					anim.playAnimation(g,0,0);
					if(!anim.canPlay){
						pls[2].superSkillUseOver(mos);
					}
				}
			}
		}
		else if(f==pls[3] && pls[3]!=null){
			if(pls[3].superSkillUsed){
				g.drawImage(skillback,0,0,null);
				if(pls[3].superCount>=0 && pls[3].superCount<pls[3].superMaxCount){
					g.drawImage(supers[3],pls[3].superCount*16,0,null);
					pls[3].superCount+=1;
				}
				if(pls[3].superCount>=pls[3].superMaxCount){
					g.drawImage(supers[3],pls[3].superMaxCount*16,0,null);
					anim.canPlay=true;
					anim.playAnimation(g,0,0);
					if(!anim.canPlay){
						pls[3].superSkillUseOver(mos);
					}
				}
			}
		}
		else if(f==mos[0] && bossType!=0){
			if(mos[0].superSkillUsed){
				g.drawImage(skillback,0,0,null);
				if(mos[0].superCount>=0 && mos[0].superCount<mos[0].superMaxCount){
					g.drawImage(mos[0].superBoss,mos[0].superCount*16,0,null);
					mos[0].superCount+=1;
				}
				if(mos[0].superCount>=mos[0].superMaxCount){
					g.drawImage(mos[0].superBoss,mos[0].superMaxCount*16,0,null);
					anim.canPlay=true;
					anim.playAnimation(g,0,0);
					if(!anim.canPlay){
						mos[0].superSkillUseOver(pls);
					}
				}
			}
		}
		

	}
	
	public void drawMonsterEffect(Graphics g,Monster mo){
		if(mo.interruptCount>=0){
			mo.interruptX+=0.3;
			mo.interruptY-=0.6;
			mo.interruptCount+=1;
			g.drawImage(interrupt,(int)mo.interruptX,(int)mo.interruptY,null);
			if(mo.interruptCount>=mo.interruptMaxCount){
				mo.interruptCount=-1;
			}
		}else {
			mo.interruptX=mo.initialX;
			mo.interruptY=mo.initialY;
		}
		
		if(mo.missCount>=0){
			mo.missX+=0.3;
			mo.missY-=0.6;
			mo.missCount+=1;
			g.drawImage(miss,(int)mo.missX,(int)mo.missY,null);
			if(mo.missCount>+mo.missMaxCount){
				mo.missCount=-1;
			}
		}else{
			mo.missX=mo.initialMissX;
			mo.missY=mo.initialMissY;
		}
	}
	
	public void drawSpecEffect(Graphics g,Player pl){

		if(!pl.magicUsed && !pl.groupMagicUsed){
			pl.specX=mos[0].locX;
			pl.specY=mos[0].locY;
		}
		
		if(pl.magicUsed || pl.groupMagicUsed){
			pl.specX-=0.3;
			pl.specY-=0.6;
			switch(pl.state){
			case Player.cool:
				g.drawImage(cool,(int)pl.specX,(int)pl.specY,null);
				break;
			case Player.good:
				g.drawImage(good,(int)pl.specX,(int)pl.specY,null);
				break;
			case Player.perfect:
				g.drawImage(perfect,(int)pl.specX,(int)pl.specY,null);
				break;
			}
		}else {

			pl.specX=mos[0].locX;
			pl.specY=mos[0].locY;
		}
		
		
		if(pl.interruptCount>=0){
			pl.interruptX+=0.3;
			pl.interruptY-=0.6;
			pl.interruptCount+=1;
			g.drawImage(interrupt,(int)pl.interruptX,(int)pl.interruptY,null);
			if(pl.interruptCount>=pl.interruptMaxCount){
				pl.interruptCount=-1;
			}
		}else {
			pl.interruptX=pl.initialX;
			pl.interruptY=pl.initialY;
		}
		
		
		if(pl.missCount>=0){
			pl.missX+=0.8;
			pl.missY-=2.0;
			pl.missCount+=1;
			g.drawImage(miss,(int)pl.missX,(int)pl.missY,null);
			if(pl.missCount>=pl.missMaxCount){
				pl.missCount=-1;
			}
		}else {
			pl.missX=pl.initialMissX;
			pl.missY=pl.initialMissY;
		}
		
		if(pl.defendCount>=0){
			pl.defendX+=0.3;
			pl.defendY-=1.1;
			pl.defendCount+=1;
			g.drawImage(defend,(int)pl.defendX,(int)pl.defendY,null);
			if(pl.defendCount>=pl.defendMaxCount){
				pl.defendCount=-1;
			}
		}else{
			pl.defendX=pl.initialX;
			pl.defendY=pl.initialY;
		}
		
		
	}
	
	
	public void drawPlayerSpeedUp(Graphics g,Animation anim,Player speeder,Player speedee){
		if(speeder.ifSelect){
//			g.setColor(Color.pink);
			playerSpeedTargetJudge(speeder);//不能给死人加速
//			g.drawRect(pls[speeder.speedTarget].locX+10,pls[speeder.speedTarget].locY+50,50,30);
			g.drawImage(arrow,pls[speeder.speedTarget].locX,pls[speeder.speedTarget].locY-15,null);
			g.drawImage(shadow,pls[speeder.speedTarget].locX,pls[speeder.speedTarget].locY+20,null);
		}
		if(speeder.hasSpeeded){
			anim.canPlay=true;
			anim.playAnimation(g,speedee.locX-30,speedee.locY);
		}
		if(!anim.canPlay && speeder.hasSpeeded){
			speeder.speedUpOver(speedee);

		}
	}
	
	public void drawPlayerSpeedDown(Graphics g,Animation anim,Player downer,Monster downee){
		if(downer.ifSelect){
			speedDownTargetJudge(downer);//不能给死人加速
			g.drawImage(arrow,mos[downer.speedDownTarget].locX,mos[downer.speedTarget].locY-15,null);
			g.drawImage(shadow,mos[downer.speedTarget].locX,mos[downer.speedTarget].locY+20,null);
		}
		if(downer.speedDown){
			anim.canPlay=true;
			anim.playAnimation(g,downee.locX-30,downee.locY);
		}
		if(!anim.canPlay && downer.speedDown){
			downer.speedDownOver(downee);

		}
	}
	
	public void drawPlayerHeal(Graphics g,Animation anim,Player healer,Player healee){
		 if(healer.ifSelect){

				//治愈目标
				playerHealTargetJudge(healer);
				g.drawImage(arrow,pls[healer.healTarget].locX,pls[healer.healTarget].locY-15,null);
				g.drawImage(shadow,pls[healer.healTarget].locX,pls[healer.healTarget].locY+20,null);
			}
			if(healer.hasHealed){
				anim.canPlay=true;
				anim.playAnimation(g,healee.locX-35,healee.locY-45);
			}
			if(!anim.canPlay && healer.hasHealed){
				healer.healOver(healee);
			}
	}
	
	public void drawPlayerGHeal(Graphics g,Animation anim,Player healer){
		if(healer.groupHealed){
			anim.canPlay=true;
			anim.playAnimation(g,350,160);
		}
		if(!anim.canPlay && healer.groupHealed){
			healer.groupHealOver(pls);
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
	
	public void playerSpeedTargetJudge(Player pl){
		for(int i=0;i<pls.length;i++){
			if(pls[pl.speedTarget]!=null && !pls[pl.speedTarget].fightable){
				pls[pl.speedTarget].selectable=false;
			}else if(pls[pl.speedTarget]!=null && pls[pl.speedTarget].fightable){
				pls[pl.speedTarget].selectable=true;
			}
		}
		
		while((pls[pl.speedTarget]!=null && !pls[pl.speedTarget].selectable)||(pls[pl.speedTarget]==null)){
			pl.speedTarget=(pl.speedTarget+1)%pls.length;
			if(pls[pl.speedTarget]!=null && pls[pl.speedTarget].selectable){
				break;
			}
		}
		
	}
	//减速目标判定
	public void speedDownTargetJudge(Player pl){
		for(int i=0;i<mos.length;i++){
			if(!mos[pl.speedDownTarget].fightable){
				mos[pl.speedDownTarget].selectable=false;
			}else if(mos[pl.speedDownTarget].fightable){
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
	
	//判定
	public void playerAttackTargetJudge(Player pl) {
	    while(!mos[pl.attackTarget].fightable){
			pl.attackTarget=(pl.attackTarget+1)%mos.length;
			if(mos[pl.attackTarget].fightable){
				break;
			}
		}
	}

	public void playerMagicTargetJudge(Player pl) {
		while(!mos[pl.magicTarget].fightable){
			pl.magicTarget=(pl.magicTarget+1)%mos.length;
			if(mos[pl.magicTarget].fightable){
				break;
			}
		}
	}
	
	
	public void positionDecide(){
		for(int i=0;i<pls.length;i++){
			if(pls[i]!=null){
				if(pls[i].plocation>=140 && pls[i].plocation<=160){
					position=i;
				}
			}
		}
		if(pls[position]==null){
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null){
					position=i;
					break;
				}
			}
		}
	}
	
	public void monsterTargetJudge(Monster mo){
		while(pls[mo.target]==null){
			mo.target=(mo.target+1)%pls.length;
			if(pls[mo.target]!=null){
				break;
			}
		}
	}
	
	public void drawCharacterState(Graphics g){
		g.drawImage(stateback,0,0,null);
		for(int i=0;i<pls.length;i++){
			if(pls!=null){
				g.drawImage(actors[i],320*(i%2),240*(i/2),null);
			}
		}
		
		g.setColor(Color.GRAY);
		g.drawRect(Player.statePosition.x*320,Player.statePosition.y*240,320,240);
	}
	
	
	
	public void drawPlayerAttack(Graphics g,Player attacker,Monster victim){
		if(attacker.attackCount>=0){
			g.drawImage(attacks[attacker.attackCount],victim.locX,victim.locY,null);
			attacker.attackCount+=1;
		}
		if(attacker.attackCount>=attacks.length){
			attacker.attackCount=-1;
		}
	}
	
	public void drawMonsterAttack(Graphics g,Monster attacker,Player victim){
		if(attacker.attackCount>=0){
			g.drawImage(attacks[attacker.attackCount],victim.locX,victim.locY,null);
			attacker.attackCount+=1;
		}
		if(attacker.attackCount>=attacks.length){
			attacker.attackCount=-1;
		}
	}
	
	//玩家爆炸效果
	public void drawPlayerBomb(Graphics g,Player pl){
		if(!pl.bombed && pl.bombCount>=0){
			if(pl.bombCount>=0){
				g.drawImage(bombs[pl.bombCount],pl.locX-25,pl.locY-20,null);
				pl.bombCount+=1;
			}
			if(pl.bombCount>=bombs.length){
				pl.bombCount=-1;
				pl.bombed=true;
			}
			
		}
	}
	
	//小怪爆炸效果
	public void drawMonsterBomb(Graphics g,Monster mo){
		if(!mo.bombed && mo.bombCount>=0){
			if(mo.bombCount>=0){
				g.drawImage(bombs[mo.bombCount],mo.locX-25,mo.locY-20,null);
				mo.bombCount+=1;
			}
			if(mo.bombCount>=bombs.length){
				mo.bombCount=-1;
				mo.bombed=true;
			}
			
		}
		
	}
	
	
		public void numberToPicture(int num){
			if(num>=1000){
				System.out.println("number out of range");
			}else{
				a=num/100;
				b=(num%100)/10;
			    c=(num%100)%10;
			}
			
		}
		
	public void drawPlayerAttackNumber(Graphics g,int num,Player pl){
		if(pl.attackNumCount>=0){
			numberToPicture(num);
			if(a==0 ){
				if(b!=0){
					g.drawImage(attackNumbers[10],(int)mos[pl.attackTarget].attackNumX,(int)mos[pl.attackTarget].attackNumY,null);
					g.drawImage(attackNumbers[b],(int)mos[pl.attackTarget].attackNumX+12,(int)mos[pl.attackTarget].attackNumY-1,null);
					g.drawImage(attackNumbers[c],(int)mos[pl.attackTarget].attackNumX+24,(int)mos[pl.attackTarget].attackNumY-2,null);
				}
				else{
					g.drawImage(attackNumbers[10],(int)mos[pl.attackTarget].attackNumX,(int)mos[pl.attackTarget].attackNumY,null);
					g.drawImage(attackNumbers[c],(int)mos[pl.attackTarget].attackNumX+12,(int)mos[pl.attackTarget].attackNumY-1,null);
				}
			}
			else {
				g.drawImage(attackNumbers[10],(int)mos[pl.attackTarget].attackNumX,(int)mos[pl.attackTarget].attackNumY,null);
				g.drawImage(attackNumbers[a],(int)mos[pl.attackTarget].attackNumX+12,(int)mos[pl.attackTarget].attackNumY-1,null);
				g.drawImage(attackNumbers[b],(int)mos[pl.attackTarget].attackNumX+24,(int)mos[pl.attackTarget].attackNumY-2,null);
				g.drawImage(attackNumbers[c],(int)mos[pl.attackTarget].attackNumX+36,(int)mos[pl.attackTarget].attackNumY-3,null);
			}
			pl.attackNumCount+=1;
			mos[pl.attackTarget].attackNumX+=0.4;
			mos[pl.attackTarget].attackNumY-=1.0;
		}
		if(pl.attackNumCount>=pl.attackNumMaxCount){
			pl.attackNumCount=-1;
			mos[pl.attackTarget].attackNumX=mos[pl.attackTarget].initialNumX;
			mos[pl.attackTarget].attackNumY=mos[pl.attackTarget].initialNumY;
		}
		
	}
	
	public void drawPlayerMagicNumber(Graphics g,int num,Player pl){
		if(pl.magicNumCount>=0){
			numberToPicture(num);
			if(a==0){
				if(b!=0){
					g.drawImage(magicNumbers[10],(int)mos[pl.magicTarget].magicNumX,(int)mos[pl.magicTarget].magicNumY,null);
					g.drawImage(magicNumbers[b],(int)mos[pl.magicTarget].magicNumX+12,(int)mos[pl.magicTarget].magicNumY-1,null);
					g.drawImage(magicNumbers[c],(int)mos[pl.magicTarget].magicNumX+24,(int)mos[pl.magicTarget].magicNumY-2,null);
				}
				else{
					g.drawImage(magicNumbers[10],(int)mos[pl.magicTarget].magicNumX,(int)mos[pl.magicTarget].magicNumY,null);
					g.drawImage(magicNumbers[c],(int)mos[pl.magicTarget].magicNumX+12,(int)mos[pl.magicTarget].magicNumY-1,null);
				}
				
			}
			else{
				g.drawImage(magicNumbers[10],(int)mos[pl.magicTarget].magicNumX,(int)mos[pl.magicTarget].magicNumY,null);
				g.drawImage(magicNumbers[a],(int)mos[pl.magicTarget].magicNumX+12,(int)mos[pl.magicTarget].magicNumY-1,null);
				g.drawImage(magicNumbers[b],(int)mos[pl.magicTarget].magicNumX+24,(int)mos[pl.magicTarget].magicNumY-2,null);
				g.drawImage(magicNumbers[c],(int)mos[pl.magicTarget].magicNumX+36,(int)mos[pl.magicTarget].magicNumY-3,null);
			}
			pl.magicNumCount+=1;
			mos[pl.magicTarget].magicNumX+=0.4;
			mos[pl.magicTarget].magicNumY-=1.0;
		}
		if(pl.magicNumCount>=pl.magicNumMaxCount){
			pl.magicNumCount=-1;
			mos[pl.magicTarget].magicNumX=mos[pl.magicTarget].initialNumX;
			mos[pl.magicTarget].magicNumY=mos[pl.magicTarget].initialNumY;
		}
	}
	
	public void drawPlayerHealNumber(Graphics g,int num,Player pl){
		if(pl.healNumCount>=0){
			numberToPicture(num);
			if(a==0){
				if(b!=0){
					g.drawImage(numbers[10],(int)pls[pl.healTarget].healNumX,(int)pls[pl.healTarget].healNumY,null);
					g.drawImage(numbers[b],(int)pls[pl.healTarget].healNumX+12,(int)pls[pl.healTarget].healNumY-1,null);
					g.drawImage(numbers[c],(int)pls[pl.healTarget].healNumX+24,(int)pls[pl.healTarget].healNumY-2,null);
				}
				else{
					g.drawImage(numbers[10],(int)pls[pl.healTarget].healNumX,(int)pls[pl.healTarget].healNumY,null);
					g.drawImage(numbers[c],(int)pls[pl.healTarget].healNumX+12,(int)pls[pl.healTarget].healNumY-1,null);
				}
			}else{
				g.drawImage(numbers[10],(int)pls[pl.healTarget].healNumX,(int)pls[pl.healTarget].healNumY,null);
				g.drawImage(numbers[a],(int)pls[pl.healTarget].healNumX+12,(int)pls[pl.healTarget].healNumY-1,null);
				g.drawImage(numbers[b],(int)pls[pl.healTarget].healNumX+24,(int)pls[pl.healTarget].healNumY-2,null);
				g.drawImage(numbers[c],(int)pls[pl.healTarget].healNumX+36,(int)pls[pl.healTarget].healNumY-3,null);
			}
			pl.healNumCount+=1;
			pls[pl.healTarget].healNumX+=0.4;
			pls[pl.healTarget].healNumY-=1.0;
		}
		if(pl.healNumCount>=pl.healNumMaxCount){
			pl.healNumCount=-1;
			pls[pl.healTarget].healNumX=pls[pl.healTarget].initialNumX;
			pls[pl.healTarget].healNumY=pls[pl.healTarget].initialNumY;
		}
	}
	
	public void drawPlayerSpeedUpNumber(Graphics g,int num,Player pl){
		if(pl.speedNumCount>=0){
			numberToPicture(num);
			if(a==0){
				if(b!=0){
					g.drawImage(numbers[10],(int)pls[pl.speedTarget].speedNumX,(int)pls[pl.speedTarget].speedNumY,null);
					g.drawImage(numbers[b],(int)pls[pl.speedTarget].speedNumX+12,(int)pls[pl.speedTarget].speedNumY-1,null);
					g.drawImage(numbers[c],(int)pls[pl.speedTarget].speedNumX+24,(int)pls[pl.speedTarget].speedNumY-2,null);
				}
				else{
					g.drawImage(numbers[10],(int)pls[pl.speedTarget].speedNumX,(int)pls[pl.speedTarget].speedNumY,null);
					g.drawImage(numbers[c],(int)pls[pl.speedTarget].speedNumX+12,(int)pls[pl.speedTarget].speedNumY-1,null);
				}
				
			}else{
				g.drawImage(numbers[10],(int)pls[pl.speedTarget].speedNumX,(int)pls[pl.speedTarget].speedNumY,null);
				g.drawImage(numbers[a],(int)pls[pl.speedTarget].speedNumX+12,(int)pls[pl.speedTarget].speedNumY-1,null);
				g.drawImage(numbers[b],(int)pls[pl.speedTarget].speedNumX+24,(int)pls[pl.speedTarget].speedNumY-2,null);
				g.drawImage(numbers[c],(int)pls[pl.speedTarget].speedNumX+36,(int)pls[pl.speedTarget].speedNumY-3,null);
			}
			pl.speedNumCount+=1;
			pls[pl.speedTarget].speedNumX+=0.4;
			pls[pl.speedTarget].speedNumY-=1.0;
		}
		if(pl.speedNumCount>=pl.speedNumMaxCount){
			pl.speedNumCount=-1;
			pls[pl.speedTarget].speedNumX=pls[pl.speedTarget].initialNumX;
			pls[pl.speedTarget].speedNumY=pls[pl.speedTarget].initialNumY;
		}
	}
	
	//画减速数字
	public void drawMonsterSpeedDownNumber(Graphics g,int num,Player pl){
		if(pl.speedDownNumCount>=0){
			numberToPicture(num);
			if(a==0){
				if(b!=0){
					g.drawImage(negativeNumbers[10],(int)mos[pl.speedDownTarget].speedDownNumX,(int)mos[pl.speedDownTarget].speedDownNumY,null);
					g.drawImage(negativeNumbers[b],(int)mos[pl.speedDownTarget].speedDownNumX+12,(int)mos[pl.speedDownTarget].speedDownNumY-1,null);
					g.drawImage(negativeNumbers[c],(int)mos[pl.speedDownTarget].speedDownNumX+24,(int)mos[pl.speedDownTarget].speedDownNumY-2,null);
				}
				else{
					g.drawImage(negativeNumbers[10],(int)mos[pl.speedDownTarget].speedDownNumX,(int)mos[pl.speedDownTarget].speedDownNumY,null);
					g.drawImage(negativeNumbers[c],(int)mos[pl.speedDownTarget].speedDownNumX+12,(int)mos[pl.speedDownTarget].speedDownNumY-1,null);
				}
				
			}else{
				g.drawImage(negativeNumbers[10],(int)mos[pl.speedDownTarget].speedDownNumX,(int)mos[pl.speedDownTarget].speedDownNumY,null);
				g.drawImage(negativeNumbers[a],(int)mos[pl.speedDownTarget].speedDownNumX+12,(int)mos[pl.speedDownTarget].speedDownNumY-1,null);
				g.drawImage(negativeNumbers[b],(int)mos[pl.speedDownTarget].speedDownNumX+24,(int)mos[pl.speedDownTarget].speedDownNumY-2,null);
				g.drawImage(negativeNumbers[c],(int)mos[pl.speedDownTarget].speedDownNumX+36,(int)mos[pl.speedDownTarget].speedDownNumY-3,null);
			}
			pl.speedDownNumCount+=1;
			mos[pl.speedDownTarget].speedDownNumX+=0.4;
			mos[pl.speedDownTarget].speedDownNumY-=1.0;
		}
		if(pl.speedDownNumCount>=pl.speedDownNumMaxCount){
			pl.speedDownNumCount=-1;
			mos[pl.speedDownTarget].speedDownNumX=mos[pl.speedTarget].initialNumX;
			mos[pl.speedDownTarget].speedDownNumY=mos[pl.speedTarget].initialNumY;
		}
	}
	
	public void drawMonsterAttackNumber(Graphics g,int num,Monster mo){
		if(mo.attackNumCount>=0){
			numberToPicture(num);
			if(a==0){
				if(b!=0){
					g.drawImage(attackNumbers[10],(int)pls[mo.target].attackNumX,(int)pls[mo.target].attackNumY,null);
					g.drawImage(attackNumbers[b],(int)pls[mo.target].attackNumX+12,(int)pls[mo.target].attackNumY-1,null);
					g.drawImage(attackNumbers[c],(int)pls[mo.target].attackNumX+24,(int)pls[mo.target].attackNumY-2,null);
				}
				else{
					g.drawImage(attackNumbers[10],(int)pls[mo.target].attackNumX,(int)pls[mo.target].attackNumY,null);
					g.drawImage(attackNumbers[c],(int)pls[mo.target].attackNumX+12,(int)pls[mo.target].attackNumY-1,null);
				}
			}
			else{
				g.drawImage(attackNumbers[10],(int)pls[mo.target].attackNumX,(int)pls[mo.target].attackNumY,null);
				g.drawImage(attackNumbers[a],(int)pls[mo.target].attackNumX+12,(int)pls[mo.target].attackNumY-1,null);
				g.drawImage(attackNumbers[b],(int)pls[mo.target].attackNumX+24,(int)pls[mo.target].attackNumY-2,null);
				g.drawImage(attackNumbers[c],(int)pls[mo.target].attackNumX+36,(int)pls[mo.target].attackNumY-3,null);
			}
			mo.attackNumCount+=1;
			pls[mo.target].attackNumX+=0.4;
			pls[mo.target].attackNumY-=1.0;
		}
		if(mo.attackNumCount>=mo.attackNumMaxCount){
			mo.attackNumCount=-1;
			pls[mo.target].attackNumX=pls[mo.target].initialNumX;
			pls[mo.target].attackNumY=pls[mo.target].initialNumY;
		}
	
	}
	   
	public void drawMonsterMagicNumber(Graphics g,int num,Monster mo){
		if(mo.magicNumCount>=0){
			numberToPicture(num);
			if(a==0){
				if(b!=0){
					g.drawImage(magicNumbers[10],(int)pls[mo.target].magicNumX,(int)pls[mo.target].magicNumY,null);
					g.drawImage(magicNumbers[b],(int)pls[mo.target].magicNumX+12,(int)pls[mo.target].magicNumY-1,null);
					g.drawImage(magicNumbers[c],(int)pls[mo.target].magicNumX+24,(int)pls[mo.target].magicNumY-2,null);
				}
				else{
					g.drawImage(magicNumbers[10],(int)pls[mo.target].magicNumX,(int)pls[mo.target].magicNumY,null);
					g.drawImage(magicNumbers[c],(int)pls[mo.target].magicNumX+12,(int)pls[mo.target].magicNumY-1,null);
				}
			}
			else{
				g.drawImage(magicNumbers[10],(int)pls[mo.target].magicNumX,(int)pls[mo.target].magicNumY,null);
				g.drawImage(magicNumbers[a],(int)pls[mo.target].magicNumX+12,(int)pls[mo.target].magicNumY-1,null);
				g.drawImage(magicNumbers[b],(int)pls[mo.target].magicNumX+24,(int)pls[mo.target].magicNumY-2,null);
				g.drawImage(magicNumbers[c],(int)pls[mo.target].magicNumX+36,(int)pls[mo.target].magicNumY-3,null);
			}
			mo.magicNumCount+=1;
			pls[mo.target].magicNumX+=0.4;
			pls[mo.target].magicNumY-=1.0;
		}
		if(mo.magicNumCount>=mo.magicNumMaxCount){
			mo.magicNumCount=-1;
			pls[mo.target].magicNumX=pls[mo.target].initialNumX;
			pls[mo.target].magicNumY=pls[mo.target].initialNumY;
		}
		
	}
	
	public void drawPlayerSuperAttackNumber(Graphics g,int num,Player pl){
		if(pl.superNumCount>=0){
			numberToPicture(num);
			for(int i=0;i<mos.length;i++){
				if(mos[i].fightable){
					if(a==0 ){
						if(b!=0){
							g.drawImage(attackNumbers[10],(int)mos[i].attackNumX,(int)mos[i].attackNumY,null);
							g.drawImage(attackNumbers[b],(int)mos[i].attackNumX+12,(int)mos[i].attackNumY-1,null);
							g.drawImage(attackNumbers[c],(int)mos[i].attackNumX+24,(int)mos[i].attackNumY-2,null);
						}
						else{
							g.drawImage(attackNumbers[10],(int)mos[i].attackNumX,(int)mos[i].attackNumY,null);
							g.drawImage(attackNumbers[c],(int)mos[i].attackNumX+12,(int)mos[i].attackNumY-1,null);
						}
					}
					else {
						g.drawImage(attackNumbers[10],(int)mos[i].attackNumX,(int)mos[i].attackNumY,null);
						g.drawImage(attackNumbers[a],(int)mos[i].attackNumX+12,(int)mos[i].attackNumY-1,null);
						g.drawImage(attackNumbers[b],(int)mos[i].attackNumX+24,(int)mos[i].attackNumY-2,null);
						g.drawImage(attackNumbers[c],(int)mos[i].attackNumX+36,(int)mos[i].attackNumY-3,null);
					}
				
				}
			}
		    pl.superNumCount+=1;
		    for(int i=0;i<mos.length;i++){
			   mos[i].attackNumX+=0.4;
			   mos[i].attackNumY-=1.0;
		    }
		}
		if(pl.superNumCount>=pl.superNumMaxCount){
			pl.superNumCount=-1;
			for(int i=0;i<mos.length;i++){
				
				mos[i].attackNumX=mos[i].initialNumX;
				mos[i].attackNumY=mos[i].initialNumY;
			}
		}
	}
	
	public void drawBossSuperAttackNumber(Graphics g,int num,Monster boss){
		if(boss.superNumCount>=0){
			numberToPicture(num);
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null && pls[i].fightable){
					if(a==0){
						if(b!=0){
							g.drawImage(attackNumbers[10],(int)pls[i].attackNumX,(int)pls[i].attackNumY,null);
							g.drawImage(attackNumbers[b],(int)pls[i].attackNumX+12,(int)pls[i].attackNumY-1,null);
							g.drawImage(attackNumbers[c],(int)pls[i].attackNumX+24,(int)pls[i].attackNumY-2,null);
						}
						else{
							g.drawImage(attackNumbers[10],(int)pls[i].attackNumX,(int)pls[i].attackNumY,null);
							g.drawImage(attackNumbers[c],(int)pls[i].attackNumX+12,(int)pls[i].attackNumY-1,null);
						}
					}
					else{
						g.drawImage(attackNumbers[10],(int)pls[i].attackNumX,(int)pls[i].attackNumY,null);
						g.drawImage(attackNumbers[a],(int)pls[i].attackNumX+12,(int)pls[i].attackNumY-1,null);
						g.drawImage(attackNumbers[b],(int)pls[i].attackNumX+24,(int)pls[i].attackNumY-2,null);
						g.drawImage(attackNumbers[c],(int)pls[i].attackNumX+36,(int)pls[i].attackNumY-3,null);
					}
				}
			}
			boss.superNumCount+=1;
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null){
					pls[i].attackNumX+=0.4;
					pls[i].attackNumY-=1.0;
				}
			}
		}
		if(boss.superNumCount>=boss.superNumMaxCount){
			boss.superNumCount=-1;
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null){
					pls[i].attackNumX=pls[i].initialNumX;
					pls[i].attackNumY=pls[i].initialNumY;
				}
			}
		}
	}
	
	public void drawPlayerGroupMagicNumber(Graphics g,int num,Player pl){
		if(pl.gMagicNumCount>=0){
			numberToPicture(num);
			for(int i=0;i<mos.length;i++){
				if(mos[i].fightable){
					if(a==0){
						if(b!=0){
							g.drawImage(magicNumbers[10],(int)mos[i].magicNumX,(int)mos[i].magicNumY,null);
							g.drawImage(magicNumbers[b],(int)mos[i].magicNumX+12,(int)mos[i].magicNumY-1,null);
							g.drawImage(magicNumbers[c],(int)mos[i].magicNumX+24,(int)mos[i].magicNumY-2,null);
						}
						else{
							g.drawImage(magicNumbers[10],(int)mos[i].magicNumX,(int)mos[i].magicNumY,null);
							g.drawImage(magicNumbers[c],(int)mos[i].magicNumX+12,(int)mos[i].magicNumY-1,null);
						}
						
					}
					else{
						g.drawImage(magicNumbers[10],(int)mos[i].magicNumX,(int)mos[i].magicNumY,null);
						g.drawImage(magicNumbers[a],(int)mos[i].magicNumX+12,(int)mos[i].magicNumY-1,null);
						g.drawImage(magicNumbers[b],(int)mos[i].magicNumX+24,(int)mos[i].magicNumY-2,null);
						g.drawImage(magicNumbers[c],(int)mos[i].magicNumX+36,(int)mos[i].magicNumY-3,null);
					}
					mos[i].magicNumX+=0.4;
					mos[i].magicNumY-=1.0;
				}
			}
			pl.gMagicNumCount+=1;
		}
		if(pl.gMagicNumCount>=pl.gMagicMaxCount){
			pl.gMagicNumCount=-1;
			for(int i=0;i<mos.length;i++){
				if(mos[i].beenMagiced){
					mos[i].beenMagiced=false;
					
				}
				mos[i].magicNumX=mos[i].initialNumX;
				mos[i].magicNumY=mos[i].initialNumY;
			}
			
		}
	}
	
	public void drawMonsterGroupMagicNumber(Graphics g,int num,Monster mo){
		if(mo.gMagicNumCount>=0){
			numberToPicture(num);
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null && pls[i].fightable){
					if(a==0){
						if(b!=0){
							g.drawImage(magicNumbers[10],(int)pls[i].magicNumX,(int)pls[i].magicNumY,null);
							g.drawImage(magicNumbers[b],(int)pls[i].magicNumX+12,(int)pls[i].magicNumY-1,null);
							g.drawImage(magicNumbers[c],(int)pls[i].magicNumX+24,(int)pls[i].magicNumY-2,null);
						}
						else{
							g.drawImage(magicNumbers[10],(int)pls[i].magicNumX,(int)pls[i].magicNumY,null);
							g.drawImage(magicNumbers[c],(int)pls[i].magicNumX+12,(int)pls[i].magicNumY-1,null);
						}
						
					}
					else{
						g.drawImage(magicNumbers[10],(int)pls[i].magicNumX,(int)pls[i].magicNumY,null);
						g.drawImage(magicNumbers[a],(int)pls[i].magicNumX+12,(int)pls[i].magicNumY-1,null);
						g.drawImage(magicNumbers[b],(int)pls[i].magicNumX+24,(int)pls[i].magicNumY-2,null);
						g.drawImage(magicNumbers[c],(int)pls[i].magicNumX+36,(int)pls[i].magicNumY-3,null);
					}
					pls[i].magicNumX+=0.4;
					pls[i].magicNumY-=1.0;
				}
			}
			mo.gMagicNumCount+=1;
		}
		if(mo.gMagicNumCount>=mo.gMagicMaxCount){
			mo.gMagicNumCount=-1;
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null){
					pls[i].magicNumX=pls[i].initialNumX;
					pls[i].magicNumY=pls[i].initialNumY;
					
				}
				
			}
			
		}
	}
	
	public void drawPlayerGroupHealNumber(Graphics g,int num,Player pl){
		if(pl.gHealNumCount>=0){
			numberToPicture(num);
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null){
					if(a==0){
						if(b!=0){
							g.drawImage(numbers[10],(int)pls[i].healNumX,(int)pls[i].healNumY,null);
							g.drawImage(numbers[b],(int)pls[i].healNumX+12,(int)pls[i].healNumY-1,null);
							g.drawImage(numbers[c],(int)pls[i].healNumX+24,(int)pls[i].healNumY-2,null);
						}
						else{
							g.drawImage(numbers[10],(int)pls[i].healNumX,(int)pls[i].healNumY,null);
							g.drawImage(numbers[c],(int)pls[i].healNumX+12,(int)pls[i].healNumY-1,null);
						}
					}else{
						g.drawImage(numbers[10],(int)pls[i].healNumX,(int)pls[i].healNumY,null);
						g.drawImage(numbers[a],(int)pls[i].healNumX+12,(int)pls[i].healNumY-1,null);
						g.drawImage(numbers[b],(int)pls[i].healNumX+24,(int)pls[i].healNumY-2,null);
						g.drawImage(numbers[c],(int)pls[i].healNumX+36,(int)pls[i].healNumY-3,null);
					}
					pls[i].healNumX+=0.4;
					pls[i].healNumY-=1.0;
				}
				
			}
			pl.gHealNumCount+=1;
		}
		if(pl.gHealNumCount>=pl.gHealNumMaxCount){
			pl.gHealNumCount=-1;
			for(int i=0;i<pls.length;i++){
				if(pls[i]!=null){
					pls[i].healNumX=pls[i].initialNumX;
					pls[i].healNumY=pls[i].initialNumY;
				}
				
			}
			
		}
	}
	//讲数据转变为合适的比例显示出来
		public int dataToFight(int data){
			double a=(double)data/80;
			return (int)(data/a);
			
		}
		
		public int dataToFight(int data,int standard){
			double a=(double)data/standard;
			return (int)(data/a);
		}
	
}
