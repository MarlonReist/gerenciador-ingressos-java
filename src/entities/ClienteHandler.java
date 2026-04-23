package entities;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;

public class ClienteHandler implements Runnable{
    private Bilheteria bilheteria;
    private Socket cliente;

    public ClienteHandler(Bilheteria bilheteria, Socket cliente) {
        this.bilheteria = bilheteria;
        this.cliente = cliente;
    }

    @Override
    public void run() {
    try {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
        String mensagem = entrada.readLine();

        if ("COMPRAR".equals(mensagem)) {
            String resultado = bilheteria.comprarIngresso();
            saida.println(resultado);
        } else {
            saida.println("Comando inválido");
        }
        cliente.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    }
}
