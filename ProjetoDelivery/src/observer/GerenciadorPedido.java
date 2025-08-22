package observer;

import java.util.ArrayList;
import java.util.List;
import builder.Pedido;

// O Sujeito (Subject) que notifica
public class GerenciadorPedido {
    private List<ObservadorPedido> observadores = new ArrayList<>();
    private String statusAtual;

    public void adicionarObservador(ObservadorPedido observador) {
        this.observadores.add(observador);
    }

    public void removerObservador(ObservadorPedido observador) {
        this.observadores.remove(observador);
    }

    // Método que notifica todos os observadores
    public void notificarObservadores() {
        for (ObservadorPedido observador : observadores) {
            observador.atualizar(statusAtual);
        }
    }

    // Método para mudar o status do pedido e notificar
    public void setStatusPedido(String novoStatus) {
        System.out.println("\n*** STATUS DO PEDIDO ATUALIZADO: " + novoStatus + " ***");
        this.statusAtual = novoStatus;
        notificarObservadores();
    }
}