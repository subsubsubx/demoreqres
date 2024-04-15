package feign;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class ReqInterceptor implements RequestInterceptor{
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Kal");
        System.out.println(requestTemplate.headers());
    }

}
