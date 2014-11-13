#!/usr/bin/python
# -*- coding: utf-8 _*_

class Node:
    '''Representación de un nodo en una grafica'''

    def __init__(self, nombre, id_pais, continente,tropas, jugador, vecinos):
        '''Constructor del nodo '''
        self.nombre = nombre
        self.id_pais = id_pais
        self.continente = continente
        self.tropas = tropas
        self.jugador = jugador
        if type(vecinos) == list:
            self.vecinos = vecinos
        else:
            return None


            
    def getnombre(self):
        '''Regresa el nombre del nodo '''
        return self.nombre

    def getid(self):
        '''Regresa el identificador del nodo'''
        return self.id_pais

    def getcontinente(self):
        '''Regresa el continente al cual pertenece el país'''
        return self.continente

    def gettropas(self):
        '''Regresa las tropas que tiene el pais'''
        return self.tropas

    def getjugador(self):
        '''Regresa el jugador al que esta asociado el pais'''
        return self.jugador

    def getvecinos(self):
        '''Regresa la lista de vecinos de éste nodo'''
        return self.vecinos
        

    
