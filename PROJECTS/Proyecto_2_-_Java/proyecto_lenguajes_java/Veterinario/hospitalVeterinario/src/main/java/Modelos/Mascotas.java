package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

    contiene un HashMap donde se van a almacenar las mascotas del sistema. la clase tiene funciones para consultar, agregar, modificar y elimnar una mascotas
    (la funcion agregarmascotas puede servir para modificar ya que el mapa sobreescribe el id)
    tambien cuenta con una funcion para imprimir todos las mascotas del sistema

 */
public class Mascotas {
    Map<Integer, MascotaImpl> mascotas = new HashMap<Integer, MascotaImpl>();

    public void agregarMascota(MascotaImpl mascota){
        mascotas.put(mascota.getId(), mascota);
    }

    public void eliminarMascota(int id){
        mascotas.remove(id);
    }

    public MascotaImpl consultarMascota(int id){
        return mascotas.get(id);
    }

    public List<String> listarMascotas(){
        List<String> lista = new ArrayList<>();
        for(Map.Entry<Integer, MascotaImpl> entry : mascotas.entrySet()){
            lista.add(entry.getValue().getInformacionMascota());
        }
        return lista;
    }

    public Map<Integer, MascotaImpl> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Map<Integer, MascotaImpl> mascotas) {
        this.mascotas = mascotas;
    }
}
