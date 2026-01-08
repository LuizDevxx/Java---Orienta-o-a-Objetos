import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);

        Biblioteca b = new Biblioteca();


        System.out.println("-----BEM VINDO A LIVRARIA SARAIVA-----");
        int opcao;
        while (true) {
            System.out.println();
            System.out.println("Digite uma opção: ");
            System.out.println("1-Listar livro");
            System.out.println("2-Emprestimo de livros");
            System.out.println("3-Buscar por livro");
            System.out.println("4-Buscar por autor");
            System.out.println("5-Cadastrar");
            System.out.println("6-Sair");
            System.out.print("Opção: ");
            opcao = e.nextInt();

            switch (opcao) {
                case 1 -> b.mostrarLivros();
                case 2 -> b.emprestimo();
                case 3 -> b.buscarPorTitulo();
                case 4 -> b.buscarAutor();
                case 5 -> b.cadastrar();
                case 6 -> {
                    System.out.println();
                    b.fim();
                    e.close();
                    return;
                }
                default -> {
                    System.out.println("Digite uma opção válida");
                }

            }
        }
    }
}