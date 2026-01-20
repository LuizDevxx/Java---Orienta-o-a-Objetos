import java.time.LocalDate;

public class DadosCliente {
    private static int contadorid=0;
    private int id;
    private double saldo;
    private String titular;
    private LocalDate DataNacimento;

    public DadosCliente(String nome, LocalDate data, double valor){

        contadorid++;
        id = contadorid;
        setTitular(nome);
        this.DataNacimento = data;
        saldo += valor;
    }

    public int getId() {
        return id;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular){
        this.titular=titular;
    }
    public LocalDate getData(){
        return DataNacimento;
    }

}
