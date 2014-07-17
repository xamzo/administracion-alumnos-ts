package cl.ubb.spring.web.administracionalumnosts.controller;

import cl.ubb.spring.web.administracionalumnosts.controller.JsonResponse.JsonResponse;
import cl.ubb.spring.web.administracionalumnosts.model.estado.Estado;
import cl.ubb.spring.web.administracionalumnosts.model.estado.TipoEstado;
import cl.ubb.spring.web.administracionalumnosts.service.EstadoService;
import cl.ubb.spring.web.administracionalumnosts.service.TipoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by w7600PC on 13/07/2014.
 */
@Controller
@RequestMapping("/estado")
public class EstadoController {
    static Logger log = Logger.getLogger(EstadoController.class.getName());
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private TipoEstadoService tipoEstadoService;


    public EstadoService getEstadoService() {
        return estadoService;
    }

    public void setEstadoService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public TipoEstadoService getTipoEstadoService() {
        return tipoEstadoService;
    }

    public void setTipoEstadoService(TipoEstadoService tipoEstadoService) {
        this.tipoEstadoService = tipoEstadoService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView m = new ModelAndView();
        m.setViewName("/estado/admin");
        return m;
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Estado> listaEstados() {
        return estadoService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView formCreate() {
        List<TipoEstado> tiposDeEstado = tipoEstadoService.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listaTipoEstado", tiposDeEstado);
        map.put("estado", new Estado());
        ModelAndView m = new ModelAndView();
        m.setViewName("/estado/create");
        m.addAllObjects(map);
        return m;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView formUpdate(@PathVariable long id) {
        Estado e = this.estadoService.findByPk(id);
        List<TipoEstado> tiposDeEstado = tipoEstadoService.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listaTipoEstado", tiposDeEstado);
        map.put("estado", e);
        ModelAndView m = new ModelAndView();
        m.setViewName("/estado/update");
        m.addAllObjects(map);
        return m;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse saveUpdate(@ModelAttribute("estado") Estado e, @PathVariable long id, BindingResult result) {
        e.setIdEstadoPk(id);
        log.info("llega actualizar y debe retorn<r");
        JsonResponse res = new JsonResponse();
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "nombreEstado", "El nombre no puede ser vacío");
        if (!result.hasErrors()) {
            estadoService.save(e);
            res.setStatus("SUCCESS");
            res.setResult("Se ha Insertado Correctamente");
        } else {
            res.setStatus("FAIL");
            res.setResult(result.getAllErrors());
        }
        return res;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse guardar(@ModelAttribute("estado") Estado e, BindingResult result, Model model) {
        log.info("llega a guardar y debe retorn<r");
        log.info(e.getNombreEstado() + " " + e.getTipoEstado());
        JsonResponse res = new JsonResponse();
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "nombreEstado", "El nombre no puede ser vacío");
        if (!result.hasErrors()) {
            estadoService.save(e);
            res.setStatus("SUCCESS");
            res.setResult("Se ha Insertado Correctamente");
        } else {
            res.setStatus("FAIL");
            res.setResult(result.getAllErrors());
        }
        return res;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    JsonResponse delete(@PathVariable long id) {
        this.estadoService.delete(this.estadoService.findByPk(id));
        JsonResponse res = new JsonResponse();
        res.setStatus("SUCCESS");
        res.setResult("Se ha eliminado Correctamente");
        return res;
    }


}
