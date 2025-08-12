package mack.principal;

import mack.lp2.*;

public class Principal{

    public static void main(String[] args) {
        Veiculo v1 = new Carro("Ferrari", 0.0f);
        Veiculo v2 = new Carro("Fusca", 0.0f);
        Veiculo v3 = new Motocicleta("Moto", 0.0f);

        v1.andar();
        v2.andar();
        v3.andar();

        v1 = new Motocicleta();
        v1.andar();
    }
}