package cl.ubb.spring.web.administracionalumnosts.model.genericos;

import javax.persistence.*;

/**
 * Created by w7600PC on 01/07/2014.
 */
@Entity
@Table(name = "campus")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCampus;
    @Column(nullable = false)
    private String nombreCampus;

    public long getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(long idCampus) {
        this.idCampus = idCampus;
    }

    public String getNombreCampus() {
        return nombreCampus;
    }

    public void setNombreCampus(String nombreCampus) {
        this.nombreCampus = nombreCampus;
    }
}
