package org.jsp.userapidemo.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.userapidemo.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.phone=?1 and u.password=?2")
	Optional<User> verifyUser(long phone, String password);

	@Query("select u from User u where u.email=?1 and u.password=?2")
	Optional<User> verifyUser(String email, String password);

	@Query("select u from User u where u.id=?1 and u.password=?2")
	Optional<User> verifyUser(int id, String password);

	@Query("select u from User u where u.name=?1")
	List<User> findByName(String name);

	@Query("select u from User u where u.age=?1")
	List<User> findByAge(int age);

	@Query("select u from User u where u.email=?1")
	Optional<User> findByEmail(String email);

}
