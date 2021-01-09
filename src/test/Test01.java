package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import util.Util;

public class Test01 {
	 public static void main(String[] args) {
		a:for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(j);
				break a;
			}
		}
		 
		 
	}
}
