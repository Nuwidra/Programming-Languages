import java.util.Arrays;

public class TestMyTriangle {

    public static void main(String[] args){

    	// •Cree tres puntos
        MyPoint v1 = new MyPoint(5346,53453);
        MyPoint v2 = new MyPoint(1123,7568);
        MyPoint v3 = new MyPoint(12325,542);

        MyTriangle triangulo = new MyTriangle(v1,v2,v3);
        MyTriangle triangulo_1 = new MyTriangle(9,5,1,6,412,20);

        // •Muestre que los métodos de punto funcionan.
        System.out.println(v1.getX());
        System.out.println(v2.getY());

        System.out.println("V2" + v2);
        System.out.println("v2" + v2);

        // •Cree un triangulo a partir de los tres puntos
        System.out.println("V1: " + v1);
        System.out.println("V2: " + v2);
        System.out.println("V3: " + v3);

        System.out.println(v1.distance(14345,14235));
        System.out.println(v2.distance(v3));

        // •Cree un triangulo a partir de valores x,y de tres ubicaciones.
        System.out.println(Arrays.toString(v1.getXY()));
        System.out.println(Arrays.toString(v2.getXY()));
        System.out.println(Arrays.toString(v3.getXY()));

        // •Pruebe con ambos triángulos que los métodos creados funcionan.
        System.out.println(triangulo);
        System.out.println(triangulo_1);

        System.out.println(triangulo.getPerimeter());
        System.out.println(triangulo_1.getPerimeter());

        System.out.println(triangulo.getType());
        System.out.println(triangulo_1.getType());

    }

}
