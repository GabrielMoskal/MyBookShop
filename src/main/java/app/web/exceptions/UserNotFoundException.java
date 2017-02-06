package app.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Gabriel on 05.02.2017.
 */
// TODO
@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "{exception.notFound}")
public class UserNotFoundException extends RuntimeException {
}
