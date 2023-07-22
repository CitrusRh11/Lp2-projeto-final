package Estoque;

public class Estoque {

	public String nome;
	private String marca;
	private int quantidade;
	private double preço;
	private String fornecedor;
	private int ValidadeD;
	private int ValidadeM;

	public Estoque(String nome, String marca, int quantidade, double preço, String fornecedor, int ValidadeD,
			int ValidadeM) {
		this.nome = nome;
		this.marca = marca;
		this.quantidade = quantidade;
		this.preço = preço;
		this.fornecedor = fornecedor;
		this.ValidadeD = ValidadeD;
		this.ValidadeM = ValidadeM;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getmarca() {
		return marca;
	}

	public void setmarca(String marca) {
		this.marca = marca;
	}

	public int getquantidade() {
		return quantidade;
	}

	public void setquantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getpreço() {
		return preço;
	}

	public void setpreço(double preço) {
		this.preço = preço;
	}

	public String getfornecedor() {
		return fornecedor;
	}

	public void setfornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setValidadeD(int ValidadeD) {
		this.ValidadeD = ValidadeD;
	}

	public int getValidadeD() {
		return ValidadeD;
	}

	public void setValidadeM(int ValidadeM) {
		this.ValidadeM = ValidadeM;
	}

	public int getValidadeM() {
		return ValidadeM;
	}
}
