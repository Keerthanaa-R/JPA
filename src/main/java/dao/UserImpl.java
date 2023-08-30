package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Account;
import model.Admin;
import model.User;

public class UserImpl implements IUser {

	@Override
	public String userLoginValidation(User user) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Admin> list = manager.createQuery("select a from User a where a.username='" + user.getUsername()
				+ "'and a.password='" + user.getPassword() + "'").getResultList();
		if (list.size() > 0) {
			return "Success";
		} else {
			return "failure";
		}
	}

	@Override
	public String deleted(long accountid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		User u = manager.getReference(User.class, accountid);
		manager.remove(u);
		manager.getTransaction().commit();
		return accountid + "Removed From Account";

	}

	@Override
	public List<Account> viewAccountDetails(String username) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Account> list = manager.createQuery("select a from Account a where a.username='" + username + "'")
				.getResultList();

		return list;
	}

//	@Override
//	public String updateAccount(Account account) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
//		EntityManager manager = factory.createEntityManager();
//		manager.getTransaction().begin();
//		manager.merge(account);
//		manager.getTransaction().commit();
//		return account.getAccountid() + "Updated Successfully";
//
//	}
	@Override
	public String updateUserPassword(User user) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		User u1 = (User) manager.createQuery("select u from User u where u.username='" + user.getUsername() + "'")
				.getSingleResult();
		u1.setUsername(u1.getUsername());
		u1.setPassword(user.getPassword());
		manager.merge(u1);
		manager.getTransaction().commit();
		return "Password Updated";
	}

}
