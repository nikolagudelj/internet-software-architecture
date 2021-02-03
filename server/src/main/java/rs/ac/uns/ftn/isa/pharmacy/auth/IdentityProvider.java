package rs.ac.uns.ftn.isa.pharmacy.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public interface IdentityProvider {
    String getEmail();
    long getUserId();
    Collection<? extends GrantedAuthority> getAuthorities();
}
