package modal;

import java.sql.Date;

public class User {
	private String user_id;
	private String user_passwd;
	private String user_transwd;
	private Date create_time;
	private Date last_time;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public String getUser_transwd() {
		return user_transwd;
	}
	public void setUser_transwd(String user_transwd) {
		this.user_transwd = user_transwd;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_time() {
		return last_time;
	}
	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}

}
