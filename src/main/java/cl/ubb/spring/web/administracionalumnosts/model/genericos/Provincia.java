package cl.ubb.spring.web.administracionalumnosts.model.genericos;

import javax.persistence.*;
import java.util.List;

/**
 * Created by w7600PC on 15/07/2014.
 */
@Entity(name = "provincia")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long PROVINCIA_ID;
    @Column(nullable = false)
    private String PROVINCIA_NOMBRE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCIA_REGION_ID", nullable = false)
    private Region region;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "COMUNA_PROVINCIA_ID")
    private List<Comuna> comunaList;


    public long getPROVINCIA_ID() {
        return PROVINCIA_ID;
    }

    public void setPROVINCIA_ID(long PROVINCIA_ID) {
        this.PROVINCIA_ID = PROVINCIA_ID;
    }

    public String getPROVINCIA_NOMBRE() {
        return PROVINCIA_NOMBRE;
    }

    public void setPROVINCIA_NOMBRE(String PROVINCIA_NOMBRE) {
        this.PROVINCIA_NOMBRE = PROVINCIA_NOMBRE;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Comuna> getComunaList() {
        return comunaList;
    }

    public void setComunaList(List<Comuna> comunaList) {
        this.comunaList = comunaList;
    }
}
