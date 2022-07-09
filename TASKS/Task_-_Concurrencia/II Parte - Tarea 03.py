import math
import threading
import asyncio
import os
import time

#Funcion para sacar la piramide pentagonal
def piramide_pentagonal (altura, apotema, lado):
    area_basal = (5*lado*apotema)/2
    resultado = (area_basal*altura)/3
    print('El volumen de la piramide pentagonal es de: ', int(resultado), 'cm3')
    return resultado

#Funcion para sacar el cilindro
def cilindro (diametro, altura):
    resultado = math.pi*((diametro/2)**2)*altura
    print('El volumen del cilindro es de: ', int(resultado), 'cm3')
    return resultado

#Funcion para sacar volumenes
def volumenes ():
    resultado = cilindro(500, 350) - piramide_pentagonal (250, 150, 50)
    print('El volumen del cilindo y la piramide dentro de este es de: ', int(resultado), 'cm3')

#Funcion para sacar volumenes con Asyncio
async def volumenes_asyncio ():
    resultado = cilindro(500, 350) - piramide_pentagonal (250, 150, 50)
    print('El volumen del cilindo y la piramide dentro de este es de: ', int(resultado), 'cm3')

#Programa sin concurrencia
print('Los volumenes sin concurrencia:')
volumenes()
time.sleep(5)
os.system("clear")

#Programa con concurrencia Threading
print('Los volumenes con Threading:')
t = threading.Thread(target=volumenes)
t.start()
time.sleep(5)
os.system("clear")

#Programa con concurrencia Asyncio
print('Los volumenes con Asyncio:')
asyncio.run(volumenes_asyncio())
time.sleep(5)
os.system("clear")