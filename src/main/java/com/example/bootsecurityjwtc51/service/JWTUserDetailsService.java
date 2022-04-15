package com.example.bootsecurityjwtc51.service;


import com.example.bootsecurityjwtc51.configuration.jwt.GenerateJWTUser;
import com.example.bootsecurityjwtc51.configuration.jwt.JWTUser;
import com.example.bootsecurityjwtc51.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTUserDetailsService implements UserDetailsService {
	private final UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = service.findByUsername(username);

		if (user == null){
			throw new UsernameNotFoundException("User with username: " + username + "not found");
		}

		return GenerateJWTUser.create(user);
	}
}
