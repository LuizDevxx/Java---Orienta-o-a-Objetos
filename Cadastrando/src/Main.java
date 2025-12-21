import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);
        PessoaService p = new PessoaService();

        while (true) {
            System.out.println("Digite a opção que deseja: ");
            System.out.println("1- Cadastrar Pessoa");
            System.out.println("2- Listar pessoas");
            System.out.println("3- Buscar por id");
            System.out.println("4- Remover usuario");
            System.out.println("5- Sair");
            System.out.print("Opção: ");
            int opcao = e.nextInt();

            System.out.println();


            switch (opcao) {
                case 1 -> {
                    p.cadastrar();
                }
                case 2 -> {
                    p.listar();
                }
                case 3 -> {
                    p.buscar();
                }
                case 4 -> {
                    p.excluir();
                }
                case 5 -> {
                    System.out.println("Obrigado por usar nosso sistema");
                    return;
                }
                default -> {
                    System.out.println("Digite de 1 a 5");

                }
            }
        }
    }
}
