package Modelos;

import java.time.LocalDate;
import java.util.Date;

/*
Esta es la clase padre de las facturas, ya que hay facturas de varios tipos
en esta clase se almacena lo que toda factura tiene: fecha y productos comprados

 */
public class FacturaImpl{

    //Constructor
    LocalDate fecha;
    ProductoCompradoImpl productos;

    public FacturaImpl(LocalDate fecha, ProductoCompradoImpl productos) {
        this.fecha = fecha;
        this.productos = productos;
    }

    // Sets y gets
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ProductoCompradoImpl getProductos() {
        return productos;
    }

    public void setProductos(ProductoCompradoImpl productos) {
        this.productos = productos;
    }
}
