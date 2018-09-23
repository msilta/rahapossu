package fi.multisilta.rahapossu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class ApplicationConfig {

    @Autowired
    public void configurePropertyHandling(PropertySourcesPlaceholderConfigurer configurer) {
        // Trim property values
        configurer.setTrimValues(true);
    }

}
