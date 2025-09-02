public class CriterioPrecoMaximo implements CriterioBusca {
    public boolean testar(Produto p, String valor) {
        return p.getPreco() <= Double.parseDouble(valor);
    }
}