package cl.ubb.spring.web.administracionalumnosts.service;

import cl.ubb.spring.web.administracionalumnosts.dao.EstadoDAO;
import cl.ubb.spring.web.administracionalumnosts.model.estado.Estado;
import cl.ubb.spring.web.administracionalumnosts.model.estado.TipoEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by w7600PC on 02/07/2014.
 */
@Service
public class EstadoService {
    @Autowired
    private EstadoDAO estadoDAO;

    @Transactional
    public Estado findByPk(long id) {
        return this.estadoDAO.findByPk(id);
    }

    @Transactional
    public List<Estado> findAll() {
        return this.estadoDAO.findAll();
    }

    @Transactional
    public List<Estado> findByTipoEstado(TipoEstado t) {
        return this.estadoDAO.findAllByTipoEstado(t);
    }

    @Transactional
    public void save(Estado e) {
        this.estadoDAO.save(e);
    }

    @Transactional
    public void delete(Estado t) {
        this.estadoDAO.delete(t);
    }

    public EstadoDAO getEstadoDAO() {
        return estadoDAO;
    }

    public void setEstadoDAO(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }
}
