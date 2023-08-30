package dao;

import java.util.List;

import model.Admin;
import model.User;

public interface IAdmin {
	public String adminLoginValidation(Admin admin);

	public List<User> viewUser();

	public String updateAdminPassword(Admin admin);

}
