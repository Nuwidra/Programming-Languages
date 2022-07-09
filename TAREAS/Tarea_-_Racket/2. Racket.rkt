#lang racket
; Instituto Tecnologico de Costa Rica

; Pablo Muñoz Hidalgo
; Jonathan Quesada Salas

; ======== Estructuras ========

; Estructura de persona
(struct person (ID name lastname1 lastname2 address)#:transparent #:mutable)

; Estructura de curso
(struct course (ID name credits)#:transparent)

; Se define los cursos
(define curso1(course 01 'InteligenciaArtificial 4))
(define curso2(course 02 'BasesDeDatos 4))
(define curso3(course 03 'InvestigacionDeOpetaciones 5))
(define curso4(course 03 'Ingles 3))

; Sub-estructura estudiante que extiene de persona
(struct student person (university faculty courses)#:transparent #:mutable)

; Se define a las personas
(define persona1 (student 001 'Marta 'Perez 'Porras 'Heredia 'UNA 'Computacion (list curso1 curso2)))
(define persona2 (student 002 'Gloria 'Avila 'Obando 'Alajuela 'TEC 'IngenieriaIndustrial (list curso3 curso4)))
(define persona3 (person 003 'Jose 'Flores 'Mata 'Cartago))
(define persona4 (person 004 'Diego 'Valverde 'Solis 'SanJose))

; Despliegue todos los datos de la persona 001
persona1

; Despliegue el nombre de la estudiante 002
persona2

; Modifique el primer apellido del estudiante 002 a Matamoros
(set-person-lastname1! persona2 'Matamoros)

; Para mostrar que se hizo el cambio del primer apellido del estudiante 002 a Matamoros
persona2

; Agregue, al final de la lista de cursos el curso 03, al estudiante 001. Despliegue todos los datos del estudiante 001.
(set-student-courses! persona1 (append (list curso3)(student-courses persona1)))

; Se llama a la persona actualizada
persona1

; Punto 10
(define (check-numbers-size a b)
 (cond
 [(empty? b) (cons a b)]
 [(> a (list-ref b 0)) (cons (list-ref b 0) (cons a (rest b)))]
 [else (cons a b)]))

(define (bubble1 L)
 (foldr (lambda (x y) (check-numbers-size x y)) '() L))

(define (bubble lst)
 (cond [(apply < lst) lst]
 [else (bubble (bubble1 lst))]))

(bubble1 (bubble (list 1 5 4 41 0 61 50 84 8 16 6855 6853 6852)))

; Punto 10 modificado

(define (bubble-string L)
 (sort L string<?))


(bubble-string '("InteligenciaArtificial" "BasesDeDatos" "InvestigacionDeOpetaciones" "Ingles"))

