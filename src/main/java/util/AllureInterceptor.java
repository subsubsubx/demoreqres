

package util;

import io.qameta.allure.Allure;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;


@Component
public class AllureInterceptor implements Interceptor {


    @Override
    public Response intercept(final Chain chain) throws IOException {


        final Request request = chain.request();
        final Response response = chain.proceed(request);
        final Response.Builder responseBuilder = response.newBuilder();


        final ResponseBody responseBody = response.body();

/*        if (Objects.nonNull(responseBody)) {
            final byte[] bytes = responseBody.bytes();
            responseBuilder.body(ResponseBody.create(responseBody.contentType(), bytes));

        }
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP Request ").append(request.method()).append(" " + request.url());

        if (request.body() != null) {
            sb.append("\nRequest body: ").append(request.body());
        }
        sb.append("\nResponse code - ").append(response.code());
        if (responseBody != null) {
            sb.append("\nResponse body: ").append(responseBody);
        }*/

        Allure.step("Hello World!", (step) -> {
            step.parameter("HTTP Method", request.method());
                    if (Objects.nonNull(request.body())){
                        step.parameter("Request body", request.body());
                }
            step.parameter("Response code", response.code());
            if (Objects.nonNull(response.body())){

            //    step.parameter("Response body", responseBody);
            }
        });


        return responseBuilder.build();
    }
}



