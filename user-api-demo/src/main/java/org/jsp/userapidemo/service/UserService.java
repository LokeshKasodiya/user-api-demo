package org.jsp.userapidemo.service;

import java.util.List;
import java.util.Optional;

import org.jsp.userapidemo.dao.UserDao;
import org.jsp.userapidemo.dto.ResponseStructure;
import org.jsp.userapidemo.dto.User;
import org.jsp.userapidemo.exception.IdNotFoundException;
import org.jsp.userapidemo.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.saveUser(user));
		structure.setMessage("User saved successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.updateUser(user));
		structure.setMessage("User Updated successfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		Optional<User> dbUser = userDao.findById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);

		}
		throw new IdNotFoundException() ;
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setData(userDao.findAll());
		structure.setMessage("List Of All Users");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<User> dbUser = userDao.findById(id);
		if (dbUser.isPresent()) {
			userDao.delete(id);
			structure.setData("User Deleted");
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setData("User Not Deleted");
		structure.setMessage("User Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone, String password) {
		Optional<User> dbUser = userDao.verifyUser(phone, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);

		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
		Optional<User> dbUser = userDao.verifyUser(email, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);

		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(int id, String password) {
		Optional<User> dbUser = userDao.verifyUser(id, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);

		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<List<User>>> findByName(String name) {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setData(userDao.findByName(name));
		structure.setMessage("List Of All Users");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<User>>> findByAge(int age) {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setData(userDao.findByAge(age));
		structure.setMessage("List Of All Users");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<User>> findByEmail(String email) {
		Optional<User> dbUser = userDao.findByEmail(email);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dbUser.isPresent()) {
			structure.setData(dbUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);

		}
		structure.setData(null);
		structure.setMessage("User Not FOund");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
	}

}
