package pl.larys.jba.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.larys.jba.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by piotr on 15.05.16.
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername uniqueUsername) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository == null)
            return true;
        return userRepository.findByName(username) == null;
    }
}
