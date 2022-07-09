package Modelos;
import java.util.ArrayList;

/*
    El expediente de la mascota puede guardar tratamientos y productos comprados para la mascota.
    en esta clase cuenta con las funciones necesarias para agregar tratamientos y productos.
    Estos se van a guardar en dos array List

 */
public class ExpedienteImpl implements  Expediente{

    //Constructor
    ArrayList<TratamientoImpl> tratamientos;
    ArrayList<ProductoCompradoImpl> productosComprados;

    public ExpedienteImpl() {
        this.tratamientos = new ArrayList<TratamientoImpl>();
        this.productosComprados = new ArrayList<ProductoCompradoImpl>();
    }

    //Funciones importadas de expediente
    @Override
    public void agregarTratamiento(TratamientoImpl tratamiento) {
        tratamientos.add(tratamiento);
    }

    @Override
    public void agregarProductoComprado(ProductoCompradoImpl productoComprado) {
        productosComprados.add(productoComprado);
    }
    // Sets y gets
    public ArrayList<TratamientoImpl> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(ArrayList<TratamientoImpl> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public ArrayList<ProductoCompradoImpl> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(ArrayList<ProductoCompradoImpl> productosComprados) {
        this.productosComprados = productosComprados;
    }
}
