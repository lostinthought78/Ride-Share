package rideshare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import rideshare.service.UserService;

@Component
public class SecurityUtils {
	
	@Autowired
	private UserService userService;

	public RideShareUserDetails getSecurityContext() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		RideShareUserDetails nvUserDetails = null;
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			nvUserDetails = (RideShareUserDetails) userService.loadUserByUsername(auth.getName());
		}
		
		return nvUserDetails;
	}

	public long getCurrentUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return getSecurityContext().getUser().getId();
		} else {
			return 0;
		}
	}
}
