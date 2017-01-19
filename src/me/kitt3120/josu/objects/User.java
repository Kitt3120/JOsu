package me.kitt3120.josu.objects;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {
	
	private long userID, count300, count100, count50, playCount, rankedScore, totalScore, rank, countryRank, pp, countSS, countS, countA;
	private double level, accuracy;
	private String userName, country;
	private UserEvent[] userEvents;

	public User(JSONObject user) {
		if(!user.isNull("username")) userName = user.getString("username");
		if(!user.isNull("country")) country = user.getString("country");

		if(!user.isNull("user_id")) userID = Long.parseLong(user.getString("user_id"));
		if(!user.isNull("count300")) count300 = Long.parseLong(user.getString("count300"));
		if(!user.isNull("count100")) count100 = Long.parseLong(user.getString("count100"));
		if(!user.isNull("count50")) count50 = Long.parseLong(user.getString("count50"));
		if(!user.isNull("playcount")) playCount = Long.parseLong(user.getString("playcount"));
		if(!user.isNull("ranked_score")) rankedScore = Long.parseLong(user.getString("ranked_score"));
		if(!user.isNull("total_score")) totalScore = Long.parseLong(user.getString("total_score"));
		if(!user.isNull("pp_rank")) rank = Long.parseLong(user.getString("pp_rank"));
		if(!user.isNull("pp_country_rank")) countryRank = Long.parseLong(user.getString("pp_country_rank"));
		try {
			if(!user.isNull("pp_raw")) pp = Long.parseLong(user.getString("pp_raw"));
		} catch (Exception e) {
			if(!user.isNull("pp_raw")) pp = (long)Double.parseDouble(user.getString("pp_raw"));
		}
		if(!user.isNull("count_rank_ss")) countSS = Integer.parseInt(user.getString("count_rank_ss"));
		if(!user.isNull("count_rank_s")) countS = Integer.parseInt(user.getString("count_rank_s"));
		if(!user.isNull("count_rank_a")) countA = Integer.parseInt(user.getString("count_rank_a"));

		if(!user.isNull("level")) level = Double.parseDouble(user.getString("level"));
		if(!user.isNull("accuracy")) accuracy = Double.parseDouble(user.getString("accuracy"));
		
		if(!user.isNull("events")){
			JSONArray events = user.getJSONArray("events");
			userEvents = new UserEvent[events.length()];
			for(int i = 0; i < events.length(); i++){
				userEvents[i] = new UserEvent(events.getJSONObject(i));
			}
		}
		
	}

	public long getUserID() {
		return userID;
	}

	public long getCount300() {
		return count300;
	}

	public long getCount100() {
		return count100;
	}

	public long getCount50() {
		return count50;
	}

	public long getPlayCount() {
		return playCount;
	}

	public long getRankedScore() {
		return rankedScore;
	}

	public long getTotalScore() {
		return totalScore;
	}

	public long getRank() {
		return rank;
	}

	public long getCountryRank() {
		return countryRank;
	}

	public long getPp() {
		return pp;
	}

	public long getCountSS() {
		return countSS;
	}

	public long getCountS() {
		return countS;
	}

	public long getCountA() {
		return countA;
	}

	public double getLevel() {
		return level;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public String getUserName() {
		return userName;
	}

	public String getCountry() {
		return country;
	}

	public UserEvent[] getUserEvents() {
		return userEvents;
	}
}
