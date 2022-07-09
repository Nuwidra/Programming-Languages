package Modelos;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Clase de implementacion de la interfaz Inventario


    contiene un HashMap donde se van a almacenar los productos del sistema. la clase tiene funciones para consultar, agregar, modificar y elimnar un producto
    (la funcion agregarProducto puede servir para modificar ya que el mapa sobreescribe el id)
    tambien cuenta con una funcion para imprimir todos los productos del inventario


 */
public class InventarioImpl implements Inventario {

    //Constructor
    Map<Integer,ProductoImpl> productos = new HashMap<Integer, ProductoImpl>();

    //Implementa todas las funciones de la interfaz inventario
    @Override
    public ProductoImpl buscarProducto(int id) {
        return productos.get(id);
    }

    @Override
    public boolean verificarCantidad(ProductoImpl producto, int cantidadDeseada) {
        return producto.getCantidad() >= cantidadDeseada;
    }

    @Override
    public void modificarCantidad(ProductoImpl producto, int nueva_cantidad) {
        producto.setCantidad(producto.getCantidad() + nueva_cantidad);
        productos.put(producto.getId(), producto);
    }

    @Override
    public void ingresarNuevoProducto(ProductoImpl producto) {
        productos.put(producto.getId(), producto);
    }

    public void eliminarProducto(int id){
        productos.remove(id);
    }

    @Override
    public List<String> listarInventario() {
        List<String> inventario = new ArrayList<>();

        for(Map.Entry<Integer,ProductoImpl> entry : productos.entrySet()){
            inventario.addAll(entry.getValue().getInformacionProducto());
        }
        return inventario;
    }


}
