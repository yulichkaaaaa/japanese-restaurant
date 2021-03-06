package com.yuliana.japaneserestaurant.web.config;

import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web configuration class.
 *
 * @author Yulia Shuleiko
 */
@Configuration
@ComponentScan(basePackages = "com.yuliana.japaneserestaurant")
public class WebConfig implements WebMvcConfigurer {

    private static final String ERRORS_RESOURCE_BUNDLE = "classpath:errors";
    private static final String ENCODING = "UTF-8";

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter(jackson2ObjectMapperBuilder().build()));
    }

    /**
     * Create the {@code Jackson2ObjectMapperBuilder} object as a bean
     *
     * @return the {@code Jackson2ObjectMapperBuilder} object
     */
    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return builder;
    }

    /**
     * Create the {@code ReloadableResourceBundleMessageSource} object as a bean
     *
     * @return the {@code ReloadableResourceBundleMessageSource} object
     */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename(ERRORS_RESOURCE_BUNDLE);
        source.setDefaultEncoding(ENCODING);
        return source;
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
