/* ---------------------------------------------------------- */
/* PARTE 2 DE LA TAREA                                        */
/* ---------------------------------------------------------- */
/*                                     JONATHAN QUESADA SALAS */
/*                                        PABLO MUÑOZ HIDALGO */
/* ---------------------------------------------------------- */

#include <stdio.h>

int matrizDeJuego[8][8];

/* ------------------------------------------------------------------------------- */
/* LO MISMO QUE EL EJERCICIO 1, SOLO CON LA RESTRICCION DE QUE SEA UNA MATRIZ 8X8  */
/* ------------------------------------------------------------------------------- */
void readMatrix(){
	
	/*----------------------------------------------*/
	/*SE RECORRE TODAS LAS FILAS*/ 
	/*----------------------------------------------*/
	for (int fila = 0; fila < 8; ++fila){
		
		/*----------------------------------------------*/
		/*SE RECORRE TODAS LAS COLUMNAS*/ 
		/*----------------------------------------------*/
		for (int columna = 0; columna < 8; ++columna){
			
			matrizDeJuego[fila][columna] = 0;
		}
	}
}

/* ------------------------------------------------------------------------------- */
/*LO MISMO QUE EL EJERCICIO 1, SOLO CON LA RESTRICCION DE QUE SEA UNA MATRIZ 8X8   */
/* ------------------------------------------------------------------------------- */
void showMatrix(){
	
	/*----------------------------------------------*/
	/* SE RECORRE LAS FILAS
	/*----------------------------------------------*/
	for (int fila = 0; fila < 8; ++fila){
		
		/*----------------------------------------------*/
		/* SE RECORRE LAS COLUMNAS
		/*----------------------------------------------*/
		for (int columna = 0; columna < 8; ++columna){
			
			/*-----------------------------------------------------*/
			/* SE VA ARMANDO EL TABLERO COMO CONSECUENTE LA MATRIZ
			/*-----------------------------------------------------*/
			printf("%d\t",matrizDeJuego[fila][columna]);
		}
		printf("\n");
	}
}

void insertShip(){
	int COL =0;
	
	/*-----------------------------------------------------*/
	/* SE COLOCAN LOS BARCOS EN LA MATRIZ/TABLERO
	/*-----------------------------------------------------*/
	for (int colocarBarcos = 0; 8 > colocarBarcos; ++colocarBarcos){
			
		/*-----------------------------------------------------*/
		/* EL USUARIO SELECCIONA DONDE PONER LOS BARCOS
		/*-----------------------------------------------------*/
		printf("Eliga un numero del 1 al 7 para colocar un barco estas en la fila %d/8\n",(colocarBarcos+1));
		scanf("%d",&COL);
		
		/*-----------------------------------------------------*/
		/* EN CASO DE INGRESAR ALGO INVALIDO
		/*-----------------------------------------------------*/
		if (COL >=8){
			printf("Numero invalido");
			colocarBarcos = colocarBarcos-1;
		}
		matrizDeJuego[colocarBarcos][(COL-1)]= 1;		
	}
}

void tiro()
{
	int barcosHundidos = 0;
	/*-----------------------------------------------------*/
	/* SE ESTABLECE LOS INTENTOS TOTALES
	/*-----------------------------------------------------*/
	for (int intento = 0; intento < 12; ++intento){
		int ROW;
		int COL;
		
		/*-----------------------------------------------------*/
		/* CUANDO SE HUNDIERON TODOS LOS BARCOS
		/*-----------------------------------------------------*/
		if (barcosHundidos >=8){
			printf("fin del juego\n");
			intento = 13;
		}
		
		/*-----------------------------------------------------*/
		/* SE INTRODUCE LAS UBICACIONES X Y DE LOS TIROS
		/*-----------------------------------------------------*/
		printf("UBICACION EN X: ");
		scanf("%d",&ROW);
		printf("UBICACION EN Y: ");
		scanf("%d",&COL);
		
		/*-----------------------------------------------------*/
		/* SE INTRODUCE LAS UBICACIONES X Y DE LOS TIROS
		/*-----------------------------------------------------*/
		if (9 <= COL | 9 <= ROW ){
			printf("NO SE INGRESO LO SOLICITADO");
			intento = intento-1;
		}

		/*-----------------------------------------------------*/
		/* CUANDO SE INTRODUCE UNA CASILLA SIN BARCO
		/*-----------------------------------------------------*/
		if (matrizDeJuego[(ROW-1)][(COL-1)] == 0){
			matrizDeJuego[(ROW-1)][(COL-1)] = 2;
			printf("agua");
		}
		else{
			/*-----------------------------------------------------*/
			/* CUANDO SE INTRODUCE UNA CASILLA CON BARCO
			/*-----------------------------------------------------*/
			printf("\nbarco");
			barcosHundidos = barcosHundidos+1;
			matrizDeJuego[(ROW-1)][(COL-1)] = 2;
		}
		printf("\n");
		
	}

}

/*----------------------------------------------------------*/
/* MAIN DONDE SE LLAMAN LAS FUNCIONES PARA EMPEZAR EL JUEGO
/*----------------------------------------------------------*/
int main(){
	insertShip();
	showMatrix();
	tiro();
	showMatrix();
}
