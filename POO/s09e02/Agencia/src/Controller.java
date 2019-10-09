import java.util.ArrayList;
import java.util.Scanner;

class Cliente{
	protected String nome;
	ArrayList<Conta> contas;
	Poupanca c_poupanca;
	Corrente c_corrente;
	
	public Cliente(String nome) {
		this.nome = nome;
		c_poupanca = new Poupanca(1, this.nome);
		c_corrente = new Corrente(1, this.nome);
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
	
	public Conta(int id, String nome_cliente) {
		this.id = id;
		this.nome_cliente = nome_cliente;
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
	public void sacar(double valor) {
		if(valor <= this.saldo) {
			this.saldo -= valor;
			System.out.println("Operação realizada com sucesso!");
			System.out.println("Saldo atual: " + this.saldo);
		}else {
			System.out.println("Valor incompatível!");
		}
	}public void despositar(double valor) {
		this.saldo += valor;
		System.out.println("Operação realizada com sucesso!");
		System.out.println("Saldo atual: " + this.saldo);
	}
}
class Corrente extends Conta{
	protected double tarifa = 20;  
	
	public Corrente(int id, String nome_cliente) {
		super(id, nome_cliente);
	}
	
	public void update() {
		saldo -= tarifa;
	}
}
class Poupanca extends Conta{
	protected double rendimento = 0.01;  
	
	public Poupanca(int id, String nome_cliente) {
		super(id, nome_cliente);
	}
	public void update() {
		saldo = saldo * 0.01;
	}
}
class Agencia{
	ArrayList<Cliente> clientes;
	
	public Agencia() {
		clientes = new ArrayList<Cliente>();
	}
}


public class Controller {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Cliente jorge = new Cliente("Jorge");
		
		while(true) {
			System.out.println("add,");
			String line = scan.nextLine();
			String[] vet = line.split(" ");
			
		}
	}

}
