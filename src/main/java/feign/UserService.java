package feign;


import dto.NewUser;
import dto.NewUserResponse;
import dto.UserDto;
import dto.UsersDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "users", url = "${base.url}", configuration = Config.class)
public interface UserService {


    @RequestMapping(method = RequestMethod.GET, value = "/api/users/{id}", produces = "application/json")
    ResponseEntity<UserDto> getUser(@PathVariable("id") Integer id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/users?page={pageId}",produces = "application/json")
    ResponseEntity<UsersDto> getUsers(@PathVariable("pageId") Integer pageId);


    @RequestMapping(method = RequestMethod.POST, value = "/api/users")
    ResponseEntity<NewUserResponse> postUser(@RequestBody NewUser newUser);

}

