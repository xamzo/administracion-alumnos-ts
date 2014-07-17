package cl.ubb.spring.web.administracionalumnosts.model.centroDePractica;

import cl.ubb.spring.web.administracionalumnosts.model.genericos.Comuna;

import javax.persistence.*;
import java.util.List;

/**
 * Created by w7600PC on 15/07/2014.
 */
@Entity
@Table(name = "centro_de_practica")
public class CentroDePractica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCentroDePracticaPk;
    @Column(nullable = false)
    private String nombreCentroDePractica;
    private String direccion;
    private String telefono;
    private String paginaWeb;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idComunaFk", nullable = false)
    private Comuna comuna;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "centroDePractica")
    private List<DivisionCentroDePractica> divisionCentroDePracticas;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "centroDePractica")
    private List<ContactoCentroDePractica> contactoCentroDePracticas;

    public long getIdCentroDePracticaPk() {
        return idCentroDePracticaPk;
    }

    public List<DivisionCentroDePractica> getDivisionCentroDePracticas() {
        return divisionCentroDePracticas;
    }

    public void setDivisionCentroDePracticas(List<DivisionCentroDePractica> divisionCentroDePracticas) {
        this.divisionCentroDePracticas = divisionCentroDePracticas;
    }

    public List<ContactoCentroDePractica> getContactoCentroDePracticas() {
        return contactoCentroDePracticas;
    }

    public void setContactoCentroDePracticas(List<ContactoCentroDePractica> contactoCentroDePracticas) {
        this.contactoCentroDePracticas = contactoCentroDePracticas;
    }

    public void setIdCentroDePracticaPk(long idCentroDePracticaPk) {
        this.idCentroDePracticaPk = idCentroDePracticaPk;
    }

    public String getNombreCentroDePractica() {
        return nombreCentroDePractica;
    }

    public void setNombreCentroDePractica(String nombreCentroDePractica) {
        this.nombreCentroDePractica = nombreCentroDePractica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
}
