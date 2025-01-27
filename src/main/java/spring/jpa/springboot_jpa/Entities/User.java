package spring.jpa.springboot_jpa.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //toda clase de jpa debe estar notada con...indica q es una clase de persistencia
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name="nombre")
    private String name;
    @Column(name="apellido")
    private String lastname;
    
    public User(){}

    public User(Long iD, String name, String lastname) {
        ID = iD;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User [ID=" + ID + ", name=" + name + ", lastname=" + lastname + "]";
    }

    
}
