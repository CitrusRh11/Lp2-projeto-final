package Estoque;

public class Menu {

    public void menu() {
        System.out.println("Escolha uma opcao");
        System.out.println("1 ~> Gerenciar estoque");
        System.out.println("2 ~> Ver lista de produtos");
        System.out.println("3 ~> Carrinho de compras");
        System.out.println("0 ~> Sair do armazem");
    }

    public void art() {
        String asciiArt = "  ____  ______ __  __  __      _______ _   _ _____   ____   \n"
                + " |  _ \\|  ____|  \\/  | \\ \\    / /_   _| \\ | |  __ \\ / __ \\  \n"
                + " | |_) | |__  | \\  / |  \\ \\  / /  | | |  \\| | |  | | |  | | \n"
                + " |  _ <|  __| | |\\/| |   \\ \\/ /   | | | . ` | |  | | |  | | \n"
                + " | |_) | |____| |  | |    \\  /   _| |_| |\\  | |__| | |__| | \n"
                + " |____/|______|_|  |_|     \\/___|_____|_| \\_|_____/ \\____/  \n"
                + "                       /\\   / __ \\                          \n"
                + "                      /  \\ | |  | |                         \n"
                + "                     / /\\ \\| |  | |                         \n"
                + "                    / ____ \\ |__| |                         \n"
                + "           _____  _/_/__  \\_\\____/ ____________ __  __      \n"
                + "     /\\   |  __ \\|  \\/  |   /\\    |___  /  ____|  \\/  |     \n"
                + "    /  \\  | |__) | \\  / |  /  \\      / /| |__  | \\  / |     \n"
                + "   / /\\ \\ |  _  /| |\\/| | / /\\ \\    / / |  __| | |\\/| |     \n"
                + "  / ____ \\| | \\ \\| |  | |/ ____ \\  / /__| |____| |  | |     \n"
                + " /_/    \\_\\_|  \\_\\_|  |_/_/    \\_\\/_____|______|_|  |_|     \n"
                + "                                                            \n"
                + "                                                            ";

        System.out.println(asciiArt);

    }

    public void menu1() {
        System.out.println("Escolha uma opcao");
        System.out.println("1 ~> Adicionar produtos");
        System.out.println("2 ~> Remover produtos");
        System.out.println("3 ~> Validade");
        System.out.println("4 ~> Voltar");
    }

    public void addProd() {
        System.out.println("Escolha uma opcao");
        System.out.println("1 ~> Adicionar Alimento");
        System.out.println("2 ~> Adicionar Fruta/Verdura");
        System.out.println("3 ~> Adicionar Frios");
        System.out.println("4 ~> Adicionar Material de limpeza");
        System.out.println("5 ~> Voltar");
    }

    public void artCarrinho() {
        String art = "       _        ,\n" +
                "      (_\\______/________\n" +
                "         \\-|-|/|-|-|-|-|/\n" +
                "          \\==/-|-|-|-|-/\n" +
                "           \\/|-|-|-|,-'\n" +
                "            \\--|-'''\n" +
                "             \\_j________\n" +
                "              (_)     (_)";

        System.out.println(art);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public void carrinho() {
        System.out.println("Escolha uma opcao");
        System.out.println("1 ~> Colocar item no carrino");
        System.out.println("2 ~> Remover do carrinho");
        System.out.println("3 ~> Itens do carrinho");
        System.out.println("5 ~> Voltar");
    }

}
