#lang racket
(require compatibility/mlist)
; ------------------------------------------------------
; Instituto Tecnologico de Costa Rica
; ------------------------------------------------------
;                                    Pablo Muñoz Hidalgo
;                                 Jonathan Quesada Salas
; ------------------------------------------------------

; ---------------------- PROYECTO ----------------------
;-----------------------------------------------------------------------------
; DOMINO
;-----------------------------------------------------------------------------

; Se define la lista de fichas en el orden en que venia en la especificacion.
(define lista-fichas(list (list 0 0) (list 0 1) (list 1 1) (list 0 2)
                                                (list 1 2) (list 2 2) (list 0 3) (list 1 3)
                                                (list 2 3) (list 3 3) (list 0 4) (list 1 4)
                                                (list 2 4) (list 3 4) (list 4 4) (list 0 5)
                                                (list 1 5) (list 2 5) (list 3 5) (list 4 5)
                                                (list 5 5) (list 0 6) (list 1 6) (list 2 6)
                                                (list 3 6) (list 4 6) (list 5 6) (list 6 6)))


; ------------------------------------------------------
;                  ELIMINAR DOMINO (FICHA)
; ------------------------------------------------------
; Entradas: Lista objetivo o lista en donde esta la ficha a borrar
;           Ficha en especifico (Lista)
;
; Salida:   Lista de dominos con la ficha eliminada, esto cambia permanentemente a lista-fichas 
; ------------------------------------------------------
(define (delete-ficha objective-list domino)
  ; Cambia el valor de lista-fichas con la nueva lista con el elemento borrado
  (set! lista-fichas (delete-ficha-aux objective-list domino))
  lista-fichas)


; Funcion auxiliar de Eliminar Domino
(define (delete-ficha-aux objective-list domino)
  ; Revisa que la lista no sea vacia o null
  (cond ((null? objective-list)
         '())
        ; Si el dominoa actual es igual a la ficha que buscamos que la borre
        ((equal? domino (car objective-list))
         (cdr objective-list))
        (else
         ; Si no llama de forma recursiva a si misma sin la ultima ficha consultada, osea borra la ficha temporalmente para analizar la siguiente
         (cons (car objective-list) 
               (delete-ficha-aux (cdr objective-list) domino)))))



; Se define la lista larga como global que en realidad es la lista que contendrá la lista mas grande en un instancia en especifico.
(define lista-larga (list ))


; ------------------------------------------------------
;                  ENCONTRAR LISTA MAS LARGA (LISTA)
; ------------------------------------------------------
; Entradas: Lista objetivo
;           Lista vacia que se llenara iterativamente con las fichas a enlazar
;
; Salida:   Lista enlazada de dominos mas larga encontrada 
; ------------------------------------------------------
(define (find-lista-mas-larga lista-a-buscar lista-temporal)
  ; Revisa que la lista larga este vacia, en caso de que no lo este la borra, esto dado a que si se vuelve a ejecutar la funcion tiende a no devolver nada.
  (cond [(not(empty? lista-larga))(set! lista-larga (list ))])
  ; Revisa que el largo de la lista temporal no sea mas grande que la lista-larga, en caso de que si setea la lista-larga como temporal
  (cond
    [(> (length lista-temporal)(length lista-larga))(set! lista-larga lista-temporal)])
  ; Revisa que la lista a buscar no este vacia y llama al aux
  (cond
    [(empty? lista-a-buscar)lista-larga]
    [(< (length lista-larga)(length lista-fichas)) (lista-mas-larga-aux lista-a-buscar lista-temporal (first lista-a-buscar) lista-a-buscar)]))


; Funcion aux de lista-mas-larga, entra un indice o ficha a comparar
(define (lista-mas-larga-aux lista-a-buscar temporal indice iterative-list)

     ; Revisa que no este vacio
     (cond
       [(empty? temporal) (find-lista-mas-larga (delete-ficha-aux iterative-list indice) (list indice))]
       ; Compara entre el primer indice y el ultimo (segunda posicion) de lista temporal
       [(equal? (first indice) (last (last temporal))) (find-lista-mas-larga (delete-ficha-aux iterative-list indice) (append temporal(list indice)))]
       ; Compara entre el primer indice y la primera de lista temporal
       [(equal? (first indice) (first (first temporal))) (find-lista-mas-larga (delete-ficha-aux iterative-list indice) (append (list (reverse indice)) temporal))]
       ; Compara entre el ultimo de indice (segunda posicion) y la primera de lista temporal
       [(equal? (last indice) (first (first temporal))) (find-lista-mas-larga (delete-ficha-aux iterative-list indice) (append (list indice) temporal))]
       ; Compara entre el primer indice y  el ultimo (segunda posicion) de lista temporal
       [(equal? (last indice) (last (last temporal))) (find-lista-mas-larga (delete-ficha-aux iterative-list indice) (append temporal (list (reverse indice))))]
       ; Si no siga buscando en el resto de la lista
       [else (lista-mas-larga-aux (rest lista-a-buscar) temporal (first (rest lista-a-buscar))iterative-list)]))


; (delete-ficha <objective-list> <domino>)
; (find-lista-más-larga <lista-fichas> <lista-larga>)


     
