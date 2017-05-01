package app.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import app.validation.PasswordCorrect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserRegistration {

    @NotNull
    @Size(min = 4, max = 15, message = "{username.size}")
    private String username;
    @NotNull
    @PasswordCorrect(message = "{password.notEqual}")
    @Size(min=5, max=25, message = "{password.size}")
    private Password password;
    @Size(min=2, max=30, message = "{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min=2, max=30, message = "{lastName.size}")
    private String lastName;
    @NotNull
    @Email(message = "{email.valid}")
    private String email;

    public UserRegistration() {
        this("no username", new Password(),"no firstname", "no lastname", "no email");
    }

    public UserRegistration(String username, Password password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
