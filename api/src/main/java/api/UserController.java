package api;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

//	final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@RequestMapping("/api/users")
	public List<User> getAllUsers() {
		return userService.getList();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/api/user/signup")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping("/api/user/profile")
	public User getUserByName(@RequestParam ("name") String name) {
		return userService.getUserByName(name);
	}
	
//	@RequestMapping(method=RequestMethod.PUT, value="/user/profile/update")
//	public void updateUser(@RequestBody User user,@RequestParam ("name") String name, @RequestParam ("password") String password) {
//		userService.updateUser(user, name, password);
//	}


}
