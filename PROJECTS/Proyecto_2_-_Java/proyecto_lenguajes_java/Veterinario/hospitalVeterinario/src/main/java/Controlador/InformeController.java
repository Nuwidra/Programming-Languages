package Controlador;

import Modelos.DuenioImpl;
import Modelos.Duenios;
import Modelos.MascotaImpl;
import com.hospital.hospitalVeterinario.HospitalVeterinarioApplication;
import forms.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    Esta clase es el controlador del apartado de los informes del sistema
    tiene todas las funciones que involucran a los informes.

 */
@Controller
public class InformeController {

    @GetMapping("/informes")
    public String menuInformes() {
        return "informes";
    }

    @GetMapping("/listaMascotas")
    public String listarMascotas(@ModelAttribute Form form, Model model) {
        form = new Form();
        form.setMascotas(HospitalVeterinarioApplication.mascotas.listarMascotas());
        model.addAttribute("form", form);

        return "listaMascotas";
    }

    @GetMapping("/listaProductos")
    public String listarProductos(@ModelAttribute Form form, Model model) {
        form = new Form();
        form.setInventario(HospitalVeterinarioApplication.inventario.listarInventario());
        model.addAttribute("form", form);

        return "listaProductos";
    }
    @GetMapping("/listaDueniosMascotas")
    public String listarClientesYMascotas(@ModelAttribute Form form, Model model) {



        List<String> lista = new ArrayList<>();
        Map<Integer,DuenioImpl> duenios = HospitalVeterinarioApplication.duenios.getDuenios();
        for(Map.Entry<Integer, DuenioImpl> entry: duenios.entrySet()){
            lista.addAll(entry.getValue().getInformacionDuenio());
        }

        form = new Form();
        form.setInfoDuenio(lista);
        model.addAttribute("form", form);


        return "listaDueniosMascotas";
    }

    @GetMapping("/mascotasAtendidasPorVeterinario")
    public String solicitarCedulaVeterinario(Model model) {
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "mascotasAtendidasPorVeterinario";
    }

    @PostMapping("/listaMascotasAtendidasPorVeterinario")
    public String listarMascotasDeVeterinario(@ModelAttribute Form form, Model model) {

        List<String> lista = new ArrayList<>();
        Map<Integer, MascotaImpl> mascotas = HospitalVeterinarioApplication.mascotas.getMascotas();
        for(Map.Entry<Integer, MascotaImpl> entry: mascotas.entrySet()){
            if(entry.getValue().atendidoPorVeterinario(form.getCedulaVeterinario())){
                lista.add(entry.getValue().getInformacionMascota());
            }
        }

        form = new Form();
        form.setInfoDuenio(lista);
        model.addAttribute("form", form);
        return "listaMascotasAtendidasPorVeterinario";
    }

    @GetMapping("/listaFacturas")
    public String solicitarCedulaDuenio(Model model) {
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "listafacturas";
    }

    @PostMapping("/listaFacturas")
    public String listarFacturas(@ModelAttribute Form form, Model model) {

        List<String> lista = new ArrayList<>();
        DuenioImpl duenio = HospitalVeterinarioApplication.duenios.consultarDuenio(form.getCedulaDuenio());


        form = new Form();
        form.setInfoDuenio(duenio.listarFacturas());
        model.addAttribute("form", form);
        return "listaFacturas2";
    }


}
