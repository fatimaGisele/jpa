package spring.jpa.springboot_jpa.DTO;


public class UserDto {

    private String name;
    private String lastname;

    public UserDto(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
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
        return "UserDto [name=" + name + ", lastname=" + lastname + "]";
    }


}
