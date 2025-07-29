package in.authenticationSystem.Authify.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.authenticationSystem.Authify.Entity.UserEntity;
import in.authenticationSystem.Authify.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserEntity existingUser = userRepository.findByEmail(email)
									.orElseThrow(()->new UsernameNotFoundException("Email not found for the email: " + email));
		
		return new User(existingUser.getEmail(),existingUser.getPassword(),new ArrayList<>());
	}
	
	

}
