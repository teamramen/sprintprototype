public class Attendance {
	private boolean present;
	private int session;

	public Attendance(boolean present, int session) {
		this.present = present;
		this.session = session;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

}