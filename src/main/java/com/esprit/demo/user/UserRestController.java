package com.esprit.demo.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    IUserService userService;

    @PostMapping("/add-user")
    public User addUserS(@RequestBody User user) {
        return userService.addUser(user);
    }
}
