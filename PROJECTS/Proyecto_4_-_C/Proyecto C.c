/*
 * ==================================================================
 * Nombre      : Tarea Programada IV
 * Autores     : Pablo Muñoz Hidalgo 
 *               Jonathan Quesada Salas
 * Versión     : 1.0
 * Copyright   : Your copyright notice
 * Descripcion : Esta tarea programada consiste en el manejo de 
 *               archivos en el lenguaje de programación de C
 * ==================================================================
 * */

/*
 * ==================================================================
 * Los respectivos includes para realizar lo solicitado
 * ==================================================================
 * */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * ==============================================================cubo
 * Función    : cubo
 * Proposito  : Poder establecer la estructura que va a tener el 
 *              cubo multidimensional asignado.
 *              Declaracion de la estructura de cubo doble con su 
 *              respectivo nombre.
 * Parametros : Ninguno
 * Retorno    : Nada
 * ==================================================================
 * */
struct cubo{
	int           id;
	struct nodo*  inicio;
};

/*
 * ==============================================================nodo
 * Función    : nodo
 * Proposito  : Poder establecer la estructura del nodo como tal.
 *              Declaracion de un nodo con sus respectivos valores
 * Parametros : Ninguno
 * Retorno    : Nada
 * ==================================================================
 * */
struct nodo{
    char*        region;
    char*        pais;
    char*        linea;
    char*        modelo;
    char*        cantidad;
    char*        precio;
    char*        costo;
	struct nodo* siguiente;
};

/*
 * ========================================================crear_cubo
 * Función    : crear_cubo
 * Proposito  : Poder reservar un espacio en memoria para poder
 *              almacenar el cubo como tal.
 * Parametros : Ninguno
 * Retorno    : nuevo_cubo
 * ==================================================================
 * */
struct cubo* crear_cubo(){
	/*
	 * ==========================================
	 * Reserva espacio en memoria para nuevo nodo
	 * ==========================================
	 * 
	 * */
	struct cubo* nuevo_cubo = calloc(1, sizeof(struct cubo));
	return nuevo_cubo;
}

/*
 * ========================================================crear_nodo
 * Función    : crear_nodo
 * Proposito  : Esta funcionalidad nos ayudará para poder reservar 
 *              el espacio en memoria para cada uno de los parametros
 *              del modelo multidimensional que van a formar parte 
 *              del cubo
 * Parametros : region
 *              modelo
 *              pais
 *              linea
 *              precio
 *              costo
 *              cantidad
 * Retorno    : nuevo_nodo
 * ==================================================================
 * */
struct nodo* crear_nodo(char* region, char* modelo, char* pais, char* linea, char* precio, char* costo, char* cantidad){
	/*
	 * ==========================================
	 * Reserva espacio en memoria para nuevo nodo
	 * ==========================================
	 * 
	 * */
	struct nodo* nuevo_nodo = calloc(1, sizeof(struct nodo));
	
	/*
	 * ==========================================
	 * Reserva espacio en memoria para region 
	 * ==========================================
	 * 
	 * */
	nuevo_nodo->region = calloc(strlen(region)+1, sizeof(char));
	strcpy(nuevo_nodo->region, region);
	/*
	 * ==========================================
	 * Reserva espacio en memoria para modelo 
	 * ==========================================
	 * 
	 * */
	nuevo_nodo->modelo = calloc(strlen(modelo)+1, sizeof(char));
	strcpy(nuevo_nodo->modelo, modelo);
	/*
	 * ==========================================
	 * Reserva espacio en memoria para pis 
	 * ==========================================
	 * 
	 * */
	nuevo_nodo->pais = calloc(strlen(pais)+1, sizeof(char));
	strcpy(nuevo_nodo->pais, pais);
	/*
	 * ==========================================
	 * Reserva espacio en memoria para linea 
	 * ==========================================
	 * 
	 * */
	nuevo_nodo->linea = calloc(strlen(linea)+1, sizeof(char));
	strcpy(nuevo_nodo->linea, linea);
	/*
	 * ==========================================
	 * Reserva espacio en memoria para precio 
	 * ==========================================
	 * 
	 * */
	nuevo_nodo->precio = calloc(strlen(precio)+1, sizeof(char));
	strcpy(nuevo_nodo->precio, precio);
	/*
	 * ==========================================
	 * Reserva espacio en memoria para costo 
	 * ==========================================
	 * 
	 * */
	nuevo_nodo->costo = calloc(strlen(costo)+1, sizeof(char));
	strcpy(nuevo_nodo->costo, costo);
	/*
	 * ==========================================
	 * Reserva espacio en memoria para cantidad 
	 * ==========================================
	 * 
	 * */
	nuevo_nodo->cantidad = calloc(strlen(cantidad)+1, sizeof(char));
	strcpy(nuevo_nodo->cantidad, cantidad);
	return nuevo_nodo;
}

/*
 * =====================================================imprimir_cubo
 * Función    : imprimir_cubo
 * Proposito  : El proposito de esta funcion es poder imprimir el 
 *              cubo que este mismo contendrá toda la información
 *              de los nodos.
 * Parametros : cubo
 * Retorno    : El cubo impreso en terminal
 * ==================================================================
 * */
//Funcion que imprime una cubo doble nodo por nodo
int imprimir_cubo(struct cubo* cubo){

	/*
	 * ==========================================
	 * Declaración de variables
	 * ==========================================
	 * 
	 * */
	struct nodo* actual = NULL;
	
	/*
	 * ==========================================
	 * Condicion si el cubo esta vacio
	 * ==========================================
	 * 
	 * */
	if (cubo->inicio == NULL || cubo == NULL){
		printf("El cubo esta vacio\n");
		return -2;
	}

	/*
	 * ==========================================
	 * Se asigna los valores a nuevo nodo
	 * ==========================================
	 * 
	 * */
	actual = cubo->inicio;
	
	/*
	 * ==========================================
	 * Ciclo que va por cada nodo hasta el final imprimiendo los datos de la cubo 
	 * ==========================================
	 * 
	 * */
	while (actual != NULL){

		printf("\nRegion : %s", actual->region);
		printf("\tPais : %s", actual->pais);
		printf("\tLinea : %s", actual->linea);
		printf("\tModelo : %s", actual->modelo);
		printf("\tCantidad : %d", atoi(actual->cantidad));
		printf("\tPrecio : %d", atoi(actual->precio));
		printf("\tCosto : %d", atoi(actual->costo));
		actual = actual->siguiente;
	}

	printf("\n\n\n");
	return 0;
}

/*
 * ======================================================agregar_nodo
 * Función    : agregar_nodo
 * Proposito  : Esta funcion se encargará de poder agregar los 
 *              respectivos nodos al cubo como tal
 * Parametros : cubo
 *              nuevo_nodo
 * Retorno    : cubo
 * ==================================================================
 * */
struct cubo* agregar_nodo(struct cubo* cubo, struct nodo* nuevo_nodo){
	/*
	 * ==========================================
	 * Declaración de variables
	 * ==========================================
	 * 
	 * */
	struct nodo* actual = NULL;
	struct nodo* anterior = NULL;
	
	/*
	 * ==========================================
	 * Condicion si el cubo esta vacio
	 * ==========================================
	 * 
	 * */
	if (cubo->inicio == NULL){
		cubo->inicio = nuevo_nodo;
		nuevo_nodo->siguiente = NULL;
		return cubo;
	}
	actual = cubo->inicio;
	/*
	 * ==========================================
	 * Si el indice es el primer elemento
	 * ==========================================
	 * 
	 * */
	while (actual != NULL){
		anterior = actual;
		actual = actual->siguiente;
	}
	/*
	 * ======================================================
	 * Se redireccionan los punteros para el retorno del cubo
	 * ======================================================
	 * 
	 * */
	anterior->siguiente = nuevo_nodo;
	nuevo_nodo->siguiente =	NULL;
	return cubo;
}

/*
 * =======================================================borrar_cubo
 * Función    : borrar_cubo
 * Proposito  : Esta funcion se encargará de poder borrar todo lo que 
 *              contenga el cubo
 * Parametros : cubo
 * Retorno    : Mesanje de cubo vacio
 * ==================================================================
 * */
int borrar_cubo(struct cubo* cubo){
	/*
	 * ==========================================
	 * Condicion si el cubo esta vacio
	 * ==========================================
	 * 
	 * */
	if (cubo->inicio == NULL){
		printf("Cubo Vacio");
	}
	/*
	 * ==========================================
	 * Declaración de variables
	 * ==========================================
	 * 
	 * */
	struct nodo* actual = cubo->inicio;
	struct nodo* anterior;
	/*
	 * ==========================================
	 * Declaración de si actual es difente a NULL
	 * recorra todo el archivo y que vaya 
	 * haciendo free para ir borrando todo a su 
	 * paso
	 * ==========================================
	 * 
	 * */
	while (actual != NULL){
		anterior = actual;
		actual = actual->siguiente;
		free(anterior);
		anterior = NULL;
		cubo->inicio = NULL;
	}
	return 0;
}

/*
 * =======================================================cargar_cubo
 * Función    : cargar_cubo
 * Proposito  : Esta funcionalidad se va a encargar de poder cargar
 *              el cubo en un archivo de extension .csv
 * Parametros : cubo
 * Retorno    : cubo
 * ==================================================================
 * */
struct cubo* cargar_cubo(struct cubo* cubo){
	/*
	 * ==========================================
	 * Se abre el archivo extension .csv
	 * ==========================================
	 * 
	 * */
	//nombre = strcat(nombre,".csv");
	FILE* fp = fopen("prueba.csv", "r");

	/*
	 * ==========================================
	 * En caso que no se pueda abrir
	 * ==========================================
	 * 
	 * */
	if (!fp)
		printf("Can't open file\n");

	else {
		/*
		 * ==========================================
		 * Declaracion de variables
		 * ==========================================
		 * 
		 * */
		char buffer[1024];

		int fila    = 0;
		int columna = 0;
		/*
		 * ==========================================
		 * Se abre el archivo extension .csv
		 * ==========================================
		 * 
		 * */
		while (fgets(buffer,
					1024, fp)) {
			columna = 0;
			fila++;

			/*
			 * ==========================================
			 * Continuacion en las filas
			 * ==========================================
			 * 
			 * */
			if (fila == 1)
				continue;

			/*
			 * ==========================================
			 * Se recorre cada una de las columnas 
			 * asignandose los respectivos valores
			 * que tengan los parametros como tal
			 * ==========================================
			 * 
			 * */
			char* valor = strtok(buffer, ", ");
			char* region;
			char* pais;
			char* linea;
			char* modelo;
			char* cantidad;
			char* precio;
			char* costo;

			while (valor) {
				/*
				 * 
				 * ==========================================
				 * Columna de REGION
				 * ==========================================
				 * 
				 * */
				if (columna == 0) {
					region = valor;
				}

				/*
				 * 
				 * ==========================================
				 * Columna de PAIS
				 * ==========================================
				 * 
				 * */
				if (columna == 1) {
					pais = valor;
				}

				/*
				 * 
				 * ==========================================
				 * Columna de LINEA
				 * ==========================================
				 * 
				 * */
				if (columna == 2) {
					linea = valor;
				}

                /*
				 * 
				 * ==========================================
				 * Columna de MODELO
				 * ==========================================
				 * 
				 * */
				if (columna == 3) {
                    modelo = valor;
				}

                /*
				 * 
				 * ==========================================
				 * Columna de CANTIDAD
				 * ==========================================
				 * 
				 * */
				if (columna == 4) {
					cantidad = valor;
				}

                /*
				 * 
				 * ==========================================
				 * Columna de PRECIO
				 * ==========================================
				 * 
				 * */
				if (columna == 5) {
					precio = valor;
				}

                /*
				 * 
				 * ==========================================
				 * Columna de COSTO
				 * ==========================================
				 * 
				 * */
				if (columna == 6) {
					costo = valor;
					/*
					 * 
					 * ==========================================
					 * Se crea el nodo con todos los parametros
					 * recorridos, de esa manera para todo el 
					 * archivo
					 * ==========================================
					 * 
					 * */
					struct nodo* nuevo_nodo = crear_nodo(region, modelo, pais, linea, precio, costo, cantidad);
					cubo = agregar_nodo(cubo, nuevo_nodo);
				}
				valor = strtok(NULL, ", ");
				/*
				 * 
				 * ==========================================
				 * Avanza por todas las columnas
				 * ==========================================
				 * 
				 * */
				columna++;
			}
		}

		/*
		 * 
		 * ==========================================
		 * Se cierra el archivo
		 * ==========================================
		 * 
		 * */
		fclose(fp);
	}
	return cubo;
}

/*
 * ==============================================================cubo
 * Función    :
 * Proposito  :
 * Parametros :
 * Retorno    :
 * ==================================================================
 * */
int leer_archivo(){
    /*
	 * ==========================================
	 * Se abre el archivo extension .csv
	 * ==========================================
	 * 
	 * */
	FILE* fp = fopen("prueba.csv", "r");

	/*
	 * ==========================================
	 * En caso que no se pueda abrir
	 * ==========================================
	 * 
	 * */
	if (!fp)
		printf("Can't open file\n");

	else {
		/*
		 * ==========================================
		 * Declaracion de variables
		 * ==========================================
		 * 
		 * */
		char buffer[1024];
		int fila    = 0;
		int columna = 0;

		/*
		 * ==========================================
		 * Se obtienen los valores de las filas
		 * ==========================================
		 * 
		 * */
		while (fgets(buffer,
					1024, fp)) {
			columna = 0;
			fila++;

			
			/*
			 * ==========================================
			 * Continuacion en las filas
			 * ==========================================
			 * 
			 * */
			if (fila == 1)
				continue;

			char* valor = strtok(buffer, ", ");

			while (valor) {
				/*
				 * 
				 * ==========================================
				 * Columna de REGION
				 * ==========================================
				 * 
				 * */
				if (columna == 0) {
					printf("Region :");
				}

				/*
				 * 
				 * ==========================================
				 * Columna de PAIS
				 * ==========================================
				 * 
				 * */
				if (columna == 1) {
					printf("\tPais :");
				}

				/*
				 * 
				 * ==========================================
				 * Columna de LINEA
				 * ==========================================
				 * 
				 * */
				if (columna == 2) {
					printf("\tLinea :");
				}

                /*
				 * 
				 * ==========================================
				 * Columna de MODELO
				 * ==========================================
				 * 
				 * */
				if (columna == 3) {
					printf("\tModelo :");
				}

                /*
				 * 
				 * ==========================================
				 * Columna de CANTIDAD
				 * ==========================================
				 * 
				 * */
				if (columna == 4) {
					printf("\tCantidad :");
				}

                /*
				 * 
				 * ==========================================
				 * Columna de PRECIO
				 * ==========================================
				 * 
				 * */
				if (columna == 5) {
					printf("\tPrecio :");
				}

                /*
				 * 
				 * ==========================================
				 * Columna de COSTO
				 * ==========================================
				 * 
				 * */
				if (columna == 6) {
					printf("\tCosto :");
				}

				/*
				 * 
				 * ==========================================
				 * Se imprimen los valores
				 * ==========================================
				 * 
				 * */
				printf("%s", valor);
				valor = strtok(NULL, ", ");
				/*
				 * 
				 * ==========================================
				 * Avanza por todas las columnas
				 * ==========================================
				 * 
				 * */
				columna++;
			}

			printf("\n");
		}

		/*
		 * 
		 * ==========================================
		 * Se cierra el archivo
		 * ==========================================
		 * 
		 * */
		fclose(fp);
	}
	return 0;
}

/*
 * =========================================================crear_csv
 * Función    : crear_csv
 * Proposito  : Poder crear un nuevo archivo .csv con las columnas
 *              respectivas del modelo multidimensional
 * Parametros : nombre_archivo
 * Retorno    : Nada
 * ==================================================================
 * */
int crear_csv (char nombre_archivo [256]){
	FILE* fp = fopen("test","w+");
	fprintf(fp,"región,país,linea,modelo,cantidad,precio,costo");
	fclose(fp);
}

/*
 * ==============================================================cubo
 * Función    :
 * Proposito  :
 * Parametros :
 * Retorno    :
 * ==================================================================
 * */
int guardar_nueva_linea_cubo()
{
	/*
	 * ==========================================
	 * Se crea un archivo de extension .csv
	 * ==========================================
	 * 
	 * */
	char* nombre_archivo = "test";
	crear_csv(nombre_archivo);
	/*
	 * ==========================================
	 * Se abre el archivo de extensión .csv
	 * ==========================================
	 * 
	 * */
	FILE* fp = fopen("test.csv", "a+");
	
	/*
	 * ==========================================
	 * Se reserva un espacio en memora para
	 * todos los paramentros del modelo 
	 * multidimensional
	 * ==========================================
	 * 
	 * */
    char nueva_region [256];
    char nuevo_pais [256];
    char nueva_linea [256];
    char nuevo_modelo [256];
    char nueva_cantidad [256];
    char nuevo_precio [256];
    char nuevo_costo [256];

	if (!fp) {
		/*
		 * ==========================================
		 * En caso que no se pueda abrir el archivo
		 * ==========================================
		 * 
		 * */
		printf("Can't open file\n");
		return 0;
	}

	/*
	 * ==========================================
	 * Se agrega la REGION
	 * ==========================================
	 * 
	 * */
	printf("\nIngrese la region (AS o AC)\n");
	scanf("%s", nueva_region);
	
	/*
	 * ==========================================
	 * Se agrega el PAIS
	 * ==========================================
	 * 
	 * */
	printf("\nIngrese el pais (Sin espacios)\n");
	scanf("%s", nuevo_pais);
	
	/*
	 * ==========================================
	 * Se agrega la LINEA
	 * ==========================================
	 * 
	 * */
	printf("\nIngrese la linea del producto (Sin espacios)\n");
	scanf("%s", nueva_linea);
	
	/*
	 * ==========================================
	 * Se agrega el MODELO
	 * ==========================================
	 * 
	 * */
	printf("\nIngrese el modelo (Sin espacios)\n");
	scanf("%s", nuevo_modelo);
	
	/*
	 * ==========================================
	 * Se agrega la CANTIDAD
	 * ==========================================
	 * 
	 * */
	printf("\nIngrese la cantidad numerica (Entero)\n");
	scanf("%s", nueva_cantidad);
	
	/*
	 * ==========================================
	 * Se agrega el PRECIO
	 * ==========================================
	 * 
	 * */
	printf("\nIngrese el precio (Entero)\n");
	scanf("%s", nuevo_precio);
	
	/*
	 * ==========================================
	 * Se agrega el COSTO
	 * ==========================================
	 * 
	 * */
	printf("\nIngrese el costo (Entero)\n");
	scanf("%s", nuevo_costo);


	/*
	 * ==========================================
	 * Se añade la respectiva linea con todos
	 * los respectivos parametros del modelo
	 * multidimensional en el archivo .csv
	 * ==========================================
	 * 
	 * */
	fprintf(fp, "%s, %s, %s, %s, %s, %s, %s\n", nueva_region, nuevo_pais, nueva_linea, nuevo_modelo, nueva_cantidad, nuevo_precio , nuevo_costo);
	printf("\nSe ha anadido correctamente");
	
	/*
	 * ==========================================
	 * Se cierra el archivo
	 * ==========================================
	 * 
	 * */
	fclose(fp);
	return 0;
}

/*
 * =================================================================main
 * Función    : main
 * Proposito  : La funcion main se va a encargar como un medio de 
 *              control para poder ejecutar las funcionalidades del 
 *              sistema.
 * Parametros : Ninguno 
 * Retorno    : Las funcionalidades respectivas explicadas anteriormente
 * =====================================================================
 * */
int main()
{
	struct cubo* cubo;
    cubo = crear_cubo();
	cargar_cubo(cubo);
	//Exportar
	guardar_nueva_linea_cubo();
	//Prueba borrar cubo
	//borrar_cubo(cubo);
	imprimir_cubo(cubo);
    return 0;
}
