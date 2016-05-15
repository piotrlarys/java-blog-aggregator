package pl.larys.jba.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by piotr on 15.05.16.
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
