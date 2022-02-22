package com.example.shoppingapi.user;

import com.example.shoppingapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserId(Integer id);

//    @Query("select u from User u where u.fullName = ?1")
//    User findByFullName(String fullname);

//    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

}
