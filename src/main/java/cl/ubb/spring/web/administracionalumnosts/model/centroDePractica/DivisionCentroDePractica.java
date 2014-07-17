package cl.ubb.spring.web.administracionalumnosts.model.centroDePractica;

/**
 * Created by w7600PC on 15/07/2014.
 */

import javax.persistence.*;
import java.util.List;

/**
 * Esta Clase representa cualquier división dentro de un centro de práctica
 * - Una unidad
 * - Departamento
 * - Programa
 * - etc
 * <p/>
 * Además una división puede tener sub-divisiones
 */
@Entity
@Table(name = "division_centro_practica")
public class DivisionCentroDePractica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDivisionCentroDePracticaPk;
    @Column(nullable = false)
    private String nombreDivisionCentroPractica;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCentroDePracticaFk", nullable = true)
    private CentroDePractica centroDePractica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDivisionCentroDePracticaFk", nullable = true)
    private DivisionCentroDePractica divisionCentroDePracticaPadre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "divisionCentroDePracticaPadre")
    private List<DivisionCentroDePractica> divisionCentroDePracticasHijo;

    public long getIdDivisionCentroDePracticaPk() {
        return idDivisionCentroDePracticaPk;
    }

    public void setIdDivisionCentroDePracticaPk(long idDivisionCentroDePracticaPk) {
        this.idDivisionCentroDePracticaPk = idDivisionCentroDePracticaPk;
    }

    public String getNombreDivisionCentroPractica() {
        return nombreDivisionCentroPractica;
    }

    public void setNombreDivisionCentroPractica(String nombreDivisionCentroPractica) {
        this.nombreDivisionCentroPractica = nombreDivisionCentroPractica;
    }

    public DivisionCentroDePractica getDivisionCentroDePracticaPadre() {
        return divisionCentroDePracticaPadre;
    }

    public void setDivisionCentroDePracticaPadre(DivisionCentroDePractica divisionCentroDePracticaPadre) {
        this.divisionCentroDePracticaPadre = divisionCentroDePracticaPadre;
    }

    public List<DivisionCentroDePractica> getDivisionCentroDePracticasHijo() {
        return divisionCentroDePracticasHijo;
    }

    public void setDivisionCentroDePracticasHijo(List<DivisionCentroDePractica> divisionCentroDePracticasHijo) {
        this.divisionCentroDePracticasHijo = divisionCentroDePracticasHijo;
    }

    public CentroDePractica getCentroDePractica() {
        return centroDePractica;
    }

    public void setCentroDePractica(CentroDePractica centroDePractica) {
        this.centroDePractica = centroDePractica;
    }
}
