package com.ichwan.async;

import com.ichwan.async.api.Student;
import com.ichwan.async.api.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAsyncApplication.class, args);
	}

	/**
	 * automatically insert data
     */
	@Bean
	public CommandLineRunner commandLineRunner(StudentRepository repository){
		return args -> {
			for (int i = 0; i < 20; i++) {
				repository.save(
						Student.builder()
								.firstname("ichwan")
								.lastname("surya")
								.age(i)
								.build()).subscribe();
			}
		};
	}
}
