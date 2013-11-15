
public class Course {
	private String courseName;
	private String moduleCode;
	private String alias;

	public Course(String courseName, String moduleCode, String alias) {
		this.courseName = courseName;
		this.moduleCode = moduleCode;
		this.alias = alias;
	}

	public String getCoursename() {
		return courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}