package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.*;
import java.lang.*;
import com.example.entity.Users;

@SpringBootApplication
@RestController
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@GetMapping("/user")
	public String user(@RequestParam(name="id") String id){
		Users user = ReadUser.readUser(Integer.parseInt(id));
		if (user != null)
		{
			return user.getUserName();
		}
		return "Error";
		
	}
}
