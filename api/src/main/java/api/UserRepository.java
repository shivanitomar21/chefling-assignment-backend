package api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByName(String name);
	
	@Query("from User where name=?1 and password=?2")
	public User findByNameAndPass(String name,String password);

}
