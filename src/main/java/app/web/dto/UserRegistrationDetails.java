package app.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import app.validation.PasswordCorrect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class UserRegistrationDetails extends UserDetails {

    @NotNull
    @PasswordCorrect(message = "{password.notCorrect}")
    @Size(min=5, max=25, message = "{password.size}")
    private Password password;

    public UserRegistrationDetails() {
        this(null, null, null, null, null);
    }

    public UserRegistrationDetails(String username, Password password, String firstName, String lastName, String email) {
        super(username, firstName, lastName, email);
        this.password = password;
    }
}
