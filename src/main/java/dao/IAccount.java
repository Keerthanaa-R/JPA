package dao;

import java.util.List;

import model.Account;

public interface IAccount {
	public List<Account> viewAccount();

	public String delete(long accountid);

	public String update(Account account);

	public String add(Account account);

	//public List<Account> viewAccountDetails(String username);

}
