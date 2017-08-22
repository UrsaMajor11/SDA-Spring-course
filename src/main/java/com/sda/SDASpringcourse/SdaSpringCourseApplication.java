package com.sda.SDASpringcourse;

import com.sda.SDASpringcourse.model.User;
import com.sda.SDASpringcourse.repository.JpaUserRepository;
import com.sda.SDASpringcourse.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SdaSpringCourseApplication {

	@Autowired
	private JpaUserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SdaSpringCourseApplication.class, args);
	}

	@PostConstruct
	public void init() {
		repository.save(new User("Bartek", "Mytko", "123456789"));
		repository.save(new User("Maria", "Mytko", "987654321"));
		repository.save(new User("Antek", "Mytko", "147258369"));
	}
}
