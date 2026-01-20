import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operacoes {

    Scanner e = new Scanner(System.in);
    List<DadosCliente> dados = new ArrayList<>();

    public void Cadastrar() {
        e.nextLine();
        System.out.println("-----AREA DE CADASTRO-----");
        System.out.println();

        System.out.print("Digite seu nome: ");
        String nome = e.nextLine();

        System.out.print("Digite sua data de nascimento: ");
        String dataTexto = e.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate data = LocalDate.parse(dataTexto, formatter);

        System.out.println("Ira efetuar algum depósito? digite 0 caso nao");
        System.out.print("Valor: ");
        double valor = e.nextDouble();

        dados.add(new DadosCliente(nome, data, valor));

        System.out.println("Usuario cadastrado com sucesso!!");
        System.out.println();
    }

    public void acessarConta() {

        if (dados.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
            System.out.println();
            return;
        }

        System.out.print("Digite o numero da sua conta: ");
        int id = e.nextInt();

        for (DadosCliente dadosCliente : dados) {
            if (id == dadosCliente.getId()) {
                System.out.println();
                System.out.println("------------------------------");
                System.out.println("Conta encontrada");
                System.out.println("CONTA: " + dadosCliente.getId());
                System.out.println("NOME: " + dadosCliente.getTitular());
                System.out.println("DATA DE NASCIMENTO: " + dadosCliente.getData());
                System.out.printf("SALDO: %.2f",dadosCliente.getSaldo());
                System.out.println("------------------------------");
                System.out.println();
                menu(id);
                return;

            }
        }
        System.out.println();
        System.out.println("Conta não encontrada");
        System.out.println();
    }

    public void menu(int id) {

        int opcao;
        while (true) {
            System.out.println("Digite a opção que deseja: ");
            System.out.println("1- Depositar");
            System.out.println("2- Sacar");
            System.out.println("3- Mostrar Saldo");
            System.out.println("4- Sair");
            opcao = e.nextInt();

            switch (opcao) {
                case 1 -> {
                    depositar(id);
                }
                case 2 -> {
                    sacar(id);
                }
                case 3 -> {
                    mostrarSaldo(id);
                }
                case 4 -> {
                    System.out.println("Saindo da conta, OBRIGADO POR SER NOSSO CLIENTE:)");
                    return;
                }
                default -> System.out.println("Digite de 1 a 4");
            }
        }

    }

    public void depositar(int id) {
        double valor;
        double total=0;

        System.out.println();
        System.out.println("-----AREA DE DEPOSITO-----");
        do {
            System.out.println();
            System.out.print("Digite um valor para deposito: ");
            valor = e.nextDouble();

            if (valor <= 0) {
                System.err.println("Digite um valor valido para deposito, maior que 0");
            }
        } while (valor <= 0);

        for (DadosCliente dadosCliente : dados) {
            if (id == dadosCliente.getId()) {
                total = dadosCliente.getSaldo() + valor;
                dadosCliente.setSaldo(total);
                System.out.printf("SALDO ATUAL: %.2f", dadosCliente.getSaldo());
                System.out.println();
            }
        }
    }


    public void sacar(int id) {
        double valor;
        double total;

        System.out.println();
        System.out.println("-----AREA DE SAQUE-----");
        do {
            System.out.println();
            System.out.print("Digite um valor para saque: ");
            valor = e.nextDouble();

            if (valor <= 0) {
                System.err.println("Digite um valor valido para deposito, maior que 0");
            }
        } while (valor <= 0);

        for (DadosCliente dadosCliente : dados) {
            if (id == dadosCliente.getId()) {
                do {
                    if (valor > dadosCliente.getSaldo()) {
                        System.out.println();
                        System.err.printf("Digite um valor valido para saque, menor ou igual a saldo que é: %.2f", dadosCliente.getSaldo());
                    }
                    System.out.println();
                    System.out.print("Digite um valor para saque: ");
                    valor = e.nextDouble();

                } while (valor > dadosCliente.getSaldo() || valor < 0);

                total = dadosCliente.getSaldo() - valor;
                dadosCliente.setSaldo(total);

                System.out.printf("SALDO ATUAL: %.2f", dadosCliente.getSaldo());
                System.out.println();
            }
        }
    }

    public void mostrarSaldo(int id) {

        for (DadosCliente dadosCliente : dados) {
            System.out.println();
            if (id == dadosCliente.getId()) {
                System.out.println("----------MOSTRANDO SALDO-------------");
                System.out.println("----------------------");
                System.out.println("NOME: " + dadosCliente.getTitular());
                System.out.printf("SALDO: %.2f", dadosCliente.getSaldo());
                System.out.println("----------------------");
                System.out.println();

            }
        }
    }
}
