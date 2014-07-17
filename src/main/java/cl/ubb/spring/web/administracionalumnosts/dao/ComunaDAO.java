package cl.ubb.spring.web.administracionalumnosts.dao;

import cl.ubb.spring.web.administracionalumnosts.model.genericos.Comuna;
import cl.ubb.spring.web.administracionalumnosts.model.genericos.Provincia;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by w7600PC on 15/07/2014.
 */
public class ComunaDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Comuna> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Comuna.class).list();
    }

    public Comuna findByPk(long id) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Comuna.class);
        c.add(Restrictions.eq("COMUNA_ID", id));
        return (Comuna) c.uniqueResult();
    }

    public List<Comuna> findAllByTipoEstado(Provincia t) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(Comuna.class);
        c.add(Restrictions.eq("idProvinciaFk", t.getPROVINCIA_ID()));
        return (List<Comuna>) c.list();
    }
}
