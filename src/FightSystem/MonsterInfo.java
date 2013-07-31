package FightSystem;

import java.util.ArrayList;

public class MonsterInfo {
	
	//保存不同场景的怪物信息
	static ArrayList<Integer> hps=new ArrayList<Integer>();
	static ArrayList<Integer> mps=new ArrayList<Integer>();
	static ArrayList<Integer> mpkills=new ArrayList<Integer>();
	static ArrayList<Integer> atts=new ArrayList<Integer>();
	static ArrayList<Integer> matts=new ArrayList<Integer>();
	static ArrayList<Double> speeds=new ArrayList<Double>(); 
	
	
	public MonsterInfo(){
		
	}
	
//	public static void load(Monster mo,int i){
//		mo.setAtt(atts.get(i));
//		mo.setMatt(matts.get(i));
//		mo.setSpeed(speeds.get(i));
//	}
	
	public static void initialize(){
		hps.add(100);
		hps.add(100);
		hps.add(300);
		hps.add(300);
		hps.add(500);
		hps.add(500);
		hps.add(500);
		hps.add(10000);
		hps.add(200);
		hps.add(300);
		hps.add(300);
		hps.add(300);
		mps.add(30);
		mps.add(30);
		mps.add(30);
		mps.add(30);
		mps.add(50);
		mps.add(50);
		mps.add(50);
		mps.add(70);
		mps.add(70);
		mps.add(70);
		mps.add(70);
		mps.add(70);
		atts.add(5);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		atts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		matts.add(10);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		speeds.add(10.0);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(10);
	}

}
