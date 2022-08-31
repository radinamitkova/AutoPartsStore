package bg.startit.autoPartsStore.security;

import bg.startit.autoPartsStore.dao.UserDao;
import bg.startit.autoPartsStore.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userDao.getUserById(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
               // .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
