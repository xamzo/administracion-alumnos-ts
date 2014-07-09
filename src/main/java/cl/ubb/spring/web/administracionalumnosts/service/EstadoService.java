package cl.ubb.spring.web.administracionalumnosts.service;

import cl.ubb.spring.web.administracionalumnosts.dao.EstadoDAO;
import cl.ubb.spring.web.administracionalumnosts.model.estado.Estado;
import cl.ubb.spring.web.administracionalumnosts.model.estado.TipoEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by w7600PC on 02/07/2014.
 */
@Service
public class EstadoService {
    @Autowired
    private EstadoDAO estadoDAO;

    public Estado findByPk(long id) {
        return this.estadoDAO.findByPk(id);
    }

    public List<Estado> findAll() {
        return this.estadoDAO.findAll();
    }

    public List<Estado> findByTipoEstado(TipoEstado t) {
        return this.estadoDAO.findAllByTipoEstado(t);
    }

    public void save(Estado e) {
        this.estadoDAO.save(e);
    }

    public EstadoDAO getEstadoDAO() {
        return estadoDAO;
    }

    public void setEstadoDAO(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }
}
