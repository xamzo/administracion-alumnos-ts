package cl.ubb.spring.web.administracionalumnosts.dao;


import cl.ubb.spring.web.administracionalumnosts.model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cristobalortiz
 * Date: 13-06-14
 * Time: 0:34
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UsuarioDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Usuario> find(){
       return (List<Usuario>)sessionFactory.getCurrentSession().createCriteria(Usuario.class).list();
    }

    public Usuario findByUserName(String userName){
        System.out.println("username en DAO: "+userName);

        Criteria c=sessionFactory.getCurrentSession().createCriteria(Usuario.class);
        Usuario usu=(Usuario)c.add(Restrictions.eq("username", userName)).uniqueResult();
        return  usu;
    }

    public void save(Usuario usuario){
        sessionFactory.getCurrentSession().save(usuario);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
