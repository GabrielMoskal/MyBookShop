package app.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Gabriel on 01.05.2017.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDetails {
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public UserDetails(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
