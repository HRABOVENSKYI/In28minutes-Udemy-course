package ua.lviv.dataart.restfulwebservices.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.dataart.restfulwebservices.api.model.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> getUserById(Integer id);
}
