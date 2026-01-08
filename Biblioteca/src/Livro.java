

public class Livro {

    private int id;
    private static int contadorId = 0;
    private String titulo;
    private Autor autor;
    private boolean disponivel;



    public Livro(String titulo, Autor autor) {
        contadorId++;
        this.id=contadorId;
        this.titulo=titulo;
        this.autor=autor;
        this.disponivel = true;


    }
    public Autor getAutor(){
        return autor;
    }
    public int getId() {
        return id;
    }
    public String getTitulo(){
        return titulo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

}
