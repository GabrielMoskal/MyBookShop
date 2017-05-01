package app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Gabriel on 02.04.2017.
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordCorrectValidator.class)
@Documented
public @interface PasswordCorrect {
    String message() default "Password and confirmed password don't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
