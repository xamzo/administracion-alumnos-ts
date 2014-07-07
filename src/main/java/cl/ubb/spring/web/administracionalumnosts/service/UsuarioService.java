package cl.ubb.spring.web.administracionalumnosts.service;

import cl.ubb.spring.web.administracionalumnosts.dao.UsuarioDAO;
import cl.ubb.spring.web.administracionalumnosts.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cristobalortiz
 * Date: 13-06-14
 * Time: 0:41
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Transactional
    public List<Usuario> getAll() {
        return usuarioDAO.find();
    }

    @Transactional
    public void create(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
