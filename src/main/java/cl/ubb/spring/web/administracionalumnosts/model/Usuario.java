package cl.ubb.spring.web.administracionalumnosts.model;



import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cristobalortiz
 * Date: 12-06-14
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String rut;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="usuario_rol",
            joinColumns={@JoinColumn(name="usuario_id")},
            inverseJoinColumns={@JoinColumn(name="rol_id")})
    private List<Rol> roles;

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
