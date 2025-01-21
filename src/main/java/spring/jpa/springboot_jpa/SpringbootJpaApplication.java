package spring.jpa.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.jpa.springboot_jpa.Entities.User;
import spring.jpa.springboot_jpa.Repositories.IUserRepository;


@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private IUserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// metodo de instancia....
		List<User> list = (List<User>) userRepository.findAll();
		list.stream().forEach(user->System.out.println(user));
	}

}
