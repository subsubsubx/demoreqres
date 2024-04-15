package feign;

import feign.slf4j.Slf4jLogger;
import me.bvn13.openfeign.logger.normalized.NormalizedFeignLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = "feign")
public class Config {

    @Autowired
    public ReqInterceptor reqInterceptor;


    @Bean
    public Logger feignLogger() {
        return new NormalizedFeignLogger();
    }


    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
