// src/Main.java

import builder.Pedido;
import builder.Pedido.PedidoBuilder;
import singleton.Cardapio;
import strategy.EstrategiaFrete;
import strategy.FretePadrao;
import strategy.FretePromocional;
import observer.Cliente;
import observer.GerenciadorPedido;
import model.ItemMenu;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cardapio cardapio = Cardapio.getInstancia(); // Singleton
        GerenciadorPedido gerenciador = null;
        Pedido pedidoAtual = null;
        Cliente cliente = new Cliente("João");

        System.out.println("--- Sistema Interativo de Pedidos de Delivery ---");

        boolean sair = false;
        while (!sair) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Fazer um novo pedido");
            System.out.println("2. Atualizar status do pedido (se houver)");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                switch (opcao) {
                    case 1:
                        // --- Demonstração do Padrão Builder e Strategy ---
                        System.out.println("\n--- Fazer Novo Pedido ---");
                        cardapio.exibirCardapio(); // Acessando o Cardápio (Singleton)

                        PedidoBuilder builder = new PedidoBuilder();

                        // Loop para adicionar itens
                        System.out.println("Adicione itens ao seu pedido (digite o número do item). Digite '0' para finalizar.");
                        int itemNum = -1;
                        do {
                            try {
                                System.out.print("Número do item (1 a " + cardapio.getItens().size() + "): ");
                                itemNum = scanner.nextInt();
                                scanner.nextLine(); // Consome a quebra de linha

                                if (itemNum > 0 && itemNum <= cardapio.getItens().size()) {
                                    ItemMenu itemSelecionado = cardapio.getItens().get(itemNum - 1);
                                    builder.adicionarItem(itemSelecionado);
                                    System.out.println(itemSelecionado.getNome() + " adicionado ao pedido.");
                                } else if (itemNum != 0) {
                                    System.out.println("Item inválido. Por favor, tente novamente.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Por favor, digite um número.");
                                scanner.nextLine(); // Limpa o buffer do scanner
                                itemNum = -1; // Para continuar o loop
                            }
                        } while (itemNum != 0);

                        System.out.print("Adicionar observações ao pedido? (Digite aqui ou pressione Enter para pular): ");
                        String observacoes = scanner.nextLine();
                        if (!observacoes.isEmpty()) {
                            builder.adicionarObservacoes(observacoes);
                        }

                        pedidoAtual = builder.construir(); // Constrói o pedido usando o Builder

                        double valorTotal = pedidoAtual.getItens().stream().mapToDouble(ItemMenu::getPreco).sum();
                        System.out.println("\nPedido finalizado. Valor total: R$" + String.format("%.2f", valorTotal));

                        // Seleção da estratégia de frete (Strategy)
                        System.out.println("Escolha a estratégia de frete:");
                        System.out.println("1. Frete Padrão (R$ 10,00)");
                        System.out.println("2. Frete Promocional (grátis acima de R$ 80,00)");
                        System.out.print("Opção: ");
                        int opcaoFrete = scanner.nextInt();
                        scanner.nextLine();

                        EstrategiaFrete estrategiaFrete;
                        if (opcaoFrete == 2) {
                            estrategiaFrete = new FretePromocional();
                            System.out.println("Estratégia 'Frete Promocional' selecionada.");
                        } else {
                            estrategiaFrete = new FretePadrao();
                            System.out.println("Estratégia 'Frete Padrão' selecionada.");
                        }
                        double frete = estrategiaFrete.calcularFrete(valorTotal);
                        System.out.println("Valor do frete: R$" + String.format("%.2f", frete));
                        System.out.println("Total a pagar: R$" + String.format("%.2f", valorTotal + frete));

                        // --- Demonstração do Padrão Observer ---
                        gerenciador = new GerenciadorPedido();
                        gerenciador.adicionarObservador(cliente);
                        gerenciador.setStatusPedido("Pedido Recebido");

                        break;

                    case 2:
                        // --- Atualizar Status do Pedido ---
                        if (pedidoAtual != null) {
                            System.out.println("\n--- Atualizar Status do Pedido ---");
                            System.out.print("Digite o novo status (Ex: 'Em preparo', 'A caminho', 'Entregue'): ");
                            String novoStatus = scanner.nextLine();
                            gerenciador.setStatusPedido(novoStatus);
                        } else {
                            System.out.println("Nenhum pedido foi feito ainda.");
                        }
                        break;

                    case 3:
                        sair = true;
                        System.out.println("Obrigado por usar o sistema. Até mais!");
                        break;

                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número correspondente à opção.");
                scanner.nextLine(); // Limpa o buffer para evitar loop infinito
            }
        }
        scanner.close();
    }
}