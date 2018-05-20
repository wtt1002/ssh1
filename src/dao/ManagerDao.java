package dao;

import domain.Manager;

public interface ManagerDao {

	public void save(Manager manager);
	public Manager managerLogin(String managerId, String password);

}
