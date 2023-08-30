package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@Column(name = "account_id")
	private long accountid;
	private String username;
	private String password;

	public long getAccountid() {
		return accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
