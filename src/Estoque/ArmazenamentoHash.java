package Estoque;


import java.util.HashMap;

public class ArmazenamentoHash  {


	private HashMap<String, Estoque> estoqueHashMap;

    public ArmazenamentoHash() {
        estoqueHashMap = new HashMap<>();
    }

    public void adicionarEstoque(Estoque item) {
        estoqueHashMap.put(item.getnome(), item);
    }

    public void removerEstoque(String nomeDoEstoque) {
        estoqueHashMap.remove(nomeDoEstoque);
    }
    
    public HashMap<String, Estoque> lista() {
		return estoqueHashMap;
    }
    
    public boolean HashEmpty(ArmazenamentoHash hash) {
        return hash == null;
    }
		
	}
   

