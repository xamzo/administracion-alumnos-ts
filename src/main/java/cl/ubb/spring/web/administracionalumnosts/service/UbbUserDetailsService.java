package cl.ubb.spring.web.administracionalumnosts.service;

import cl.ubb.spring.web.administracionalumnosts.dao.UsuarioDAO;
import cl.ubb.spring.web.administracionalumnosts.model.Rol;
import cl.ubb.spring.web.administracionalumnosts.model.Usuario;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cristobalortiz
 * Date: 16-06-14
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UbbUserDetailsService implements UserDetailsService {
    static Logger log = Logger.getLogger(UbbUserDetailsService.class.getName());
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("inicia login");
        System.out.println("sout unucia login");
        Usuario usuario = null;
        usuario = usuarioDAO.findByUserName(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<Rol> roles = usuario.getRoles();
        for (Rol rol : roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        }
        User user = new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
        log.info("Retorna el usuario");
        return user;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
