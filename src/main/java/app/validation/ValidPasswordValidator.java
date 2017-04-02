package app.validation;

import app.web.dto.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Gabriel on 02.04.2017.
 */
public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, Object> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) {
            return true;
        }
        User user = (User)object;
        String password = user.getPassword();
        String confirmedPassword = user.getConfirmedPassword();
        return password.equals(confirmedPassword);
    }
}
