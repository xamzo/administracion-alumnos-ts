package cl.ubb.spring.web.administracionalumnosts.model.genericos;

import javax.persistence.*;
import java.util.List;

/**
 * Created by w7600PC on 01/07/2014.
 */
@Entity
@Table(name = "carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCarrera;
    @Column(nullable = false)
    private int codigoCarrera;
    @Column(nullable = false)
    private String nombreCarrera;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
    private List<PlanCarrera> planCarreraList;

    public long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public List<PlanCarrera> getPlanCarreraList() {
        return planCarreraList;
    }

    public void setPlanCarreraList(List<PlanCarrera> planCarreraList) {
        this.planCarreraList = planCarreraList;
    }
}
