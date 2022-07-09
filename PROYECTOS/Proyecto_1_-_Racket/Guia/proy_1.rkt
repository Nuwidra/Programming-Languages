#lang racket
(require compatibility/mlist)
;-----------------------------------------------------------------------------
; Creación del árbol

; struct node
(struct node(id name value hijo)#:transparent #:mutable)

; create-node() 
; crea un struct de tipo node para el arbol 
(define (create-node id name value hijo)
 (define new-node(node id name value hijo))
  new-node)

; struct tree
; Contiene un struct de tipo node que representa al padre del arbol
(struct tree(padre)#:transparent #:mutable)

; create-tree()
; Crea una struct de tipo arbol, que a su vez crea el primer struct node del arbol
(define (create-tree id name value)
  (define new-tree(tree (create-node id name value (list))))
  new-tree)

;-----------------------------------------------------------------------------
#|find-node()
recibe el identificador de un nodo y un arbol|#
(define (find-node id parameter-tree)

; DEFINICION DE VARIABLES
  (define node-root (list (tree-padre parameter-tree)))
  (define result #f)


; DEFINICION DE FUNCIONES INTERNAS 

  #|find-node-aux()
  recibe el mismo id y una lista que contiene un conjunto de nodos
  verifica si existe un nodo con el id|#
  (define (find-node-aux id node-list)

      (define actual-node (first node-list))
    
      (cond
        [(= (node-id actual-node) id) ; si corresponde al nodo
         (set! result actual-node)] ; cambia la variable de result a ese nodo
        [else
         (cond  ; si tiene hijos llama a la funcion que itera estos 
           [(not(empty? (node-hijo actual-node))) 
            (iterate-hijo id (node-hijo actual-node))])]))

  
  #|iterate-hijos()
  recibe el mismo id y la lista de hijos|#
  (define (iterate-hijo id hijo)
    (unless (empty? hijo) 
      (find-node-aux id hijo) 
      (cond
        [(equal? result #f) ; si no cambia el resultado continua iterando los hijos
         (iterate-hijo id (rest hijo))])))
  
  
;  FUNCION PRINCIPAL 

; llamado a la funcion auxiliar con el id y con la raiz
  (find-node-aux id node-root)
  
  result) ; si nunca encontro el nodo, retorna falso 

;-----------------------------------------------------------------------------
#|insert-node()
recibe un arbol, el id del padre del nodo a insertar y
la informacion del nodo a insertar|#
(define (insert-node parameter-tree id-padre id name value)

;  DEFINICION DE VARIABLES
  (define node-root (tree-padre parameter-tree))
  (define padre-to-insert (find-node id-padre parameter-tree))
  (define node-to-insert (create-node id name value '()))

;  FUNCION PRINCIPAL 
  (cond
    [(not (equal? #f (find-node id parameter-tree))) ; si existe el nodo
     (displayln "nodo ya existe")]
    
    [else
     (set-node-hijo! padre-to-insert
             ; cambia la lista de hijos
             ; añade el nuevo nodo a la izquierda
            (list* node-to-insert (node-hijo padre-to-insert)))]))

;-----------------------------------------------------------------------------
#|ancestor()
recibe un arbol y el id del nodo|#
(define (ancestor id parameter-tree)

;  DEFINICION DE VARIABLES
  (define result #f)
  (define node-root (list (tree-padre parameter-tree)))

;  DEFINICION DE FUNCIONES INTERNAS 

  #|ancestor-aux()
  recibe el mismo id, una lista que contiene un conjunto de nodos
  y al posible nodo-padre
  verifica si existe un nodo con el id|#
  (define (ancestor-aux id node-list padre-node)
    
    (define actual-node (first node-list))
    
    (cond
     [(= (node-id actual-node) id) ;si corresponde al nodo
      (set! result padre-node)]
     [else
      (cond
        [(not(empty? (node-hijo actual-node))) ;si tiene hijos itera sobre estos
        (iterate-hijo id (node-hijo actual-node) actual-node)])]))

  
  #|iterate-hijo()
  recibe el mismo id, la lista de hijos
  y al posible padre|#
  (define (iterate-hijo id hijo padre-node)
    (unless (empty? hijo)
      (ancestor-aux id hijo padre-node)
      (cond
        [(equal? result #f) ; si no cambia el resultado continua iterando los hijos
         (iterate-hijo id (rest hijo) padre-node)])))

;  FUNCION PRINCIPAL 

; llamado a la funcion auxiliar con el id, la raiz, y una lista vacía como posible padre
  (ancestor-aux id node-root '()) 

  result) ; si el id corresponde a la raiz, retorna una lista vacia

;-----------------------------------------------------------------------------
#|delete-node()
recibe un arbol y el id del nodo|#
(define (delete-node id parameter-tree)

;  DEFINICION DE VARIABLES
  (define node-to-eliminate (find-node id parameter-tree))
  
;  DEFINICION DE FUNCIONES INTERNAS

  #|delete-node-aux()
   recibe un arbol y el id del nodo|#
  (define (delete-node-aux id node hijo)
    
    ; intercambia los datos del nodo a eliminar por los de su primer hijo
    (set-node-id! node (node-id (first hijo)))
    (set-node-name! node (node-name (first hijo)))
    (set-node-value! node (node-value (first hijo)))

    ; almacena temportalmente los hijos del hijo por el cual se hara el cambio
    (define temp-child (node-hijo (first hijo)))

    ; elimina al primer hijo de la lista de hijos
    (set-node-hijo! node
                        (remove* (list (first hijo))
                                 (node-hijo node)))
    ; añade los nuevos hijos 
    (set-node-hijo! node
                        (append temp-child (node-hijo node))))
  
  
;  FUNCION PRINCIPAL 

  (cond
      ; si el nodo a eliminar tiene hijos
    [(not (empty? (node-hijo node-to-eliminate)))
     (delete-node-aux id node-to-eliminate (node-hijo node-to-eliminate))]
    
   [else
    ; si no tiene se situa en el padre y simplemente elimina el nodo
    (define padre (ancestor id parameter-tree))
    (set-node-hijo! padre
                        (remove* (list node-to-eliminate) (node-hijo padre)))])
  
           
  (tree-padre parameter-tree))

;-----------------------------------------------------------------------------
#|find-right-siblings()
recibe un arbol y el id del nodo al que buscar el hermano derecho|#
(define (find-right-siblings id parameter-tree)

;  DEFINICION DE VARIABLES
  (define node-root(list(tree-padre parameter-tree)))
  (define result #f)

;  DEFINICION DE FUNCIONES INTERNAS

  #|find-right-siblings-aux()
  recibe el mismo id, una lista que contiene un conjunto de nodos
  verifica si existe un nodo con el id|#
  (define (find-right-siblings-aux id node-list)
    
    (define actual-node (first node-list))
    
    (cond
      [(= (node-id actual-node) id) ; si corresponde al id hay dos opciones
       
       (cond
         [(empty? (rest node-list)) ; si el resto de la lista esta vacia no tiene hermanos
          (set! result '())]
         [else
          (set! result (second node-list))])] ; en caso contrario setea el siguiente nodo

      [else
       (cond
         [(not(empty? (node-hijo actual-node))) ;si tiene hijos itera sobre estos 
          (iterate-hijo id (node-hijo actual-node))])]))
  

  #|iterate-hijos()
  recibe el mismo id y la lista de hijos|#
  (define (iterate-hijo id hijo)
    (unless (empty? hijo)
      (find-right-siblings-aux id hijo)
      (cond
        [(equal? result #f) ; si no cambia el resultado continua iterando los hijos
         (iterate-hijo id (rest hijo))])))

  
;  FUNCION PRINCIPAL 

  (find-right-siblings-aux id node-root)

  (cond
    [(equal? result '()) (displayln "no hermanos derecho")]
    [else result])); si result es una lista vacia

;-----------------------------------------------------------------------------
#|find-left-siblings()
recibe un arbol y el id del nodo al que buscar el hermano izquierdo|#
(define (find-left-siblings id parameter-tree)

;  DEFINICION DE VARIABLES
  (define node-root(list(tree-padre parameter-tree)))
  (define result #f)
  
;  DEFINICION DE FUNCIONES INTERNAS

  #|find-left-siblings-aux()
  recibe el mismo id y la lista de hijos y el posible hermano|#
  (define (find-left-siblings-aux id parameter-node left-sibling)
    
      (define actual-node (first parameter-node ))
      (cond
        [(= (node-id actual-node) id)
            (set! result left-sibling)]
        [else
         (cond
           [(not(empty? (node-hijo actual-node)));si tiene hijos itera sobre estos
            (iterate-hijos id (node-hijo actual-node) '())])]))
                                                       #|el posible hermano se ingresa como
                                                    vacio ya que ingresa a una nueva lista de
                                                    hermanos|#

  
  #|iterate-hijos()
  recibe el mismo id y la lista de hijos y el posible hermano|#
  (define (iterate-hijos id hijo sibling)
    (unless (empty? hijo)
      (find-left-siblings-aux id hijo sibling)
      (cond
        [(equal? result #f) ; si no cambia el resultado continua iterando los hijos
         (iterate-hijos id (rest hijo) (list(first hijo)))])))
                                               #|en la siguiente interacion establece el posible
                                              hermano con el elemento a la izquierda
                                              del siguiente elemento a iterar|#

  
;  FUNCION PRINCIPAL 
  (find-left-siblings-aux id node-root '())

  (cond
    [(equal? result '()) (displayln "no hermano izquierdo")]
    [else result])); si result es una lista vacia

;-----------------------------------------------------------------------------



;Arbol Prueba
(define arbol-prueba (create-tree 01 "prueba" 69))
(define node2 (create-node 02 "prueba2" 70 (list)))
(define node3 (create-node 03 "prueba3" 71 (list)))
(define node4 (create-node 04 "prueba4" 72 (list)))

(define list-append (append (list node2)(list node3)(list node4)))

(set-node-hijo! node3 (list (create-node 05 "prueba5" 73 (list)) (create-node 07 "prueba07" 77 (list (create-node 08 "prueba08" 100 (list))))))
(set-node-hijo! node4 (list (create-node 20 "prueba20" 42 (list))))
(set-node-hijo! (tree-padre arbol-prueba) list-append)


