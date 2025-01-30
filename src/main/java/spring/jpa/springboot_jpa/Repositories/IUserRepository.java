package spring.jpa.springboot_jpa.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import spring.jpa.springboot_jpa.DTO.UserDto;
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

    @Query("select new User(u.name, u.lastname) from User u")
    List<User> findAllUser();

    @Query("select new spring.jpa.springboot_jpa.DTO.UserDto(u.name, u.lastname) from User u")
    List<UserDto> findAllUserDto();

    @Query("select count(distinct (u.lastname)) from User u")
    Long findLastnameCount();

    @Query("select min(u.id), max(u.id), sum(u.id), avg(length(u.name)), count(u.id) from User u")
    Object getResume();

    @Query("select u.name, length(u.name) from User u where length(u.name) = (select min(length(u.name)) from User u)")
    List<Object[]> algObjects();
}
