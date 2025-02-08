package spring.jpa.springboot_jpa.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {
    @Column(name="creado")
    private LocalDateTime create;
    @Column(name="actualizado")
    private LocalDateTime update;

        @PrePersist
    public void prePersist(){
        this.create = LocalDateTime.now();
        System.out.println("PrePersist");
    }

    @PreUpdate
    public void preUpdate(){
        this.update = LocalDateTime.now();
        System.out.println("PreUpdate");
    }
    public LocalDateTime getCreate() {
        return create;
    }


    public void setCreate(LocalDateTime create) {
        this.create = create;
    }


    public LocalDateTime getUpdate() {
        return update;
    }


    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }

}
