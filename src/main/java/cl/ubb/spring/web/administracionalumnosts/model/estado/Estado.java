package cl.ubb.spring.web.administracionalumnosts.model.estado;

import javax.persistence.*;
import java.util.List;

/**
 * Created by w7600PC on 01/07/2014.
 */
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstadoPk;

    @Column(nullable = false)
    private String nombreEstado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoEstadoFk", nullable = false)
    private TipoEstado tipoEstado;

    public TipoEstado getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public long getIdEstadoPk() {
        return idEstadoPk;
    }

    public void setIdEstadoPk(long idEstadoPk) {
        this.idEstadoPk = idEstadoPk;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
