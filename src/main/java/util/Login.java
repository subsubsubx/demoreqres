package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.LogDto;
import lombok.extern.log4j.Log4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Login {

    @Value("${base.url}")
    private String baseUrl;


    @Value("${test.user}")
    private String user;

 @Value("${test.password}")
    private String password;




    public String getAuthCookie() {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("email", user)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url(baseUrl + "/api/login")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            ObjectMapper om = new ObjectMapper();
            assert response.body() != null;
            LogDto.Response token = om.readValue(response.body().string(), LogDto.Response.class);
            return token.getToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
