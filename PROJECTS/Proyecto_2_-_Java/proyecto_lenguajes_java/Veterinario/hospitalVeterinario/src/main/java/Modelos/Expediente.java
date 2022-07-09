package Modelos;

public interface Expediente {

    //Interfaz Expediente con las funciones agregar tratamiento y producto comprado
    public void agregarTratamiento(TratamientoImpl tratamiento);
    public void agregarProductoComprado(ProductoCompradoImpl productoComprado);

}
