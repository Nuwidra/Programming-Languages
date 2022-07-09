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
    Esta clase es el controlador del apartado de la Tienda del sistema
    tiene todas las funciones que involucran a la tienda.

 */
@Controller
public class TiendaController {


    @GetMapping("/tienda")
    public String menuConsultas(Model model) {
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "tienda";
    }

    @PostMapping("/tienda")
    public String ingresoDeCedula(@ModelAttribute Form form, Model model) {

        DuenioImpl duenio = HospitalVeterinarioApplication.duenios.consultarDuenio(form.getCedulaDuenio());
        if(duenio != null){
            List<String> informacionDuenio = duenio.getInformacionDuenio();
            System.out.println(informacionDuenio);
            form.setInfoDuenio(informacionDuenio);
            form.setInventario(HospitalVeterinarioApplication.inventario.listarInventario());
            model.addAttribute("form", form);
            return "tiendaInfoDuenio";
        }
        return "principal";
    }

    @PostMapping("/tienda/submit")
    public String ingresarCompraTienda(@ModelAttribute Form form, Model model) {
        Random rand = new Random();
        System.out.println("dentro del ingreso xD");
        //veo si hay cantidad de producto necesario
        ProductoImpl producto = HospitalVeterinarioApplication.inventario.buscarProducto(form.getIdProducto());
        if(HospitalVeterinarioApplication.inventario.verificarCantidad(producto, form.getCantidadProducto())){
            HospitalVeterinarioApplication.inventario.modificarCantidad(producto, -1* form.getCantidadProducto());

            //agrego la compra al expediente de la mascota

            ProductoCompradoImpl productoComprado = new ProductoCompradoImpl( rand.nextInt(1000000000), java.time.LocalDate.now(), producto, form.getCantidadProducto() );
            MascotaImpl mascota = HospitalVeterinarioApplication.mascotas.consultarMascota(form.getIdMascota());


            ExpedienteImpl expediente = mascota.getExpediente();
            expediente.agregarProductoComprado(productoComprado);
            mascota.setExpediente(expediente);

            HospitalVeterinarioApplication.mascotas.agregarMascota(mascota);

            //agrego informacion a la factura
            System.out.println(form.getCedulaDuenio());
            DuenioImpl duenio = HospitalVeterinarioApplication.duenios.consultarDuenio(form.getCedulaDuenio());
            FacturaTiendaImpl factura = new FacturaTiendaImpl(rand.nextInt(1000000000), java.time.LocalDate.now(), productoComprado);
            duenio.agregarFacturaTienda(factura);
            HospitalVeterinarioApplication.duenios.agregarDuenio(duenio);

            return "exito";
        }

        return "principal";
    }


}
