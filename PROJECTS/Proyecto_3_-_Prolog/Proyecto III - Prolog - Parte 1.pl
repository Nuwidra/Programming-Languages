% ----------------------------------------------------------------------
%                                                   TAREA PROGRAMADA III
% ----------------------------------------------------------------------
% JONATHAN QUESADA SALAS      - 2020023583
% PABLO ALBERTO MUÑOZ HIDALGO - 2020031899
% ----------------------------------------------------------------------

% -------------------------------------------------------------------------------------------
% DEFINICION DE HECHOS
% -------------------------------------------------------------------------------------------
urbanizacion(a,b,10).
urbanizacion(b,c,3).
urbanizacion(b,e,5).
urbanizacion(b,d,4).
urbanizacion(e,h,2).
urbanizacion(d,h,1).
urbanizacion(c,f,2).
urbanizacion(f,i,3).
urbanizacion(f,j,3).
urbanizacion(g,j,1).
urbanizacion(h,f,1).
urbanizacion(h,i,6).
urbanizacion_inv(b,a,10).
urbanizacion_inv(c,b,3).
urbanizacion_inv(e,b,5).
urbanizacion_inv(d,b,4).
urbanizacion_inv(h,e,2).
urbanizacion_inv(h,d,1).
urbanizacion_inv(f,c,2).
urbanizacion_inv(i,f,3).
urbanizacion_inv(j,f,3).
urbanizacion_inv(j,g,1).
urbanizacion_inv(f,h,1).
urbanizacion_inv(i,h,6).
comisiones(a, b, 5.0).
comisiones(b, c, 1.0).
comisiones(b, e, 2.0).
comisiones(b, d, 2.0).
comisiones(e, h, 1.0).
comisiones(d, h, 0.5).
comisiones(c, f, 1.0).
comisiones(f, i, 2.0).
comisiones(f, j, 2.0).
comisiones(g, j, 0.5).
comisiones(h, f, 0.5).
comisiones(h, i, 3.0).
comisiones(b, a, 5.0).
comisiones(c, b, 1.0).
comisiones(e, b, 2.0).
comisiones(d, b, 2.0).
comisiones(h, e, 1.0).
comisiones(h, d, 0.5).
comisiones(f, c, 1.0).
comisiones(i, f, 2.0).
comisiones(j, f, 2.0).
comisiones(j, g, 0.5).
comisiones(f, h, 0.5).
comisiones(i, h, 3.0).
comisiones(_ , [], 0.0).

% -------------------------------------------------------------------------------------------
% FUNCION RECURSIVA CAMINO QUE VA CONECTANDO LOS NODOS
% -------------------------------------------------------------------------------------------
camino(A, B, [A, B], X) :-
    urbanizacion(A, B, X).
camino(A, B, CaminoAB, Largo) :-
    urbanizacion(A, C, X),
    camino(C, B, CaminoCB, LargoCB),
    CaminoAB = [A | CaminoCB],
    Largo is X + LargoCB.


% -------------------------------------------------------------------------------------------
% FUNCION PRINCIPAL QUE SE LLAMA EN LA INTERFAZ, ORDENA EL CAMINO Y LO IMPRIME AL USUARIO, LLAMA A LA FUNCION CAMINO
% -------------------------------------------------------------------------------------------
caminoMasCorto(A, B) :-
    findall(p(Costo, Camino),
            camino(A, B, Camino, Costo),
            Caminos),
    sort(Caminos, Lista),
    Lista = [p(Costo1, Camino1) | _],
    printCamino(Camino1),
    printComisiones(Camino1, Comision1),
    writef(' (con distancia de %d km y una comision de %d%)\n', [Costo1, Comision1]).

% -------------------------------------------------------------------------------------------
% FUNCION RECURSIVA CAMINO INVERSO QUE VA CONECTANDO LOS NODOS
% -------------------------------------------------------------------------------------------
camino_inv(A, B, [A, B], X) :-
    urbanizacion_inv(A, B, X).
camino_inv(A, B, CaminoAB, Largo) :-
    urbanizacion_inv(A, C, X),
    camino_inv(C, B, CaminoCB, LargoCB),
    CaminoAB = [A | CaminoCB],
    Largo is X + LargoCB.


% -------------------------------------------------------------------------------------------
% FUNCION PRINCIPAL PARA EL CAMINO INVERTIDO QUE SE LLAMA EN LA INTERFAZ, ORDENA EL CAMINO Y LO IMPRIME AL USUARIO, LLAMA A LA FUNCION CAMINO INVERTIDO
% -------------------------------------------------------------------------------------------
caminoMasCorto_inv(A, B) :-
    findall(p(Costo, Camino),
            camino_inv(A, B, Camino, Costo),
            Caminos),
    sort(Caminos, Lista),
    Lista = [p(Costo1, Camino1) | _],
    printCamino(Camino1),
    printComisiones(Camino1, Comision1),
    writef(' (con distancia de %d km y una comision de %d%)\n', [Costo1, Comision1]).

% -------------------------------------------------------------------------------------------
% FUNCION RECURSIVA QUE RECORRE LA LISTA DEL CAMINO SOLUCION E IMPRIME EL COSTO EN COMISIONES
% -------------------------------------------------------------------------------------------
printComisiones([], 0).
printComisiones([X|T], Y) :-
	car(T, Cabeza),
    comisiones(X, Cabeza, Comision),
    printComisiones(T, C),
    Y is Comision + C.

% -------------------------------------------------------------------------------------------
% EXTRAE LA CABEZA DE UNA LISTA, SE USA EN PRINT COMISIONES
% -------------------------------------------------------------------------------------------
car([], []).
car([X|Y], X).

% -------------------------------------------------------------------------------------------
% FUNCION RECURSIVA QUE RECORRE LA LISTA DE SOLUCION E IMPRIME LA SOLUCION
% -------------------------------------------------------------------------------------------
printCamino([]).
printCamino([X]) :-
    !, write(X).
printCamino([X|T]) :-
    write(X),
    write(', '),
    printCamino(T).

% -------------------------------------------------------------------------------------------
% PRUEBAS
% -------------------------------------------------------------------------------------------
%caminoMasCorto(a,i).
%caminoMasCorto(a,h).
%caminoMasCorto(a,j).
%caminoMasCorto(j,e).

%caminoMasCorto_inv(i,a).
%caminoMasCorto_inv(h,a).
%caminoMasCorto_inv(j,a).
%caminoMasCorto_inv(e,j).
