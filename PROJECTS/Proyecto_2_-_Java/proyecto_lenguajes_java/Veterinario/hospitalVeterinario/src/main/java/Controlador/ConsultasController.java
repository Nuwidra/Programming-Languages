package Controlador;

import Modelos.*;
import com.hospital.hospitalVeterinario.HospitalVeterinarioApplication;
import forms.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Random;
/*
    Esta clase es el controlador del apartado de las consultas medicas del sistema
    tiene todas las funciones que involucran a las consultas medicas.

 */
@Controller
public class ConsultasController {

    @GetMapping("/consultas")
    public String menuConsultas(Model model) {
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "consultas";
    }

    @PostMapping("/consultas")
    public String ingresoDeCedula(@ModelAttribute Form form, Model model) {
        DuenioImpl duenio = HospitalVeterinarioApplication.duenios.consultarDuenio(form.getCedulaDuenio());
        if(duenio != null){
            List<String> informacionDuenio = duenio.getInformacionDuenio();
            System.out.println(informacionDuenio);
            form.setInfoDuenio(informacionDuenio);
            form.setInventario(HospitalVeterinarioApplication.inventario.listarInventario());
            model.addAttribute("form", form);
            return "consultasInfoDuenio";
        }
        return "principal";
    }


    /*
    Esta funcion toma los datos del formulario de la consulta medica y genera la factura para el duenio de la mascota, tambien a;ade al expediente de

     */
    @PostMapping("/consultas/submit")
    public String ingresarConsulta(@ModelAttribute Form form, Model model) {
        Random rand = new Random();
        //veo si hay cantidad de producto necesario
        ProductoImpl producto = HospitalVeterinarioApplication.inventario.buscarProducto(form.getIdMedicamento());
        if(HospitalVeterinarioApplication.inventario.verificarCantidad(producto, form.getCantidadProducto())){
            HospitalVeterinarioApplication.inventario.modificarCantidad(producto, -1* form.getCantidadProducto());

            //agrego el tratamiento de la medicina a la mascota

            ProductoCompradoImpl productoComprado = new ProductoCompradoImpl( rand.nextInt(1000000000), java.time.LocalDate.now(), producto, form.getCantidadProducto() );
            MascotaImpl mascota = HospitalVeterinarioApplication.mascotas.consultarMascota(form.getIdMascota());
            VeterinarioImpl veterinario = HospitalVeterinarioApplication.veterinarios.consultarVeterinario(form.getCedulaVeterinario());
            TratamientoImpl tratamiento = new TratamientoImpl(rand.nextInt(1000000000), java.time.LocalDate.now(), form.getObservacion(), veterinario, productoComprado);


            ExpedienteImpl expediente = mascota.getExpediente();
            expediente.agregarTratamiento(tratamiento);
            mascota.setExpediente(expediente);

            HospitalVeterinarioApplication.mascotas.agregarMascota(mascota);

            //agrego informacion a la factura
            System.out.println(form.getCedulaDuenio());
            DuenioImpl duenio = HospitalVeterinarioApplication.duenios.consultarDuenio(form.getCedulaDuenio());
            FacturaConsultaImpl factura = new FacturaConsultaImpl(rand.nextInt(1000000000), "Consulta medica", java.time.LocalDate.now(), productoComprado);
            duenio.agregarFacturaConsulta(factura);
            HospitalVeterinarioApplication.duenios.agregarDuenio(duenio);

            return "exito";
        }

        return "principal";
    }



}
