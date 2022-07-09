package Controlador;

import Modelos.*;
import com.hospital.hospitalVeterinario.HospitalVeterinarioApplication;
import forms.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*
    Esta clase es el controlador de la administracion del sistema
    tiene todas las funciones que involucran a la tienda.
    puede consultar, modificar, eliminar, insertar entidades del sistema.
 */
@Controller
public class AdministradorController {

    @GetMapping("/modificarSistema")
    public String menuModificarSistema(){
        return "modificarSistema";
    }

    @GetMapping("/duenios")
    public String menuDuenios(Model model) {
        return "duenios";
    }

    @GetMapping("/duenios/consulta")
    public String consultarDuenio(Model model){
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "dueniosConsulta";
    }

    @PostMapping("/duenios/consulta")
    public String consultarDuenioResultado(@ModelAttribute Form form, Model model){
        DuenioImpl duenio = HospitalVeterinarioApplication.duenios.consultarDuenio(form.getCedulaDuenio());
        if(duenio != null){
            List<String> informacionDuenio = duenio.getInformacionDuenio();
            System.out.println(informacionDuenio);
            form.setInfoDuenio(informacionDuenio);
            form.setInventario(HospitalVeterinarioApplication.inventario.listarInventario());
            model.addAttribute("form", form);
            return "dueniosConsultaResultado";
        }
        return "principal";
    }

    @GetMapping("/duenios/insertar")
    public String insertarDuenio(Model model){
        model.addAttribute("form", new Form());
        return "dueniosInsertar";
    }

    @PostMapping("/duenios/insertar")
    public String insertarDuenioResultado(@ModelAttribute Form form, Model model){

        String[] splitMascotas = form.getMascotasRaw().split(",");

        ArrayList<MascotaImpl> listMascotasImpl = new ArrayList<MascotaImpl>();
        for(int i = 0; i  < splitMascotas.length; i++){
            if(splitMascotas[i] != "") {
                listMascotasImpl.add(HospitalVeterinarioApplication.mascotas.consultarMascota(Integer.parseInt(splitMascotas[i])));
            }
        }
        DuenioImpl duenio = new DuenioImpl(form.getCedulaDuenio(),form.getNombre(),form.getAp1(),form.getAp2(),form.getDireccion(),form.getTelefono(),listMascotasImpl);
        HospitalVeterinarioApplication.duenios.agregarDuenio(duenio);
        return "exito";
    }


    @GetMapping("/duenios/modificar")
    public String modificarDuenio(Model model){
        model.addAttribute("form", new Form());
        return "dueniosModificarConsulta";
    }

    @PostMapping("/duenios/modificar")
    public String buscarModificarDuenio(@ModelAttribute Form form, Model model){
        System.out.println();
        DuenioImpl duenio = HospitalVeterinarioApplication.duenios.consultarDuenio(form.getCedulaDuenio());
        if(duenio!=null){
            form.setCedulaDuenio(duenio.getCedula());
            form.setNombre(duenio.getNombre());
            form.setAp1(duenio.getAp1());
            form.setAp2(duenio.getAp2());
            form.setDireccion(duenio.getDireccion());
            form.setTelefono(duenio.getTelefono());
            String mascotasRaw = "";
            Map<Integer, MascotaImpl> mascotasDeDuenio = duenio.getMascotas();
            for(Map.Entry<Integer,MascotaImpl> entry : mascotasDeDuenio.entrySet()){
                mascotasRaw += Integer.toString(entry.getKey()) + ",";
            }
            form.setMascotasRaw(mascotasRaw);
            model.addAttribute("form", form);
            HospitalVeterinarioApplication.duenios.eliminarDuenio(form.getCedulaDuenio());
            return "dueniosInsertar";
        }

        return "principal";
    }

    @GetMapping("/duenios/eliminar")
    public String eliminarDuenio(Model model){
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "dueniosEliminarConsulta";
    }

    @PostMapping("/duenios/eliminar")
    public String eliminarDuenioResultado(@ModelAttribute Form form, Model model){
        HospitalVeterinarioApplication.duenios.eliminarDuenio((form.getCedulaDuenio()));
        return "exito";
    }

    @GetMapping("/veterinarios")
    public String menuVeterinarios(Model model) {
        return "veterinarios";
    }

    @GetMapping("/veterinarios/consulta")
    public String consultarVeterinario(Model model){
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "veterinariosConsulta";
    }

    @PostMapping("/veterinarios/consulta")
    public String consultarVeterinarioResultado(@ModelAttribute Form form, Model model){
        VeterinarioImpl veterinario = HospitalVeterinarioApplication.veterinarios.consultarVeterinario(form.getCedulaVeterinario());
        if(veterinario != null){
            List<String> informacionDuenio = veterinario.getInformacionPersonal();

            form.setInfoDuenio(informacionDuenio);
            model.addAttribute("form", form);
            return "veterinariosConsultaResultado";
        }
        return "principal";
    }


    @GetMapping("/veterinarios/insertar")
    public String insertarVeterinario(Model model){
        model.addAttribute("form", new Form());
        return "veterinariosInsertar";
    }

    @PostMapping("/veterinarios/insertar")
    public String insertarVeterinarioResultado(@ModelAttribute Form form, Model model){


        VeterinarioImpl veterinario = new VeterinarioImpl(form.getCedulaVeterinario(),form.getNombre(),form.getAp1(),form.getAp2(),form.getDireccion(),form.getTelefono(),form.getEspecialidad(), form.getHorario());
        HospitalVeterinarioApplication.veterinarios.agregarVeterinario(veterinario);
        return "exito";
    }

    @GetMapping("/veterinarios/modificar")
    public String modificarVeterinario(Model model){
        model.addAttribute("form", new Form());
        return "veterinariosModificarConsulta";
    }

    @PostMapping("/veterinarios/modificar")
    public String buscarModificarVeterinario(@ModelAttribute Form form, Model model){
        System.out.println();
        VeterinarioImpl veterinario = HospitalVeterinarioApplication.veterinarios.consultarVeterinario(form.getCedulaVeterinario());
        if(veterinario!=null){
            form.setCedulaVeterinario(veterinario.getCedula());
            form.setNombre(veterinario.getNombre());
            form.setAp1(veterinario.getAp1());
            form.setAp2(veterinario.getAp2());
            form.setDireccion(veterinario.getDireccion());
            form.setTelefono(veterinario.getTelefono());
            form.setEspecialidad(veterinario.getEspecialidad());
            form.setHorario(veterinario.getHorarioAtencion());
            model.addAttribute("form", form);
            HospitalVeterinarioApplication.veterinarios.eliminarVeterinario(form.getCedulaVeterinario());
            return "veterinariosInsertar";
        }

        return "principal";
    }

    @GetMapping("/veterinarios/eliminar")
    public String eliminarVeterinario(Model model){
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "veterinariosEliminarConsulta";
    }

    @PostMapping("/veterinarios/eliminar")
    public String eliminarVeterinarioResultado(@ModelAttribute Form form, Model model){
        HospitalVeterinarioApplication.veterinarios.eliminarVeterinario((form.getCedulaVeterinario()));
        return "exito";
    }


    @GetMapping("/mascotas")
    public String menuMascotas(Model model) {
        return "mascotas";
    }

    @GetMapping("/mascotas/consulta")
    public String consultarMasctota(Model model){
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "mascotasConsulta";
    }

    @PostMapping("/mascotas/consulta")
    public String consultarMascotaResultado(@ModelAttribute Form form, Model model){
        MascotaImpl mascota = HospitalVeterinarioApplication.mascotas.consultarMascota(form.getIdMascota());

        if(mascota != null){
            List<String> info = new ArrayList<>();
            String informacionMascota = mascota.getInformacionMascota();
            info.add(informacionMascota);
            System.out.println(informacionMascota);
            form.setInfoDuenio(info);
            model.addAttribute("form", form);
            return "mascotasConsultaResultado";
        }
        return "principal";
    }

    @GetMapping("/mascotas/insertar")
    public String insertarMascota(Model model){
        model.addAttribute("form", new Form());
        return "mascotasInsertar";
    }

    @PostMapping("/mascotas/insertar")
    public String insertarMascotaResultado(@ModelAttribute Form form, Model model){

        MascotaImpl mascota = new MascotaImpl(form.getIdMascota(),form.getTipo(), form.getNombre(), form.getFecha());
        HospitalVeterinarioApplication.mascotas.agregarMascota(mascota);
        return "exito";
    }

    @GetMapping("/mascotas/modificar")
    public String modificarMascotas(Model model){
        model.addAttribute("form", new Form());
        return "mascotasModificarConsulta";
    }

    @PostMapping("/mascotas/modificar")
    public String buscarModificarMascota(@ModelAttribute Form form, Model model){
        System.out.println();
        MascotaImpl mascota = HospitalVeterinarioApplication.mascotas.consultarMascota(form.getIdMascota());
        if(mascota!=null){
            form.setCedulaVeterinario(mascota.getId());
            form.setNombre(mascota.getNombre());
            form.setTipo(mascota.getTipo());
            form.setFecha(mascota.getFecha_nacimiento());

            model.addAttribute("form", form);
            HospitalVeterinarioApplication.mascotas.eliminarMascota(form.getIdMascota());
            return "mascotasInsertar";
        }

        return "principal";
    }

    @GetMapping("/mascotas/eliminar")
    public String eliminarMascota(Model model){
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "mascotasEliminarConsulta";
    }

    @PostMapping("/mascotas/eliminar")
    public String eliminarMascotaResultado(@ModelAttribute Form form, Model model){
        HospitalVeterinarioApplication.mascotas.eliminarMascota((form.getIdMascota()));
        Map<Integer, DuenioImpl> duenios = HospitalVeterinarioApplication.duenios.getDuenios();
        for(Map.Entry<Integer, DuenioImpl> entry: duenios.entrySet()){
            Map<Integer, MascotaImpl> mascotasDuenio = entry.getValue().getMascotas();
            mascotasDuenio.remove(form.getIdMascota());
            entry.getValue().setMascotas(mascotasDuenio);
            duenios.put(entry.getKey(), entry.getValue());
        }

        return "exito";
    }


    @GetMapping("/productos")
    public String menuProductos(Model model) {
        return "productos";
    }

    @GetMapping("/productos/consulta")
    public String consultarProductos(Model model){
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "productosConsulta";
    }

    @PostMapping("/productos/consulta")
    public String consultarProductosResultado(@ModelAttribute Form form, Model model){
        ProductoImpl producto = HospitalVeterinarioApplication.inventario.buscarProducto(form.getIdProducto());
        if(producto != null){
            List<String> informacionDuenio = producto.getInformacionProducto();

            form.setInfoDuenio(informacionDuenio);
            model.addAttribute("form", form);
            return "productosConsultaResultado";
        }
        return "principal";
    }

    @GetMapping("/productos/insertar")
    public String insertarProducto(Model model){
        model.addAttribute("form", new Form());
        return "productosInsertar";
    }

    @PostMapping("/productos/insertar")
    public String insetarProductoResultado(@ModelAttribute Form form, Model model){

        ProductoImpl producto = new ProductoImpl(form.getIdProducto(), form.getNombre(), form.getDescripcion(), form.getCantidadProducto());
        if(HospitalVeterinarioApplication.inventario.buscarProducto(form.getIdProducto()) == null){
            HospitalVeterinarioApplication.inventario.ingresarNuevoProducto(producto);
            return "exito";
        }
        else{
            return "principal";
        }

    }


    @GetMapping("/productos/modificar")
    public String modificarProducto(Model model){
        model.addAttribute("form", new Form());
        return "productosModificarConsulta";
    }

    @PostMapping("/productos/modificar")
    public String buscarModificarProducto(@ModelAttribute Form form, Model model){
        System.out.println();
        ProductoImpl producto = HospitalVeterinarioApplication.inventario.buscarProducto(form.getIdProducto());
        if(producto!=null){
            form.setIdProducto(producto.getId());
            form.setNombre(producto.getNombre());
            form.setDescripcion(producto.getDescripcion());
            form.setCantidadProducto(producto.getCantidad());
            model.addAttribute("form", form);
            HospitalVeterinarioApplication.inventario.eliminarProducto(form.getIdProducto());
            return "productosInsertar";
        }

        return "principal";
    }

    @GetMapping("/productos/eliminar")
    public String eliminarProducto(Model model){
        model.addAttribute("cedula","");
        model.addAttribute("form", new Form());
        return "productosEliminarConsulta";
    }

    @PostMapping("/productos/eliminar")
    public String eliminarProductoResultado(@ModelAttribute Form form, Model model){
        HospitalVeterinarioApplication.inventario.eliminarProducto((form.getIdProducto()));
        return "exito";
    }

}



