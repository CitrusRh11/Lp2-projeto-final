package Estoque;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Main {

	// Um unico Scanner para todo o programa: varios Scanners lendo System.in perdem entrada.
	static Scanner in = new Scanner(System.in);

	static final String[] CATEGORIAS = { "Alimentos", "Frutas e Verduras", "Frios", "Limpeza" };

	public static void main(String[] args) {

		Armazenamento armazemAli = new Armazenamento();
		Armazenamento armazemFrut = new Armazenamento();
		Armazenamento armazemFrio = new Armazenamento();
		Armazenamento armazemLimp = new Armazenamento();
		List<Armazenamento> armazens = List.of(armazemAli, armazemFrut, armazemFrio, armazemLimp);

		Armazenamento carro = new Armazenamento();
		ArmazenamentoHash hash = new ArmazenamentoHash();

		armazemAli.adicionarEstoque(new alimento("Pipoca", "yoki", 10, 5.50, "Mar vermelho", 10, 7));
		armazemAli.adicionarEstoque(new alimento("Cereal", "Nestle", 120, 12.99, "Assai", 12, 12));
		armazemAli.adicionarEstoque(new alimento("Arroz", "Pop", 300, 5.99, "Assai", 1, 1));
		armazemAli.adicionarEstoque(new alimento("Caixa de chocolate", "Garoto", 33, 9.99, "Extra", 3, 8));
		armazemFrut.adicionarEstoque(new frutasVerduras("Banana", "prata", 1500, 9.90, "Favorito", 17, 7));
		armazemFrut.adicionarEstoque(new frutasVerduras("Pepino", "Tio Ze", 78, 8.99, "Tio Ze", 28, 7));
		armazemFrut.adicionarEstoque(new frutasVerduras("Cenoura", "Tio Ze", 949, 1.99, "Tio Ze", 28, 7));
		armazemFrut.adicionarEstoque(new frutasVerduras("Cebola", "Fazenda do seu Ze", 300, 2.99, "Seu Ze", 9, 7));
		armazemFrio.adicionarEstoque(new frios("Carne de porco", "Friboi", 798, 4.75, "Nordestao", 7, 3, -10));
		armazemFrio.adicionarEstoque(new frios("Lasanha congelada", "Sadia", 77, 8.99, "Imperatriz", 10, 6, -5));
		armazemFrio.adicionarEstoque(new frios("Empanado", "Rezende", 2300, 2.50, "Imperatriz", 17, 3, -20));
		armazemFrio.adicionarEstoque(new frios("Presunto", "Sadia", 75, 20, "Friboi", 15, 7, 5));
		armazemLimp.adicionarEstoque(new limpeza("Escova de dente", "Colgate", 99999, 11, "Hiper", 9, 11));
		armazemLimp.adicionarEstoque(new limpeza("Sabonete", "Dove", 463, 3.99, "Hiper", 13, 5));
		armazemLimp.adicionarEstoque(new limpeza("Sabao em po", "Ype", 4326, 6.49, "Hiper", 23, 2));

		Menu menu = new Menu();
		int opcao = -1;

		while (opcao != 0) {
			menu.art();
			menu.menu();
			opcao = readInt(0, 3);
			limparConsole();
			switch (opcao) {
				case 1:
					gerenciarEstoque(menu, armazens);
					break;
				case 2:
					listarTodos(armazens);
					break;
				case 3:
					gerenciarCarrinho(menu, armazens, carro, hash);
					break;
			}
		}
	}

	// ---------- Entrada ----------

	public static void limparConsole() {
		for (int i = 0; i < 30; i++) {
			System.out.println("");
		}
	}

	public static int readInt() {
		while (true) {
			if (in.hasNextInt()) {
				return in.nextInt();
			}
			if (!in.hasNext()) {
				System.exit(0); // fim da entrada
			}
			System.out.println("Erro: Digite um numero inteiro valido.");
			in.next(); // descarta o que foi digitado
		}
	}

	public static int readInt(int min, int max) {
		int valor = readInt();
		while (valor < min || valor > max) {
			System.out.println("Valor invalido. Digite um numero entre " + min + " e " + max + ".");
			valor = readInt();
		}
		return valor;
	}

	public static double readDouble() {
		while (true) {
			if (!in.hasNext()) {
				System.exit(0);
			}
			String token = in.next().replace(',', '.');
			try {
				double valor = Double.parseDouble(token);
				if (valor >= 0) {
					return valor;
				}
			} catch (NumberFormatException e) {
				// cai na mensagem abaixo
			}
			System.out.println("Erro: Digite um valor numerico valido.");
		}
	}

	public static String readLine() {
		String linha = "";
		while (linha.isBlank()) {
			if (!in.hasNextLine()) {
				System.exit(0);
			}
			linha = in.nextLine().trim();
		}
		return linha;
	}

	// ---------- Estoque ----------

	static void gerenciarEstoque(Menu menu, List<Armazenamento> armazens) {
		int opcao = -1;
		while (opcao != 4) {
			menu.menu1();
			opcao = readInt(1, 4);
			limparConsole();
			switch (opcao) {
				case 1:
					adicionarProduto(menu, armazens);
					break;
				case 2:
					removerProduto(armazens);
					break;
				case 3:
					verificarValidade(armazens);
					break;
			}
		}
	}

	static void adicionarProduto(Menu menu, List<Armazenamento> armazens) {
		menu.addProd();
		int opcao = readInt(1, 5);
		if (opcao == 5) {
			return;
		}
		int categoria = opcao - 1;
		Estoque produto = lerProduto(categoria);
		armazens.get(categoria).adicionarEstoque(produto);
		System.out.println(produto.getnome() + " adicionado em " + CATEGORIAS[categoria] + ".");
	}

	static Estoque lerProduto(int categoria) {
		System.out.print("Nome: ");
		String nome = readLine();
		System.out.print("Marca: ");
		String marca = readLine();
		System.out.print("Quantidade: ");
		int quantidade = readInt(1, Integer.MAX_VALUE);
		System.out.print("Preco (R$): ");
		double preco = readDouble();
		System.out.print("Fornecedor: ");
		String fornecedor = readLine();
		System.out.print("Validade - dia: ");
		int dia = readInt(1, 31);
		System.out.print("Validade - mes: ");
		int mes = readInt(1, 12);

		switch (categoria) {
			case 0:
				return new alimento(nome, marca, quantidade, preco, fornecedor, dia, mes);
			case 1:
				return new frutasVerduras(nome, marca, quantidade, preco, fornecedor, dia, mes);
			case 2:
				System.out.print("Temperatura de armazenamento (graus C): ");
				int temperatura = readInt(-50, 50);
				return new frios(nome, marca, quantidade, preco, fornecedor, dia, mes, temperatura);
			default:
				return new limpeza(nome, marca, quantidade, preco, fornecedor, dia, mes);
		}
	}

	static void removerProduto(List<Armazenamento> armazens) {
		System.out.println("Selecione o estoque:");
		for (int i = 0; i < CATEGORIAS.length; i++) {
			System.out.println((i + 1) + " ~> " + CATEGORIAS[i]);
		}
		Armazenamento armazem = armazens.get(readInt(1, CATEGORIAS.length) - 1);
		List<Estoque> itens = armazem.getEstoque();

		if (itens.isEmpty()) {
			System.out.println("Estoque vazio.");
			return;
		}
		listarResumo(itens);
		System.out.println("Selecione o numero do produto que deseja remover:");
		int indice = readInt(1, itens.size()) - 1;
		Estoque produto = itens.get(indice);
		armazem.removerEstoque(indice);
		System.out.println("O produto " + produto.getnome() + " foi removido do estoque.");
	}

	static void verificarValidade(List<Armazenamento> armazens) {
		System.out.println("Produtos que vencem nos proximos 14 dias:");
		LocalDate hoje = LocalDate.now();
		int cont = 1;
		for (Armazenamento armazem : armazens) {
			for (Estoque item : armazem.getEstoque()) {
				long dias = diasAteVencer(item, hoje);
				if (dias <= 14) {
					System.out.println(cont + ". " + item.getnome() + " - " + dias + " dias restantes.");
					cont++;
				}
			}
		}
		if (cont == 1) {
			System.out.println("Nenhum produto.");
		}
		System.out.println("");
	}

	// A validade guarda so dia e mes, entao considera a proxima ocorrencia dessa data.
	static long diasAteVencer(Estoque item, LocalDate hoje) {
		LocalDate validade = dataNoAno(hoje.getYear(), item);
		if (validade.isBefore(hoje)) {
			validade = dataNoAno(hoje.getYear() + 1, item);
		}
		return ChronoUnit.DAYS.between(hoje, validade);
	}

	// Ajusta dias que nao existem no mes (ex.: 31/04 vira 30/04) em vez de lancar excecao.
	static LocalDate dataNoAno(int ano, Estoque item) {
		YearMonth mes = YearMonth.of(ano, item.getValidadeM());
		int dia = Math.min(item.getValidadeD(), mes.lengthOfMonth());
		return mes.atDay(dia);
	}

	// ---------- Listagens ----------

	static void listarTodos(List<Armazenamento> armazens) {
		System.out.println("Lista de Produtos:");
		for (int i = 0; i < CATEGORIAS.length; i++) {
			System.out.println("");
			System.out.println(CATEGORIAS[i] + ":");
			int cont = 1;
			for (Estoque item : armazens.get(i).getEstoque()) {
				System.out.print(cont + ". " + item.getnome() + " || ");
				System.out.print("Marca: " + item.getmarca() + " || ");
				System.out.print("Unidades: " + item.getquantidade() + " || ");
				System.out.print("R$" + item.getpreço() + " || ");
				System.out.print("Fornecedor: " + item.getfornecedor() + " || ");
				if (item instanceof frios) {
					System.out.print("Temperatura: " + ((frios) item).getTemperatura() + " C || ");
				}
				System.out.println("Validade: " + item.getValidadeD() + "/" + item.getValidadeM());
				cont++;
			}
			System.out.println("-----------------");
		}
		System.out.println("");
	}

	static void listarResumo(List<Estoque> itens) {
		int cont = 1;
		for (Estoque item : itens) {
			System.out.println(cont + ". " + item.getnome() + " || " + item.getmarca() + " || "
					+ item.getquantidade() + " un. || R$" + item.getpreço());
			cont++;
		}
	}

	// ---------- Carrinho ----------

	static void gerenciarCarrinho(Menu menu, List<Armazenamento> armazens, Armazenamento carro,
			ArmazenamentoHash hash) {
		int opcao = -1;
		while (opcao != 4) {
			menu.artCarrinho();
			menu.carrinho();
			opcao = readInt(1, 4);
			limparConsole();
			switch (opcao) {
				case 1:
					adicionarAoCarrinho(menu, armazens, carro, hash);
					break;
				case 2:
					removerDoCarrinho(carro, hash);
					break;
				case 3:
					listarCarrinho(carro);
					break;
			}
		}
	}

	static void adicionarAoCarrinho(Menu menu, List<Armazenamento> armazens, Armazenamento carro,
			ArmazenamentoHash hash) {
		menu.addProd();
		int opcao = readInt(1, 5);
		if (opcao == 5) {
			return;
		}
		Armazenamento armazem = armazens.get(opcao - 1);
		List<Estoque> itens = armazem.getEstoque();
		if (itens.isEmpty()) {
			System.out.println("Estoque vazio.");
			return;
		}

		listarResumo(itens);
		System.out.println("Escolha o produto que voce deseja comprar");
		int indice = readInt(1, itens.size()) - 1;
		Estoque produto = itens.get(indice);

		System.out.println("Quantas unidades? (disponivel: " + produto.getquantidade() + ")");
		int unidades = readInt(1, produto.getquantidade());

		// O HashMap indexa o carrinho pelo nome: comprar o mesmo produto de novo soma as unidades.
		Estoque noCarrinho = hash.lista().get(produto.getnome());
		if (noCarrinho != null) {
			noCarrinho.setquantidade(noCarrinho.getquantidade() + unidades);
		} else {
			Estoque item = new Estoque(produto.getnome(), produto.getmarca(), unidades, produto.getpreço(),
					produto.getfornecedor(), produto.getValidadeD(), produto.getValidadeM());
			carro.adicionarEstoque(item);
			hash.adicionarEstoque(item);
		}

		produto.setquantidade(produto.getquantidade() - unidades);
		if (produto.getquantidade() == 0) {
			armazem.removerEstoque(indice);
		}
		System.out.println(unidades + "x " + produto.getnome() + " adicionado ao carrinho.");
	}

	static void removerDoCarrinho(Armazenamento carro, ArmazenamentoHash hash) {
		List<Estoque> carrinho = carro.getEstoque();
		if (carrinho.isEmpty()) {
			System.out.println("Carrinho vazio.");
			return;
		}

		int cont = 1;
		for (Estoque item : carrinho) {
			System.out.println(cont + ". " + item.getnome() + " || Quant: " + item.getquantidade());
			cont++;
		}
		System.out.println("Selecione o numero do produto que deseja remover:");
		int indice = readInt(1, carrinho.size()) - 1;
		Estoque item = carrinho.get(indice);

		System.out.println("Quantas unidades deseja remover?");
		int unidades = readInt(1, item.getquantidade());
		item.setquantidade(item.getquantidade() - unidades);

		if (item.getquantidade() == 0) {
			carro.removerEstoque(indice);
			hash.removerEstoque(item.getnome());
			System.out.println("O produto " + item.getnome() + " foi completamente removido do carrinho.");
		} else {
			System.out.println("Foram removidas " + unidades + " unidades do produto " + item.getnome() + ".");
		}
	}

	static void listarCarrinho(Armazenamento carro) {
		List<Estoque> carrinho = carro.getEstoque();
		if (carrinho.isEmpty()) {
			System.out.println("Carrinho vazio.");
			return;
		}
		double total = 0;
		int cont = 1;
		for (Estoque item : carrinho) {
			double subtotal = item.getquantidade() * item.getpreço();
			System.out.println(cont + ". " + item.getnome() + " || " + item.getquantidade() + " x R$"
					+ item.getpreço() + " || Subtotal: R$" + String.format("%.2f", subtotal));
			total += subtotal;
			cont++;
		}
		System.out.println("Total: R$" + String.format("%.2f", total));
		System.out.println("");
	}
}
