package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 Clase que hereda de FacturaImpl
 esta clase es para las facturas de tipo consulta, simplemente
 agrega los atributos de ese tipo de factura. y cuenta con un metodo para imprimir toda la informacion de la factura

 */
public class FacturaConsultaImpl extends FacturaImpl{

    //Constructor
    int idFactura;
    String servicio;

    public FacturaConsultaImpl(int idFactura, String servicio, LocalDate fecha, ProductoCompradoImpl productos) {
        super(fecha, productos);
        this.idFactura = idFactura;
        this.servicio = servicio;
    }
    // Sets y gets
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public List<String> getFactura(){
        List<String> lista = new ArrayList<>();
        lista.add("Id Factura: "+idFactura);
        lista.add("servicio: "+servicio);
        lista.add("Fecha: "+fecha);
        lista.addAll(productos.getProducto().getInformacionParaFactura());
        lista.add("-----------------------------------------------------");
        return lista;
    }

}
