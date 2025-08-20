package mack.principal;

import mack.lp2.*;

public class Principal {
    public static void main(String[] args) {
        Veiculo v1 = new Carro("ferrari", 0.0f, 4);
        Veiculo v2 = new Carro("fusca", 0.0f, 4);
        Veiculo v3 = new Motocicleta();

        v1.andar();
        v1 = new Motocicleta();
        v1.andar();

    }
}