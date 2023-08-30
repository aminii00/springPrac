package sec01.ex01;

import java.util.Date;

public class StudentAllVO {

	private String id;
	private String username;
	private String univ;
	private String birth;
	private String email;
	
	StudentAllVO(String id, String username, String univ, String birth, String email){
		this.id= id;
		this.username =username;
		this.univ = univ;
		this.birth = birth;
		this.email = email;
	}
	
	StudentAllVO(String username, String univ, String birth, String email){
		this.username =username;
		this.univ = univ;
		this.birth = birth;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
