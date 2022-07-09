public class MyTriangle {

	// 5 puntos) Defina la clase MyTriangle que representa un triángulo en 2D definido por los 
	// tres puntos de las esquinas (utilizando la clase MyPoint). Defina los atributos apropiados y
	// la composición de clases
	private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    // (2 puntos) Constructores: 
    //	•MyTriangle(x1: int,y1: int, x2: int,y2: int, x3: int,y3: int): define un triángulo, primero 
    //	creando a partir de los xi y yi tres puntos para definir los vértices del triángulo.
    //	•MyTriangle (v1: MyPoint, v2: MyPoint, v3: MyPoint): define un triángulo utilizando 
    // 	los tres puntos vi para definir los vértices de este
    public MyTriangle (int x1, int y1, int x2, int y2, int x3, int y3){this.v1 = new MyPoint(x1,y1);this.v2 = new MyPoint(x2, y2);this.v3 = new MyPoint(x3, y3);}

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3){this.v1 = v1;this.v2 = v2;this.v3 = v3;}

    // •toString(): devuelve un String con la siguiente información 
    // "MyTriangle[v1=(x1,y1),v2=(x2,y2),v3=(x3,y3)]"
    @Override
    public String toString(){
        return "MyTriangle[v1=(" +String.valueOf(v1.getX()) + "," +  String.valueOf(v1.getY()) + "),v2=(" + String.valueOf(v2.getX()) + "," + String.valueOf(v2.getY()) + "),v3=(" + String.valueOf(v3.getX()) + "," + String.valueOf(v3.getY()) + ")";
    }

    // •getPerimeter(): devuelve el perímetro del triángulo
    public double getPerimeter(){
    	
    	// Se definenen cada lado del triangulo
        double lado_1 = v1.distance(v2);
        double lado_2 = v1.distance(v3);
        double lado_3 = v2.distance(v3);
        
        // Se suman los lados del triangulo
        return lado_1 + lado_2 + lado_3;
    }

    // •GetType(): devuelve el tipo de triángulo que corresponde a "equilátero" si todos los 
    // lados del triángulo son iguales, "isósceles" si dos de los tres lados son iguales, o 
    // "escaleno" si los tres lados son diferentes
    public String getType(){
        double lado_1 = v1.distance(v2);
        double lado_2 = v1.distance(v3);
        double lado_3 = v2.distance(v3);

        if(lado_1 == lado_2 && lado_2 == lado_3){return "El triangulo es equilatero";}
        else if(lado_1 == lado_2 || lado_1 == lado_3 || lado_2 == lado_3){return "El triangulo es isoseles";}
        else{return "Es triangulo es escaleno";}
    }

}