package Mobilele.demo.service.impl;

import Mobilele.demo.model.dto.UserLoginDTO;
import Mobilele.demo.model.dto.UserRegistrationDTO;
import Mobilele.demo.model.entity.UserEntity;
import Mobilele.demo.repository.UserRepository;
import Mobilele.demo.service.UserService;
import Mobilele.demo.util.CurrentUser;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        var userEntity = userRepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

        boolean loginSuccess = false;

        if (userEntity != null) {

            String rawPassword = userLoginDTO.password();
            String encodedPassword = userEntity.getPassword();

            loginSuccess = encodedPassword != null &&
                    passwordEncoder.matches(rawPassword, encodedPassword);

            if (loginSuccess) {
                currentUser
                        .setFirstName(userEntity.getFirstName())
                        .setLastName(userEntity.getLastName())
                        .setLogged(true);
            } else {
                currentUser.logout();
            }
        }
        return loginSuccess;
    }

    public void logoutUser() {
        currentUser.logout();
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
    }
}
