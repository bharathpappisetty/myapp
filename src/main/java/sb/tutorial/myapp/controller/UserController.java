package sb.tutorial.myapp.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sb.tutorial.myapp.exception.CommonException;
import sb.tutorial.myapp.exception.UserNotFoundException;
import sb.tutorial.myapp.model.User;
import sb.tutorial.myapp.model.dto.UserDto;
import sb.tutorial.myapp.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    // @RequestMapping (value = "/api/user", method = RequestMethod.GET)
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @DeleteMapping("/{id}")
    public UserDto deleteById(@PathVariable String id) {
        return userService.deleteUserById(id);

    }


    @PostMapping("")
    public String createUser(@RequestBody @Valid User user) {
         return userService.createUser(user);
    }

    @PutMapping("")
    public String updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


}
