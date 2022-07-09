package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
 Clase que hereda de FacturaImpl
 esta clase es para las facturas de tipo tienda, simplemente
 agrega los atributos de ese tipo de tienda. y cuenta con un metodo para imprimir toda la informacion de la factura

 */
public class FacturaTiendaImpl extends FacturaImpl{

    //Constructor
    int id;
    public FacturaTiendaImpl(int id, LocalDate fecha, ProductoCompradoImpl productos) {

        super(fecha, productos);
        this.id = id;
    }

    // Sets y gets
    public List<String> getFactura(){
        List<String> lista = new ArrayList<>();
        lista.add("Id Factura: "+id);
        lista.add("Fecha: "+fecha);
        lista.addAll(productos.getProducto().getInformacionParaFactura());
        lista.add("-----------------------------------------------------");
        return lista;
    }
}
