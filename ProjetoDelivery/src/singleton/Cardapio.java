package singleton;
import java.util.ArrayList;
import java.util.List;
import model.ItemMenu;

public class Cardapio {
    // 1. Instância única da classe
    private static Cardapio instanciaUnica;
    private List<ItemMenu> itens;

    // 2. Construtor privado para impedir a criação de novas instâncias
    private Cardapio() {
        this.itens = new ArrayList<>();
        // Adicionando alguns itens de exemplo
        this.itens.add(new ItemMenu("Hamburguer", 25.00));
        this.itens.add(new ItemMenu("Batata Frita", 12.00));
        this.itens.add(new ItemMenu("Refrigerante", 8.00));
        this.itens.add(new ItemMenu("Pizza de Calabresa", 50.00));
    }

    // 3. Método estático para obter a única instância
    // Ele cria a instância se ela ainda não existir.
    public static Cardapio getInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Cardapio();
        }
        return instanciaUnica;
    }

    public List<ItemMenu> getItens() {
        return itens;
    }

    public void exibirCardapio() {
        System.out.println("--- Cardápio do Restaurante ---");
        for (ItemMenu item : itens) {
            System.out.println(item);
        }
        System.out.println("-----------------------------");
    }
}
