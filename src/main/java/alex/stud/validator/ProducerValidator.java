package alex.stud.validator;

import alex.stud.entity.Producer;
import alex.stud.service.interfaces.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProducerValidator implements Validator {

    @Autowired
    private SupplyService supplyService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Producer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Producer producer = (Producer) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        if (producer.getName().length() < 6 || producer.getName().length() > 32) {
            errors.rejectValue("name", "producer.name.size");
        }

        if (supplyService.findByName(producer.getName()) != null) {
            errors.rejectValue("name", "producer.name.duplicate");
        }

        //TODO: number is number


        if (producer.getNumber().length() < 10 || producer.getNumber().length() > 13) {
            errors.rejectValue("number", "producer.number.size");
        }


        if (producer.getAddress().length() < 8 || producer.getAddress().length() > 32) {
            errors.rejectValue("address", "producer.address.size");
        }



        /*
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (producer.getPassword().length() < 8 || producer.getPassword().length() > 32) {
            errors.rejectValue("password", "size.userForm.password");
        }*/

    }
}
