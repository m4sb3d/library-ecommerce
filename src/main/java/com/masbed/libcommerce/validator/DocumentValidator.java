package com.masbed.libcommerce.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

public class DocumentValidator  implements ConstraintValidator<Document, String> {

    List<DocumentType> documentTypes;

    @Override
    public void initialize(Document constraintAnnotation) {
        documentTypes = Arrays.asList(constraintAnnotation.documentTypes());

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for(DocumentType documentType: documentTypes){
            ConstraintValidator validator = documentType.getConstraintValidator();
            validator.initialize(null);

            if(validator.isValid(value, null)) return true;
        }

        return false;
    }

}
