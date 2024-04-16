package feign.api;


import dto.user.NewUserDto;
import dto.user.UserDto;
import dto.user.UsersDto;
import config.BaseConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.cloud.openfeign.FeignClient(name = "users", url = "${base.url}", configuration = BaseConfiguration.class)
public interface UserService {


    @RequestMapping(method = RequestMethod.GET, value = "/api/users/{id}")
    ResponseEntity<UserDto> getUser(@PathVariable("id") Integer id);



    @RequestMapping(method = RequestMethod.GET, value = "/api/users?page={pageId}")
    ResponseEntity<UsersDto> getUsers(@PathVariable("pageId") Integer pageId);



    @RequestMapping(method = RequestMethod.POST, value = "/api/users")
    ResponseEntity<NewUserDto> postUser(@RequestBody NewUserDto newUserDto);

}

