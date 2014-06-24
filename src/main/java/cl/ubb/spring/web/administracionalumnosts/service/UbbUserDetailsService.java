package cl.ubb.spring.web.administracionalumnosts.service;

import cl.ubb.spring.web.administracionalumnosts.dao.UsuarioDAO;
import cl.ubb.spring.web.administracionalumnosts.model.Rol;
import cl.ubb.spring.web.administracionalumnosts.model.Usuario;
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

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = null;
        usuario = usuarioDAO.findByUserName(username);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<Rol>roles=usuario.getRoles();
        for (Rol rol:roles) {
            authorities.add(new SimpleGrantedAuthority(rol.getName()));
        }




        User user= new User(usuario.getUsername(),usuario.getPassword(),
        true,true, true, true,authorities);

        return user;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
}
