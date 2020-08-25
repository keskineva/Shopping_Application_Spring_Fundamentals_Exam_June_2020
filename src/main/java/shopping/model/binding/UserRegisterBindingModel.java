package shopping.model.binding;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRegisterBindingModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Username length must be more than 3 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Please enter a valid email!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Length(min = 3, max = 20, message = "Password length must be more than 3 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
