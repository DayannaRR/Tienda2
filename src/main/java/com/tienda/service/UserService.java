
package com.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tienda.entity.Persona;

/**
 *
 * @author Dayanna Rojas
 */
@Service
public class UserService implements UserDetailsService{
    @Autowired
    public IPersonaService personaService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona=this.personaService.findByNombre(username);
        UserPrincipal userPrincipal= new UserPrincipal(persona);
        return userPrincipal;
    }
    
}
