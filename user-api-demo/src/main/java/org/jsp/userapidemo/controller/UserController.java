package org.jsp.userapidemo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.jsp.userapidemo.dto.ResponseStructure;
import org.jsp.userapidemo.dto.User;
import org.jsp.userapidemo.repository.UserRepository;
import org.jsp.userapidemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(value = "/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PutMapping(value = "/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id) {
		return service.findUserById(id);
	}

	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		return service.findAllUser();

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

	@PostMapping("users/verify-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone, @RequestParam String password) {
		return service.verifyUser(phone, password);
	}

	@PostMapping("users/verify-by-email")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email,
			@RequestParam String password) {
		return service.verifyUser(email, password);
	}

	@PostMapping("users/verify-by-id")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam int id, @RequestParam String password) {
		return service.verifyUser(id, password);
	}

	@GetMapping("/users/by-name/{name}")
	public ResponseEntity<ResponseStructure<List<User>>> findByName(@PathVariable String name) {
		return service.findByName(name);

	}

	@GetMapping("/users/by-age/{name}")
	public ResponseEntity<ResponseStructure<List<User>>> findByAge(@PathVariable int age) {
		return service.findByAge(age);

	}

	@GetMapping("/users/find-by-email/{email}")
	public ResponseEntity<ResponseStructure<User>> findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}
}
