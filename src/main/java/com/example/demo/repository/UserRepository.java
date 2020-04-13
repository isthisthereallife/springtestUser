package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    List<User> findAllByName(String name);
/*

    BasicUser findByTitle(String title);

    UserWithImages findByTitle(String title);

    CompleteUser findByTitle(String title);

*/

}