package app.validation;

import app.web.dto.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Gabriel on 02.04.2017.
 */
public class PasswordCorrectValidator implements ConstraintValidator<PasswordCorrect, Object> {

    @Override
    public void initialize(PasswordCorrect constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) {
            return true;
        }
        Password passwordWithConfirmation = (Password) object;
        String password = passwordWithConfirmation.getPassword();
        String confirmedPassword = passwordWithConfirmation.getConfirmedPassword();
        return password.equals(confirmedPassword);
    }
}
