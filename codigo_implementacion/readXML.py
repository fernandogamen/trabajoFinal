#! /usr/bin/python
# -*- coding: utf-8 _*_

import xml.etree.ElementTree as ET

###########################################
# Por medio de este modulo es que podemos #
# generar un parser para un archivo xml   #
# y cargar la grafica de nuestro          #
# territorio de juego.                    #
# Fernando Abigail Galicia Mendoza        #
# Estefania Prieto Larios                 #
# Antonio Galvan                          #
###########################################

def loadXML():
    '''
    Metodo encargado de generar el arbol que 
    se encuentra definido en el archivo .xml
    '''
    territorio = ET.parse('Territorio.xml')
    arbol = territorio.getroot()
    
    for node in arbol:
        ids = [x.text for x in node.findall('id')]
        continente = [x.text for x in node.findall('continente')]
        tropas = [x.text for x in node.findall('tropas')]
        vecinos = [x.text for x in node.findall('vecino')]
        salida = [node[0].text]+ids+continente+tropas+vecinos
        print [node.attrib['nombre']]+[x.text for x in node]
<<<<<<< HEAD
<<<<<<< HEAD
=======
    
    print arbol.find('pais')
    
=======
>>>>>>> 3a454f73080f9fa5851bf6062c6ff69eab907d58
        
        

    

<<<<<<< HEAD
=======
    
    print arbol.find('pais')
    
>>>>>>> d5a576137561fe483411bc5ba1c454d97b0c69d2
=======
>>>>>>> 431bc719a1723c38e407353ba77ca26a436889fc
>>>>>>> 3a454f73080f9fa5851bf6062c6ff69eab907d58

loadXML()
