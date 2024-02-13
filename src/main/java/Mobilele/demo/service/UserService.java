package Mobilele.demo.service;

import Mobilele.demo.model.dto.UserLoginDTO;
import Mobilele.demo.model.dto.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
