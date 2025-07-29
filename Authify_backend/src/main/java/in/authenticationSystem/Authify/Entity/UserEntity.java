package in.authenticationSystem.Authify.Entity;


import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="tbl_users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String userId;
	private String name;
	
	@Column(unique=true)
	private String email;
	private String password;
	private String verifyOtp;
	
	@Column(columnDefinition = "BOOLEAN")
	private Boolean isAccountVerified;
	private Long verifyOtpExpiredAt;
	private String resetOtp;
	private Long resetOtpExpiredAt;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
