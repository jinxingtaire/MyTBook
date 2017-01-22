package jim.mytbook.entity;

public class UserInfo {
	private int code;
	private User user;
	private String token;
	public UserInfo(int code, User user, String token) {
		super();
		this.code = code;
		this.user = user;
		this.token = token;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}
