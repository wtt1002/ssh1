package domain;

public class Manager {

	private Integer UID;
	private String managerId;
	private String password;
	private String managerName;
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
}
