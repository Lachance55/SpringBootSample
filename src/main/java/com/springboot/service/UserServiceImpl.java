package com.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.springboot.model.User;



@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	
	/**
	 * FIXME @author Daner Servisten Dao Çağırılmak istendiğinde mapperin kafası karışıyor. Bi bilene danışılsa iyi olabilir.
	 */
	
//	@Autowired
//	UserDao userDao;
//	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//	
//	@Autowired
//	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//	}
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
//		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(SpringBootDaoTestClient.fetchDB());
//		this.setNamedParameterJdbcTemplate(template);
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Ali",30, "aaa"));
		users.add(new User(counter.incrementAndGet(),"Veli",40, "aa"));
		users.add(new User(counter.incrementAndGet(),"Meli",45, "aa"));
		users.add(new User(counter.incrementAndGet(),"Fikret",50, "ee"));
		return users;
	}

}
