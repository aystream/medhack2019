package ru.mts.medhack2019.service;

import ru.mts.medhack2019.dto.UserDTO;
import ru.mts.medhack2019.model.User;

import java.util.List;

/**
 * Сервис для работы с пользователями.
 */
public interface UserService {
    User findById(Long id);

    User create(UserDTO userDTO);

    User update(UserDTO userDTO);

    List<User> findAll();

    void delete(Long id);
}
