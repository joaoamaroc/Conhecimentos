package spring;

public enum Level{
	N("Null"), K("Kid"), B("Basic"), I("Intermediary"), A("Advanced"), S("Senior");
	
    private final String displayName;

    private Level(String displayName) {
        this.displayName = displayName;
    }
    

    public String getDisplayName() {
		return displayName;
	}


	public String toString() {
        return displayName;
    }
}
