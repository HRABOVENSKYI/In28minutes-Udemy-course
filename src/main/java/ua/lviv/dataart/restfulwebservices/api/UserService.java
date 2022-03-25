package ua.lviv.dataart.restfulwebservices.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.dataart.restfulwebservices.exception.UserNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User createUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id).orElseThrow(() ->
                new UserNotFoundException(String.format("User with the id %d not found", id)));
    }

    public User updateUser(Integer id, User user) {
        User existingUser = getUserById(id);
        existingUser.setAge(user.getAge());
        existingUser.setName(user.getName());
        return userDao.save(existingUser);
    }

    public void deleteUser(Integer id) {
        User user = getUserById(id);
        userDao.delete(user);
    }
}
