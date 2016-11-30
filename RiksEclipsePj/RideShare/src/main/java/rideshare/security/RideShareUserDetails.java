package rideshare.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import rideshare.domain.User;

public class RideShareUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;

	public RideShareUserDetails(User user) {
		super();
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>();
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	public boolean isEnabled() {
		return user.isEnabled();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {}
}