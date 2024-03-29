package Mobilele.demo.web;

import Mobilele.demo.model.dto.UserLoginDTO;
import Mobilele.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        boolean loginSuccessful = userService.loginUser(userLoginDTO);

        return loginSuccessful ? "index" : "auth-login";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logoutUser();
        return "index";
    }
}
