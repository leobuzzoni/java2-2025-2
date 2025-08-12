package mack.lp2;

public abstract class Veiculo{
    private String modelo;
    private float velocidade;

    public abstract void andar();

    public Veiculo(String modelo, float velocidade){
        this.modelo = modelo;
        this.velocidade = velocidade;
    }

    public Veiculo(){}

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setVelocidade(float velocidade){
        this.velocidade = velocidade;
    }

    public String getModelo(){
        return this.modelo;
    }

    public float getVelocidade(){
        return this.velocidade;
    }

    
}