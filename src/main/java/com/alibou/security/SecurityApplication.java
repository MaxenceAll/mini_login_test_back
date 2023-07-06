package com.alibou.security;

import com.alibou.security.auth.AuthenticationService;
import com.alibou.security.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

import static com.alibou.security.user.Role.*;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {

		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthenticationService service){
		return args -> {
			var admin = RegisterRequest.builder()
					.firstName("Admin_nom")
					.lastName("Admin_prénom")
					.email("admin@gmail.com")
					.role(ADMIN)
					.password("1234")
					.build();

			var manager = RegisterRequest.builder()
					.firstName("Manager_nom")
					.lastName("Manager_prénom")
					.email("manager@gmail.com")
					.role(MANAGER)
					.password("1234")
					.build();

			var user = RegisterRequest.builder()
					.firstName("User_nom")
					.lastName("User_prénom")
					.email("user@gmail.com")
					.role(USER)
					.password("1234")
					.build();
			System.out.println("Admin token is : " + service.register(admin).getToken());
			System.out.println("Manager token is : " + service.register(manager).getToken());
			System.out.println("User token is : " + service.register(user).getToken());
		};
	}

}
