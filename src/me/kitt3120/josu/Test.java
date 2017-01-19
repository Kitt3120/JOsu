package me.kitt3120.josu;

import java.io.IOException;

import org.json.JSONException;

import me.kitt3120.josu.enums.GameMode;
import me.kitt3120.josu.objects.BeatMap;
import me.kitt3120.josu.objects.User;

public class Test {

	public static void main(String[] args) {
		JOsu api = new JOsu("baef7e484cc08a8abb7b7f6eda369769590bb575");
		try {
			if(!api.isKeyValid()){
				System.out.println("Key is not valid");
				return;
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
			return;
		}
		try {
			User kitt = api.getUser("[ Kitt3120 ]", GameMode.OSU);
			BeatMap[] maps = api.getBeatMaps((int) kitt.getUserID());
			for(BeatMap map : maps){
				System.out.println("Eine Map von Kitt: " + map.getArtist() + " - " + map.getTitle() + "[Status:" + map.getBeatMapState().name() + "]");
			}
		} catch (JSONException | IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}

}
