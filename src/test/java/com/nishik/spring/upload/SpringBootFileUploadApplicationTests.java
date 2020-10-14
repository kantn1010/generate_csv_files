package com.nishik.spring.upload;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.nishik.spring.upload.entity.User;
import com.nishik.spring.upload.jpaRepo.FileUploadRepository;

@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringBootFileUploadApplicationTests {

	@Autowired
	private FileUploadRepository repo;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	@Rollback(false)
	void contextLoads() throws IOException {
		
		File file = new File("D:\\fileUpload\\file.csv");
		User user = new User();
		user.setEmail_id(user.getEmail_id());
		
		byte[] bytes = Files.readAllBytes(file.toPath());
		user.setContent(bytes);
		long filesize = bytes.length;
		user.setSize(filesize);
		
		User savedDoc = repo.save(user);
		
		User existDoc = entityManager.find(User.class, savedDoc.getUser_id());
		
		assertThat(existDoc.getSize()).isEqualTo(filesize);
	}

}
