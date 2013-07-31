package FightSystem;

import java.util.ArrayList;

public class BossInfo {
	
	static ArrayList<Integer> hps=new ArrayList<Integer>();
	static ArrayList<Integer> mps=new ArrayList<Integer>();
	static ArrayList<Integer> mpkills=new ArrayList<Integer>();
	static ArrayList<Integer> atts=new ArrayList<Integer>();
	static ArrayList<Integer> matts=new ArrayList<Integer>();
	static ArrayList<Double> speeds=new ArrayList<Double>(); 
	
	public BossInfo(){
		
	}
	
	public static void initialize(){
		hps.add(500);
		hps.add(1000);
		hps.add(3000);
		hps.add(10000);
		hps.add(5000);
		hps.add(8000);
		hps.add(5000);
		hps.add(10000);
		hps.add(1000);
		hps.add(1000);
		hps.add(1000);
		atts.add(20);
		atts.add(30);
		atts.add(50);
		atts.add(200);
		atts.add(200);
		atts.add(200);
		atts.add(100);
		atts.add(200);
		atts.add(50);
		atts.add(50);
		atts.add(50);
		matts.add(20);
		matts.add(30);
		matts.add(50);
		matts.add(200);
		matts.add(200);
		matts.add(200);
		matts.add(100);
		matts.add(200);
		matts.add(50);
		matts.add(50);
		matts.add(50);
		mps.add(100);
		mps.add(100);
		mps.add(150);
		mps.add(200);
		mps.add(200);
		mps.add(250);
		mps.add(300);
		mps.add(300);
		mps.add(200);
		mps.add(150);
		mps.add(150);
		mpkills.add(10);
		mpkills.add(10);
		mpkills.add(15);
		mpkills.add(15);
		mpkills.add(20);
		mpkills.add(25);
		mpkills.add(30);
		mpkills.add(30);
		mpkills.add(20);
		mpkills.add(20);
		mpkills.add(20);
		speeds.add(20.0);
		speeds.add(20.0);
		speeds.add(20.0);
		speeds.add(25.0);
		speeds.add(25.0);
		speeds.add(25.0);
		speeds.add(30.0);
		speeds.add(30.0);
		speeds.add(20.0);
		speeds.add(20.0);
		speeds.add(20.0);
	}

}
