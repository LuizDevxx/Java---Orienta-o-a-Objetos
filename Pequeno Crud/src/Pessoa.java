public class Pessoa {
    private int id;
    private String name;
    private int idade;

    public Pessoa(int id, String name, int idade) {
        this.id = id;
        setName(name);
        setIdade(idade);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdade() {
        return idade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void apresentar() {
        System.out.println("ID: " + id);
        System.out.println("NOME: " + name);
        System.out.println("IDADE: " + idade);
    }
}
