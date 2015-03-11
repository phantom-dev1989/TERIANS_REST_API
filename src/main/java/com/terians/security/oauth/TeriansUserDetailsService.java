/*
package com.terians.security;

import com.terians.jpa.model.TeriansUser;
import com.terians.jpa.service.TeriansUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class TeriansUserDetailsService implements UserDetailsService {

    @Autowired
    private TeriansUserService teriansUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        try {

            TeriansUser teriansUser = teriansUserService.findByUsername(s);

            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            return new User(
                    teriansUser.getUsername(),
                    teriansUser.getPassword().toLowerCase(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(teriansUser.getRoles()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    */
/**
 * Retrieves a collection of {@link org.springframework.security.core.GrantedAuthority}
 *
 * @return a collection of {@link org.springframework.security.core.GrantedAuthority
 *//*


    public Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        roles.stream().forEach((item)->{
            authorities.add(new SimpleGrantedAuthority(item));
        });

        return authorities;
    }

}

*/
