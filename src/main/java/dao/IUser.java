package dao;

import java.util.List;

import model.Account;
import model.Admin;
import model.User;

public interface IUser {
	public String userLoginValidation(User user);

	public String deleted(long accountid);

	public List<Account> viewAccountDetails(String username);

	// public String updateAccount(Account account);
	public String updateUserPassword(User user);

}
