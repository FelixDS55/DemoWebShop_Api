package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegistrationNewUserRequest {
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("ConfirmPassword")
    private String confirmPassword;
    @JsonProperty("register-button")
    private String registerButton;
}
