public class MyPoint {
	// (5 puntos) Cree la clase MyPoint que modela un punto en 2D e implementa la siguiente 
	// funcionalidad, defina los atributos apropiados:    
	private int x;
    private int y;

    // (2 puntos) Constructores: 
    // 	•MyPoint: define un punto en la posición fija (0,0).
    //	•MyPoint (x: int,y: int): define un punto en la posición x,y
    public MyPoint (){this.x = 0;this.y = 0;}

    public MyPoint (int x, int y){this.x = x;this.y = y;}

    // • Gets y sets definidos como de costumbre
    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y) {this.y = y;}

    // •El método getXY  retorna un array con los valores de x (posición 0) y y(posición 1).
    public int[] getXY(){int[] point = new int[]{this.x, this.y};return point;}

    // •toString: retorna el String “(x,y)” donde x,y representa el valor x,y del punto.
    @Override
    public String toString(){
        return "(" + String.valueOf(x) + "," + String.valueOf(y) + ")";
    }

    // •distance(x: int,y: int): devuelve la distancia del punto actual al punto (x,y)
    public double distance (int x, int y){
        double primer_punto = Math.pow(x-this.x, 2);
        double segundo_punto = Math.pow(y-this.y, 2);

        double distance = Math.sqrt(primer_punto + segundo_punto);
        return distance;
    }

    // •distance(another MyPoint): devuelve la distancia del punto actual al punto another.
    public double distance (MyPoint another){
    	
    	// El pow sirve para elevar el numero a una potencia para poder sacar el teorema de pitagoras
        double primer_punto = Math.pow(another.getX() - this.x, 2);
        double segundo_punto = Math.pow(another.getY() - this.y, 2);
        
        // sqrt es para sacar la raiz cuadrada 
        double distance = Math.sqrt(primer_punto + segundo_punto);return distance;}

    // •distance(): devuelve la distancia euclideana del punto actual al punto (0,0).
    public double distance(){
    	
    	// El pow sirve para elevar el numero a una potencia para poder sacar el teorema de pitagoras
        double primer_punto = Math.pow(this.x,2);
        double segundo_punto = Math.pow(this.y,2);

        // sqrt es para sacar la raiz cuadrada 
        double distance = Math.sqrt(primer_punto + segundo_punto);
        return distance;
    }

}
