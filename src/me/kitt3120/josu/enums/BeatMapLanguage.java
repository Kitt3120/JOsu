package me.kitt3120.josu.enums;

public enum BeatMapLanguage {
	
	ANY, OTHER, ENGLISH, JAPANESE, CHINESE, INSTRUMENTAL, KOREAN, FRENCH, GERMAN, SWEDISH, SPANISH, ITALIAN;
	
	public static BeatMapLanguage byId(int id){
		for(BeatMapLanguage genre : values()){
			if(genre.ordinal() == id){
				return genre;
			}
		}
		return null;
	}
	
}
