package cl.ubb.spring.web.administracionalumnosts.model.genericos;


import javax.persistence.*;

/**
 * Created by w7600PC on 15/07/2014.
 */
@Entity(name = "comuna")
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long COMUNA_ID;
    @Column(nullable = false)
    private String COMUNA_NOMBRE;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMUNA_PROVINCIA_ID", nullable = false)
    private Provincia COMUNA_PROVINCIA_ID;

    public long getCOMUNA_ID() {
        return COMUNA_ID;
    }

    public void setCOMUNA_ID(long COMUNA_ID) {
        this.COMUNA_ID = COMUNA_ID;
    }

    public String getCOMUNA_NOMBRE() {
        return COMUNA_NOMBRE;
    }

    public void setCOMUNA_NOMBRE(String COMUNA_NOMBRE) {
        this.COMUNA_NOMBRE = COMUNA_NOMBRE;
    }

    public Provincia getCOMUNA_PROVINCIA_ID() {
        return COMUNA_PROVINCIA_ID;
    }

    public void setCOMUNA_PROVINCIA_ID(Provincia COMUNA_PROVINCIA_ID) {
        this.COMUNA_PROVINCIA_ID = COMUNA_PROVINCIA_ID;
    }
}
