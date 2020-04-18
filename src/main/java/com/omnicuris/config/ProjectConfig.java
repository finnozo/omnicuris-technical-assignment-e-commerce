package com.omnicuris.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableJpaAuditing
@EnableSwagger2
public class ProjectConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
