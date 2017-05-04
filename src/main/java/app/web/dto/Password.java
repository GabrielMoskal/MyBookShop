package app.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by Gabriel on 30.04.2017.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Password implements CharSequence {

    private String password;
    private String confirmedPassword;

    public Password() {
        this("", "");
    }

    public Password(String password, String confirmedPassword) {
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    @Override
    public char charAt(int index) {
        return password.charAt(index);
    }

    @Override
    public int length() {
        return password.length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return password.subSequence(start, end);
    }

    @Override
    public String toString() {
        return password;
    }
}
