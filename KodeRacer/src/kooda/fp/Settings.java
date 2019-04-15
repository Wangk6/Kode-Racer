package kooda.fp;

public class Settings{

	static int fullScreen;
	int volume;
	
	public static int getFullScreen() {
		return fullScreen;
	}

	public static void setFullScreen(int value) {
		fullScreen = value;
		System.out.println("getFullSreen" + fullScreen);
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	
}
