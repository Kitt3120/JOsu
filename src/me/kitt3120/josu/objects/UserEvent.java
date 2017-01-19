package me.kitt3120.josu.objects;

import org.json.JSONObject;

public class UserEvent {
	
	private String displayHtml, date;
	private long beatMapID, beatMapSetID, epicfactor;
	
	public UserEvent(JSONObject event) {
		if(!event.isNull("display_html")) displayHtml = event.getString("display_html");
		if(!event.isNull("date")) date = event.getString("date");
		if(!event.isNull("beatmap_id")) beatMapID = Long.parseLong(event.getString("beatmap_id"));
		if(!event.isNull("beatmapset_id")) beatMapSetID = Long.parseLong(event.getString("beatmapset_id"));
		if(!event.isNull("epicfactor")) epicfactor = Long.parseLong(event.getString("epicfactor"));
	}

	public String getDisplayHtml() {
		return displayHtml;
	}

	public String getDate() {
		return date;
	}

	public long getBeatMapID() {
		return beatMapID;
	}

	public long getBeatMapSetID() {
		return beatMapSetID;
	}

	public long getEpicfactor() {
		return epicfactor;
	}

}
