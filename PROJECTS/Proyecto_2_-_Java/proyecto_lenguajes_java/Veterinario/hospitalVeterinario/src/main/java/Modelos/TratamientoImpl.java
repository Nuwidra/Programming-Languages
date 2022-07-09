package Modelos;

import java.time.LocalDate;
import java.util.Date;

/*
    clase que representa un tratamiento recomendado por un veterinario
 */
public class TratamientoImpl {

    //Constructor
    private int id;
    private LocalDate fecha;
    private String descripcion;
    private VeterinarioImpl veterinario;
    private ProductoCompradoImpl medicamento;

    public TratamientoImpl(int id, LocalDate fecha, String descripcion, VeterinarioImpl veterinario, ProductoCompradoImpl medicamento) {
        this.id = id;

        this.fecha = fecha;
        this.descripcion = descripcion;
        this.veterinario = veterinario;
        this.medicamento = medicamento;
    }

    // Sets y gets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public VeterinarioImpl getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(VeterinarioImpl veterinario) {
        this.veterinario = veterinario;
    }

    public ProductoCompradoImpl getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(ProductoCompradoImpl medicamento) {
        this.medicamento = medicamento;
    }
}
