package spring.jpa.springboot_jpa.Repositories;

import org.springframework.data.repository.CrudRepository;
import spring.jpa.springboot_jpa.Entities.User;


public interface IUserRepository extends CrudRepository<User,Integer>{


}
