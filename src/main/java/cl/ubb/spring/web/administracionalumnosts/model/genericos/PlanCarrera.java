package cl.ubb.spring.web.administracionalumnosts.model.genericos;

import javax.persistence.*;

/**
 * Created by w7600PC on 01/07/2014.
 */
@Entity
@Table(name = "plan_carrera")
public class PlanCarrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPlanCarrera;

    @Column(nullable = false)
    private int codigoPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrera_fk", nullable = false)
    private Carrera carrera;

    public long getIdPlanCarrera() {
        return idPlanCarrera;
    }

    public void setIdPlanCarrera(long idPlanCarrera) {
        this.idPlanCarrera = idPlanCarrera;
    }

    public int getCodigoPlan() {
        return codigoPlan;
    }

    public void setCodigoPlan(int codigoPlan) {
        this.codigoPlan = codigoPlan;
    }
}
