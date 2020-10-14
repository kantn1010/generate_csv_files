package com.nishik.spring.upload.jpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nishik.spring.upload.entity.User;

public interface FileUploadRepository extends JpaRepository<User, Long>{

@Query("SELECT NEW USER(d.user_id,d.email_id,d.name) from USER d ORDER BY d.upload_date DESC")
List<User> findAll();
}
