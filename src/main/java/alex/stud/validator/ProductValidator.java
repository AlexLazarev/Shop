package alex.stud.validator;

import alex.stud.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       Product product = (Product)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "required");
        if (product.getType().length() < 3 || product.getType().length() > 12) {
            errors.rejectValue("type", "product.type.size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        if (product.getName().length() < 2 || product.getName().length() > 32) {
            errors.rejectValue("name", "product.name.size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
        if (product.getPrice() != null && !product.getPrice().toString().matches("\\d{1,9}")) {
            errors.rejectValue("price", "product.price.incorrect");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "required");
        if (product.getPrice() != null && !product.getQuantity().toString().matches("\\d{1,9}")) {
            errors.rejectValue("quantity", "product.quantity.incorrect");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "material", "required");
        if (product.getMaterial().length() < 2 || product.getMaterial().length() > 128) {
            errors.rejectValue("material", "product.material.size");
        }

        if (product.getDescription().length() > 255) {
            errors.rejectValue("description", "product.description.size");
        }
    }
}