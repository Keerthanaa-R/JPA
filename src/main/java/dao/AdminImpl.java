package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Admin;
import model.User;
import util.Query;

public class AdminImpl implements IAdmin {

	@Override
	public String adminLoginValidation(Admin admin) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Admin> list = manager.createQuery("select a from Admin a where a.username='" + admin.getUsername()
				+ "'and a.password='" + admin.getPassword() + "'").getResultList();
		if (list.size() > 0) {
			return "Success";
		} else {
			return "failure";
		}
	}

	@Override
	public List<User> viewUser() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<User> list = manager.createQuery(Query.VIEW_USER).getResultList();

		return list;
	}
	@Override
    public String updateAdminPassword(Admin admin) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Admin a1 = (Admin) manager.createQuery("select a from Admin a where a.username='"+ admin.getUsername() + "'").getSingleResult();
        a1.setUsername(a1.getUsername());
        a1.setPassword(admin.getPassword());
        manager.merge(a1);
        manager.getTransaction().commit();
        return "Password Updated";
    }

}
