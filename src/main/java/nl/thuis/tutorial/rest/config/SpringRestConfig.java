package nl.thuis.tutorial.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"nl.thuis.tutorial.rest.dispatcher", "nl.thuis.tutorial.rest.controller"})
public class SpringRestConfig implements WebMvcConfigurer {

}
