package com.example.myrestfulservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {

    private final UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> userList(){
        return userDaoService.findAll();
    }

    @GetMapping(path="/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userDaoService.findOne(id);

        if( user == null ){
            throw new UserNotFoundException(String.format("ID[%s] not found. ", id));
        }

        return user;
    }

    @PostMapping(path="/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
