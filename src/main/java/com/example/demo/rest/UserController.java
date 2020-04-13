package com.example.demo.rest;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;


@RestController
//@ResponseBody //<---(inkluderas automatiskt)
// gör så att responses konverteras till JSON
@RequestMapping("/rest/user") //parent-URL:n för denna klass
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("createService")
    private UserService userService;
    //framför en funktion
    //kan ha flera stycken
    //gör så att den körs direkt efter konstruktion
    //varje gång en startar upp programmet
    @PostConstruct
    void thisFunctionWillRunAfterConstruction(){
        System.out.println("Hello World!");
        var rootUser = userRepository.findAllByName("root");
        if (rootUser == null){
            userRepository.save(new User("root", ""));
        }
    }



    @GetMapping("/{id}")
    public Optional<User> getSpecificUser(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @GetMapping
    public Iterable<User> getAllUsers(@RequestParam(required = false) String name) {
        if (name == null) {
            return userRepository.findAll();
        } else {
            return userRepository.findAllByName(name);
        }
    }

    @PostMapping
    public User createUser(@RequestBody User userToBeCreated) {
        return userRepository.save(userToBeCreated);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public Boolean deleteAll() {
        System.out.println("Deleted all users.");
        userRepository.deleteAll();
        return true;
    }

    @GetMapping("/login")
    String loggggggin() {
        return "Login successful!";
    }

    @GetMapping("/logout")
    String testpagenr2() {
        return "Logout successfull!";
    }

    @GetMapping("/login/{id}")
    String aoneuhoseuho(@PathVariable long id, @RequestParam String displayName) {
        return displayName + " {User #" + id + "} just logged in. ";
    }
}
