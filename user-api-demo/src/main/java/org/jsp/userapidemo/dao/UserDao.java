package org.jsp.userapidemo.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.userapidemo.dto.User;
import org.jsp.userapidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> findById(int id) {
		return repository.findById(id);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public boolean delete(int id) {
		Optional<User> dbUser = findById(id);
		if (dbUser.isPresent()) {
			repository.delete(dbUser.get());
			return true;
		}
		return false;
	}

	public Optional<User> verifyUser(long phone, String password) {
		return repository.verifyUser(phone, password);
	}

	public Optional<User> verifyUser(String email, String password) {
		return repository.verifyUser(email, password);
	}

	public Optional<User> verifyUser(int id, String password) {
		return repository.verifyUser(id, password);
	}

	public List<User> findByName(String name) {
		return repository.findByName(name);
	}

	public List<User> findByAge(int age) {
		return repository.findByAge(age);
	}

	public Optional<User> findByEmail(String email) {
		return repository.findByEmail(email);
	}
}
