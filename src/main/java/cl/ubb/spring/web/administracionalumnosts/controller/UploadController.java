package cl.ubb.spring.web.administracionalumnosts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: cristobalortiz
 * Date: 26-06-14
 * Time: 20:28
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class UploadController {


    @RequestMapping(value = {"/upload-document"}, method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadFile(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        System.out.println("upload.............");
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            return "Archivo Enviado";
        } else {
            return "Archivo No Enviado";
        }
    }
}
