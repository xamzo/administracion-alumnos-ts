package cl.ubb.spring.web.administracionalumnosts.dao;

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
public class TipoEstadoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(TipoEstado t) {

        this.sessionFactory.getCurrentSession().saveOrUpdate(t);
    }

    public void delete(TipoEstado t) {
        this.sessionFactory.getCurrentSession().delete(t);
    }

    public List<TipoEstado> findAll() {
        return (List<TipoEstado>) this.sessionFactory.getCurrentSession().createCriteria(TipoEstado.class).list();
    }

    public TipoEstado findByPk(long id) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(TipoEstado.class);
        c.add(Restrictions.eq("idTipoEstadoPk", id));
        return (TipoEstado) c.uniqueResult();
    }
}
