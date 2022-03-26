package ua.lviv.dataart.restfulwebservices.api.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.dataart.restfulwebservices.api.dto.UserDto;
import ua.lviv.dataart.restfulwebservices.api.model.User;
import ua.lviv.dataart.restfulwebservices.api.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream()
                .map(u -> mapper.map(u, UserDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        return new ResponseEntity<>(mapper.map(userService.createUser(user), UserDto.class), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(mapper.map(userService.getUserById(id), UserDto.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return ResponseEntity.ok(mapper.map(userService.updateUser(id, user), UserDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
