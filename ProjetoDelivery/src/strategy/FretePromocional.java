package strategy;

// Estratégia concreta: frete grátis para pedidos acima de R$ 80,00
public class FretePromocional implements EstrategiaFrete {
    @Override
    public double calcularFrete(double valorTotalPedido) {
        if (valorTotalPedido > 80.00) {
            return 0.00;
        }
        return 5.00; // Frete reduzido
    }
}
