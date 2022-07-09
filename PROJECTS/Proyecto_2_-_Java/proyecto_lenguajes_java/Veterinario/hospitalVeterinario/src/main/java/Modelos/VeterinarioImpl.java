package Modelos;

import java.util.*;


/*
    Clase que hereda de persona, sirve especificamente para guardar personas de tipo veterinarios, cuenta con una funcion que devuelve toda su informacion para ser
    imprimida en la web
    
 */
public class VeterinarioImpl extends PersonaImpl {

    //Constructor
    String horarioAtencion;
    String especialidad;

    public VeterinarioImpl(Integer cedula, String nombre, String ap1, String ap2, String direccion, String telefono, String especialidad, String horarioAtencion) {
        super(cedula, nombre, ap1, ap2, direccion, telefono);
        this.especialidad = especialidad;
        this.horarioAtencion = horarioAtencion;
    }

    public List<String> getInformacionPersonal(){
        List<String> informacion = new ArrayList<>();
        informacion.add("Nombre: "+nombre+" "+ap1+" "+ap2+"\n");
        informacion.add("Cedula: "+cedula+"\n");
        informacion.add("Direccion: "+direccion+"\n");
        informacion.add("Telefono: "+telefono+"\n");
        informacion.add("Especialidad: "+especialidad+"\n");
        informacion.add("horario de atencion: "+horarioAtencion+"\n");

        return informacion;
    }

    // Sets y gets
    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
