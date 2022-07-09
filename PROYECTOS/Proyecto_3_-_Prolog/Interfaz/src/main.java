import org.jpl7.*;
import java.lang.String;
public class main {

    public static void main(String[] args){

        Query q1=new Query("consult",new Term[]{new Atom("C:\\Usuarios\\Jonathan\\Escritorio\\Proyecto.pl")});
        q1.hasSolution();
        int consulta = 0;
        System.out.println("Java con prolog funciona");
        do{
            consulta = ejecutarElPrograma();
        }while(consulta !=-1);
        System.exit(0);
    }

    public static int ejecutarElPrograma(){
        Query ejecutarConsultorio=new Query("consult",new Term[]{new Atom("C:\\Usuarios\\Jonathan\\Escritorio\\Proyecto.pl")});
        ejecutarConsultorio.hasSolution();

        System.out.println("Java con prolog funciona");
        try {
            Query query = new Query("programa.");

        }catch (Exception e){
            System.out.println("Mi rey no se pudo ejecutar");
        }
        return 0;
    }
}
