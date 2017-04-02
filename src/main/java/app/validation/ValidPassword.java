package app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Gabriel on 02.04.2017.
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPasswordValidator.class)
@Documented
public @interface ValidPassword {
    String message() default "Passwords doesn't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
