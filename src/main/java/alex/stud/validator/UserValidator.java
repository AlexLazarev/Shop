package alex.stud.validator;

import alex.stud.entity.User;
import alex.stud.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "size.userForm.username");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "different.userForm.password");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required");
        if (user.getFirstName().length() < 2 || user.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "user.name.size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required");
        if (user.getlastName().length() < 2 || user.getlastName().length() > 32) {
            errors.rejectValue("lastName", "user.name.size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "required");
        if (    !user.getNumber().matches("\\d{10,12}") &&
                !user.getNumber().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")){
            errors.rejectValue("number", "producer.number.NotNumber");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
        if (    !user.getEmail().matches("\\w+\\@\\w+\\.[a-z]{2,3}")){
            errors.rejectValue("email", "user.email.incorrect");
        }
    }
}
