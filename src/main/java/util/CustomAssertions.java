package util;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.asserts.Assertion;

@Component
public class CustomAssertions {


    public static <T> void assertCodeSuccessful(ResponseEntity<T> resp){
        Assert.assertTrue(resp.getStatusCode().is2xxSuccessful(), "Неуспешный статус код: " +
                resp.getStatusCode().value());
    }

}
