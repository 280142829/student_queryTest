package web;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import util.Util;

public class Test01 {

	public static void main(String[] args) {
		JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
		String sql1 = "SELECT count(*) FROM USER ";
		String sql2 = "WHERE NAME LIKE ? ";
		String sql3 = "AND address LIKE ? ";
		String sql4 = "AND email LIKE ? ";
		String  sql = sql1+sql2+sql3+sql4;
		
		int count = jt.queryForObject(sql, int.class,"%"+"¿Ó"+"%","%"+"2"+"%","%"+"5"+"%");
		System.out.println(count);
		
		
		
	}

}
