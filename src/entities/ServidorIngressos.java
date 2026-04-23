package entities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorIngressos {

    private int porta;
    private Bilheteria bilheteria;

    public ServidorIngressos(int porta, Bilheteria bilheteria) {
        this.porta = porta;
        this.bilheteria = bilheteria;
    }

    public void iniciar() throws IOException {
        ServerSocket server = new ServerSocket(porta);
        System.out.println("Servidor rodando...");
        while (true) {
            Socket cliente = server.accept();
            System.out.println("Cliente conectado");

            ClienteHandler handler = new ClienteHandler(bilheteria, cliente);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }

}
