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
    territorio = ET.parse('Territorio1.xml')
    arbol = territorio.getroot()
    """
    pais = arbol[1]
    ids = arbol[2]
    continente = arbol[3]
    tropas = arbol[4]
    jugador = arbol[5]
    vecinos = arbol[6]
    """
    
    for vecino in arbol.iter('vecino'):
        print vecino.attrib
       
    for ids in arbol.iter('ids'):
        print ids.attrib

    listTropas = []
   
    for tropas in arbol.iter('tropas'):
        for ids in arbol.iter('ids'):
            for vecino in arbol.iter('vecino'):
                listTropas.append((vecino.attrib,tropas.attrib,ids.attrib))
                
    print listTropas
    tropas.set('tropas',9)
    ids.set('ids',3)
    print listTropas
       
loadXML()
