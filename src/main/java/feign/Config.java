package feign;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import me.bvn13.openfeign.logger.normalized.NormalizedFeignLogger;
import okhttp3.OkHttpClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = "feign")
public class Config {


    @Bean
    public feign.okhttp.OkHttpClient client() {
        return new feign.okhttp.OkHttpClient(new OkHttpClient.Builder().addInterceptor(new AllureOkHttp3()).build());
    }


    @Bean
    public Logger feignLogger() {
        return new NormalizedFeignLogger();
    }


    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
