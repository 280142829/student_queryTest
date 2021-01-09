package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;
public class Util {
	private static DataSource ds ;
	 static {
			
	        try {
	            //1.���������ļ�
	            Properties pro = new Properties();
	            //ʹ��ClassLoader���������ļ�����ȡ�ֽ�������
	            InputStream is = Util.class.getClassLoader().getResourceAsStream("druid.properties");
	            pro.load(is);
	
	            //2.��ʼ�����ӳض���
	            ds = DruidDataSourceFactory.createDataSource(pro);
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	    /**
	     * ��ȡ���ӳض���
	     */
	    public static DataSource getDataSource(){
	        return ds;
	    }
	
	
}
