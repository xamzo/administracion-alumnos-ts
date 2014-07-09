package cl.ubb.spring.web.administracionalumnosts.controller;

import cl.ubb.spring.web.administracionalumnosts.controller.JsonResponse.JsonResponse;
import cl.ubb.spring.web.administracionalumnosts.model.estado.TipoEstado;
import cl.ubb.spring.web.administracionalumnosts.service.TipoEstadoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by w7600PC on 01/07/2014.
 */
@Controller
@RequestMapping("/tipoestado")
public class TipoEstadoController {
    static Logger log = Logger.getLogger(TipoEstadoController.class.getName());
    @Autowired
    private TipoEstadoService tipoEstadoService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        List<TipoEstado> tipoEstados = tipoEstadoService.findAll();
        log.info("largo de la lista " + tipoEstados.size());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("lista", tipoEstados);
        ModelAndView m = new ModelAndView();
        m.addAllObjects(map);
        m.setViewName("/tipoestado/admin");
        return m;
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TipoEstado> listaTipoEstados(@RequestParam(value = "_search", required = false) Boolean search,
                                      @RequestParam(value = "filters", required = false) String filters,
                                      @RequestParam(value = "page", required = false) Integer page,
                                      @RequestParam(value = "rows", required = false) Integer rows,
                                      @RequestParam(value = "sidx", required = false) String sidx,
                                      @RequestParam(value = "sord", required = false) String sord) {
        return tipoEstadoService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView formCreate() {
        return new ModelAndView("/tipoestado/create", "tipoEstado", new TipoEstado());
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView formUpdate(@PathVariable long id) {
        TipoEstado e = this.tipoEstadoService.findByPk(id);
        return new ModelAndView("/tipoestado/update", "tipoEstado", e);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonResponse saveUpdate(@RequestBody TipoEstado e, @PathVariable long id, BindingResult result) {
        e.setIdTipoEstadoPk(id);
        tipoEstadoService.save(e);
        log.info("llega actualizar y debe retorn<r");
        JsonResponse res = new JsonResponse();
        res.setStatus("SUCCESS");
        res.setResult("Se ha Actualizado Correctamente");
        return res;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    JsonResponse guardar(@RequestBody TipoEstado e, BindingResult result) {
        tipoEstadoService.save(e);
        log.info("llega a guardar y debe retorn<r");
        JsonResponse res = new JsonResponse();
        res.setStatus("SUCCESS");
        res.setResult("Se ha Insertado Correctamente");
        return res;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    JsonResponse delete(@PathVariable long id) {
        this.tipoEstadoService.delete(this.tipoEstadoService.findByPk(id));
        JsonResponse res = new JsonResponse();
        res.setStatus("SUCCESS");
        res.setResult("Se ha eliminado Correctamente");
        return res;
    }


    public TipoEstadoService getTipoEstadoService() {
        return tipoEstadoService;
    }

    public void setTipoEstadoService(TipoEstadoService tipoEstadoService) {
        this.tipoEstadoService = tipoEstadoService;
    }
}
