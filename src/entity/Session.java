package entity;

public class Session {
	
	private String sessionName;
	private String sessionType; //lab, tutorial, lecture
	private boolean present;
	
	public Session(String sessionName, String sessionType, boolean present)
	{
		this.sessionName = sessionName;
		this.sessionType = sessionType;
		this.present = present;
	}
	
	public String getSessionName()
	{
		return this.sessionName;
	}
	
	public void setSessionName(String sessionName)
	{
		this.sessionName = sessionName;
	}
	
	public String getSessionType()
	{
		return this.sessionType;
	}
	
	public void setSessionType(String sessionType)
	{
		this.sessionType = sessionType;
	}
	
	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}
}
