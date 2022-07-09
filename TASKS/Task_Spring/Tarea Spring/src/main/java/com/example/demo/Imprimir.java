package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Imprimir {
    @Autowired
    private Persona persona;

    public void setAtributos(Persona persona, int cedula, String nombre) {
        persona.setCedula(cedula);
        persona.setNombre(nombre);
    }

    @RequestMapping("/")
    public String mensaje(){
        this.setAtributos(this.persona, 435, "Jonathan");
        return persona.getNombre() + " tiene como cedula " + persona.getCedula();
    }


}
