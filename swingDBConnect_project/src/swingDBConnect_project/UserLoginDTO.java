package swingDBConnect_project;

import java.sql.Connection;

public class UserLoginDTO {

	private String id;
	private String pw;

	private Connection conn;

	public UserLoginDTO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public String toString() {
		return "UserLoginDTO [id=" + id + ", pw=" + pw + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
