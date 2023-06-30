package com.cglia.student.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class JacksonConfiguration {
    @Autowired
    public void configureJackson(ObjectMapper objectMapper) {
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}