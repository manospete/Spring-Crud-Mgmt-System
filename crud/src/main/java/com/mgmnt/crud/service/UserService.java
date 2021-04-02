package com.mgmnt.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mgmnt.crud.entity.User;
import com.mgmnt.crud.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;


	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Transactional
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Transactional
	public User findUserById(Long id) throws Exception {
		return userRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("User not found  with ID %d", id)));
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}


	public void deleteUser(Long id) throws Exception {
		final User user = userRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("User not found  with ID %d", id)));

		userRepository.deleteById(user.getId());
	}
}
