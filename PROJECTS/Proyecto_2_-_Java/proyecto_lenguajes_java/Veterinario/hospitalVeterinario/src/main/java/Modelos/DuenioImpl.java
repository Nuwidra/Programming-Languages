package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuenioImpl extends PersonaImpl{

    //Constructor
    Map<Integer, MascotaImpl> mascotas = new HashMap<Integer, MascotaImpl>();
    List<FacturaImpl> facturas = new ArrayList<>();
    List<FacturaConsultaImpl> facturasConsulta = new ArrayList<>();
    List<FacturaTiendaImpl> facturasTienda = new ArrayList<>();

    public DuenioImpl(int cedula, String nombre, String ap1, String ap2, String direccion, String telefono, ArrayList<MascotaImpl> listaMascotas) {
        super(cedula, nombre, ap1, ap2, direccion, telefono);
        for(int i = 0; i < listaMascotas.size(); i++){
            mascotas.put(listaMascotas.get(i).getId(), listaMascotas.get(i));
        }
    }

    /*
        Recibe una factura de tipo consulta medica para ingresarla en la estructura de facturas de consulta del dueño
     */
    public void agregarFacturaConsulta(FacturaConsultaImpl factura){
        facturasConsulta.add(factura);
    }

    /*
        Recibe una factura de tipo compra en la tienda para ingresarla en la estructura de facturas de tienda del dño
     */
    public void agregarFacturaTienda(FacturaTiendaImpl factura){
        facturasTienda.add(factura);
    }

    /*
        Devuelve una lista de Strings donde tiene toda la informacion de las facturas, esta lista de strings
        se utiliza para que los datos sean visualidos en la web.
     */
    public List<String> listarFacturas(){
        List<String> lista = new ArrayList<>();
        for(int i = 0; i < facturasConsulta.size(); i++) {
            lista.addAll(facturasConsulta.get(i).getFactura());
        }
        for(int i = 0; i < facturasTienda.size(); i++) {
            lista.addAll(facturasTienda.get(i).getFactura());
        }
        return lista;
    }

    /*
        Devuelve una lista de strings con toda la informacion correspondiente a la clase para
        imprimirla en la web
     */
    public List<String> getInformacionDuenio(){
        List<String> informacion = super.getInformacionPersonal();

        //informacion de las mascotas
        informacion.add("Mascotas:\n\n");
        for(Map.Entry<Integer,MascotaImpl> entry: mascotas.entrySet()){
            informacion.add(entry.getValue().getInformacionMascota()+"\n");
        }
        return informacion;
    }

    // Sets y gets
    public Map<Integer, MascotaImpl> getMascotas() {
        return mascotas;
    }

    public void setMascotas(Map<Integer, MascotaImpl> mascotas) {
        this.mascotas = mascotas;
    }

    public List<FacturaImpl> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaImpl> facturas) {
        this.facturas = facturas;
    }

    public List<FacturaConsultaImpl> getFacturasConsulta() {
        return facturasConsulta;
    }

    public void setFacturasConsulta(List<FacturaConsultaImpl> facturasConsulta) {
        this.facturasConsulta = facturasConsulta;
    }

    public List<FacturaTiendaImpl> getFacturasTienda() {
        return facturasTienda;
    }

    public void setFacturasTienda(List<FacturaTiendaImpl> facturasTienda) {
        this.facturasTienda = facturasTienda;
    }
}
