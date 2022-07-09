/* ---------------------------------------------------------- */
/* PARTE 1 DE LA TAREA                                        */
/* ---------------------------------------------------------- */
/*                                     JONATHAN QUESADA SALAS */
/*                                        PABLO MUÑOZ HIDALGO */
/* ---------------------------------------------------------- */
int matrizAlmacenaje [10][10];

int readMatrix(int ROW, int COL){
	
	/*----------------------------------------------*/
	/* SE RECORRE TODAS LAS FILAS*/ 
	/*----------------------------------------------*/
	for (int fila = 0; fila < ROW; ++fila){
		
		/*----------------------------------------------*/
		/* SE RECORRE TODAS LAS COLUMNAS*/ 
		/*----------------------------------------------*/
		for (int columna = 0; columna < COL; ++columna){
			
			/*----------------------------------------------*/
			/* SE ALMACENA LA MATRIZ*/ 
			/*----------------------------------------------*/
			matrizAlmacenaje [fila][columna] = fila+columna;
		}
	}
}

int showMatrix(int ROW, int COL){
	
	/*----------------------------------------------*/
	/* RECORRE TODAS LAS FILAS*/ 
	/*----------------------------------------------*/
	for (int fila = 0; fila < ROW; ++fila){
		
		/*----------------------------------------------*/
		/* RECORRE TODAS LAS COLUMNAS*/ 
		/*----------------------------------------------*/
		for (int columna = 0; columna < COL; ++columna){
			
			/*----------------------------------------------*/
			/* SE VA IMPRIMIENDO LA MATRIZ*/ 
			/*----------------------------------------------*/
			printf("%d\t",matrizAlmacenaje[fila][columna]);
			
		}
		/*----------------------------------------------*/
		/* SALTO DE LINEA PARA DAR FORMA A LA MATRIZ
		/*----------------------------------------------*/
		printf("\n");
	}
}

int sumMatrixColumns(int ROW, int COL){
	
	/*--------------------------------------------------*/
	/* SE INICIALIZA LA VARIABLE CONTENEDOR DE LA SUMA
	/*--------------------------------------------------*/
	int sumaTotalColumna = 0;
	
	/*----------------------------------------------*/
	/* SE RECORRE LAS FILAS
	/*----------------------------------------------*/
	for (int fila = 0; fila < COL; ++fila){
		
		/*----------------------------------------------*/
		/* SE RECORRE LAS COLUMNAS
		/*----------------------------------------------*/
		for (int columna = 0; columna < ROW; ++columna){
			
			/*----------------------------------------------------*/
			/*SE VA REALIZANDO LA SUMA RESPECTIVA DE LAS COLUMNAS
			/*----------------------------------------------------*/
			sumaTotalColumna = sumaTotalColumna + matrizAlmacenaje[columna][fila];
		}
	}
	/*----------------------------------------------*/
	/* SE RETORNA LA SUMA TOTAL
	/*----------------------------------------------*/
	return sumaTotalColumna;
}


void maxMatrixColumns(int ROW, int COL){
	
	/*----------------------------------------------*/
	/* SE INICIALIZA VARIABLES
	/*----------------------------------------------*/
	int maximaColumnaSuma = 0;
	int maximaColumna = 0;
	int sumatoria = 0;

	/*----------------------------------------------*/
	/* SE RECORRE LAS FILAS
	/*----------------------------------------------*/
	for (int fila = 0; fila < COL; ++fila){
		
		sumatoria = 0;
		/*----------------------------------------------*/
		/* SE RECORRE LAS COLUMNAS
		/*----------------------------------------------*/
		for (int columna = 0; columna < ROW; ++columna){
			
			/*----------------------------------------------*/
			/* SE VA SUMANDO LOS VALORES DE LA MATRIZ
			/*----------------------------------------------*/
			sumatoria = sumatoria + matrizAlmacenaje[columna][fila];
		}

		if (maximaColumnaSuma < sumatoria){
			maximaColumnaSuma = sumatoria;
			maximaColumna = fila+1;
		}
	}
	
	/*----------------------------------------------*/
	/* SE SE IMPRIME LOS RESULTADOS RESPECTIVOS
	/*----------------------------------------------*/
	printf("maxMatrixColumns: %d\n", maximaColumnaSuma);
	
	printf("columnaMayor: %d\n", maximaColumna);
}


int main()
{
	int filas = 10;
	int columnas = 10;
	
	readMatrix(filas,columnas);
	showMatrix(filas,columnas);
	printf("sumMatrixColumns: %d\n",sumMatrixColumns(filas,columnas));
	maxMatrixColumns(filas,columnas);
	return 0;
}
