import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);
        Operacoes op = new Operacoes();

        int opcao;

        System.out.println("-----Bem vindo ao BANCO FUTURO-----");

        while (true) {
            System.out.println("Digite umas das opções: ");
            System.out.println("1- Cadastrar");
            System.out.println("2- Tenho cadastro");
            System.out.println("3- Sair");
            System.out.print("Opção: ");
            opcao = e.nextInt();

            switch (opcao) {
                case 1 -> {
                    op.Cadastrar();
                }
                case 2 -> {
                    op.acessarConta();
                }
                case 3 -> {
                    System.out.println("OBRIGADO POR SER NOSSO CLIENTE :)");
                    return;
                }
                default -> System.out.println("Digite somente 1 a 3");
            }
        }
    }
}