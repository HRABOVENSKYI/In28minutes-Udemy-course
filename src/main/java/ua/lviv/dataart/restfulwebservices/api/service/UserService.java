package ua.lviv.dataart.restfulwebservices.api.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ua.lviv.dataart.restfulwebservices.api.dto.PostDto;
import ua.lviv.dataart.restfulwebservices.api.model.Post;
import ua.lviv.dataart.restfulwebservices.api.model.User;
import ua.lviv.dataart.restfulwebservices.api.dao.UserDao;
import ua.lviv.dataart.restfulwebservices.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    private final ModelMapper mapper;

    public User createUser(User user) {
        return userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id).orElseThrow(() ->
                new NotFoundException(String.format("User with the id %d not found", id)));
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

    public List<Post> getAllUsersPosts(Integer id) {
        return new ArrayList<>(getUserById(id).getPosts());
    }

    public void createPost(Integer userId, PostDto postDto) {
        User user = getUserById(userId);
        user.addPost(mapper.map(postDto, Post.class));
        userDao.save(user);
    }

    public void deletePost(Integer userId, Integer postId) {
        User user = getUserById(userId);
        Post post = user.getPosts().stream()
                .filter(p -> p.getId().equals(postId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(
                        String.format("Post with id %d not found for user with id %d", postId, userId)));
        user.removePost(post);
    }
}
