package application;

import entities.Bilheteria;
import entities.ServidorIngressos;

import java.io.IOException;

public class Program {
    public static void main (String[] args) throws IOException {

        Bilheteria bilheteria = new Bilheteria(3);
        ServidorIngressos servidor = new ServidorIngressos(5000, bilheteria);
        servidor.iniciar();
        }
    }
