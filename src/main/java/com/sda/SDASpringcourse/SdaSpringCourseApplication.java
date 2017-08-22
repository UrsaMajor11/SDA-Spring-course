package com.sda.SDASpringcourse;

import com.sda.SDASpringcourse.model.News;
import com.sda.SDASpringcourse.model.User;
import com.sda.SDASpringcourse.repository.JpaNewsRepository;
import com.sda.SDASpringcourse.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SdaSpringCourseApplication {

	@Autowired
	private JpaUserRepository userRepository;

	@Autowired
	JpaNewsRepository newsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SdaSpringCourseApplication.class, args);
	}

	@PostConstruct
	public void init() {
		userRepository.save(new User("Bartek", "Mytko", "123456789"));
		userRepository.save(new User("Maria", "Mytko", "987654321"));
		userRepository.save(new User("Antek", "Mytko", "147258369"));

		News news0 = new News("Zamach w Barcelonie 0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
				"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
				"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
				"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
				"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
				"sunt in culpa qui officia deserunt mollit anim id est laborum.",
				"https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
				"https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
				userRepository.findOne(1));
		News news1 = new News("Zamach w Barcelonie 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
				"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
				"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
				"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
				"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
				"sunt in culpa qui officia deserunt mollit anim id est laborum.",
				"https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
				"https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
				userRepository.findOne(3));
		News news2 = new News("Zamach w Barcelonie 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
				"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
				"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
				"ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
				"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
				"sunt in culpa qui officia deserunt mollit anim id est laborum.",
				"https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
				"https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
				userRepository.findOne(3));

		newsRepository.save(news0);
		newsRepository.save(news1);
		newsRepository.save(news2);
	}
}
