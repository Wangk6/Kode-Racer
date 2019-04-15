package kooda.fp;

public class Settings extends Driver{

	int fullScreen;
	int volume;
	
	public Settings() {
		fullScreen = 0;
		volume = 0;
	}
	
	public int getFullScreen() {
		return fullScreen;
	}

	public void setFullScreen(int fullScreen) {
		this.fullScreen = fullScreen;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	
}
