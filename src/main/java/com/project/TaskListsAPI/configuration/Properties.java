package com.project.TaskListsAPI.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")

public class Properties {

    private final Environment env;

    public Properties(Environment env) {
        this.env = env;
    }

    public String getConfig(String configKey) {
        return env.getProperty(configKey);
    }
}