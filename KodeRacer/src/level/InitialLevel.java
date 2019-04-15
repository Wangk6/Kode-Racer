package level;

abstract class InitialLevel {
	private int windowWidth;
	private int windowHeight;
	private String levelName;
	
	//Window Width
	abstract int getWindowWidth();
	abstract void setWindowWidth(int windowWidth);
	
	//Window Height
	abstract int getWindowHeight();
	abstract void setWindowHeight(int windowHeight);
	
	//Level Name
	abstract String getLevelName();
	abstract void setLevelName(String levelName);
}
