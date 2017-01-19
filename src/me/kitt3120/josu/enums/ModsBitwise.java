package me.kitt3120.josu.enums;

import java.util.ArrayList;
import java.util.List;

public class ModsBitwise {

	public static int None(){
		return 0;
	}
	
	public static int NoFail(){
		return 1;
	}
	
	public static int Easy(){
		return 2;
	}
	
	public static int NoVideo(){
		return 4;
	}
	
	public static int Hidden(){
		return 8;
	}
	
	public static int HardRock(){
		return 16;
	}
	
	public static int SuddenDeath(){
		return 32;
	}
	
	public static int DoubleTime(){
		return 64;
	}
	
	public static int Relax(){
		return 128;
	}
	
	public static int HalfTime(){
		return 256;
	}
	
	public static int Nightcore(){
		return 512; // Only set along with DoubleTime. i.e: NC only gives 576
	}
	
	public static int Flashlight(){
		return 1024;
	}
	
	public static int AutoPlay(){
		return 2048;
	}
	
	public static int SpunOut(){
		return 4096;
	}
	
	public static int Relax2(){ // Autopilot?
		return 8192;
	}
	
	public static int Perfect(){
		return 16384;
	}
	
	public static int Key4(){
		return 32768;
	}
	
	public static int Key5(){
		return 65536;
	}
	
	public static int Key6(){
		return 131072;
	}
	
	public static int Key7(){
		return 262144;
	}
	
	public static int Key8(){
		return 524288;
	}
	
	public static int KeyMod(){
		return 1015808;
	}

	public static int FadeIn(){
		return 1048576;
	}
	
	public static int Random(){
		return 2097152;
	}

	public static int LastMod(){
		return 4194304;
	}
	
	public static int Key9(){
		return 16777216;
	}
	
	public static int Key10(){
		return 33554432;
	}
	
	public static int Key1(){
		return 67108864;
	}
	
	public static int Key3(){
		return 134217728;
	}
	
	public static int Key2(){
		return 268435456;
	}
	
	public static int[] getAllModsAsArray(){
		return new int[]{None(), NoFail(), Easy(), NoVideo(), Hidden(), HardRock(), SuddenDeath(), DoubleTime(), Relax(), HalfTime(), Nightcore(), Flashlight(), AutoPlay(), SpunOut(), Relax2(), Perfect(), Key4(), Key5(), Key6(), Key7(), Key8(), FadeIn(), Random(), LastMod(), Key9(), Key10(), Key1(), Key3(), Key2()};
	}
	
	public static Mod getMod(int bit){
		if(bit == 0){
			return Mod.NONE;
		}
		if(bit == 1){
			return Mod.NOFAIL;
		}
		if(bit == 2){
			return Mod.EASY;
		}
		if(bit == 4){
			return Mod.NOVIDEO;
		}
		if(bit == 8){
			return Mod.HIDDEN;
		}
		if(bit == 16){
			return Mod.HARDROCK;
		}
		if(bit == 32){
			return Mod.SUDDENDEATH;
		}
		if(bit == 64){
			return Mod.DOUBLETIME;
		}
		if(bit == 128){
			return Mod.RELAX;
		}
		if(bit == 256){
			return Mod.HALFTIME;
		}
		if(bit == 512){
			return Mod.NIGHTCORE;
		}
		if(bit == 1024){
			return Mod.FLASHLIGHT;
		}
		if(bit == 2048){
			return Mod.AUTOPLAY;
		}
		if(bit == 4096){
			return Mod.SPUNOUT;
		}
		if(bit == 8192){
			return Mod.RELAX2;
		}
		if(bit == 16384){
			return Mod.PERFECT;
		}
		if(bit == 32768){
			return Mod.KEY4;
		}
		if(bit == 65536){
			return Mod.KEY5;
		}
		if(bit == 131072){
			return Mod.KEY6;
		}
		if(bit == 262144){
			return Mod.KEY8;
		}
		if(bit == 524288){
			return Mod.KEY9;
		}
		if(bit == 1015808){
			return Mod.KEYMOD;
		}
		if(bit == 1048576){
			return Mod.FADEIN;
		}
		if(bit == 2097152){
			return Mod.RANDOM;
		}
		if(bit == 4194304){
			return Mod.LASTMOD;
		}
		if(bit == 16777216){
			return Mod.KEY9;
		}
		if(bit == 33554432){
			return Mod.KEY10;
		}
		if(bit == 67108864){
			return Mod.KEY1;
		}
		if(bit == 134217728){
			return Mod.KEY3;
		}
		if(bit == 268435456){
			return Mod.KEY2;
		}
		
		return Mod.NONE;
	}
	
	public static List<long[]> combinations(int n, int[] arr) {
		List<long[]> list = new ArrayList<>();
	    // Calculate the number of arrays we should create
	    long numArrays = (long)Math.pow(arr.length, n);
	    // Create each array
	    for(long i = 0; i < numArrays; i++) {
	        list.add(new long[n]);
	    }
	    // Fill up the arrays
	    for(int j = 0; j < n; j++) {
	        // This is the period with which this position changes, i.e.
	        // a period of 5 means the value changes every 5th array
	        int period = (int) Math.pow(arr.length, n - j - 1);
	        for(int i = 0; i < numArrays; i++) {
	            long[] current = list.get(i);
	            // Get the correct item and set it
	            int index = i / period % arr.length;
	            current[j] = arr[index];
	    		System.out.println("-" + arr[index]);
	        }
	    }
	    return list;
	}
	
	public static Mod[] getMods(int modsBit){
		long[] selectedModsBits = new long[0];
		System.out.println("Calculating...");
		for(int i = 0; i < 30; i++){
			System.out.println("-- Round " + i + " --");
			System.out.println("Calculating combinations...");
			List<long[]> combs = combinations(i, getAllModsAsArray());
			for(long[] in : combs){
				int addition = 0;
				for(int inteCount = 0; inteCount < in.length; i++){
					addition += in[inteCount];
				}
				if(addition == modsBit){
					selectedModsBits = in;
					System.out.println("Found mods : " + in.toString());
				}
			}
		}
		System.out.println("Done");
		
		Mod[] usedMods = new Mod[selectedModsBits.length];
		for(int i = 0; i < selectedModsBits.length; i++){
			usedMods[i] = getMod((int) selectedModsBits[i]);
		}
		return usedMods;
	}

}
