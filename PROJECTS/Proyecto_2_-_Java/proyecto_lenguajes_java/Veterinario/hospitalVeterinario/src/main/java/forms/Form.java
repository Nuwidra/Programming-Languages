package forms;

import java.util.List;

public class Form {

    //Constructor
    int cedulaDuenio;
    List<String> infoDuenio;
    int cedulaVeterinario;
    int idMascota;
    int idMedicamento;
    int idProducto;
    int cantidadProducto;
    List<String> inventario;
    List<String> mascotas;
    String observacion;
    String nombre;
    String ap1;
    String ap2;
    String direccion;
    String telefono;
    String mascotasRaw;
    String especialidad;
    String horario;
    String tipo;
    String fecha;
    String descripcion;


    //Definicion de todos los gets y sets que se van a usar en el programa.
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    public String getMascotasRaw() {
        return mascotasRaw;
    }

    public void setMascotasRaw(String mascotasRaw) {
        this.mascotasRaw = mascotasRaw;
    }

    public List<String> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<String> mascotas) {
        this.mascotas = mascotas;
    }

    public List<String> getInventario() {
        return inventario;
    }

    public void setInventario(List<String> productos) {
        this.inventario = productos;
    }

    public String getObservacion() {
        return observacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public List<String> getInfoDuenio() {
        return infoDuenio;
    }

    public void setInfoDuenio(List<String> infoDuenio) {
        this.infoDuenio = infoDuenio;
    }

    public int getCedulaDuenio() {
        return cedulaDuenio;
    }

    public void setCedulaDuenio(int cedulaDuenio) {
        this.cedulaDuenio = cedulaDuenio;
    }

    public int getCedulaVeterinario() {
        return cedulaVeterinario;
    }

    public void setCedulaVeterinario(int cedulaVeterinario) {
        this.cedulaVeterinario = cedulaVeterinario;
    }
}
