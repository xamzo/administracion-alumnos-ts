package cl.ubb.spring.web.administracionalumnosts.service;

import cl.ubb.spring.web.administracionalumnosts.dao.TipoEstadoDAO;
import cl.ubb.spring.web.administracionalumnosts.model.estado.TipoEstado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by w7600PC on 01/07/2014.
 */
@Service
public class TipoEstadoService {
    @Autowired
    private TipoEstadoDAO tipoEstadoDAO;

    @Transactional
    public TipoEstado findByPk(long id) {
        return this.tipoEstadoDAO.findByPk(id);
    }

    @Transactional
    public List<TipoEstado> findAll() {
        return this.tipoEstadoDAO.findAll();
    }

    @Transactional
    public void save(TipoEstado t) {
        this.tipoEstadoDAO.save(t);
    }

    @Transactional
    public void delete(TipoEstado t) {
        this.tipoEstadoDAO.delete(t);
    }

    public TipoEstadoDAO getTipoEstadoDAO() {
        return tipoEstadoDAO;
    }

    public void setTipoEstadoDAO(TipoEstadoDAO tipoEstadoDAO) {
        this.tipoEstadoDAO = tipoEstadoDAO;
    }
}
