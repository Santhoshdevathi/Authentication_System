package in.authenticationSystem.Authify.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.authenticationSystem.Authify.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

	Optional<UserEntity> findByEmail(String email);
	
	Boolean existsByEmail(String email);
	
	
}
