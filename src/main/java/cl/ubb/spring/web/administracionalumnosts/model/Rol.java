package cl.ubb.spring.web.administracionalumnosts.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: cristobalortiz
 * Date: 16-06-14
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="rol")
public class Rol {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
