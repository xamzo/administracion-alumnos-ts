package cl.ubb.spring.web.administracionalumnosts.model.centroDePractica;

import cl.ubb.spring.web.administracionalumnosts.model.estado.TipoEstado;

import javax.persistence.*;

/**
 * Created by w7600PC on 15/07/2014.
 */
@Entity
@Table(name = "contacto_centro_de_practica")
public class ContactoCentroDePractica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContactoCentroDePractica;
    @Column(nullable = false)
    private String nombres;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false)
    private String telefonoPrincipal;
    private String telefonoSecundario;
    @Column(nullable = false)
    private String emailPrincipal;
    private String cargo;
    private String unidad;
    @Column(columnDefinition = "boolean default true")
    private boolean contactoPrincipal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCentroDePracticaFk", nullable = false)
    private CentroDePractica centroDePractica;

    public long getIdContactoCentroDePractica() {
        return idContactoCentroDePractica;
    }

    public void setIdContactoCentroDePractica(long idContactoCentroDePractica) {
        this.idContactoCentroDePractica = idContactoCentroDePractica;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefonoPrincipal() {
        return telefonoPrincipal;
    }

    public void setTelefonoPrincipal(String telefonoPrincipal) {
        this.telefonoPrincipal = telefonoPrincipal;
    }

    public String getTelefonoSecundario() {
        return telefonoSecundario;
    }

    public void setTelefonoSecundario(String telefonoSecundario) {
        this.telefonoSecundario = telefonoSecundario;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public boolean isContactoPrincipal() {
        return contactoPrincipal;
    }

    public void setContactoPrincipal(boolean contactoPrincipal) {
        this.contactoPrincipal = contactoPrincipal;
    }
}
