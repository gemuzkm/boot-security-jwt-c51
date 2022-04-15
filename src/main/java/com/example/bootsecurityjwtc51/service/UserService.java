package com.example.bootsecurityjwtc51.service;

import com.example.bootsecurityjwtc51.entity.Role;
import com.example.bootsecurityjwtc51.entity.Status;
import com.example.bootsecurityjwtc51.entity.User;
import com.example.bootsecurityjwtc51.repository.RoleRepository;
import com.example.bootsecurityjwtc51.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public void registration(User user) {
		List<Role> roles = new ArrayList<>();
		Role role = new Role();
		role.setTypeOfRole("USER");
		roles.add(role);
		user.setRoleList(roles);

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoleList(roles);
		user.setStatus(Status.ACTIVE);
		role.setUser(user);
		User regUser = userRepository.save(user);
		roleRepository.save(role);
	}

	public User findByUsername(String username) {
		User byUsername = userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User with username: " + username + " not found"));
		return byUsername;
	}

	public boolean existByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	public boolean existByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

}
