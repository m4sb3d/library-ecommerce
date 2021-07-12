package com.masbed.libcommerce.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {DocumentValidator.class})
public @interface Document {

    String message() default "não está num formato correto";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    DocumentType[] documentTypes();
}
