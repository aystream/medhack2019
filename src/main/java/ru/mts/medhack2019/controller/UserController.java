package ru.mts.medhack2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.service.UserService;
import ru.mts.medhack2019.shared.mapper.UserMapper;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService
            userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userMapper.toListDTOs(userService.findAll());
    }

    @GetMapping("/{id}")
    public UserDTO read(@PathVariable("id") Long id) {
        return userMapper.toDTO(userService.findById(id));
    }

    @PostMapping
    public UserDTO createClient(@RequestBody @Validated UserDTO userDTO) {
        return userMapper.toDTO(userService.create(userDTO));
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return userMapper.toDTO(userService.update(userDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

}
