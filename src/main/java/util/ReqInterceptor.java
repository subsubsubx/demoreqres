
package util;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReqInterceptor implements RequestInterceptor {

    private boolean isAuth;
    private String token;
    @Autowired
    private Login login;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (!isAuth) {
            token = login.getAuthCookie();
            isAuth = true;
        }
        requestTemplate.header("Authorization", token);
    }


}


