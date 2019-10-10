import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

class Cliente{
	protected String nome;
	ArrayList<Conta> contas;
	
	public Cliente(String nome) {
		this.nome = nome;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
class Conta{
	protected int id;
	protected String nome_cliente;
	protected String tipo;
	protected double saldo;
	
	public Conta(int id, String nome_cliente, double saldo, String tipo) {
		this.id = id;
		this.nome_cliente = nome_cliente;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	public Conta(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
class Corrente extends Conta{	
	public Corrente(String nome_cliente) {
		this.setId(id);
		this.setNome_cliente(nome_cliente);
		this.setSaldo(saldo);
		this.setTipo("CC");
	}
}
class Poupanca extends Conta{

	public Poupanca(String nome_cliente) {
		this.setId(id);
		this.setNome_cliente(nome_cliente);
		this.setSaldo(saldo);
		this.setTipo("CP");

	}
}
class Agencia{
	ArrayList<Cliente> clientes;
	ArrayList<Conta> contas;

	public Agencia() {
		clientes = new ArrayList<Cliente>();
		contas = new ArrayList<Conta>();
	}
	public void addCli(String nome){
		for(Cliente x : clientes){
			if(x.getNome().equals(nome)){
				System.out.println("Cliente já existe!");
				return;
			}
		Cliente cliente = new Cliente(nome);
		Conta poupanca = new Conta(nome);
		Conta corrente = new Conta(nome);
		cliente.add(poupanca);
		cliente.add(corrente);
		this.contas.add(poupanca);
		this.contas.add(corrente);
		}
	}
	public void sacar(int indice, double valor) {
		for(Conta x : contas){
			if(indice == c.getId()){
				if(valor <= this.saldo) {
				this.saldo -= valor;
				System.out.println("Operação realizada com sucesso!");
				System.out.println("Saldo atual: " + c.getSaldo());
				}else {
				System.out.println("Valor incompatível!");
				}
			}
		}
	}public void despositar(int indice, double valor) {
		for(Conta x : contas){
			if(indice == c.getId()){
				this.saldo += valor;
				System.out.println("Operação realizada com sucesso!");
				System.out.println("Saldo atual: " + c.getSaldo());
			}
		}
	}
	public void update(){
		for(Conta x : contas){
			if(c.getTipo().equals("CP")){
				
			}
		}
	}
}


public class Controller {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("aadCli, sacar, depositar, transferir, show, end");
			System.out.println("add,");
			String line = scan.nextLine();
			String[] vet = line.split(" ");
			break;
		}
	}

}
