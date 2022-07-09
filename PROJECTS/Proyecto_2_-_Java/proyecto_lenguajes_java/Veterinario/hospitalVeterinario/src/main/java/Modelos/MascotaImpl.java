package Modelos;

import java.util.ArrayList;
import java.util.Date;


/*
    clase de implementacion de la interfaz Mascota

 */
public class MascotaImpl {

    //Constructor
    int id;
    String tipo;
    String nombre;
    String fecha_nacimiento;
    ExpedienteImpl expediente;

    public MascotaImpl(int id, String tipo, String nombre, String fecha_nacimiento) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        expediente = new ExpedienteImpl();
    }

    // Sets y gets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public ExpedienteImpl getExpediente() {
        return expediente;
    }

    public void setExpediente(ExpedienteImpl expediente) {
        this.expediente = expediente;
    }

    /*
        Devuelve un String con la informacion de la mascota

     */
    public String getInformacionMascota(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Id: "+id +"\n");
        stringBuilder.append("Nombre: "+nombre+"\n");
        stringBuilder.append("Tipo: "+tipo+"\n");
        return stringBuilder.toString();
    }
    /*
        funcion que recibe la cedula de un veterinario
        y devuelve true si la mascota ha sido atendida por ese veterinario
        false si la mascota no ha sido atendida por ese veterinario

     */
    public boolean atendidoPorVeterinario(int cedula){
        ArrayList<TratamientoImpl> tratamientos = expediente.getTratamientos();
        for(int i = 0; i < tratamientos.size(); i++){
            if(tratamientos.get(i).getVeterinario().getCedula() == cedula){
                return true;
            }
        }
        return false;
    }

}
