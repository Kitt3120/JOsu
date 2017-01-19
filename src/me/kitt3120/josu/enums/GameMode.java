package me.kitt3120.josu.enums;

public enum GameMode {
	
	OSU, TAIKO, CTB, MANIA;
	
	public static GameMode byId(int id){
		for(GameMode genre : values()){
			if(genre.ordinal() == id){
				return genre;
			}
		}
		return null;
	}
}
