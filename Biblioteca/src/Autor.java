import java.time.LocalDate;

public class Autor {

    private int id;
    private static int contadorId = 0;
    private String autor;
    private LocalDate datanascimento;

    public Autor(String autor, LocalDate datanascimento ){

        contadorId++;
        this.id= contadorId;
        setAutor(autor);
        setDatanascimento(datanascimento);
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public int getId(){
        return id;
    }
    public void setDatanascimento(LocalDate datanascimento){
    this.datanascimento=datanascimento;
    }

}
