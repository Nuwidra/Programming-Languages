package Modelos;

import java.util.ArrayList;
import java.util.List;

/*
    Clase Padre de personas ya que las personas pueden ser veterinarios o duenios de mascotas

 */
public class PersonaImpl{

    //Constructor
    protected Integer cedula;
    protected String nombre;
    protected String ap1;
    protected String ap2;
    protected String direccion;
    protected String telefono;

    public PersonaImpl(Integer cedula, String nombre, String ap1, String ap2, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Sets y gets
    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp1() {
        return ap1;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getInformacionPersonal(){
        List<String> informacion = new ArrayList<>();
        informacion.add("Nombre: "+nombre+" "+ap1+" "+ap2+"\n");
        informacion.add("Cedula: "+cedula+"\n");
        informacion.add("Direccion: "+direccion+"\n");
        informacion.add("Telefono: "+telefono+"\n");

        return informacion;
    }

}
