package Modelos;

import java.util.List;

public interface Inventario {
    /*Interfaz Inventario con las funciones:
        -buscarProducto
        -verificarCantidad
        -modificarCantidad
        -ingresarNuevoProducto
        -eliminarProducto
        -listarInventario
     */
    public ProductoImpl buscarProducto(int id);
    public boolean verificarCantidad(ProductoImpl producto, int cantidadDeseada);
    public void modificarCantidad(ProductoImpl producto, int nueva_cantidad);
    public void ingresarNuevoProducto(ProductoImpl producto);
    public void eliminarProducto(int cantidad);
    public List<String> listarInventario();




}
