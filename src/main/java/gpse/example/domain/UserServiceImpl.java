package gpse.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User name " + username + " not found.")); //<2>
    }

    // tag::createUser[]
    @Override
    public User createUser(final String username, final String password, final String firstname, final String lastname, final String... roles) {
        final User user = new User(username, firstname, lastname, password);// <1>
        for (final String role : roles) {
            user.addRole(role);// <2>
        }

        final User saved = userRepository.save(user); // <3>
        return saved;
    }
    // end::createUser[]

}
