package me.kitt3120.josu.objects;

import org.json.JSONObject;

import me.kitt3120.josu.enums.Mod;
import me.kitt3120.josu.enums.ModsBitwise;

public class Score {
	
	private int score, count300, count100, count50, countMiss, countKatu, countGeki, maxCombo, userID;
	private float pp;
	private boolean perfect;
	private Mod[] enabledMods;
	private String userName, date, rank;
	
	public Score(JSONObject score) {
		this.score = Integer.parseInt(score.getString("score"));
		count300 = Integer.parseInt(score.getString("count300"));
		count100 = Integer.parseInt(score.getString("count100"));
		count50 = Integer.parseInt(score.getString("count50"));
		countMiss = Integer.parseInt(score.getString("countmiss"));
		countKatu = Integer.parseInt(score.getString("countkatu"));
		countGeki = Integer.parseInt(score.getString("countgeki"));
		maxCombo = Integer.parseInt(score.getString("maxcombo"));
		userID = Integer.parseInt(score.getString("user_id"));
		
		userName = score.getString("username");
		date = score.getString("date");
		rank = score.getString("rank");
		
		pp = Float.parseFloat(score.getString("pp"));
		
		perfect = (Integer.parseInt(score.getString("perfect")) == 1);
		
		enabledMods = ModsBitwise.getMods(Integer.parseInt(score.getString("enabled_mods")));
	}

	public int getScore() {
		return score;
	}

	public int getCount300() {
		return count300;
	}

	public int getCount100() {
		return count100;
	}

	public int getCount50() {
		return count50;
	}

	public int getCountMiss() {
		return countMiss;
	}

	public int getCountKatu() {
		return countKatu;
	}

	public int getCountGeki() {
		return countGeki;
	}

	public int getMaxCombo() {
		return maxCombo;
	}

	public int getUserID() {
		return userID;
	}

	public float getPp() {
		return pp;
	}

	public boolean isPerfect() {
		return perfect;
	}

	public Mod[] getEnabledMods() {
		return enabledMods;
	}

	public String getUserName() {
		return userName;
	}

	public String getDate() {
		return date;
	}

	public String getRank() {
		return rank;
	}

}
