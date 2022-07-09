#-----------------------------
# Primer ejercicio - Parte I
#-----------------------------
import itertools
def PARTE_A_PARTE_I():
    rango = list(range(101))
    LETRAS = ["A", "B", "C", "D", "E", "F"]
    lista_disjunta = (LETRAS + rango)
    interger = [13]
    for i in itertools.product(interger, lista_disjunta):
        print(i)
PARTE_A_PARTE_I()

def PARTE_B_PARTE_I(real1, real2):
    for i in itertools.product(real1, real2):
        print(i)
PARTE_B_PARTE_I([9, 3], [-12,-5.6])

#-----------------------------
# Segundo ejercicio - Parte I
#-----------------------------

def Lista(self, lista):
    self.lista = None or list(lista, Arbol)

def Arbol(self, hoja):
    self.hoja = int
    self.rama = list(Arbol, Arbol)

