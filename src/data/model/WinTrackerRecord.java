package data.model;

public class WinTrackerRecord {

	private String name;
	private int winCount;

	public WinTrackerRecord() {
	}
	
	public WinTrackerRecord(String name, int winCount) {
		this.name = name;
		this.winCount = winCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWinCount() {
		return winCount;
	}
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}
	@Override
	public String toString() {
		return name + " " + winCount;
	}
	
}

