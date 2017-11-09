package com.springboot;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.springboot.dao.UserDaoImpl;
import com.springboot.model.User;


/**
 * @author Daner (Kas-2017)
 */
public class SpringBootDaoTestClient {
	  private static EmbeddedDatabase db;

	    
	    public static void setUp() {
	    	db = new EmbeddedDatabaseBuilder()
	    		.setType(EmbeddedDatabaseType.HSQL)
	    		.addScript("create-db.sql")
	    		.addScript("insert-data.sql")
	    		.build();
	    }

	    public static void main(String args[]){
	    	setUp();
	    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
	    	UserDaoImpl userDao = new UserDaoImpl();
	    	userDao.setNamedParameterJdbcTemplate(template);
	    	
	    	User user = userDao.findByName("Taner");
	    	System.out.println(user);
	    	printAll();
	    	tearDown();

	    }

	    private static void printAll() {
	    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
	    	UserDaoImpl userDao = new UserDaoImpl();
	    	userDao.setNamedParameterJdbcTemplate(template);
	    	List<User> userList = userDao.findAll();
	    	userList.forEach(user-> System.out.println(user));
			
		}

		public static void tearDown() {
	        db.shutdown();
	    }

		public static EmbeddedDatabase fetchDB() {
			if(db==null) {
				setUp();
			}
			return db;
		}

}
