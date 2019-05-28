package api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepo;
	
	public List<User> getList(){
		List<User> users = new ArrayList<>();
		
		userRepo.findAll().forEach(users::add);
		
		return users;
	}

	public void addUser(User user) {
		userRepo.save(user);
	}

	public User getUserByName(String name) {
		return userRepo.findByName(name);
	}

	public void updateUser(User user, String name, String password) {
		List<User> users = userRepo.findAll();
		
		for(int i=0;i<users.size();i++)
		{
			User u = users.get(i);
			if(u.getName().equals(name) && u.getPassword().equals(password))
			{
				users.set(i, user);
			}
		}
	}
}
