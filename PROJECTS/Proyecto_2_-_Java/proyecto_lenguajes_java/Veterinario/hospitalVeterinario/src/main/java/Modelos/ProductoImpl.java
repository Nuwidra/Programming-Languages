package Modelos;

import java.util.ArrayList;
import java.util.List;


/*
    Clase principal del producto
    tiene una funcion para agarrar toda la informacion del producto, esta funcion sirve para las funciones del sistema
    donde hay que listar los productos

    y cuenta con otra funcion que solicita solamente la informacion importante que necesitan las facturas.

 */
public class ProductoImpl {

    //Constructor
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;

    public ProductoImpl(int id, String nombre, String descripcion, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    // Sets y gets
    public List<String> getInformacionProducto(){
        List<String> informacionProducto = new ArrayList<>();
        informacionProducto.add("id: "+id);
        informacionProducto.add("nombre: "+nombre);
        informacionProducto.add("descripcion: "+descripcion);
        informacionProducto.add("cantidad: "+cantidad);
        return informacionProducto;
    }

    public List<String> getInformacionParaFactura(){
        List<String> informacionProducto = new ArrayList<>();
        informacionProducto.add("id: "+id);
        informacionProducto.add("nombre: "+nombre);
        informacionProducto.add("descripcion: "+descripcion);
        return informacionProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
