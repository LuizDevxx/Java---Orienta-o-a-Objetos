import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaService {
    private Scanner e = new Scanner(System.in);
    private List<Pessoa> pessoas = new ArrayList<>();
    private int proximoId = 1;


    public void cadastrar() {

        System.out.println("-----Bem vindo a área de cadastro-----");

        System.out.print("Digite seu nome: ");
        String name = e.next();

        System.out.print("Digite sua idade: ");
        int idade = e.nextInt();

        System.out.println("Cadastrado com sucesso!");

        int id = proximoId;
        Pessoa p = new Pessoa(id, name, idade);
        pessoas.add(p);
        proximoId++;

        System.out.println();
    }

    public void listar() {
        if (pessoas.isEmpty()) {
            System.out.println("A lista esta vazia");
            System.out.println();
            return;
        }

        for (Pessoa pessoa : pessoas) {
            System.out.println("------------------------");
            pessoa.apresentar();
            System.out.println("------------------------");

        }
        System.out.println();
    }

    public void buscar() {
        if (pessoas.isEmpty()) {
            System.out.println("A lista esta vazia");
            System.out.println();
            return;
        }


        System.out.print("Digite o Id: ");
        int id = e.nextInt();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                System.out.println("Usuário encontrado");
                pessoa.apresentar();
                System.out.println();
                return;
            }

        }
        System.out.println("Não encontrado");
        System.out.println();
    }

    public void excluir() {
        if (pessoas.isEmpty()) {
            System.out.println("A lista esta vazia");
            System.out.println();
            return;
        }

        System.out.print("Digite o Id que gostaria de excluir: ");
        int id = e.nextInt();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                pessoas.remove(pessoa);
                System.out.println("Usuário removido com sucesso!!");
                System.out.println();
                return;
            }
        }
        System.out.println("Usuário não encontrado");
    }

    public void alterar() {

        if (pessoas.isEmpty()){
            System.out.println("A lista esta vazia");
            System.out.println();
            return;
        }
            System.out.println("Digite o id: ");
            int id = e.nextInt();

         for (Pessoa pessoa: pessoas){
             if (pessoa.getId() == id){

                 System.out.print("Digite seu nome: ");
                 String name = e.next();

                 System.out.print("Digite sua idade: ");
                 int idade = e.nextInt();
                 System.out.println();

                 pessoa.setName(name);
                 pessoa.setIdade(idade);
                 return;
             }
         }
        System.out.println("Usuário não encontrado");

    }
}
