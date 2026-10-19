# Estoque e Carrinho — Projeto LP2

Aplicação de console em Java que gerencia o estoque de um mercado e simula um carrinho de compras. Projeto final da disciplina Linguagem de Programação II (LP2), BTI — IMD/UFRN, 2023.1.

## Funcionalidades

- Estoque dividido em quatro categorias: alimentos, frutas e verduras, frios (com temperatura de armazenamento) e limpeza
- Cadastro e remoção de produtos
- Alerta de produtos que vencem nos próximos 14 dias
- Carrinho de compras com baixa no estoque, remoção parcial de itens, subtotal e total
- Validação de todas as entradas do usuário (texto no lugar de número, opção fora do menu, quantidade maior que o estoque)

## Como rodar

Requer Java 11 ou superior.

```bash
javac -d out src/Estoque/*.java
java -cp out Estoque.Main
```

## Estrutura

| Arquivo | Responsabilidade |
| --- | --- |
| `Estoque.java` | Classe base de um produto: nome, marca, quantidade, preço, fornecedor e validade |
| `alimento.java`, `frutasVerduras.java`, `frios.java`, `limpeza.java` | Categorias de produto (herança); `frios` acrescenta a temperatura |
| `Armazenamento.java` | Lista de produtos de uma categoria ou do carrinho (`ArrayList`) |
| `ArmazenamentoHash.java` | Índice do carrinho por nome do produto (`HashMap`) |
| `Menu.java` | Menus e arte ASCII do console |
| `Main.java` | Fluxo do programa: estoque, listagens e carrinho |

## Conceitos praticados

Herança e polimorfismo, encapsulamento, coleções (`ArrayList` e `HashMap`), tratamento de entrada com `Scanner` e datas com `java.time`.

## Limitações conhecidas

- A validade guarda só dia e mês; o programa considera a próxima ocorrência dessa data.
- Os dados ficam em memória e são perdidos ao sair.
- Preços usam `double`; um sistema real usaria `BigDecimal`.
