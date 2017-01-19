package me.kitt3120.josu.enums;

public enum BeatMapState {
	
	GRAVEYARD, WIP, PENDING, RANKED, APPROVED, QUALIFIED, LOVED;
	
	public static BeatMapState byId(int id){
		for(BeatMapState genre : values()){
			if((genre.ordinal()-2) == id){
				return genre;
			}
		}
		return null;
	}
}
