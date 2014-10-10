package tw.edu.ncu.cc.appstore.repository;

import tw.edu.ncu.cc.appstore.entity.User;

public interface UserDao {

	User persist(User user);
	
}
