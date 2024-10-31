package brac.it.simplesecurity;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final AppUserRepository appUserRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<AppUser> optionalUserDetails = appUserRepository.findByUsername(username);

    if(optionalUserDetails.isPresent()) {
      return optionalUserDetails.get();
    }else {
      throw new UsernameNotFoundException(username);
    }
  }
}
