package com.example.learn.Repo;

import com.example.learn.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,value = "Select * from User u where u.Userid=:id")
    User findByUserId(Long id);
}
