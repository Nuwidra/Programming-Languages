package Modelos;


import java.time.LocalDate;
/*
    Esta clase sirve para colocar el producto comprado en la factura correspondiente, va a tener toda la informacion correspondiente del dia de la compra, la cantidad que se compro
    y el producto que se compro
 */
public class ProductoCompradoImpl {

    //Constructor
    int id;
    LocalDate fecha;
    ProductoImpl producto;
    int cantidad;

    public ProductoCompradoImpl(int id, LocalDate fecha, ProductoImpl producto, int cantidad) {
        this.id = id;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Sets y gets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ProductoImpl getProducto() {
        return producto;
    }

    public void setProducto(ProductoImpl producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
