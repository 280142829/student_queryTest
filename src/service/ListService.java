package service;

import java.util.List;

import task01.User;

public interface ListService {
	public boolean add(User user);
	public List<User> findAll(int i,String name,String adress,String email);
	public void delete(int id);
	public User findUser(int id);
	public void update2(User user);
	
	public boolean findManage(String managename,String managenamepassword);
	public int getDatasNumber(String name,String address,String email);
	
	public void deleteSelectedDatas(String ids);
}
