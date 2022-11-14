package com.challenge.rickandmorty.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:rickandmorty.properties")
public class Properties {
}
