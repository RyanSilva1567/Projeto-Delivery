package builder;
import java.util.ArrayList;
import java.util.List;
import model.ItemMenu;

public class Pedido {
    private List<ItemMenu> itens;
    private String observacoes;

    // Construtor privado para forçar o uso do Builder
    private Pedido() {
        this.itens = new ArrayList<>();
    }

    // Getters para os atributos
    public List<ItemMenu> getItens() {
        return itens;
    }

    public String getObservacoes() {
        return observacoes;
    }

    // Classe aninhada estática que é o Builder
    public static class PedidoBuilder {
        private Pedido pedido;

        public PedidoBuilder() {
            this.pedido = new Pedido();
        }

        public PedidoBuilder adicionarItem(ItemMenu item) {
            this.pedido.itens.add(item);
            return this; // Retorna a própria instância do Builder para encadeamento
        }

        public PedidoBuilder adicionarObservacoes(String observacoes) {
            this.pedido.observacoes = observacoes;
            return this;
        }

        public Pedido construir() {
            return this.pedido;
        }
    }
}