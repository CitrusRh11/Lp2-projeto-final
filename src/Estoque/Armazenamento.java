package Estoque;

import java.util.ArrayList;
import java.util.List;

public class Armazenamento {

	ArrayList<Estoque> lista = new ArrayList<Estoque>();

	public void adicionarEstoque(Estoque produto) {
		lista.add(produto);
	}

	public void removerEstoque(int x) {
		lista.remove(x);
	}

	public List<Estoque> getEstoque() {
		return lista;
	}

}
