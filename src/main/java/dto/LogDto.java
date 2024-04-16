package dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogDto {
    private String email;
    private String password;

    @Data
    public static class Response{
        private String token;
    }
}
