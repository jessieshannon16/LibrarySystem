package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.*;
import java.lang.*;
import com.example.entity.Author;

@SpringBootApplication
@RestController
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@GetMapping("/author")
	public String author(@RequestParam(name="id") String id){
		Author author = ReadAuthor.readAuthor(Integer.parseInt(id));
		if (author != null)
		{
			return "Author details: " + author.getFirstName() + " " + author.getLastName();
		}
		return "Error";
		
	}
}
