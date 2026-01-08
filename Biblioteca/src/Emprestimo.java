import java.time.LocalDate;

public class Emprestimo {
    private static int contadorId = 0;
    private int id;
    private Livro livro;
    private String nomeCliente;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, String nomeCliente, LocalDate now){
         this.id=contadorId++;
         this.livro= livro;
         this.nomeCliente=nomeCliente;
    }
    public int getIdEmprestimo(){
        return id;
    }
    public String getNomeCliente(){
        return nomeCliente;
    }


}
