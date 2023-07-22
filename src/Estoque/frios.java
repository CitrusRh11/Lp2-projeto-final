package Estoque;

public class frios extends Estoque {
	
	private int temperatura;

    public frios(String nome, String marca, int quantidade, double preço, String fornecedor, int ValidadeD, int ValidadeM, int temperatura) {
    	super(nome, marca, quantidade, preço, fornecedor, ValidadeD, ValidadeM);
    	this.temperatura = temperatura;
	}
    
    public int getTemperatura() {
    	return temperatura;
    }
    
    public void setTemperatura(int temperatura) {
    	this.temperatura = temperatura;
    }
}
