package cl.ubb.spring.web.administracionalumnosts.model.genericos;

import javax.persistence.*;
import java.util.List;

/**
 * Created by w7600PC on 15/07/2014.
 */
@Entity(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long REGION_ID;
    @Column(nullable = false)
    private String REGION_NOMBRE;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "region")
    private List<Provincia> provinciaList;


    public long getREGION_ID() {
        return REGION_ID;
    }

    public void setREGION_ID(long REGION_ID) {
        this.REGION_ID = REGION_ID;
    }

    public String getREGION_NOMBRE() {
        return REGION_NOMBRE;
    }

    public void setREGION_NOMBRE(String REGION_NOMBRE) {
        this.REGION_NOMBRE = REGION_NOMBRE;
    }

    public List<Provincia> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<Provincia> provinciaList) {
        this.provinciaList = provinciaList;
    }
}
