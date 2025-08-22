package observer;

// Observador concreto
public class Cliente implements ObservadorPedido {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String statusPedido) {
        System.out.println("Olá, " + nome + "! O status do seu pedido mudou para: " + statusPedido);
    }
}