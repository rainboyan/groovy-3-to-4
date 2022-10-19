package com.rainboyan.groovy

import java.lang.reflect.Method
import groovy.transform.CompileStatic

@CompileStatic
trait ValidatedService {

    private ValidatorFactory validatorFactory

    private Map<Method, ExecutableValidator> executableValidatorMap = new LinkedHashMap<Method, ExecutableValidator>().withDefault {
        getValidatorFactory().getValidator().forExecutables()
    }

    ValidatorFactory getValidatorFactory() {
        null
    }

    void validate() {
        getValidatorFactory().getValidator().validate()
    }
}