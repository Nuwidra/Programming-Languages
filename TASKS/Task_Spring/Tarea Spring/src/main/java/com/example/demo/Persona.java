package com.example.demo;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    private int cedula;
    private String nombre;

    public int getCedula(){
        return cedula;
    }
    public void setCedula(int cedula){
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
