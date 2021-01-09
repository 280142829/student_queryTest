package service.serviceimpl;

import java.util.List;

import dao.Dao;
import dao.daoimpl.Daoimpl;
import service.ListService;

import task01.User;

public class ListServiceimpl implements ListService{
	
	@Override
	public boolean add(User user) {
		Dao add = new Daoimpl();
		boolean flag = add.add(user);
		return flag;
	}
	@Override
	public List<User> findAll(int i,String name,String adress,String email){
		Dao dfa = new Daoimpl();
		List list = dfa.findAll(i,name,adress,email);
	
		return list;
	}
	@Override
	public void delete(int id) {
		Dao delete = new Daoimpl();
		delete.delete(id);
	}
	@Override
	public User findUser(int id) {
		Dao find = new Daoimpl();
		return find.findUser(id);
	}
	@Override
	public void update2(User user) {
		Dao update = new Daoimpl();
		update.update2(user);
		
	}
	@Override
	public boolean findManage(String managename, String managenamepassword) {
		boolean flag=false;
		Dao findm = new Daoimpl();
		flag = findm.findManage(managename, managenamepassword);
		return flag;

	}
	@Override
	public int getDatasNumber(String name,String address,String email) {
		Dao datasNumber = new Daoimpl();
		int count = datasNumber.getDatasNumber(name, address, email);
		return count;
	}
	@Override
	public void deleteSelectedDatas(String ids) {
		Dao deleteSelected = new Daoimpl();
		deleteSelected.deleteSelectedDatas(ids);
		
	}
	
	
}
