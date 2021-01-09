package dao.daoimpl;



import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.Dao;
import task01.Manage;
import task01.User;
import util.Util;

public class Daoimpl implements Dao{
	

	@Override
	public boolean add(User user) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		String sql = "INSERT INTO USER (name,gender,age,address,qq,email)VALUES(?,?,?,?,?,?)";
		
		int count = jt.update(sql, user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
		if(count>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void delete(int id) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		//String sql2 = "DELETE FROM user WHERE id=2 OR id=3";
		String sql = "delete from user where id=?";
		jt.update(sql,id);
		
		
	}

	@Override
	public List<User> findAll(int i,String name,String address,String email) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		int index = 3*(i-1);//从0 开始，

		String sql1 = "SELECT*FROM USER ";
		String sql2 = "WHERE NAME LIKE ? ";
		String sql3 = "AND address LIKE ? ";
		String sql4 = "AND email LIKE ? ";
		String sqlend = "LIMIT ?,3";
		String sql = sql1+sql2+sql3+sql4+sqlend;
		System.out.println(sql);
		
		List<User> list = jt.query(sql,new BeanPropertyRowMapper<User>(User.class),"%"+name+"%","%"+address+"%","%"+email+"%",index);

		return list;
	}

	
	
	
	
	
	
	
	@Override
	public boolean update(User user) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		String sql = "INSERT INTO USER (name,gender,age,address,qq,email)VALUES(?,?,?,?,?,?)";
		
		int count = jt.update(sql, user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User findUser(int id) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		String sql = "select*from user where id=?";
		User user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
		
		return user;
		
	}

	@Override
	public void update2(User user) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		String sql1 = "UPDATE USER SET gender=? WHERE id=?";
		String sql2 = "UPDATE USER SET age=? WHERE id=?";
		String sql3 = "UPDATE USER SET address=? WHERE id=?";
		String sql4 = "UPDATE USER SET qq=? WHERE id=?";
		String sql5 = "UPDATE USER SET email=? WHERE id=?";
		System.out.println(user);
		int id = user.getId();
		jt.update(sql1,user.getGender(),id);
		
		int i = jt.update(sql2,user.getAge(),id);
		System.out.println(i);
		i=jt.update(sql3,user.getAddress(),id);
		System.out.println(i);
		i=jt.update(sql4,user.getQq(),id);
		System.out.println(i);
		jt.update(sql5,user.getEmail(),id);
		
		
		
		
	}

	@Override
	public boolean findManage(String managename, String managepassword) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		String sql = "select* from manage where managename=? and managepassword=?";
		Manage manage=null;
		try {
			 manage = jt.queryForObject(sql, new BeanPropertyRowMapper<Manage>(Manage.class),managename,managepassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(manage!=null) {
			return true;
		}else {
			return false;
		}
		
		
		
	}

	@Override
	public int getDatasNumber(String name,String address,String email) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		//String sql = "select count(*) from user";
		String sql1 = "SELECT count(*) FROM USER ";
		String sql2 = "WHERE NAME LIKE ? ";
		String sql3 = "AND address LIKE ? ";
		String sql4 = "AND email LIKE ? ";
		String  sql = sql1+sql2+sql3+sql4;
		
		int count = jt.queryForObject(sql, int.class,"%"+name+"%","%"+address+"%","%"+email+"%");
		return count;
	}

	@Override
	public void deleteSelectedDatas(String ids) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		if(ids!=null) {
			String sql = "DELETE FROM USER WHERE ";//字符串拼接一个集合
			StringBuffer sql2 =  new StringBuffer();
			sql2.append(sql);
			sql2.append(ids);
			System.out.println(sql2);
			jt.update(sql2.toString());
		}
		
	}
	
	



	


	
}
