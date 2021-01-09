package dao;

import java.util.List;

import task01.User;

public interface Dao {
	public boolean add(User user);
	public void delete(int id);
	public List<User> findAll(int i,String name,String address,String email);
	public boolean update(User user);
	public User findUser(int id);
	public void update2(User user);
	
	public boolean findManage(String managename,String managenamepassword);
	
	public int getDatasNumber(String name,String address,String email);
	
	public void deleteSelectedDatas(String ids);

}
