package rt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import rt.aspect.LoggingAsp;

@Configuration
@ComponentScan(basePackages = "rt.service")
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public LoggingAsp aspect() {
        return new LoggingAsp();
    }
}
