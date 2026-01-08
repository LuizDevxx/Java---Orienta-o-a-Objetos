import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    Scanner e = new Scanner(System.in);

    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();


    public Biblioteca() {
        carregandoIniciais();
    }

    private void carregandoIniciais() {
        autores.add(new Autor("Luiz Antonio", LocalDate.of(2003, 11, 3)));
        autores.add(new Autor("Lucas de Jesus", LocalDate.of(2005, 3, 23)));
        autores.add(new Autor("Bianca Azevedo", LocalDate.of(2005, 6, 18)));
        autores.add(new Autor("Marizilda de Jesus", LocalDate.of(1972, 2, 3)));

        livros.add(new Livro("POO Na pratica", autores.get(0)));
        livros.add(new Livro("Hoje e sempre", autores.get(2)));
    }


    public void mostrarLivros() {
        for (Livro livro : livros) {

            System.out.println("-------------------------");
            System.out.printf("ID: %d\n", livro.getId());
            System.out.printf("AUTOR: %s\n", livro.getAutor().getAutor());
            System.out.printf("TITULO: %s\n", livro.getTitulo());
            System.out.println("-------------------------");

        }
    }

    private Autor vericandoDuplicidade(String nome) {

        for (Autor autor : autores) {
            if (autor.getAutor().equalsIgnoreCase(nome)) {
                return autor;
            }
        }
        return null;
    }

    public void cadastrar() {
        System.out.println();
        System.out.print("Digite o nome do livro: ");
        String livro = e.nextLine();

        System.out.print("Digite o nome do autor: ");
        String nomeAutor = e.nextLine();
        System.out.println();

        Autor autor = vericandoDuplicidade(nomeAutor);

        if (autor == null) {
            autor = new Autor(nomeAutor, LocalDate.now()); // ou pedir data
            autores.add(autor);
        }

        livros.add(new Livro(livro, autor));
        System.out.println("Livro cadastrado com sucesso!");

    }

    public Livro buscarPorId() {
        System.out.print("Digite o Id do livro: ");
        int num = e.nextInt();

        for (Livro livro : livros) {

            if (livro.getId() == num) {
                System.out.println();
                System.out.println("Livro Encontrado");
                System.out.println("-------------------------");
                System.out.printf("ID: %d\n", livro.getId());
                System.out.printf("AUTOR: %s\n", livro.getAutor().getAutor());
                System.out.printf("TITULO: %s\n", livro.getTitulo());
                System.out.println("-------------------------");
                System.out.println();
                return livro;
            }
        }
        System.out.println("Livro não encontrado");
        return null;
    }

    public void buscarAutor() {

        System.out.print("Digite o Autor do livro: ");
        String nome = e.nextLine();

        for (Livro livro : livros) {

            if (livro.getAutor().getAutor().equalsIgnoreCase(nome)) {
                System.out.println();
                System.out.println("Livro Encontrado");
                System.out.println("-------------------------");
                System.out.printf("ID: %d\n", livro.getId());
                System.out.printf("AUTOR: %s\n", livro.getAutor().getAutor());
                System.out.printf("TITULO: %s\n", livro.getTitulo());
                System.out.println("-------------------------");
                System.out.println();
                return;
            }
        }
        System.out.println("Livro não encontrado");
    }

    public Livro buscarPorTitulo() {
        System.out.print("Digite o Titulo do livro: ");
        String titulo = e.nextLine();

        for (Livro livro : livros) {

            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println();
                System.out.println("Livro Encontrado");
                System.out.println("-------------------------");
                System.out.printf("ID: %d\n", livro.getId());
                System.out.printf("AUTOR: %s\n", livro.getAutor().getAutor());
                System.out.printf("TITULO: %s\n", livro.getTitulo());
                System.out.println("-------------------------");
                System.out.println();
                return livro;
            }
        }
        System.out.println("Livro não encontrado");
        return null;
    }


    public void fim() {
        System.out.println("Obrigado por acessar nosso site");
        System.out.println("Até mais :)");
    }

    public void emprestimo() {

        System.out.println("\nVamos finalizar seu empréstimo");
        System.out.print("Digite seu nome: ");
        String nomeCliente = e.nextLine();

        Livro livro = null;

        System.out.println("\nComo deseja buscar o livro?");
        System.out.println("1 - Pelo título");
        System.out.println("2 - Pelo ID");

        int opcao = e.nextInt();
        e.nextLine(); // limpar buffer

        if (opcao == 1) {
            livro = buscarPorTitulo();
        } else if (opcao == 2) {
            livro = buscarPorId();
        } else {
            System.out.println("Opção inválida");
            return;
        }

        if (livro == null) {
            System.out.println("Livro não encontrado");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println("Este livro já está emprestado");
            return;
        }

        // marcar como emprestado
        livro.setDisponivel(false);

        Emprestimo emprestimo = new Emprestimo(
                livro,
                nomeCliente,
                LocalDate.now()
        );

        emprestimos.add(emprestimo);

        System.out.println("\nEmpréstimo realizado com sucesso!");
    }

}