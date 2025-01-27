package spring.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		getNameById();
	}

	@Transactional //todo lo q modifiq la tabla va con esta notacion
	public void create(){
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String lastName = scanner.next();
		scanner.close();
		User u = new User(null,name,lastName);
		User newU = userRepository.save(u);
		System.out.println(newU);
	}

	@Transactional
	public void update(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a buscar: ");
		Long id = scanner.nextLong();
		Optional<User> userId = userRepository.findById(id);

		if(userId.isPresent()){
			User u = userId.orElseThrow();
			System.out.println(userId);
			System.out.println("Ingrese el nombre: ");
			String name = scanner.next();
			u.setName(name);
			System.out.println("Ingrese el apellido: ");
			String lastName = scanner.next();
			u.setLastname(lastName);
			User userMod = userRepository.save(u);
			System.out.println(userMod);
			scanner.close();
		}else{
			System.out.println("El usuario no existe");
		}
		
	}

	@Transactional
	public void delete(){
		userRepository.findAll().forEach(p->System.out.println(p));
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona a eliminar: ");
		Integer id = scanner.nextInt();
		userRepository.deleteById(id);
		userRepository.findAll().forEach(p->System.out.println(p));
		scanner.close();
	}

	@Transactional(readOnly = true)//cuando son solo de consulta se debe agregar el readOnly
	public void findOne(){
		userRepository.findById(8).ifPresent(System.out::println);
		
	}

	@Transactional(readOnly = true)
	public void getNameById(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona a buscar: ");
		Long id = scanner.nextLong();
		String n = userRepository.getFullNameById(id);
		System.out.println(n);
		scanner.close();
	}

	@Transactional(readOnly = true)
	public void list(){
		//List<User> list = (List<User>) userRepository.findAll();
		//List<User> list = (List<User>) userRepository.findByName("Milanesa");
		Optional<User> l= (Optional<User>) userRepository.BuscarPorApellido("Altamirano","Milanesa");
		l.stream().forEach(user->System.out.println(user));

		List<Object[]> lista =  userRepository.BuscarPersonas();
		lista.stream().forEach(user->{
			System.out.println(user[0]);
		});
	}
}
