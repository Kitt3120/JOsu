package me.kitt3120.josu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import me.kitt3120.josu.enums.GameMode;
import me.kitt3120.josu.objects.BeatMap;
import me.kitt3120.josu.objects.Score;
import me.kitt3120.josu.objects.User;
import me.kitt3120.josu.utils.StringUtils;

public class JOsu {
	
	private String APIKey;
	
	public JOsu(String APIKey) {
		this.setAPIkey(APIKey);
	}
	
	public boolean isKeyValid() throws MalformedURLException, IOException{
		String response = StringUtils.getStringFromWebsite("https://osu.ppy.sh/api/get_beatmaps?k=" + getAPIkey());
		try {
			JSONObject json = new JSONObject(response);
			if(json.has("error")){
				return false;
			}
			return true;
		} catch (JSONException e) {
			try {
				new JSONArray(response);
				return true;
			} catch (Exception e2) {
				System.out.println("Error testing APIKey: " + e.toString());
				return false;
			}
		}
	}
	
	public BeatMap[] getBeatMaps(String userName) throws JSONException, MalformedURLException, IOException{
		userName = URLEncoder.encode(userName, Charset.forName("UTF-8").name());		
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_beatmaps?");
		sb.append("k=" + getAPIkey());
		sb.append("&u=" + userName);
		sb.append("&type=string");
		
		JSONArray mapArray = new JSONArray(StringUtils.getStringFromWebsite(sb.toString()));
		BeatMap[] toReturn = new BeatMap[mapArray.length()];
		for(int i = 0; i < mapArray.length(); i++){ //Looping using this method because JSONArray does not support iteration
			toReturn[i] = new BeatMap(mapArray.getJSONObject(i));
		}
		return toReturn;
	}
	
	public BeatMap[] getBeatMaps(int userID) throws JSONException, MalformedURLException, IOException{
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_beatmaps?");
		sb.append("k=" + getAPIkey());
		sb.append("&u=" + userID);
		sb.append("&type=id");
		
		JSONArray mapArray = new JSONArray(StringUtils.getStringFromWebsite(sb.toString()));
		BeatMap[] toReturn = new BeatMap[mapArray.length()];
		for(int i = 0; i < mapArray.length(); i++){ //Looping using this method because JSONArray does not support iteration
			toReturn[i] = new BeatMap(mapArray.getJSONObject(i));
		}
		return toReturn;
	}

	public BeatMap[] getBeatMaps(String userName, int beatMapId, int beatMapSetId, GameMode gameMode, String MD5Hash, int amount) throws JSONException, MalformedURLException, IOException {
		if(userName != null) userName = URLEncoder.encode(userName, Charset.forName("UTF-8").name());
		if(amount > 500) amount = 500;
		if(amount < 1) amount = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_beatmaps?");
		sb.append("k=" + getAPIkey());
		if(userName != null) sb.append("&u=" + userName);
		if(beatMapId != 0) sb.append("&b=" + beatMapId);
		if(beatMapSetId != 0) sb.append("&s=" + beatMapSetId);
		if(gameMode != null) sb.append("&m=" + gameMode.ordinal());
		if(MD5Hash != null) sb.append("&h=" + MD5Hash);
		if(amount != 0) sb.append("&limit=" + amount);
		sb.append("&type=string");
		
		JSONArray mapArray = new JSONArray(StringUtils.getStringFromWebsite(sb.toString()));
		BeatMap[] toReturn = new BeatMap[mapArray.length()];
		for(int i = 0; i < mapArray.length(); i++){ //Looping using this method because JSONArray does not support iteration
			toReturn[i] = new BeatMap(mapArray.getJSONObject(i));
		}
		return toReturn;
	}

	public BeatMap[] getBeatMaps(int userID, int beatMapId, int beatMapSetId, GameMode gameMode, String MD5Hash, int amount) throws JSONException, MalformedURLException, IOException {
		if(amount > 500) amount = 500;
		if(amount < 1) amount = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_beatmaps?");
		sb.append("k=" + getAPIkey());
		if(userID != 0) sb.append("&u=" + userID);
		if(beatMapId != 0) sb.append("&b=" + beatMapId);
		if(beatMapSetId != 0) sb.append("&s=" + beatMapSetId);
		if(gameMode != null) sb.append("&m=" + gameMode.ordinal());
		if(MD5Hash != null) sb.append("&h=" + MD5Hash);
		if(amount != 0) sb.append("&limit=" + amount);
		sb.append("&type=id");
		
		JSONArray mapArray = new JSONArray(StringUtils.getStringFromWebsite(sb.toString()));
		BeatMap[] toReturn = new BeatMap[mapArray.length()];
		for(int i = 0; i < mapArray.length(); i++){ //Looping using this method because JSONArray does not support iteration
			toReturn[i] = new BeatMap(mapArray.getJSONObject(i));
		}
		return toReturn;
	}
	
	public User getUser(String userName, GameMode gameMode) throws JSONException, MalformedURLException, IOException{
		userName = URLEncoder.encode(userName, Charset.forName("UTF-8").name());
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_user?");
		sb.append("k=" + getAPIkey());
		sb.append("&u=" + userName);
		sb.append("&type=string");
		sb.append("&m=" + gameMode.ordinal());
		return new User(new JSONArray(StringUtils.getStringFromWebsite(sb.toString())).getJSONObject(0));
	}
	
	public User getUser(int userId, GameMode gameMode) throws JSONException, MalformedURLException, IOException{
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_user?");
		sb.append("k=" + getAPIkey());
		sb.append("&u=" + userId);
		sb.append("&type=id");
		sb.append("&m=" + gameMode.ordinal());		
		return new User(new JSONArray(StringUtils.getStringFromWebsite(sb.toString())).getJSONObject(0));
	}
	
	@Deprecated
	public Score[] getScores(int beatMapID, GameMode gameMode, int amount) throws JSONException, MalformedURLException, IOException{
		if(amount > 100) amount = 100;
		if(amount < 1) amount = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_scores?");
		sb.append("k=" + getAPIkey());
		sb.append("&b=" + beatMapID);
		sb.append("&m=" + gameMode.ordinal());
		sb.append("&limit=" + amount);
		
		JSONArray scoresArray = new JSONArray(StringUtils.getStringFromWebsite(sb.toString()));
		Score[] scores = new Score[scoresArray.length()];
		for(int i = 0; i < scoresArray.length(); i++){
			scores[i] = new Score(scoresArray.getJSONObject(i));
		}
		return scores;
	}

	@Deprecated
	public Score[] getScores(int beatMapID, GameMode gameMode, int amount, String userName) throws JSONException, MalformedURLException, IOException{
		if(amount > 100) amount = 100;
		if(amount < 1) amount = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_scores?");
		sb.append("k=" + getAPIkey());
		sb.append("&b=" + beatMapID);
		sb.append("&m=" + gameMode.ordinal());
		sb.append("&limit=" + amount);
		sb.append("&u=" + userName);
		sb.append("&type=string");
		
		JSONArray scoresArray = new JSONArray(StringUtils.getStringFromWebsite(sb.toString()));
		Score[] scores = new Score[scoresArray.length()];
		for(int i = 0; i < scoresArray.length(); i++){
			scores[i] = new Score(scoresArray.getJSONObject(i));
		}
		return scores;
	}

	@Deprecated
	public Score[] getScores(int beatMapID, GameMode gameMode, int amount, int userID) throws JSONException, MalformedURLException, IOException{
		if(amount > 100) amount = 100;
		if(amount < 1) amount = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("https://osu.ppy.sh/api/get_scores?");
		sb.append("k=" + getAPIkey());
		sb.append("&b=" + beatMapID);
		sb.append("&m=" + gameMode.ordinal());
		sb.append("&limit=" + amount);
		sb.append("&u=" + userID);
		sb.append("&type=id");
		
		JSONArray scoresArray = new JSONArray(StringUtils.getStringFromWebsite(sb.toString()));
		Score[] scores = new Score[scoresArray.length()];
		for(int i = 0; i < scoresArray.length(); i++){
			scores[i] = new Score(scoresArray.getJSONObject(i));
		}
		return scores;
	}

	public String getAPIkey() {
		return APIKey;
	}

	public void setAPIkey(String APIKey) {
		this.APIKey = APIKey;
	}

}
