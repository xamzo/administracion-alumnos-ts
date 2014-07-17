package cl.ubb.spring.web.administracionalumnosts.controller;

import cl.ubb.spring.web.administracionalumnosts.model.usuario.Usuario;
import cl.ubb.spring.web.administracionalumnosts.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cristobalortiz
 * Date: 11-06-14
 * Time: 23:39
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HelloControler {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView home() {

//        Usuario usuario = new Usuario();
//        usuario.setApellido("apellido");
//        usuario.setNombre("nombre");
//        usuario.setRut("rut");
//        usuario.setUsername("ubb");
//        usuario.setPassword("1234");
//
//        Rol r= new Rol();
//        r.setName("ROL_ADMIN");
//        List roles= new  ArrayList<Rol>();
//        roles.add(r);
//        usuario.setRoles(roles);
//
//        usuarioService.create(usuario);

        List<Usuario> user = usuarioService.getAll();
        System.out.println("lista de usuario111: " + user);
        String mensaje = "Bienvenido (Mensaje desde el controller MVC)";

        ModelAndView model = new ModelAndView("index");
        model.addObject("mensaje", mensaje);

        return model;

    }

    @RequestMapping(value = {"/admin**",}, method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView("admin");
        return model;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
