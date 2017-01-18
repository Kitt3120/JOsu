package me.kitt3120.josu;

public class JOsu {
	
	private String APIkey;
	
	public JOsu(String APIKey) {
		this.setAPIkey(APIKey);
	}

	public String getAPIkey() {
		return APIkey;
	}

	public void setAPIkey(String aPIkey) {
		APIkey = aPIkey;
	}

}
