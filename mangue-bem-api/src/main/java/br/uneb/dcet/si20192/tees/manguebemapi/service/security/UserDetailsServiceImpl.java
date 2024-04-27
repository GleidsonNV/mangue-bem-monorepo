package br.uneb.dcet.si20192.tees.manguebemapi.service.security;

import br.uneb.dcet.si20192.tees.manguebemapi.entity.User;
import br.uneb.dcet.si20192.tees.manguebemapi.entity.security.UserDetailsImpl;
import br.uneb.dcet.si20192.tees.manguebemapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found."));
        return new UserDetailsImpl(user);
    }
}
