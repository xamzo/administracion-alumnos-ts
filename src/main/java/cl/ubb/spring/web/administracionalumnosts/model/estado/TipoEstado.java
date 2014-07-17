package cl.ubb.spring.web.administracionalumnosts.model.estado;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by w7600PC on 01/07/2014.
 */
@Entity
@Table(name = "tipo_estado")
public class TipoEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipoEstadoPk;
    @Column(nullable = false)
    private String nombreTipoEstado;

    @JsonIgnore(true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoEstado")
    private List<Estado> estadoList;

    public long getIdTipoEstadoPk() {
        return idTipoEstadoPk;
    }

    public void setIdTipoEstadoPk(long idTipoEstadoPk) {
        this.idTipoEstadoPk = idTipoEstadoPk;
    }

    public String getNombreTipoEstado() {
        return nombreTipoEstado;
    }

    public void setNombreTipoEstado(String nombreTipoEstado) {
        this.nombreTipoEstado = nombreTipoEstado;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }
}
