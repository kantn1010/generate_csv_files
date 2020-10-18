package com.nishik.spring.upload.jpaRepo.userRepo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nishik.spring.upload.entity.UserLoginAccess;

public interface UserRepository extends CrudRepository<UserLoginAccess, Long> {
 
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public UserLoginAccess getUserByUsername(@Param("username") String username);

}
