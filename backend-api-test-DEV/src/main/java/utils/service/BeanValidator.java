package utils.service;


import org.testng.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.function.Consumer;

public interface BeanValidator {
    Consumer<Object> validator = (bean) -> {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> errors = validator.validate(bean);
        Assert.assertTrue(errors.size() == 0, errors.toString());
    };
}
