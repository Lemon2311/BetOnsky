package com.project.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable(name = "id") Long id) {
        Optional<User> user0 = userService.getUser(id);
        return user0;
    }

    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable(name = "email") String email) {
        Optional<User> user0 = userService.getUserByEmail(email);
        return user0;
    }

    @PatchMapping("/email/{email}/{value}")
    public void patchUserLoggedInState(@PathVariable(name = "email") String email,
                                       @PathVariable(name = "value") boolean value){
        userService.updateLoggedStateOfUser(email,value);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user, @PathVariable(value = "id") Long id) {
        userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
}
