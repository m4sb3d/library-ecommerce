package com.masbed.libcommerce.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.List;

public class ExistValidator implements ConstraintValidator<Exist, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> domainClass;
    private String fieldName;
    private boolean expected;
    private String message;


    @Override
    public void initialize(Exist constraintAnnotation) {
        domainClass = constraintAnnotation.domainClass();
        fieldName = constraintAnnotation.fildname();
        expected = constraintAnnotation.expected();

        if (expected)
            message = "O valor não existe na bas";
        else
            message = "O valor já existe na base";

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + domainClass.getSimpleName() + " WHERE " + fieldName + " = :value");
        query.setParameter("value", value);

        List<?> result = query.getResultList();
        boolean exists = result.size() > 0;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();

        if(exists == expected)
            return true;
        return false;


    }
}
