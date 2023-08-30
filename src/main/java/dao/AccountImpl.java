package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Account;
import util.Query;

public class AccountImpl implements IAccount {

	@Override
	public List<Account> viewAccount() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Account> list = manager.createQuery(Query.VIEW_ACCOUNT).getResultList();
		return list;
	}

	@Override
	public String delete(long accountid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Account a = manager.getReference(Account.class, accountid);
		manager.remove(a);
		manager.getTransaction().commit();
		return accountid + "Removed From Account";

	}

	@Override
	public String update(Account account) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(account);
		manager.getTransaction().commit();
		return account.getAccountid() + "Updated";
	}

	@Override
	public String add(Account account) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(account);
		manager.getTransaction().commit();
		return account.getAccountid() + "Added";

	}

//	@Override
//	public List<Account> viewAccountDetails(String username) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
//		EntityManager manager = factory.createEntityManager();
//		manager.getTransaction().begin();
//		@SuppressWarnings("unchecked")
//		List<Account> list = manager.createQuery("select u from User u where u.username='" + username + "'")
//				.getResultList();
//
//		return list;
//	}

}