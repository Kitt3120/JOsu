package me.kitt3120.josu.objects;

import org.json.JSONObject;

import me.kitt3120.josu.enums.BeatMapGenre;
import me.kitt3120.josu.enums.BeatMapState;
import me.kitt3120.josu.enums.GameMode;

public class BeatMap {
	
	private BeatMapState beatMapState;
	private BeatMapGenre beatMapGenre;
	private GameMode gameMode;
	private String appovedDate, lastUpdate, artist, creator, title, difficulty, MD5;
	private String[] tags;
	private int beatMapID, beatMapSetID, hitLength, totalLength, favoriteCount, playCount, passCount, maxCombo;
	private double stars, BPM, CS, OD, AR, HP;
	
	public BeatMap(JSONObject map) {
		if(!map.isNull("approved")){
			beatMapState = BeatMapState.byId(Integer.parseInt(map.getString("approved")));
		} else {
			beatMapState = BeatMapState.PENDING;
		}
		if(!map.isNull("genre_id")) beatMapGenre = BeatMapGenre.byId(Integer.parseInt(map.getString("genre_id")));
		if(!map.isNull("mode")) gameMode = GameMode.byId(Integer.parseInt(map.getString("mode")));
		
		if(!map.isNull("approved_date")) appovedDate = map.getString("approved_date");
		if(!map.isNull("last_update")) lastUpdate = map.getString("last_update");
		if(!map.isNull("artist")) artist = map.getString("artist");
		if(!map.isNull("creator")) creator = map.getString("creator");
		if(!map.isNull("title")) title = map.getString("title");
		if(!map.isNull("version")) difficulty = map.getString("version");
		if(!map.isNull("file_md5")) MD5 = map.getString("file_md5");
		
		if(!map.isNull("tags")) tags = map.getString("tags").split(" ");

		if(!map.isNull("beatmap_id")) beatMapID = Integer.parseInt(map.getString("beatmap_id"));
		if(!map.isNull("beatmapset_id")) beatMapSetID = Integer.parseInt(map.getString("beatmapset_id"));
		if(!map.isNull("bpm")) BPM = Double.parseDouble(map.getString("bpm"));
		if(!map.isNull("diff_size")) CS = Double.parseDouble(map.getString("diff_size"));
		if(!map.isNull("diff_overall")) OD = Double.parseDouble(map.getString("diff_overall"));
		if(!map.isNull("diff_approach")) AR = Double.parseDouble(map.getString("diff_approach"));
		if(!map.isNull("diff_drain")) HP = Double.parseDouble(map.getString("diff_drain"));
		if(!map.isNull("hit_length")) hitLength = Integer.parseInt(map.getString("hit_length"));
		if(!map.isNull("total_length")) totalLength = Integer.parseInt(map.getString("total_length"));
		if(!map.isNull("favourite_count")) favoriteCount = Integer.parseInt(map.getString("favourite_count"));
		if(!map.isNull("playcount")) playCount = Integer.parseInt(map.getString("playcount"));
		if(!map.isNull("passcount")) passCount = Integer.parseInt(map.getString("passcount"));
		if(!map.isNull("max_combo")) maxCombo = Integer.parseInt(map.getString("max_combo"));
		
		if(!map.isNull("difficultyrating")) stars = Double.parseDouble(map.getString("difficultyrating"));
		
	}

	public BeatMapState getBeatMapState() {
		return beatMapState;
	}

	public BeatMapGenre getBeatMapGenre() {
		return beatMapGenre;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public String getAppovedDate() {
		return appovedDate;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public String getArtist() {
		return artist;
	}

	public String getCreator() {
		return creator;
	}

	public String getTitle() {
		return title;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public String getMD5() {
		return MD5;
	}

	public String[] getTags() {
		return tags;
	}

	public int getBeatMapID() {
		return beatMapID;
	}

	public int getBeatMapSetID() {
		return beatMapSetID;
	}

	public double getBPM() {
		return BPM;
	}

	public double getCS() {
		return CS;
	}

	public double getOD() {
		return OD;
	}

	public double getAR() {
		return AR;
	}

	public double getHP() {
		return HP;
	}

	public int getHitLength() {
		return hitLength;
	}

	public int getTotalLength() {
		return totalLength;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public int getPlayCount() {
		return playCount;
	}

	public int getPassCount() {
		return passCount;
	}

	public int getMaxCombo() {
		return maxCombo;
	}

	public double getStars() {
		return stars;
	}

}
