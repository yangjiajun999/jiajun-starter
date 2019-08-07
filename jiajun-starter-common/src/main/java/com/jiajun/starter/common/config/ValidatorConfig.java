package com.jiajun.starter.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;

/**
 * @Author: 影风
 * @Date: 2019-08-07 10:54
 * @Description:
 */
@Configuration
public class ValidatorConfig {
    @Autowired
    ResourceBundleMessageSource messageSource;

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator());
        return postProcessor;
    }

    @Bean
    public Validator validator(){
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        try {
    		validator.setValidationMessageSource(messageSource);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        // validator.setMessageInterpolator(new MessageInterpolator(new PlatformResourceBundleLocator("i18n/ucenter/message" )));

        return validator;
    }

}
