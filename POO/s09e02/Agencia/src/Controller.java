import java.util.ArrayList;
import java.util.Scanner;

class Cliente {

    private String nome;
    private ArrayList<Conta> contas;

    Cliente(String nome) {
        this.nome = nome;
        contas = new ArrayList<Conta>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);

    }
}
abstract class Conta {
    static int aux = 0; 
    private int id = 0;
    private String nome;
    private double saldo;
    private String tipo;

    Conta(String nome, double saldo, String tipo) {
        this.nome = nome;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    Conta() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Conta.aux = aux;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
class Corrente extends Conta {

    public Corrente(String nome) {
        this.setId(aux);
        this.setNome(nome);
        this.setSaldo(getSaldo());
        this.setTipo("CC");
        aux ++;
    }
}
class Poupanca extends Conta {

    public Poupanca(String nome) {
        this.setId(aux);
        this.setNome(nome);
        this.setSaldo(getSaldo());
        this.setTipo("CP");
        aux ++;

    }

}
class Agencia {

    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    Agencia() {
        clientes = new ArrayList<Cliente>();
        contas = new ArrayList<Conta>();

    }

    public void addCli(String nome) {
        for (Cliente x : clientes) {
            if (x.getNome().equals(nome)) {
                System.out.println("Cliente já existe");
                return;
            }
        }
        Cliente cliente = new Cliente(nome);
        Conta corrente = new Corrente(nome);
        Conta poupanca = new Poupanca(nome);
        this.clientes.add(cliente);
        cliente.addConta(corrente);
        cliente.addConta(poupanca);
        this.contas.add(corrente);
        this.contas.add(poupanca);
    }
    
    public void show() {
        for (Conta x : contas) {
            System.out.println(x.getId() + ":" + x.getNome() + ":" + x.getSaldo() + ":" + x.getTipo());
        }
    }
    public void depositar(int indice, double valor){
        for (Conta x : contas){
            if(indice == x.getId()){
                x.setSaldo(x.getSaldo()+valor);
                return;
            }
        }
        System.out.println("Conta nem existe, parsa");
    }
    public boolean sacar(int indice, double valor){
        for (Conta x : contas){
            if(indice == x.getId()){
                if(valor <= x.getSaldo()){
                    x.setSaldo(x.getSaldo()-valor);
                    return true;
                }
            }
            else if(indice == x.getId()){
                if(valor <= x.getSaldo()){
                    System.out.println("Valor alto demais");
                    return false;
                }
            }
        }
        System.out.println("Conta nem existe, man");
        return false;
    }
    public void transferir(int i1, int i2, double valor){
        if(this.sacar(i1, valor)){
            this.depositar(i2, valor);
        }
    }
    public void update(){
        for (Conta x : contas){
            if(x.getTipo().equals("CC")){
                x.setSaldo(x.getSaldo()-20);
            }
            else{
                x.setSaldo(x.getSaldo()+(x.getSaldo()*0.01));
            }
        }
    }
    
}

public class Controller {

    public static void main(String[] args) {
        Agencia agencia = new Agencia();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("addCli, sacar, depositar, transferir, update, show, end");
            String line = scan.nextLine();
            String vet[] = line.split(" ");
                
            if(vet[0].equals("addCli")) {
                agencia.addCli(vet[1]);
            }
            else if(vet[0].equals("depositar")) {
                agencia.depositar(Integer.parseInt(vet[1]), Double.parseDouble(vet[2]));
            }
            else if(vet[0].equals("sacar")) {
                agencia.sacar(Integer.parseInt(vet[1]), Double.parseDouble(vet[2]));
            }
            else if(vet[0].equals("transferir")){
                agencia.transferir(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]), Double.parseDouble(vet[3]));
            }
            else if(vet[0].equals("show")) {
                agencia.show();
            }
            else if(vet[0].equals("end")) {
                break;
            }
            else if(vet[0].equals("update")) {
                agencia.update();
            }
            else{
                System.out.println("Comando inválido!");
            }
        }
    }
}
