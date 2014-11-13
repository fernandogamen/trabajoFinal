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
        self.vecinos = vecinos


            
    def getnombre(self):
        '''Regresa el nombre del nodo '''
        return self.nombre

    def setnombre(self, nombre):
        '''Asigna el nombre del nodo'''
        self.nombre = nombre

    def getid(self):
        '''Regresa el identificador del nodo'''
        return self.id_pais

    def setid(self, id_nodo):
        '''Asigna el identificador del nodo'''
        self.id_pais = id_pais

    def getcontinente(self):
        '''Regresa el continente al cual pertenece el país'''
        return self.continente

    def setcontinente(self, continente):
        '''Asigna un continente a un pais'''
        self.continente = continente
    

    def gettropas(self):
        '''Regresa las tropas que tiene el pais'''
        return self.tropas

    def settropas(self, tropas):
        '''Actualiza la cantidad de tropas de un jugador en un pais'''
        self.tropas = tropas

    def getjugador(self):
        '''Regresa el jugador al que esta asociado el pais'''
        return self.jugador

    def setjugador(self, jugador):
        '''Actualiza el dominio de un jugador en los territorios'''
        self.jugador = jugador

    def getvecinos(self):
        '''Regresa la lista de vecinos de éste nodo'''
        return self.vecinos
        
    def setvecinos(self, vecinos):
        '''Actualiza la lista de vecinos de ese pais'''
        self.vecinos = vecinos

    def tostring(self):
        print self.nombre, self.id_pais, self.continente,self.tropas, self.jugador, self.vecinos

    
