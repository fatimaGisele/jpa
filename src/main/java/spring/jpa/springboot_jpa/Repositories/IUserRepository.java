package spring.jpa.springboot_jpa.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import spring.jpa.springboot_jpa.Entities.User;


public interface IUserRepository extends CrudRepository<User,Integer>{

    List<User> findByName(String nString);

    @Query("select u from User u where u.lastname=?1 and u.name=?2")
    Optional<User> BuscarPorApellido(String lastname, String name);

    @Query("select u from User u ")
    List<Object[]> BuscarPersonas();

    @Query("select u from User u where u.ID=?1")
    Optional<User> findById(Long id);

    @Query("select u.name from User u where u.ID=?1")
    String getNameById(Long id);

    @Query("select concat(u.name,' ',u.lastname) from User u where u.ID=?1")
    String getFullNameById(Long id);
}
