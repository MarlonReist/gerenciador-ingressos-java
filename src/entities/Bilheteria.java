package entities;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bilheteria {

    private int ingressosDisponiveis = 3;
    private Lock lock;

    public Bilheteria(int ingressosDisponiveis) {
        this.ingressosDisponiveis = ingressosDisponiveis;
        this.lock = new ReentrantLock();
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public void setIngressosDisponiveis(int ingressosDisponiveis) {
        this.ingressosDisponiveis = ingressosDisponiveis;
    }

    public String comprarIngresso(){
        lock.lock();
        try {
            if (ingressosDisponiveis > 0) {
                ingressosDisponiveis --;
                return "Ingresso comprado";
            } else {
                return "Ingresso indisponível";
            }
        } finally {
            lock.unlock();
        }
    }
}
