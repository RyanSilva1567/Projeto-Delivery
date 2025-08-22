package strategy;

// Estratégia concreta: frete fixo
public class FretePadrao implements EstrategiaFrete {
    @Override
    public double calcularFrete(double valorTotalPedido) {
        // Frete fixo de R$ 10,00
        return 10.00;
    }
}