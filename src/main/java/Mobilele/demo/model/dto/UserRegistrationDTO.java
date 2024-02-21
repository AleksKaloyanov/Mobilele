package Mobilele.demo.model.dto;

import Mobilele.demo.model.validation.FieldMatch;
import Mobilele.demo.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@FieldMatch(
        first = "password",
        second="confirmPassword",
        message = "Passwords should match."
)
public record UserRegistrationDTO(@NotEmpty String firstName,
                                  @NotEmpty
                                  String lastName,
                                  @NotNull
                                  @Email
                                  @UniqueUserEmail
                                  String email,

                                  String password,
                                  String confirmPassword) {


}
