package task01;

public class Manage {
	private int id;
	private String managename;
	private String managepassword;
	
	
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manage(int id, String managename, String managepassword) {
		super();
		this.id = id;
		this.managename = managename;
		this.managepassword = managepassword;
	}

	public Manage(String managename, String managepassword) {
		super();
		this.managename = managename;
		this.managepassword = managepassword;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManagename() {
		return managename;
	}

	public void setManagename(String managename) {
		this.managename = managename;
	}

	public String getManagepassword() {
		return managepassword;
	}

	public void setManagepassword(String managepassword) {
		this.managepassword = managepassword;
	}

	@Override
	public String toString() {
		return "Manage [id=" + id + ", managename=" + managename + ", managepassword=" + managepassword + "]";
	}
	
	

}
