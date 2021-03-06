package cl.ubb.spring.web.administracionalumnosts.dao;

import cl.ubb.spring.web.administracionalumnosts.model.estado.Estado;
import cl.ubb.spring.web.administracionalumnosts.model.estado.TipoEstado;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by w7600PC on 01/07/2014.
 */
@Repository
public class EstadoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Estado findByPk(long id) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Estado.class);
        c.add(Restrictions.eq("idEstadoPk", id));
        return (Estado) c.uniqueResult();
    }


    public List<Estado> findAll() {
        return (List<Estado>) sessionFactory.getCurrentSession().createCriteria(Estado.class).list();
    }


    public List<Estado> findAllByTipoEstado(TipoEstado t) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Estado.class);
        c.add(Restrictions.eq("idTipoEstadoFk", t.getIdTipoEstadoPk()));
        return (List<Estado>) c.list();
    }


    public void save(Estado e) {
        this.sessionFactory.getCurrentSession().save(e);
    }

    public void delete(Estado t) {
        this.sessionFactory.getCurrentSession().delete(t);
    }

}
