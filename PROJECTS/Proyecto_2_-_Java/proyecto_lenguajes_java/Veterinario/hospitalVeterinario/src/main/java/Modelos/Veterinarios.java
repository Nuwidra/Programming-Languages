package Modelos;

import java.util.HashMap;
import java.util.Map;
/*

    Contiene un HashMap donde se van a almacenar los veterinarios del sistema. la clase tiene funciones para consultar, agregar, modificar y elimnar un veterinario
    (la funcion agregarVeterinario puede servir para modificar ya que el mapa sobreescribe el id)
    tambien cuenta con una funcion para imprimir todos los veterinarios del sistema

 */
public class Veterinarios {
    Map<Integer, VeterinarioImpl> veterinarios = new HashMap<Integer,VeterinarioImpl>();

    public void agregarVeterinario(VeterinarioImpl veterinario) {
        veterinarios.put(veterinario.getCedula(), veterinario);
    }

    public void eliminarVeterinario(int cedula){
        veterinarios.remove(cedula);
    }

    public VeterinarioImpl consultarVeterinario(int cedula){
        return veterinarios.get(cedula);
    }

}
