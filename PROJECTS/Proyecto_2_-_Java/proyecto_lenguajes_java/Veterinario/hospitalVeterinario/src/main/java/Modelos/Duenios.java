package Modelos;

import java.util.HashMap;
import java.util.Map;
/*
    Esta clase sirve para almacenar la informacion de la web, contiene un HashMap donde se
    van a almacenar los duenios del sistema. la clase tiene funciones para consultar, agregar, modificar y elimnar un duenio
    (la funcion agregarDuenio puede servir para modificar ya que el mapa sobreescribe el id)
 */
public class Duenios {
    Map<Integer, DuenioImpl> duenios = new HashMap<Integer,DuenioImpl>();

    public void agregarDuenio(DuenioImpl duenio) {
        duenios.put(duenio.getCedula(), duenio);
    }
    public DuenioImpl consultarDuenio(int cedula){
        return duenios.get(cedula);
    }

    public void eliminarDuenio(int cedula){
        duenios.remove(cedula);
    }

    public Map<Integer, DuenioImpl> getDuenios() {
        return duenios;
    }

    public void setDuenios(Map<Integer, DuenioImpl> duenios) {
        this.duenios = duenios;
    }
}
