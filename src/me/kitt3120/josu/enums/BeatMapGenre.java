package me.kitt3120.josu.enums;

public enum BeatMapGenre {
	
	ANY, UNSPECIFIED, VIDEO_GAME, ANIME, ROCK, POP, OTHER, NOVELTY, PLACEHOLDER, HIP_HOP, ELECTRONIC;
	
	/* 
	 * Note the placeholder. This is to match the enums to the right id's osu gives them. Number 8 is not used. Number 7 is Novelty, next comes number 9. 8 is skipped. 
	 * From osu!API's github : // 0 = any, 1 = unspecified, 2 = video game, 3 = anime, 4 = rock, 5 = pop, 6 = other, 7 = novelty, 9 = hip hop, 10 = electronic (note that there's no 8)
	 */
	
	public static BeatMapGenre byId(int id){
		for(BeatMapGenre genre : values()){
			if(genre.ordinal() == id){
				return genre;
			}
		}
		return null;
	}

}
