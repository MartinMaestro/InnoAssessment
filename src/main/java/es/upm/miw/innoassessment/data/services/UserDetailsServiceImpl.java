package es.upm.miw.innoassessment.data.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        if (username != null && username.equals("admin")) {
            return this.userBuilder(username, "123456", true);
        } else { 
        	throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

    private org.springframework.security.core.userdetails.User userBuilder(String username, String password, boolean enableUser) {
        boolean enabled = enableUser;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = enableUser;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
    }
}
