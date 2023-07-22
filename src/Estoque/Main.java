package Estoque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Main {

	public static void limparConsole() {
		for (int i = 0; i < 30; i++) {
			System.out.println("");
		}
	}

	public static int readInt() {
		Scanner scanner = new Scanner(System.in);
		int input;
		while (true) {
			try {
				input = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Erro: Digite um numero inteiro valido.");
				scanner.nextLine(); // Clear the invalid input from the scanner
			}
		}
		return input;
	}

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		Armazenamento armazemAli = new Armazenamento();
		List<Estoque> ItensAli = armazemAli.getEstoque();

		Armazenamento armazemFrut = new Armazenamento();
		List<Estoque> ItensFrut = armazemFrut.getEstoque();

		Armazenamento armazemFrio = new Armazenamento();
		List<Estoque> ItensFrio = armazemFrio.getEstoque();

		Armazenamento armazemLimp = new Armazenamento();
		List<Estoque> ItensLimp = armazemLimp.getEstoque();

		Armazenamento carro = new Armazenamento();
		List<Estoque> carrinho = carro.getEstoque();

		ArmazenamentoHash hash = new ArmazenamentoHash();
		HashMap<String, Estoque> map = hash.lista();

		alimento x5 = new alimento("Pipoca", "yoki", 10, 5.50, "Mar vermelho", 10, 7);
		frutasVerduras x2 = new frutasVerduras("Banana", "prata", 1500, 9.90, "Favorito", 17, 7);
		frios x3 = new frios("Carne de porco", "Friboi", 798, 4.75, "Nordestao", 7, 3, -10);
		limpeza x4 = new limpeza("Escova de dente", "Colgate", 99999, 11, "Hiper", 9, 11);
		alimento produto1 = new alimento("Cereal", "Nestle", 120, 12.99, "Assai", 12, 12);
		alimento produto2 = new alimento("Arroz", "Pop", 300, 5.99, "Assai", 1, 1);
		frutasVerduras produto3 = new frutasVerduras("Pepino", "Tio Ze", 78, 8.99, "Tio Ze", 28, 7);
		frutasVerduras produto4 = new frutasVerduras("Cenoura", "Tio Ze", 949, 1.99, "Tio Ze", 28, 7);
		frios produto5 = new frios("Lasanha congelada", "Sadia", 77, 8.99, "Imperatriz", 10, 6, -5);
		frios produto6 = new frios("Empanado", "Rezende", 2300, 2.50, "Imperatriz", 17, 3, -20);
		limpeza produto7 = new limpeza("Sabonete", "Dove", 463, 3.99, "Hiper", 13, 5);
		limpeza produto8 = new limpeza("Sabao em po", "Ype", 4326, 6.49, "Hiper", 23, 2);
		alimento produto9 = new alimento("Caixa de chocolate", "Garoto", 33, 9.99, "Extra", 3, 8);
		frios produto10 = new frios("Presunto", "Sadia", 75, 20, "Friboi", 15, 7, 5);
		frutasVerduras produto11 = new frutasVerduras("Cebola", "Fazendo do seu Ze", 300, 2.99, "Seu Ze", 9, 7);

		armazemAli.adicionarEstoque(x5);
		armazemFrut.adicionarEstoque(x2);
		armazemFrio.adicionarEstoque(x3);
		armazemLimp.adicionarEstoque(x4);
		armazemAli.adicionarEstoque(produto1);
		armazemAli.adicionarEstoque(produto2);
		armazemAli.adicionarEstoque(produto9);
		armazemFrut.adicionarEstoque(produto3);
		armazemFrut.adicionarEstoque(produto4);
		armazemFrut.adicionarEstoque(produto11);
		armazemFrio.adicionarEstoque(produto5);
		armazemFrio.adicionarEstoque(produto6);
		armazemFrio.adicionarEstoque(produto10);
		armazemLimp.adicionarEstoque(produto7);
		armazemLimp.adicionarEstoque(produto8);

		Menu menu = new Menu();
		int x = 100;

		while (x != 0) {
			menu.art();
			menu.menu();
			x = readInt();
			limparConsole();
			while (x < 0 || x > 4) {
				System.out.println("Escolha uma opcao valida");
				x = in.nextInt();
			}
			switch (x) {

				case 1:
					// Gerenciamento de estoque
					while (x != 4) {
						menu.menu1();
						x = readInt();
						limparConsole();
						while (x < 1 || x > 4) {
							System.out.println("Escolha uma opcao valida");
							x = in.nextInt();
						}
						switch (x) {
							case 1:
								// Adicionar alimento
								int aux = 10;
								menu.addProd();
								aux = readInt();
								while (aux < 1 || x > 5) {
									System.out.println("Escolha uma opcao valida");
									aux = readInt();
								}
								switch (aux) {
									case 1:
										System.out.println("Escreva o alimento no formato:");
										System.out.println(
												"Nome, Marca, quantidade, preco, fornecedor, validade Dia Mes");
										Estoque alimento = new alimento(in.next(), in.next(), in.nextInt(),
												in.nextDouble(), in.next(), in.nextInt(), in.nextInt());
										armazemAli.adicionarEstoque(alimento);
										break;

									case 2:
										System.out.println("Escreva a Fruta/Verdura no formato:");
										System.out.println(
												"Nome, Marca, quantidade, preco, fornecedor, validade Dia Mes");
										Estoque frutaVerdura = new frutasVerduras(in.next(), in.next(), in.nextInt(),
												in.nextDouble(), in.next(), in.nextInt(), in.nextInt());
										armazemFrut.adicionarEstoque(frutaVerdura);
										break;

									case 3:
										System.out.println("Escreva os Frios no formato:");
										System.out.println(
												"Nome, Marca, quantidade, preco, fornecedor, validade Dia Mes, temperatura de armazenamento");
										Estoque frio = new frios(in.next(), in.next(), in.nextInt(), in.nextDouble(),
												in.next(), in.nextInt(), in.nextInt(), in.nextInt());
										armazemFrio.adicionarEstoque(frio);
										break;

									case 4:
										System.out.println("Escreva os Frios no formato:");
										System.out.println(
												"Nome, Marca, quantidade, preco, fornecedor, Validade Dia Mes");
										Estoque limp = new limpeza(in.next(), in.next(), in.nextInt(), in.nextDouble(),
												in.next(), in.nextInt(), in.nextInt());
										armazemLimp.adicionarEstoque(limp);
										break;
								}
								break;

							case 2:
								// Remover produtos
								System.out.println("Selecione o estoque:");
								System.out.println("1 ~> Alimentos");
								System.out.println("2 ~> Frutas e Verduras");
								System.out.println("3 ~> Frios");
								System.out.println("4 ~> Limpeza");
								int opcaoEstoque = readInt();
								List<Estoque> estoqueSelecionado;

								switch (opcaoEstoque) {
									case 1:
										estoqueSelecionado = ItensAli;
										break;
									case 2:
										estoqueSelecionado = ItensFrut;
										break;
									case 3:
										estoqueSelecionado = ItensFrio;
										break;
									case 4:
										estoqueSelecionado = ItensLimp;
										break;
									default:
										System.out.println("Opcao invalida.");
										continue;
								}

								// Exibir lista de produtos do estoque selecionado
								System.out.println("Lista de Produtos:");

								// Verificar se o estoque está vazio
								if (estoqueSelecionado.isEmpty()) {
									System.out.println("Estoque vazio.");
								} else {
									int cont = 1;
									for (Estoque item : estoqueSelecionado) {
										System.out.println(cont + ". " + item.getnome());
										cont++;
									}

									System.out.println("Selecione o numero do produto que deseja remover:");
									int produtoRemover = in.nextInt();

									// Verificar se o número do produto é válido
									if (produtoRemover >= 1 && produtoRemover <= estoqueSelecionado.size()) {
										Estoque produto = estoqueSelecionado.get(produtoRemover - 1);
										estoqueSelecionado.remove(produto);
										System.out.println(
												"O produto " + produto.getnome() + " foi removido do estoque.");
									} else {
										System.out.println("Numero de produto inválido.");
									}
								}

								break;

							case 3:
								// Validade
								System.out.println("Produtos proximos ao vencimento:");

								LocalDate dataAtual = LocalDate.now();
								List<List<Estoque>> todosEstoques = new ArrayList<>();
								todosEstoques.add(ItensAli);
								todosEstoques.add(ItensFrut);
								todosEstoques.add(ItensFrio);
								todosEstoques.add(ItensLimp);

								int aux3 = 1;

								for (List<Estoque> estoqueValidade : todosEstoques) {
									for (Estoque item : estoqueValidade) {
										YearMonth validade = YearMonth.of(dataAtual.getYear(), item.getValidadeM());
										LocalDate dataValidade = validade.atDay(item.getValidadeD());

										if (dataValidade.isBefore(dataAtual)) {
											validade = validade.plusYears(1); // Adiciona 1 ano à data de validade
											dataValidade = validade.atDay(item.getValidadeD());
										}

										long diasRestantes = ChronoUnit.DAYS.between(dataAtual, dataValidade);
										if (diasRestantes <= 14) {
											System.out.println(aux3 + ". " + item.getnome() + " - "
													+ diasRestantes + " dias restantes.");
											aux3++;
										}
									}
								}

								System.out.println("");
								break;
						}
					}
					break;

				case 2:
					// Ver lista de produtos
					System.out.println("Lista de Produtos:");

					// Alimentos
					System.out.println("Alimentos:");
					int cont = 1;
					for (Estoque item : ItensAli) {
						System.out.print(cont + ". ");
						System.out.print(item.getnome() + " || ");
						System.out.print("Marca: " + item.getmarca() + " || ");
						System.out.print("Unidades: " + item.getquantidade() + " || ");
						System.out.print("R$" + item.getpreço() + " || ");
						System.out.print("Fornecedor: " + item.getfornecedor() + " || ");
						System.out.println("Validade: " + item.getValidadeD() + "/" + item.getValidadeM());
						cont++;
					}

					System.out.println("");
					System.out.println("-----------------");
					System.out.println("");

					// Frutas e Verduras
					System.out.println("Frutas e Verduras:");
					cont = 1;
					for (Estoque item : ItensFrut) {
						System.out.print(cont + ". ");
						System.out.print(item.getnome() + " || ");
						System.out.print("Marca: " + item.getmarca() + " || ");
						System.out.print("Unidades: " + item.getquantidade() + " || ");
						System.out.print("R$" + item.getpreço() + " || ");
						System.out.print("Fornecedor: " + item.getfornecedor() + " || ");
						System.out.println("Validade: " + item.getValidadeD() + "/" + item.getValidadeM());
						cont++;
					}

					System.out.println("");
					System.out.println("-----------------");
					System.out.println("");

					// Frios
					System.out.println("Frios:");
					cont = 1;
					for (Estoque item : ItensFrio) {
						System.out.print(cont + ". ");
						System.out.print(item.getnome() + " || ");
						System.out.print("Marca: " + item.getmarca() + " || ");
						System.out.print("Unidades: " + item.getquantidade() + " || ");
						System.out.print("R$" + item.getpreço() + " || ");
						System.out.print("Fornecedor: " + item.getfornecedor() + " || ");
						System.out.println("Validade: " + item.getValidadeD() + "/" + item.getValidadeM());
						cont++;
					}

					System.out.println("");
					System.out.println("-----------------");
					System.out.println("");

					// Limpeza
					System.out.println("Limpeza:");
					cont = 1;
					for (Estoque item : ItensLimp) {
						System.out.print(cont + ". ");
						System.out.print(item.getnome() + " || ");
						System.out.print("Marca: " + item.getmarca() + " || ");
						System.out.print("Unidades: " + item.getquantidade() + " || ");
						System.out.print("R$" + item.getpreço() + " || ");
						System.out.print("Fornecedor: " + item.getfornecedor() + " || ");
						System.out.println("Validade: " + item.getValidadeD() + "/" + item.getValidadeM());
						cont++;
					}

					System.out.println("");
					System.out.println("-----------------");
					System.out.println("");

					break;

				case 3:
					limparConsole();
					int y = 10;
					while (y != 5) {
						menu.artCarrinho();
						menu.carrinho();
						y = in.nextInt();
						limparConsole();
						while (x < 1 || x > 5) {
							System.out.println("Escolha uma opcao valida");
							y = in.nextInt();
						}
						switch (y) {
							case 1:
								Estoque produtoSelecionado;
								Estoque novoItem;
								int comprar;
								int unidade;
								int cont5 = 1;
								// add item
								menu.addProd();
								y = in.nextInt();
								switch (y) {
									// tipo de item
									case 1:
										// lista alimento
										cont5 = 1;
										for (Estoque item : ItensAli) {
											System.out.print(cont5 + ". ");
											System.out.print(item.getnome() + " || ");
											System.out.print(item.getmarca() + " || ");
											System.out.print(item.getquantidade() + " || ");
											System.out.println(item.getpreço());
											cont5++;
										}
										System.out.println("Escolha o produto que voce deseja comprar");
										comprar = in.nextInt();
										System.out.println("Quantas unidades?");
										unidade = in.nextInt();
										while (unidade > ItensAli.get(comprar - 1).getquantidade()) {
											System.out.println("Estoque insuficiente");
											System.out.println("");
											System.out.println("Quantas unidades?");
											unidade = in.nextInt();
										}
										produtoSelecionado = ItensAli.get(comprar - 1);
										produtoSelecionado.setquantidade(unidade);

										novoItem = new Estoque(produtoSelecionado.getnome(),
												produtoSelecionado.getmarca(), unidade, produtoSelecionado.getpreço(),
												produtoSelecionado.getfornecedor(), produtoSelecionado.getValidadeD(),
												produtoSelecionado.getValidadeM());
										carro.adicionarEstoque(novoItem);
										hash.adicionarEstoque(produtoSelecionado);

										ItensAli.get(comprar - 1)
												.setquantidade(ItensAli.get(comprar - 1).getquantidade() - unidade);

										if (ItensAli.get(comprar - 1).getquantidade() == 0) {
											ItensAli.remove(comprar - 1);
										}
										break;

									case 2:
										// lista Fruta/Verdura
										cont5 = 1;
										for (Estoque item : ItensFrut) {
											System.out.print(cont5 + ". ");
											System.out.print(item.getnome() + " || ");
											System.out.print(item.getmarca() + " || ");
											System.out.print(item.getquantidade() + " || ");
											System.out.println(item.getpreço());
											cont5++;
										}
										System.out.println("Escolha o produto que voce deseja comprar");
										comprar = in.nextInt();
										System.out.println("Quantas unidades?");
										unidade = in.nextInt();
										while (unidade > ItensFrut.get(comprar - 1).getquantidade()) {
											System.out.println("Estoque insuficiente");
											System.out.println("");
											System.out.println("Quantas unidades?");
											unidade = in.nextInt();
										}
										produtoSelecionado = ItensFrut.get(comprar - 1);
										produtoSelecionado.setquantidade(unidade);

										novoItem = new Estoque(produtoSelecionado.getnome(),
												produtoSelecionado.getmarca(), unidade, produtoSelecionado.getpreço(),
												produtoSelecionado.getfornecedor(), produtoSelecionado.getValidadeD(),
												produtoSelecionado.getValidadeM());
										carro.adicionarEstoque(novoItem);
										hash.adicionarEstoque(produtoSelecionado);

										ItensFrut.get(comprar - 1)
												.setquantidade(ItensFrut.get(comprar - 1).getquantidade() - unidade);
										if (ItensFrut.get(comprar - 1).getquantidade() == 0) {
											ItensFrut.remove(comprar - 1);
										}
										break;

									case 3:
										// Lista Frios
										cont5 = 1;
										for (Estoque item : ItensFrio) {
											System.out.print(cont5 + ". ");
											System.out.print(item.getnome() + " || ");
											System.out.print(item.getmarca() + " || ");
											System.out.print(item.getquantidade() + " || ");
											System.out.println(item.getpreço());
											cont5++;
										}
										System.out.println("Escolha o produto que voce deseja comprar");
										comprar = in.nextInt();
										System.out.println("Quantas unidades?");
										unidade = in.nextInt();
										while (unidade > ItensFrio.get(comprar - 1).getquantidade()) {
											System.out.println("Estoque insuficiente");
											System.out.println("");
											System.out.println("Quantas unidades?");
											unidade = in.nextInt();
										}
										produtoSelecionado = ItensFrio.get(comprar - 1);
										produtoSelecionado.setquantidade(unidade);

										novoItem = new Estoque(produtoSelecionado.getnome(),
												produtoSelecionado.getmarca(), unidade, produtoSelecionado.getpreço(),
												produtoSelecionado.getfornecedor(), produtoSelecionado.getValidadeD(),
												produtoSelecionado.getValidadeM());
										carro.adicionarEstoque(novoItem);
										hash.adicionarEstoque(produtoSelecionado);

										ItensFrio.get(comprar - 1)
												.setquantidade(ItensFrio.get(comprar - 1).getquantidade() - unidade);
										if (ItensFrio.get(comprar - 1).getquantidade() == 0) {
											ItensFrio.remove(comprar - 1);
										}
										break;

									case 4:
										// Lista limpeza
										cont5 = 1;
										for (Estoque item : ItensLimp) {
											System.out.print(cont5 + ". ");
											System.out.print(item.getnome() + " || ");
											System.out.print(item.getmarca() + " || ");
											System.out.print(item.getquantidade() + " || ");
											System.out.println(item.getpreço());
											cont5++;
										}
										System.out.println("Escolha o produto que voce deseja comprar");
										comprar = in.nextInt();
										System.out.println("Quantas unidades?");
										unidade = in.nextInt();
										while (unidade > ItensLimp.get(comprar - 1).getquantidade()) {
											System.out.println("Estoque insuficiente");
											System.out.println("");
											System.out.println("Quantas unidades?");
											unidade = in.nextInt();
										}
										produtoSelecionado = ItensLimp.get(comprar - 1);
										produtoSelecionado.setquantidade(unidade);

										novoItem = new Estoque(produtoSelecionado.getnome(),
												produtoSelecionado.getmarca(), unidade, produtoSelecionado.getpreço(),
												produtoSelecionado.getfornecedor(), produtoSelecionado.getValidadeD(),
												produtoSelecionado.getValidadeM());
										carro.adicionarEstoque(novoItem);
										hash.adicionarEstoque(produtoSelecionado);

										ItensLimp.get(comprar - 1)
												.setquantidade(ItensLimp.get(comprar - 1).getquantidade() - unidade);
										if (ItensLimp.get(comprar - 1).getquantidade() == 0) {
											ItensLimp.remove(comprar - 1);
										}
										break;
								}
								limparConsole();
								break;

							case 2:
								// remover carrinho
								System.out.println("Lista de Produtos:");
								// Verificar se o estoque está vazio
								if (carrinho.isEmpty()) {
									System.out.println("Estoque vazio.");
								} else {
									int cont6 = 1;
									for (Estoque item : carrinho) {
										System.out.print(cont6 + ". " + item.getnome() + " || ");
										System.out.println("Quant: " + item.getquantidade());
										cont6++;
									}

									System.out.println("Selecione o numero do produto que deseja remover:");
									int produtoRemover = in.nextInt();

									// Verificar se o número do produto é válido
									if (produtoRemover >= 1 && produtoRemover <= carrinho.size()) {
										Estoque produto = carrinho.get(produtoRemover - 1);
										System.out.println("Quantas unidades deseja remover?");
										int unidadesRemover = in.nextInt();

										// Verificar se o número de unidades é válido
										if (unidadesRemover >= 1 && unidadesRemover <= produto.getquantidade()) {
											produto.setquantidade(produto.getquantidade() - unidadesRemover);

											// Verificar se todas as unidades foram removidas
											if (produto.getquantidade() == 0) {
												carrinho.remove(produto);
												hash.removerEstoque(produto.getnome());
												System.out.println("O produto " + produto.getnome()
														+ " foi completamente removido do carrinho.");
											} else {
												System.out.println("Foram removidas " + unidadesRemover
														+ " unidades do produto " + produto.getnome() + ".");
											}
										} else {
											System.out.println("Numero de unidades invalido.");
										}
									} else {
										System.out.println("Número de produto invalido.");
									}
								}
								break;

							case 3:
								// Itens carrinho
								int cont10 = 1;
								HashMap<String, Estoque> todosItens = hash.lista();
								for (Estoque item : todosItens.values()) {
									System.out.print(cont10 + ". ");
									System.out.print(item.getnome() + " || ");
									System.out.println("R$" + item.getpreço());
									cont10++;
								}
								break;
						}
					}

			}

		}
	}
}
