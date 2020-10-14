package com.nishik.spring.upload.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nishik.spring.upload.entity.User;
import com.nishik.spring.upload.jpaRepo.FileUploadRepository;

@Controller
public class APIController {
	
	@Autowired
	private FileUploadRepository repo;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<User> listUser = repo.findAll();
		model.addAttribute("listUser",listUser);
		return "home";
	}
	
	public String uploadFile(@RequestParam("user") MultipartFile multipartFile,
			RedirectAttributes ra) throws IOException {
		String filename =StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		User user = new User();
		user.setName(filename);
		user.setContent(multipartFile.getBytes());
		user.setSize(multipartFile.getSize());
		
		repo.save(user);
		ra.addFlashAttribute("message", "The file has been Uploaded successfully!");
		return "redirect:/";
	}
	
	@GetMapping("/download")
	public void downloadFile(@Param("user_id") Long user_id, HttpServletResponse reponse) throws Exception {
		Optional<User> result = repo.findById(user_id);
		if(!result.isPresent()) {
			throw new Exception("Could not find file by id :" +user_id);
			
			
		}
		User usr = result.get();
		reponse.setContentType("application/octet-stream");
		String headerKey="Content-dispositions";
		String headerValue="attachments; filename=" +usr.getName();
		
		reponse.setHeader(headerKey,headerValue);
		
		ServletOutputStream outputStream = reponse.getOutputStream();
		outputStream.write(usr.getContent());
		
	}

}
