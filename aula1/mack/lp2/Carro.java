package mack.lp2;

public class Carro extends Veiculo {
    private int portas;

    public Carro(String modelo, float velocidade, int portas) {
        super(modelo, velocidade);
        this.portas = portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public int getPortas() {
        return this.portas;
    }

    @Override
    public void andar() {
        System.out.println("andar no carro");
    }

}