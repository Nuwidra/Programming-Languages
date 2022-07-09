package Controlador;

import com.hospital.hospitalVeterinario.HospitalVeterinarioApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
    Esta clase es el controlador de la pagina principal, redirecciona al usuario a la opcion que haya escogido

 */
@Controller
public class SistemaController {

     @GetMapping("/")
     public String menuPrincipal() {
         return "principal";
     }

}