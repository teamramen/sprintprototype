package entity;

public class Attendance {
	private boolean present;
	
	public Attendance(boolean present) {
		this.present = present;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}
}