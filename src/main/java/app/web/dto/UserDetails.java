package app.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Gabriel on 01.05.2017.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDetails {

    @NotNull
    @Size(min = 4, max = 15, message = "{username.size}")
    private String username;
    @NotNull
    @Size(min=2, max=30, message = "{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min=2, max=30, message = "{lastName.size}")
    private String lastName;
    @NotNull
    @Size(min = 5, message = "{email.valid}")
    @Email(message = "{email.valid}")
    private String email;

    public UserDetails(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
