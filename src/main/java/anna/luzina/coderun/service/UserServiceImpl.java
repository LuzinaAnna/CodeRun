

package anna.luzina.coderun.service;
import anna.luzina.coderun.domain.Role;
import anna.luzina.coderun.domain.User;
import anna.luzina.coderun.repository.UserRepo;
import anna.luzina.coderun.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(6);

    @Autowired
    UserRepo userRepository;

    @Override
    public void saveUser(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
    }

    @Override
    public List<Object> isUserPresent(User user) {
        boolean userExists = false;
        String message = null;
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser == null){
            message = "User not exists";
        }
        else{
            userExists = true;
            message = "User already exists";
        }
        return Arrays.asList(userExists, message);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        if (u == null){
            throw new UsernameNotFoundException("user not found");
        }
        return u;
    }
}